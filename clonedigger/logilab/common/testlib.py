# modified copy of some functions from test/regrtest.py from PyXml
"""Copyright (c) 2003-2006 LOGILAB S.A. (Paris, FRANCE).
http://www.logilab.fr/ -- mailto:contact@logilab.fr  

Run tests.

This will find all modules whose name match a given prefix in the test
directory, and run them.  Various command line options provide
additional facilities.

Command line options:

-v: verbose -- run tests in verbose mode with output to stdout
-q: quiet -- don't print anything except if a test fails
-t: testdir -- directory where the tests will be found
-x: exclude -- add a test to exclude
-p: profile -- profiled execution
-c: capture -- capture standard out/err during tests
-d: dbc     -- enable design-by-contract

If no non-option arguments are present, prefixes used are 'test',
'regrtest', 'smoketest' and 'unittest'.

"""
import sys
import os, os.path as osp
import re
import time
import getopt
import traceback
import unittest
import difflib
import types
from warnings import warn
from compiler.consts import CO_GENERATOR
try:
    import readline
except ImportError:
    readline = None

# PRINT_ = file('stdout.txt', 'w').write

try:
    from test import test_support
except ImportError:
    # not always available
    class TestSupport:
        def unload(self, test):
            pass
    test_support = TestSupport()

from clonedigger.logilab.common.deprecation import class_renamed, deprecated_function, \
     obsolete
from clonedigger.logilab.common.compat import set, enumerate, any
from clonedigger.logilab.common.modutils import load_module_from_name
from clonedigger.logilab.common.debugger import Debugger
from clonedigger.logilab.common.decorators import cached

__all__ = ['main', 'unittest_main', 'find_tests', 'run_test', 'spawn']

DEFAULT_PREFIXES = ('test', 'regrtest', 'smoketest', 'unittest',
                    'func', 'validation')

ENABLE_DBC = False

def main(testdir=None, exitafter=True):
    """Execute a test suite.

    This also parses command-line options and modifies its behaviour
    accordingly.

    tests -- a list of strings containing test names (optional)
    testdir -- the directory in which to look for tests (optional)

    Users other than the Python test suite will certainly want to
    specify testdir; if it's omitted, the directory containing the
    Python test suite is searched for.

    If the tests argument is omitted, the tests listed on the
    command-line will be used.  If that's empty, too, then all *.py
    files beginning with test_ will be used.

    """

    try:
        opts, args = getopt.getopt(sys.argv[1:], 'hvqx:t:pcd', ['help'])
    except getopt.error, msg:
        print msg
        print __doc__
        return 2
    verbose = 0
    quiet = False
    profile = False
    exclude = []
    capture = 0
    for o, a in opts:
        if o == '-v':
            verbose += 1
        elif o == '-q':
            quiet = True
            verbose = 0
        elif o == '-x':
            exclude.append(a)
        elif o == '-t':
            testdir = a
        elif o == '-p':
            profile = True
        elif o == '-c':
            capture += 1
        elif o == '-d':
            global ENABLE_DBC
            ENABLE_DBC = True
        elif o in ('-h', '--help'):
            print __doc__
            sys.exit(0)

    args = [item.rstrip('.py') for item in args]
    exclude = [item.rstrip('.py') for item in exclude]

    if testdir is not None:
        os.chdir(testdir)
    sys.path.insert(0, '')
    tests = find_tests('.', args or DEFAULT_PREFIXES, excludes=exclude)
    # Tell tests to be moderately quiet
    test_support.verbose = verbose
    if profile:
        print >> sys.stderr, '** profiled run'
        from hotshot import Profile
        prof = Profile('stones.prof')
        start_time, start_ctime = time.time(), time.clock()
        good, bad, skipped, all_result = prof.runcall(run_tests, tests, quiet,
                                                      verbose, None, capture)
        end_time, end_ctime = time.time(), time.clock()
        prof.close()
    else:
        start_time, start_ctime = time.time(), time.clock()
        good, bad, skipped, all_result = run_tests(tests, quiet, verbose, None, capture)
        end_time, end_ctime = time.time(), time.clock()
    if not quiet:
        print '*'*80
        if all_result:
            print 'Ran %s test cases in %0.2fs (%0.2fs CPU)' % (all_result.testsRun,
                                                                end_time - start_time,
                                                                end_ctime - start_ctime), 
            if all_result.errors:
                print ', %s errors' % len(all_result.errors),
            if all_result.failures:
                print ', %s failed' % len(all_result.failures),
            if all_result.skipped:
                print ', %s skipped' % len(all_result.skipped),
            print
        if good:
            if not bad and not skipped and len(good) > 1:
                print "All",
            print _count(len(good), "test"), "OK."
        if bad:
            print _count(len(bad), "test"), "failed:",
            print ', '.join(bad)
        if skipped:
            print _count(len(skipped), "test"), "skipped:",
            print ', '.join(['%s (%s)' % (test, msg) for test, msg in skipped])
    if profile:
        from hotshot import stats
        stats = stats.load('stones.prof')
        stats.sort_stats('time', 'calls')
        stats.print_stats(30)
    if exitafter:
        sys.exit(len(bad) + len(skipped))
    else:
        sys.path.pop(0)
        return len(bad)
main = obsolete("testlib.main() is obsolete, use the pytest tool instead")(main)


def run_tests(tests, quiet, verbose, runner=None, capture=0):
    """ execute a list of tests
    return a 3-uple with :
       _ the list of passed tests
       _ the list of failed tests
       _ the list of skipped tests
    """
    good = []
    bad = []
    skipped = []
    all_result = None
    for test in tests:
        if not quiet:
            print 
            print '-'*80
            print "Executing", test
        result = run_test(test, verbose, runner, capture)
        if type(result) is type(''):
            # an unexpected error occured
            skipped.append( (test, result))
        else:
            if all_result is None:
                all_result = result
            else:
                all_result.testsRun += result.testsRun
                all_result.failures += result.failures
                all_result.errors += result.errors
                all_result.skipped += result.skipped
            if result.errors or result.failures:
                bad.append(test)
                if verbose:
                    print "test", test, \
                          "failed -- %s errors, %s failures" % (
                        len(result.errors), len(result.failures))
            else:
                good.append(test)
            
    return good, bad, skipped, all_result
    
def find_tests(testdir,
               prefixes=DEFAULT_PREFIXES, suffix=".py",
               excludes=(),
               remove_suffix=True):
    """
    Return a list of all applicable test modules.
    """
    tests = []
    for name in os.listdir(testdir):
        if not suffix or name.endswith(suffix):
            for prefix in prefixes:
                if name.startswith(prefix):
                    if remove_suffix and name.endswith(suffix):
                        name = name[:-len(suffix)]
                    if name not in excludes:
                        tests.append(name)
    tests.sort()
    return tests


def run_test(test, verbose, runner=None, capture=0):
    """
    Run a single test.

    test -- the name of the test
    verbose -- if true, print more messages
    """
    test_support.unload(test)
    try:
        m = load_module_from_name(test, path=sys.path)
#        m = __import__(test, globals(), locals(), sys.path)
        try:
            suite = m.suite
            if callable(suite):
                suite = suite()
        except AttributeError:
            loader = unittest.TestLoader()
            suite = loader.loadTestsFromModule(m)
        if runner is None:
            runner = SkipAwareTextTestRunner(capture=capture) # verbosity=0)
        return runner.run(suite)
    except KeyboardInterrupt, v:
        raise KeyboardInterrupt, v, sys.exc_info()[2]
    except:
        # raise
        type, value = sys.exc_info()[:2]
        msg = "test %s crashed -- %s : %s" % (test, type, value)
        if verbose:
            traceback.print_exc()
        return msg

def _count(n, word):
    """format word according to n"""
    if n == 1:
        return "%d %s" % (n, word)
    else:
        return "%d %ss" % (n, word)


    

## PostMortem Debug facilities #####
def start_interactive_mode(result):
    """starts an interactive shell so that the user can inspect errors
    """
    debuggers = result.debuggers
    descrs = result.error_descrs + result.fail_descrs
    if len(debuggers) == 1:
        # don't ask for test name if there's only one failure
        debuggers[0].start()
    else:
        while True:
            testindex = 0
            print "Choose a test to debug:"
            # order debuggers in the same way than errors were printed
            print "\n".join(['\t%s : %s' % (i, descr) for i, (_, descr) in enumerate(descrs)])
            print "Type 'exit' (or ^D) to quit"
            print
            try:
                todebug = raw_input('Enter a test name: ')
                if todebug.strip().lower() == 'exit':
                    print
                    break
                else:
                    try:
                        testindex = int(todebug)
                        debugger = debuggers[descrs[testindex][0]]
                    except (ValueError, IndexError):
                        print "ERROR: invalid test number %r" % (todebug,)
                    else:
                        debugger.start()
            except (EOFError, KeyboardInterrupt):
                print
                break


# test utils ##################################################################
from cStringIO import StringIO

class SkipAwareTestResult(unittest._TextTestResult):

    def __init__(self, stream, descriptions, verbosity,
                 exitfirst=False, capture=0, printonly=None,
                 pdbmode=False, cvg=None):
        super(SkipAwareTestResult, self).__init__(stream,
                                                  descriptions, verbosity)
        self.skipped = []
        self.debuggers = []
        self.fail_descrs = []
        self.error_descrs = []
        self.exitfirst = exitfirst
        self.capture = capture
        self.printonly = printonly
        self.pdbmode = pdbmode
        self.cvg = cvg
        self.pdbclass = Debugger

    def descrs_for(self, flavour):
        return getattr(self, '%s_descrs' % flavour.lower())
    
    def _create_pdb(self, test_descr, flavour):
        self.descrs_for(flavour).append( (len(self.debuggers), test_descr) )
        if self.pdbmode:
            self.debuggers.append(self.pdbclass(sys.exc_info()[2]))
        
    def addError(self, test, err):
        exc_type, exc, tcbk = err
        if exc_type == TestSkipped:
            self.addSkipped(test, exc)
        else:
            if self.exitfirst:
                self.shouldStop = True
            descr = self.getDescription(test)
            super(SkipAwareTestResult, self).addError(test, err)
            self._create_pdb(descr, 'error')

    def addFailure(self, test, err):
        if self.exitfirst:
            self.shouldStop = True
        descr = self.getDescription(test)
        super(SkipAwareTestResult, self).addFailure(test, err)
        self._create_pdb(descr, 'fail')

    def addSkipped(self, test, reason):
        self.skipped.append((test, self.getDescription(test), reason))
        if self.showAll:
            self.stream.writeln("SKIPPED")
        elif self.dots:
            self.stream.write('S')

    def printErrors(self):
        super(SkipAwareTestResult, self).printErrors()
        self.printSkippedList()
        
    def printSkippedList(self):
        for test, descr, err in self.skipped:
            self.stream.writeln(self.separator1)
            self.stream.writeln("%s: %s" % ('SKIPPED', descr))
            self.stream.writeln("\t%s" % err)

    def printErrorList(self, flavour, errors):
        for (_, descr), (test, err) in zip(self.descrs_for(flavour), errors):
            self.stream.writeln(self.separator1)
            self.stream.writeln("%s: %s" % (flavour, descr))
            self.stream.writeln(self.separator2)
            self.stream.writeln("%s" % err)
            try:
                output, errput = test.captured_output()
            except AttributeError:
                pass # original unittest
            else:
                if output:
                    self.stream.writeln(self.separator2)
                    self.stream.writeln("captured stdout".center(len(self.separator2)))
                    self.stream.writeln(self.separator2)
                    self.stream.writeln(output)
                else:
                    self.stream.writeln('no stdout'.center(len(self.separator2)))
                if errput:
                    self.stream.writeln(self.separator2)
                    self.stream.writeln("captured stderr".center(len(self.separator2)))
                    self.stream.writeln(self.separator2)
                    self.stream.writeln(errput)
                else:
                    self.stream.writeln('no stderr'.center(len(self.separator2)))



class TestSuite(unittest.TestSuite):
    def run(self, result, runcondition=None, options=None):
        for test in self._tests:
            if result.shouldStop:
                break
            test(result, runcondition, options)
        return result
    
    # python2.3 compat
    def __call__(self, *args, **kwds):
        return self.run(*args, **kwds)


class SkipAwareTextTestRunner(unittest.TextTestRunner):

    def __init__(self, stream=sys.stderr, verbosity=1,
                 exitfirst=False, capture=False, printonly=None,
                 pdbmode=False, cvg=None, test_pattern=None, skipped_patterns=(),
                 options=None):
        super(SkipAwareTextTestRunner, self).__init__(stream=stream,
                                                      verbosity=verbosity)
        self.exitfirst = exitfirst
        self.capture = capture
        self.printonly = printonly
        self.pdbmode = pdbmode
        self.cvg = cvg
        self.test_pattern = test_pattern
        self.skipped_patterns = skipped_patterns
        self.options = options

    def _this_is_skipped(self, testedname):
        return any([(pat in testedname) for pat in self.skipped_patterns])

    def _runcondition(self, test, skipgenerator=True):
        if isinstance(test, InnerTest):
            testname = test.name
        else:
            if isinstance(test, TestCase):
                meth = test._get_test_method()
                func = meth.im_func
                testname = '%s.%s' % (meth.im_class.__name__, func.__name__)
            elif isinstance(test, types.FunctionType):
                func = test
                testname = func.__name__
            elif isinstance(test, types.MethodType):
                func = test.im_func
                testname = '%s.%s' % (test.im_class.__name__, func.__name__)
            else:
                return True # Not sure when this happens
            if is_generator(func) and skipgenerator:
                return True # Let inner tests decide at run time
        # print 'testname', testname, self.test_pattern
        if self._this_is_skipped(testname):
            return False # this was explicitly skipped
        if self.test_pattern is None:
            return True # no pattern
        try:
            classpattern, testpattern = self.test_pattern.split('.')
            klass, name = testname.split('.')
            return classpattern in klass and testpattern in name
        except ValueError:
            return self.test_pattern in testname
    
    def _makeResult(self):
        return SkipAwareTestResult(self.stream, self.descriptions, self.verbosity,
                                   self.exitfirst, self.capture, self.printonly,
                                   self.pdbmode, self.cvg)

    def run(self, test):
        "Run the given test case or test suite."
        result = self._makeResult()
        startTime = time.time()
        test(result, self._runcondition, self.options)
        stopTime = time.time()
        timeTaken = stopTime - startTime
        result.printErrors()
        self.stream.writeln(result.separator2)
        run = result.testsRun
        self.stream.writeln("Ran %d test%s in %.3fs" %
                            (run, run != 1 and "s" or "", timeTaken))
        self.stream.writeln()
        if not result.wasSuccessful():
            self.stream.write("FAILED (")
            failed, errored = map(len, (result.failures, result.errors))
            if failed:
                self.stream.write("failures=%d" % failed)
            if errored:
                if failed: self.stream.write(", ")
                self.stream.write("errors=%d" % errored)
            self.stream.writeln(")")
        else:
            self.stream.writeln("OK")
        return result


class keywords(dict):
    """keyword args (**kwargs) support for generative tests"""

class starargs(tuple):
    """variable arguments (*args) for generative tests"""
    def __new__(cls, *args):
        return tuple.__new__(cls, args)



class NonStrictTestLoader(unittest.TestLoader):
    """
    overrides default testloader to be able to omit classname when
    specifying tests to run on command line. For example, if the file
    test_foo.py contains ::
    
        class FooTC(TestCase):
            def test_foo1(self): # ...
            def test_foo2(self): # ...
            def test_bar1(self): # ...

        class BarTC(TestCase):
            def test_bar2(self): # ...

    python test_foo.py will run the 3 tests in FooTC
    python test_foo.py FooTC will run the 3 tests in FooTC
    python test_foo.py test_foo will run test_foo1 and test_foo2
    python test_foo.py test_foo1 will run test_foo1
    python test_foo.py test_bar will run FooTC.test_bar1 and BarTC.test_bar2
    """
    suiteClass = TestSuite

    def __init__(self):
        self.skipped_patterns = []

    def loadTestsFromNames(self, names, module=None):
        suites = []
        for name in names:
            suites.extend(self.loadTestsFromName(name, module))
        return self.suiteClass(suites)

    def _collect_tests(self, module):
        tests = {}
        for obj in vars(module).values():
            if (issubclass(type(obj), (types.ClassType, type)) and
                 issubclass(obj, unittest.TestCase)):
                classname = obj.__name__
                if self._this_is_skipped(classname):
                    continue
                methodnames = []
                # obj is a TestCase class
                for attrname in dir(obj):
                    if attrname.startswith(self.testMethodPrefix):
                        attr = getattr(obj, attrname)
                        if callable(attr):
                            methodnames.append(attrname)
                # keep track of class (obj) for convenience
                tests[classname] = (obj, methodnames)
        return tests

    def loadTestsFromSuite(self, module, suitename):
        try:
            suite = getattr(module, suitename)()
        except AttributeError:
            return []
        assert hasattr(suite, '_tests'), \
               "%s.%s is not a valid TestSuite" % (module.__name__, suitename)
        # python2.3 does not implement __iter__ on suites, we need to return
        # _tests explicitly
        return suite._tests
    
    def loadTestsFromName(self, name, module=None):
        parts = name.split('.')
        if module is None or len(parts) > 2:
            # let the base class do its job here
            return [super(NonStrictTestLoader, self).loadTestsFromName(name)]
        tests = self._collect_tests(module)
        # import pprint
        # pprint.pprint(tests)
        collected = []
        if len(parts) == 1:
            pattern = parts[0]
            if callable(getattr(module, pattern, None)) and pattern not in tests:
                # consider it as a suite
                return self.loadTestsFromSuite(module, pattern)
            if pattern in tests:
                # case python unittest_foo.py MyTestTC
                klass, methodnames = tests[pattern]
                for methodname in methodnames:
                    collected = [klass(methodname) for methodname in methodnames]
            else:
                # case python unittest_foo.py something
                for klass, methodnames in tests.values():
                    collected += [klass(methodname) for methodname in methodnames]
        elif len(parts) == 2:
            # case "MyClass.test_1"
            classname, pattern = parts
            klass, methodnames = tests.get(classname, (None, []))
            for methodname in methodnames:
                collected = [klass(methodname) for methodname in methodnames]
        return collected

    def _this_is_skipped(self, testedname):
        return any([(pat in testedname) for pat in self.skipped_patterns])

    def getTestCaseNames(self, testCaseClass):
        """Return a sorted sequence of method names found within testCaseClass
        """
        is_skipped = self._this_is_skipped
        if is_skipped(testCaseClass.__name__):
            return []
        testnames = super(NonStrictTestLoader, self).getTestCaseNames(testCaseClass)
        return [testname for testname in testnames if not is_skipped(testname)]

    
class SkipAwareTestProgram(unittest.TestProgram):
    # XXX: don't try to stay close to unittest.py, use optparse
    USAGE = """\
Usage: %(progName)s [options] [test] [...]

Options:
  -h, --help       Show this message
  -v, --verbose    Verbose output
  -i, --pdb        Enable test failure inspection
  -x, --exitfirst  Exit on first failure
  -c, --capture    Captures and prints standard out/err only on errors
  -p, --printonly  Only prints lines matching specified pattern (implies capture)
  -s, --skip       skip test matching this pattern (no regexp for now)
  -q, --quiet      Minimal output

Examples:
  %(progName)s                               - run default set of tests
  %(progName)s MyTestSuite                   - run suite 'MyTestSuite'
  %(progName)s MyTestCase.testSomething      - run MyTestCase.testSomething
  %(progName)s MyTestCase                    - run all 'test*' test methods
                                               in MyTestCase
"""
    def __init__(self, module='__main__', defaultTest=None, batchmode=False,
                 cvg=None, options=None):
        self.batchmode = batchmode
        self.cvg = cvg
        self.options = options
        super(SkipAwareTestProgram, self).__init__(
            module=module, defaultTest=defaultTest,
            testLoader=NonStrictTestLoader())
    
    def parseArgs(self, argv):
        self.pdbmode = False
        self.exitfirst = False
        self.capture = 0
        self.printonly = None
        self.skipped_patterns = []
        self.test_pattern = None
        import getopt
        try:
            options, args = getopt.getopt(argv[1:], 'hHvixqcp:s:',
                                          ['help','verbose','quiet', 'pdb',
                                           'exitfirst', 'capture', 'printonly=',
                                           'skip='])
            for opt, value in options:
                if opt in ('-h','-H','--help'):
                    self.usageExit()
                if opt in ('-i', '--pdb'):
                    self.pdbmode = True
                if opt in ('-x', '--exitfirst'):
                    self.exitfirst = True
                if opt in ('-q','--quiet'):
                    self.verbosity = 0
                if opt in ('-v','--verbose'):
                    self.verbosity = 2
                if opt in ('-c', '--capture'):
                    self.capture += 1
                if opt in ('-p', '--printonly'):
                    self.printonly = re.compile(value)
                if opt in ('-s', '--skip'):
                    self.skipped_patterns = [pat.strip() for pat in value.split(',')]
            self.testLoader.skipped_patterns = self.skipped_patterns
            if self.printonly is not None:
                self.capture += 1
            if len(args) == 0 and self.defaultTest is None:
                suitefunc = getattr(self.module, 'suite', None)
                if isinstance(suitefunc, (types.FunctionType, types.MethodType)):
                    self.test = self.module.suite()
                else:
                    self.test = self.testLoader.loadTestsFromModule(self.module)
                return
            if len(args) > 0:
                self.test_pattern = args[0]
                self.testNames = args
            else:
                self.testNames = (self.defaultTest,)
            self.createTests()
        except getopt.error, msg:
            self.usageExit(msg)


    def runTests(self):
        if hasattr(self.module, 'setup_module'):
            try:
                self.module.setup_module(self.options)
            except Exception, exc:
                print 'setup_module error:', exc
                sys.exit(1)
        self.testRunner = SkipAwareTextTestRunner(verbosity=self.verbosity,
                                                  exitfirst=self.exitfirst,
                                                  capture=self.capture,
                                                  printonly=self.printonly,
                                                  pdbmode=self.pdbmode,
                                                  cvg=self.cvg,
                                                  test_pattern=self.test_pattern,
                                                  skipped_patterns=self.skipped_patterns,
                                                  options=self.options)
        result = self.testRunner.run(self.test)
        if hasattr(self.module, 'teardown_module'):
            try:
                self.module.teardown_module(self.options)
            except Exception, exc:
                print 'teardown_module error:', exc
                sys.exit(1)
        if os.environ.get('PYDEBUG'):
            warn("PYDEBUG usage is deprecated, use -i / --pdb instead", DeprecationWarning)
            self.pdbmode = True
        if result.debuggers and self.pdbmode:
            start_interactive_mode(result)
        if not self.batchmode:
            sys.exit(not result.wasSuccessful())
        self.result = result




class FDCapture: 
    """adapted from py lib (http://codespeak.net/py)
    Capture IO to/from a given os-level filedescriptor.
    """
    def __init__(self, fd, attr='stdout', printonly=None):
        self.targetfd = fd
        self.tmpfile = os.tmpfile() # self.maketempfile()
        self.printonly = printonly
        # save original file descriptor
        self._savefd = os.dup(fd)
        # override original file descriptor
        os.dup2(self.tmpfile.fileno(), fd)
        # also modify sys module directly
        self.oldval = getattr(sys, attr)
        setattr(sys, attr, self) # self.tmpfile)
        self.attr = attr

    def write(self, msg):
        # msg might be composed of several lines
        for line in msg.splitlines():
            line += '\n' # keepdend=True is not enough
            if self.printonly is None or self.printonly.search(line) is None:
                self.tmpfile.write(line)
            else:
                os.write(self._savefd, line)
        
##     def maketempfile(self):
##         tmpf = os.tmpfile()
##         fd = os.dup(tmpf.fileno())
##         newf = os.fdopen(fd, tmpf.mode, 0) # No buffering
##         tmpf.close()
##         return newf
        
    def restore(self):
        """restore original fd and returns captured output"""
        # hack hack hack
        self.tmpfile.flush()
        try:
            ref_file = getattr(sys, '__%s__' % self.attr)
            ref_file.flush()
        except AttributeError:
            pass
        if hasattr(self.oldval, 'flush'):
            self.oldval.flush()
        # restore original file descriptor
        os.dup2(self._savefd, self.targetfd)
        # restore sys module
        setattr(sys, self.attr, self.oldval)
        # close backup descriptor
        os.close(self._savefd)
        # go to beginning of file and read it
        self.tmpfile.seek(0)
        return self.tmpfile.read()


def _capture(which='stdout', printonly=None):
    """private method, should not be called directly
    (cf. capture_stdout() and capture_stderr())
    """
    assert which in ('stdout', 'stderr'), "Can only capture stdout or stderr, not %s" % which
    if which == 'stdout':
        fd = 1
    else:
        fd = 2
    return FDCapture(fd, which, printonly)
    
def capture_stdout(printonly=None):
    """captures the standard output

    returns a handle object which has a `restore()` method.
    The restore() method returns the captured stdout and restores it
    """
    return _capture('stdout', printonly)
        
def capture_stderr(printonly=None):
    """captures the standard error output

    returns a handle object which has a `restore()` method.
    The restore() method returns the captured stderr and restores it
    """
    return _capture('stderr', printonly)


def unittest_main(module='__main__', defaultTest=None,
                  batchmode=False, cvg=None, options=None):
    """use this functon if you want to have the same functionality
    as unittest.main"""
    return SkipAwareTestProgram(module, defaultTest, batchmode, cvg, options)

class TestSkipped(Exception):
    """raised when a test is skipped"""

def is_generator(function):
    flags = function.func_code.co_flags
    return flags & CO_GENERATOR


def parse_generative_args(params):
    args = []
    varargs = ()
    kwargs = {}
    flags = 0 # 2 <=> starargs, 4 <=> kwargs
    for param in params:
        if isinstance(param, starargs):
            varargs = param
            if flags:
                raise TypeError('found starargs after keywords !')
            flags |= 2
            args += list(varargs)
        elif isinstance(param, keywords):
            kwargs = param
            if flags & 4:
                raise TypeError('got multiple keywords parameters')
            flags |= 4
        elif flags & 2 or flags & 4:
            raise TypeError('found parameters after kwargs or args')
        else:
            args.append(param)

    return args, kwargs

class InnerTest(tuple):
    def __new__(cls, name, *data):
        instance = tuple.__new__(cls, data)
        instance.name = name
        return instance

class ClassGetProperty(object):
    """this is a simple property-like class but for
    class attributes.
    """
    
    def __init__(self, getter):
        self.getter = getter

    def __get__(self, obj, objtype):
        return self.getter(objtype)


class TestCase(unittest.TestCase):
    """unittest.TestCase with some additional methods"""

    capture = False
    pdbclass = Debugger
    
    def __init__(self, methodName='runTest'):
        super(TestCase, self).__init__(methodName)
        # internal API changed in python2.5
        if sys.version_info >= (2, 5):
            self.__exc_info = self._exc_info
            self.__testMethodName = self._testMethodName
        else:
            # let's give easier access to _testMethodName to every subclasses
            self._testMethodName = self.__testMethodName
        self._captured_stdout = ""
        self._captured_stderr = ""
        self._out = []
        self._err = []
        self._current_test_descr = None
        self._options_ = None

    def datadir(cls):
        """helper attribute holding the standard test's data directory
        
        NOTE: this is a logilab's standard
        """
        mod = __import__(cls.__module__)
        return osp.join(osp.dirname(osp.abspath(mod.__file__)), 'data')
    # cache it (use a class method to cache on class since TestCase is
    # instantiated for each test run)
    datadir = ClassGetProperty(cached(datadir))

    def datapath(self, fname):
        """joins the object's datadir and `fname`"""
        return osp.join(self.datadir, fname)

    def set_description(self, descr):
        """sets the current test's description.
        This can be useful for generative tests because it allows to specify
        a description per yield
        """
        self._current_test_descr = descr

    # override default's unittest.py feature
    def shortDescription(self):
	"""override default unitest shortDescription to handle correctly
	generative tests
	"""
        if self._current_test_descr is not None:
	    return self._current_test_descr
	return super(TestCase, self).shortDescription()

    
    def captured_output(self):
        return self._captured_stdout.strip(), self._captured_stderr.strip()

    def _start_capture(self):
        if self.capture:
            self.start_capture()

    def _stop_capture(self):
        self._force_output_restore()
    
    def start_capture(self, printonly=None):
        self._out.append(capture_stdout(printonly or self._printonly))
        self._err.append(capture_stderr(printonly or self._printonly))

    def printonly(self, pattern, flags=0):
        rgx = re.compile(pattern, flags)
        if self._out:
            self._out[-1].printonly = rgx
            self._err[-1].printonly = rgx
        else:
            self.start_capture(printonly=rgx)
        
    def stop_capture(self):
        if self._out:
            _out = self._out.pop()
            _err = self._err.pop()
            return _out.restore(), _err.restore()
        return '', ''
    
    def _force_output_restore(self):
        while self._out:
            self._captured_stdout += self._out.pop().restore()
            self._captured_stderr += self._err.pop().restore()
    
    def quiet_run(self, result, func, *args, **kwargs):
        self._start_capture()
        try:
            func(*args, **kwargs)
        except (KeyboardInterrupt, SystemExit):
            self._stop_capture()
            raise
        except:
            self._stop_capture()
            result.addError(self, self.__exc_info())
            return False
        self._stop_capture()
        return True

    def _get_test_method(self):
        return getattr(self, self.__testMethodName)


    def optval(self, option, default=None):
        return getattr(self._options_, option, default)

    def __call__(self, result=None, runcondition=None, options=None):
        """rewrite TestCase.__call__ to support generative tests
        This is mostly a copy/paste from unittest.py (i.e same
        variable names, same logic, except for the generative tests part)
        """
        if result is None:
            result = self.defaultTestResult()
        result.pdbclass = self.pdbclass
        # if self.capture is True here, it means it was explicitly specified
        # in the user's TestCase class. If not, do what was asked on cmd line
        self.capture = self.capture or getattr(result, 'capture', False)
        self._options_ = options
        self._printonly = getattr(result, 'printonly', None)
        # if result.cvg:
        #     result.cvg.start()
        testMethod = self._get_test_method()
        if runcondition and not runcondition(testMethod):
            return # test is skipped
        result.startTest(self)
        try:
            if not self.quiet_run(result, self.setUp):
                return
            # generative tests
            if is_generator(testMethod.im_func):
                success = self._proceed_generative(result, testMethod, runcondition)
            else:
                status = self._proceed(result, testMethod)
                success = (status == 0)
            if not self.quiet_run(result, self.tearDown):
                return
            if success:
                result.addSuccess(self)
        finally:
            # if result.cvg:
            #     result.cvg.stop()
            result.stopTest(self)


            
    def _proceed_generative(self, result, testfunc, runcondition=None):
        # cancel startTest()'s increment
        result.testsRun -= 1
        self._start_capture()
        success = True
        try:
            for params in testfunc():
                if runcondition and not runcondition(testfunc, skipgenerator=False):
                    if not (isinstance(params, InnerTest) and runcondition(params)):
                        continue
                if not isinstance(params, (tuple, list)):
                    params = (params,)
                func = params[0]
                args, kwargs = parse_generative_args(params[1:])
                # increment test counter manually
                result.testsRun += 1
                status = self._proceed(result, func, args, kwargs)
                if status == 0:
                    result.addSuccess(self)
                    success = True
                else:
                    success = False
                    if status == 2:
                        result.shouldStop = True
                if result.shouldStop: # either on error or on exitfirst + error
                    break
        except:
            # if an error occurs between two yield
            result.addError(self, self.__exc_info())
            success = False
        self._stop_capture()
        return success

    def _proceed(self, result, testfunc, args=(), kwargs=None):
        """proceed the actual test
        returns 0 on success, 1 on failure, 2 on error

        Note: addSuccess can't be called here because we have to wait
        for tearDown to be successfully executed to declare the test as
        successful
        """
        self._start_capture()
        kwargs = kwargs or {}
        try:
            testfunc(*args, **kwargs)
            self._stop_capture()
        except self.failureException:
            self._stop_capture()
            result.addFailure(self, self.__exc_info())
            return 1
        except KeyboardInterrupt:
            self._stop_capture()
            raise
        except:
            self._stop_capture()
            result.addError(self, self.__exc_info())
            return 2
        return 0
            
    def defaultTestResult(self):
        return SkipAwareTestResult()

    def skip(self, msg=None):
        msg = msg or 'test was skipped'
        raise TestSkipped(msg)
    skipped_test = deprecated_function(skip)
    
    def assertDictEquals(self, d1, d2):
        """compares two dicts

        If the two dict differ, the first difference is shown in the error
        message
        """
        d1 = d1.copy()
        msgs = []
        for key, value in d2.items():
            try:
                if d1[key] != value:
                    msgs.append('%r != %r for key %r' % (d1[key], value, key))
                del d1[key]
            except KeyError:
                msgs.append('missing %r key' % key)
        if d1:
            msgs.append('d2 is lacking %r' % d1)
        if msgs:
            self.fail('\n'.join(msgs))
    assertDictEqual = assertDictEquals

    def assertSetEquals(self, got, expected, msg=None):
        """compares two iterables and shows difference between both"""
        got, expected = list(got), list(expected)
        if msg is None:
	        msg1 = '%s != %s' % (got, expected)
        else:
            msg1 = msg
        self.assertEquals(len(got), len(expected), msg1)
        got, expected = set(got), set(expected)
        if got != expected:
            missing = expected - got
            unexpected = got - expected
            if msg is None:
                msg = '\tunexepected: %s\n\tmissing: %s' % (unexpected,
                                                               missing)
            self.fail(msg)
    assertSetEqual = assertSetEquals

    def assertListEquals(self, l1, l2, msg=None):
        """compares two lists

        If the two list differ, the first difference is shown in the error
        message
        """
        _l1 = l1[:]
        for i, value in enumerate(l2):
            try:
                if _l1[0] != value:
                    from pprint import pprint
                    pprint(l1)
                    pprint(l2)
                    self.fail('%r != %r for index %d' % (_l1[0], value, i))
                del _l1[0]
            except IndexError:
                if msg is None:
                    msg = 'l1 has only %d elements, not %s (at least %r missing)'% (i, len(l2), value)
                self.fail(msg)
        if _l1:
            if msg is None:
                msg = 'l2 is lacking %r' % _l1
            self.fail(msg)
    assertListEqual = assertListEquals
    
    def assertLinesEquals(self, l1, l2, msg=None):
        """assert list of lines are equal"""
        self.assertListEquals(l1.splitlines(), l2.splitlines(), msg)
    assertLineEqual = assertLinesEquals

    def assertXMLWellFormed(self, stream, msg=None):
        """asserts the XML stream is well-formed (no DTD conformance check)"""
        from xml.sax import make_parser, SAXParseException
        parser = make_parser()
        try:
            parser.parse(stream)
        except SAXParseException:
            if msg is None:
                msg = 'XML stream not well formed'
            self.fail(msg)
    assertXMLValid = deprecated_function(assertXMLWellFormed,
                                         'assertXMLValid renamed to more precise assertXMLWellFormed')

    def assertXMLStringWellFormed(self, xml_string, msg=None):
        """asserts the XML string is well-formed (no DTD conformance check)"""
        stream = StringIO(xml_string)
        self.assertXMLWellFormed(stream, msg)
        
    assertXMLStringValid = deprecated_function(
        assertXMLStringWellFormed, 'assertXMLStringValid renamed to more precise assertXMLStringWellFormed')


    def _difftext(self, lines1, lines2, junk=None):
        junk = junk or (' ', '\t')
        # result is a generator
        result = difflib.ndiff(lines1, lines2, charjunk=lambda x: x in junk)
        read = []
        for line in result:
            read.append(line)
            # lines that don't start with a ' ' are diff ones
            if not line.startswith(' '):
                self.fail(''.join(read + list(result)))
        
    def assertTextEquals(self, text1, text2, junk=None):
        """compare two multiline strings (using difflib and splitlines())"""
        self._difftext(text1.splitlines(True), text2.splitlines(True), junk)
    assertTextEqual = assertTextEquals
            
    def assertStreamEqual(self, stream1, stream2, junk=None):
        """compare two streams (using difflib and readlines())"""
        # if stream2 is stream2, readlines() on stream1 will also read lines
        # in stream2, so they'll appear different, although they're not
        if stream1 is stream2:
            return
        # make sure we compare from the beginning of the stream
        stream1.seek(0)
        stream2.seek(0)
        # ocmpare
        self._difftext(stream1.readlines(), stream2.readlines(), junk)
            
    def assertFileEqual(self, fname1, fname2, junk=(' ', '\t')):
        """compares two files using difflib"""
        self.assertStreamEqual(file(fname1), file(fname2), junk)
            
    def assertIsInstance(self, obj, klass, msg=None, strict=False):
        """compares two files using difflib"""
        if msg is None:
            if strict:
                msg = '%r is not of class %s but of %s'
            else:
                msg = '%r is not an instance of %s but of %s'
            msg = msg % (obj, klass, type(obj))
        if strict:
            self.assert_(obj.__class__ is klass, msg)
        else:
            self.assert_(isinstance(obj, klass), msg)


    def failUnlessRaises(self, excClass, callableObj, *args, **kwargs):
        """override default failUnlessRaise method to return the raised
        exception instance.
        
        Fail unless an exception of class excClass is thrown
        by callableObj when invoked with arguments args and keyword
        arguments kwargs. If a different type of exception is
        thrown, it will not be caught, and the test case will be
        deemed to have suffered an error, exactly as for an
        unexpected exception.
        """
        try:
            callableObj(*args, **kwargs)
        except excClass, exc:
            return exc
        else:
            if hasattr(excClass, '__name__'):
                excName = excClass.__name__
            else:
                excName = str(excClass)
            raise self.failureException, "%s not raised" % excName

    assertRaises = failUnlessRaises

import doctest

class SkippedSuite(unittest.TestSuite):
    def test(self):
        """just there to trigger test execution"""
        self.skipped_test('doctest module has no DocTestSuite class')


# DocTestFinder was introduced in python2.4
if sys.version_info >= (2, 4):
    class DocTestFinder(doctest.DocTestFinder):

        def __init__(self, *args, **kwargs):
            self.skipped = kwargs.pop('skipped', ())
            doctest.DocTestFinder.__init__(self, *args, **kwargs)

        def _get_test(self, obj, name, module, globs, source_lines):
            """override default _get_test method to be able to skip tests
            according to skipped attribute's value

            Note: Python (<=2.4) use a _name_filter which could be used for that
                  purpose but it's no longer available in 2.5
                  Python 2.5 seems to have a [SKIP] flag
            """
            if getattr(obj, '__name__', '') in self.skipped:
                return None
            return doctest.DocTestFinder._get_test(self, obj, name, module,
                                                   globs, source_lines)
else:
    # this is a hack to make skipped work with python <= 2.3
    class DocTestFinder(object):
        def __init__(self, skipped):
            self.skipped = skipped
            self.original_find_tests = doctest._find_tests
            doctest._find_tests = self._find_tests
            
        def _find_tests(self, module, prefix=None):
            tests = []
            for testinfo  in self.original_find_tests(module, prefix):
                testname, _, _, _ = testinfo
                # testname looks like A.B.C.function_name
                testname = testname.split('.')[-1]
                if testname not in self.skipped:
                    tests.append(testinfo)
            return tests


class DocTest(TestCase):
    """trigger module doctest
    I don't know how to make unittest.main consider the DocTestSuite instance
    without this hack
    """
    skipped = ()
    def __call__(self, result=None, runcondition=None, options=None):
        try:
            finder = DocTestFinder(skipped=self.skipped)
            if sys.version_info >= (2, 4):
                suite = doctest.DocTestSuite(self.module, test_finder=finder)
            else:
                suite = doctest.DocTestSuite(self.module)
        except AttributeError:
            suite = SkippedSuite()
        return suite.run(result)
    run = __call__
    
    def test(self):
        """just there to trigger test execution"""

MAILBOX = None

class MockSMTP:
    """fake smtplib.SMTP"""
    
    def __init__(self, host, port):
        self.host = host
        self.port = port
        global MAILBOX
        self.reveived = MAILBOX = []
        
    def set_debuglevel(self, debuglevel):
        """ignore debug level"""

    def sendmail(self, fromaddr, toaddres, body):
        """push sent mail in the mailbox"""
        self.reveived.append((fromaddr, toaddres, body))

    def quit(self):
        """ignore quit"""


class MockConfigParser:
    """fake ConfigParser.ConfigParser"""
    
    def __init__(self, options):
        self.options = options
        
    def get(self, section, option):
        """return option in section"""
        return self.options[section][option]

    def has_option(self, section, option):
        """ask if option exists in section"""
        try:
            return self.get(section, option) or 1
        except KeyError:
            return 0
    

class MockConnection:
    """fake DB-API 2.0 connexion AND cursor (i.e. cursor() return self)"""
    
    def __init__(self, results):
        self.received = []
        self.states = []
        self.results = results
        
    def cursor(self):
        return self
    def execute(self, query, args=None):
        self.received.append( (query, args) )
    def fetchone(self):
        return self.results[0]
    def fetchall(self):
        return self.results
    def commit(self):
        self.states.append( ('commit', len(self.received)) )
    def rollback(self):
        self.states.append( ('rollback', len(self.received)) )
    def close(self):
        pass

MockConnexion = class_renamed('MockConnexion', MockConnection)

def mock_object(**params):
    """creates an object using params to set attributes
    >>> option = mock_object(verbose=False, index=range(5))
    >>> option.verbose
    False
    >>> option.index
    [0, 1, 2, 3, 4]
    """
    return type('Mock', (), params)()


def create_files(paths, chroot):
    """creates directories and files found in <path>

    :param path: list of relative paths to files or directories
    :param chroot: the root directory in which paths will be created

    >>> from os.path import isdir, isfile
    >>> isdir('/tmp/a')
    False
    >>> create_files(['a/b/foo.py', 'a/b/c/', 'a/b/c/d/e.py'], '/tmp')
    >>> isdir('/tmp/a')
    True
    >>> isdir('/tmp/a/b/c')
    True
    >>> isfile('/tmp/a/b/c/d/e.py')
    True 
    >>> isfile('/tmp/a/b/foo.py')
    True
    """
    dirs, files = set(), set()
    for path in paths:
        path = osp.join(chroot, path)
        filename = osp.basename(path)
        # path is a directory path
        if filename == '':
            dirs.add(path)
        # path is a filename path
        else:
            dirs.add(osp.dirname(path))
            files.add(path)
    for dirpath in dirs:
        if not osp.isdir(dirpath):
            os.makedirs(dirpath)
    for filepath in files:
        file(filepath, 'w').close()

def enable_dbc(*args):
    """
    Without arguments, return True if contracts can be enabled and should be
    enabled (see option -d), return False otherwise.

    With arguments, return False if contracts can't or shouldn't be enabled,
    otherwise weave ContractAspect with items passed as arguments.
    """
    if not ENABLE_DBC:
        return False
    try:
        from clonedigger.logilab.aspects.weaver import weaver
        from clonedigger.logilab.aspects.lib.contracts import ContractAspect
    except ImportError:
        sys.stderr.write('Warning: logilab.aspects is not available. Contracts disabled.')
        return False
    for arg in args:
        weaver.weave_module(arg, ContractAspect)
    return True

    
class AttrObject: # XXX cf mock_object
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)
