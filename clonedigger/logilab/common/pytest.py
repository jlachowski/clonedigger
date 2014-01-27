"""pytest is a tool that eases test running and debugging.

To be able to use pytest, you should either write tests using
the logilab.common.testlib's framework or the unittest module of the
Python's standard library.

You can customize pytest's behaviour by defining a ``pytestconf.py`` file
somewhere in your test directory. In this file, you can add options or
change the way tests are run.

To add command line options, you must define a ``update_parser`` function in
your ``pytestconf.py`` file. The function must accept a single parameter
that will be the OptionParser's instance to customize.

If you wish to customize the tester, you'll have to define a class named
``CustomPyTester``. This class should extend the default `PyTester` class
defined in the pytest module. Take a look at the `PyTester` and `DjangoTester`
classes for more information about what can be done.


For instance, if you wish to add a custom -l option to specify a loglevel, you
could define the following ``pytestconf.py`` file ::

    import logging
    from clonedigger.logilab.common.pytest import PyTester
    
    def update_parser(parser):
        parser.add_option('-l', '--loglevel', dest='loglevel', action='store',
                          choices=('debug', 'info', 'warning', 'error', 'critical'),
                          default='critical', help="the default log level possible choices are "
                          "('debug', 'info', 'warning', 'error', 'critical')")
        return parser
    
    
    class CustomPyTester(PyTester):
        def __init__(self, cvg, options):
            super(CustomPyTester, self).__init__(cvg, options)
            loglevel = options.loglevel.upper()
            logger = logging.getLogger('erudi')
            logger.setLevel(logging.getLevelName(loglevel))


In your TestCase class you can then get the value of a specific option with
the ``optval`` method::
    
    class MyTestCase(TestCase):
        def test_foo(self):
            loglevel = self.optval('loglevel')
            # ...
            
"""

PYTEST_DOC = """%prog [OPTIONS] [testfile [testpattern]]

examples:

pytest path/to/mytests.py
pytest path/to/mytests.py TheseTests
pytest path/to/mytests.py TheseTests.test_thisone

pytest one (will run both test_thisone and test_thatone)
pytest path/to/mytests.py -s not (will skip test_notthisone)

pytest --coverage test_foo.py
  (only if logilab.devtools is available)
"""

import os, sys
import os.path as osp
from time import time, clock

from clonedigger.logilab.common.fileutils import abspath_listdir
from clonedigger.logilab.common import testlib
import doctest
import unittest


import imp

import __builtin__


try:
    import django
    from clonedigger.logilab.common.modutils import modpath_from_file, load_module_from_modpath
    DJANGO_FOUND = True
except ImportError:
    DJANGO_FOUND = False

CONF_FILE = 'pytestconf.py'

## coverage hacks, do not read this, do not read this, do not read this

# hey, but this is an aspect, right ?!!!
class TraceController(object):
    nesting = 0

    def pause_tracing(cls):
        if not cls.nesting:
            cls.tracefunc = getattr(sys, '__settrace__', sys.settrace)
            cls.oldtracer = getattr(sys, '__tracer__', None)
            sys.__notrace__ = True
            cls.tracefunc(None)
        cls.nesting += 1
    pause_tracing = classmethod(pause_tracing)

    def resume_tracing(cls):
        cls.nesting -= 1
        assert cls.nesting >= 0
        if not cls.nesting:
            cls.tracefunc(cls.oldtracer)
            delattr(sys, '__notrace__')
    resume_tracing = classmethod(resume_tracing)
    

pause_tracing = TraceController.pause_tracing
resume_tracing = TraceController.resume_tracing


def nocoverage(func):
    if hasattr(func, 'uncovered'):
        return func
    func.uncovered = True
    def not_covered(*args, **kwargs):
        pause_tracing()
        try:
            return func(*args, **kwargs)
        finally:
            resume_tracing()
    not_covered.uncovered = True
    return not_covered


## end of coverage hacks


# monkeypatch unittest and doctest (ouch !)
unittest.TestCase = testlib.TestCase
unittest.main = testlib.unittest_main
unittest._TextTestResult = testlib.SkipAwareTestResult
unittest.TextTestRunner = testlib.SkipAwareTextTestRunner
unittest.TestLoader = testlib.NonStrictTestLoader
unittest.TestProgram = testlib.SkipAwareTestProgram
if sys.version_info >= (2, 4):
    doctest.DocTestCase.__bases__ = (testlib.TestCase,)
else:
    unittest.FunctionTestCase.__bases__ = (testlib.TestCase,)



def this_is_a_testfile(filename):
    """returns True if `filename` seems to be a test file"""
    filename = osp.basename(filename)
    return ((filename.startswith('unittest')
             or filename.startswith('test')
             or filename.startswith('smoketest')) 
            and filename.endswith('.py'))
    

def this_is_a_testdir(dirpath):
    """returns True if `filename` seems to be a test directory"""
    return osp.basename(dirpath) in ('test', 'tests', 'unittests')


def load_pytest_conf(path, parser):
    """loads a ``pytestconf.py`` file and update default parser
    and / or tester.
    """
    namespace = {}
    execfile(path, namespace)
    if 'update_parser' in namespace:
        namespace['update_parser'](parser)
    return namespace.get('CustomPyTester', PyTester)


def project_root(parser, projdir=os.getcwd()):
    """try to find project's root and add it to sys.path"""
    curdir = osp.abspath(projdir)
    previousdir = curdir
    testercls = PyTester
    conf_file_path = osp.join(curdir, CONF_FILE)
    if osp.isfile(conf_file_path):
        testercls = load_pytest_conf(conf_file_path, parser)
    while this_is_a_testdir(curdir) or \
              osp.isfile(osp.join(curdir, '__init__.py')):
        newdir = osp.normpath(osp.join(curdir, os.pardir))
        if newdir == curdir:
            break
        previousdir = curdir
        curdir = newdir
        conf_file_path = osp.join(curdir, CONF_FILE)
        if osp.isfile(conf_file_path):
            testercls = load_pytest_conf(conf_file_path, parser)
    return previousdir, testercls


class GlobalTestReport(object):
    """this class holds global test statistics"""
    def __init__(self):
        self.ran = 0
        self.skipped = 0
        self.failures = 0
        self.errors = 0
        self.ttime = 0
        self.ctime = 0
        self.modulescount = 0
        self.errmodules = []

    def feed(self, filename, testresult, ttime, ctime):
        """integrates new test information into internal statistics"""
        ran = testresult.testsRun
        self.ran += ran
        self.skipped += len(getattr(testresult, 'skipped', ()))
        self.failures += len(testresult.failures)
        self.errors += len(testresult.errors)
        self.ttime += ttime
        self.ctime += ctime
        self.modulescount += 1
        if not testresult.wasSuccessful():
            problems = len(testresult.failures) + len(testresult.errors)
            self.errmodules.append((filename[:-3], problems, ran))


    def failed_to_test_module(self, filename):
        """called when the test module could not be imported by unittest
        """
        self.errors += 1
        self.errmodules.append((filename[:-3], 1, 1))
        
    
    def __str__(self):
        """this is just presentation stuff"""
        line1 = ['Ran %s test cases in %.2fs (%.2fs CPU)'
                 % (self.ran, self.ttime, self.ctime)]
        if self.errors:
            line1.append('%s errors' % self.errors)
        if self.failures:
            line1.append('%s failures' % self.failures)
        if self.skipped:
            line1.append('%s skipped' % self.skipped)
        modulesok = self.modulescount - len(self.errmodules)
        if self.errors or self.failures:
            line2 = '%s modules OK (%s failed)' % (modulesok,
                                                   len(self.errmodules))
            descr = ', '.join(['%s [%s/%s]' % info for info in self.errmodules])
            line3 = '\nfailures: %s' % descr
        elif modulesok:
            line2 = 'All %s modules OK' % modulesok
            line3 = ''
        else:
            return ''
        return '%s\n%s%s' % (', '.join(line1), line2, line3)



def remove_local_modules_from_sys(testdir):
    """remove all modules from cache that come from `testdir`

    This is used to avoid strange side-effects when using the
    testall() mode of pytest.
    For instance, if we run pytest on this tree::
    
      A/test/test_utils.py
      B/test/test_utils.py

    we **have** to clean sys.modules to make sure the correct test_utils
    module is ran in B
    """
    for modname, mod in sys.modules.items():
        if mod is None:
            continue
        if not hasattr(mod, '__file__'):
            # this is the case of some built-in modules like sys, imp, marshal
            continue
        modfile = mod.__file__
        # if modfile is not an asbolute path, it was probably loaded locally
        # during the tests
        if not osp.isabs(modfile) or modfile.startswith(testdir):
            del sys.modules[modname]



class PyTester(object):
    """encaspulates testrun logic"""
    
    def __init__(self, cvg, options):
        self.tested_files = []
        self.report = GlobalTestReport()
        self.cvg = cvg
        self.options = options

    def show_report(self):
        """prints the report and returns appropriate exitcode"""
        # everything has been ran, print report
        print "*" * 79
        print self.report
        return self.report.failures + self.report.errors
        

    def testall(self, exitfirst=False):
        """walks trhough current working directory, finds something
        which can be considered as a testdir and runs every test there
        """
        for dirname, dirs, files in os.walk(os.getcwd()):
            for skipped in ('CVS', '.svn', '.hg'):
                if skipped in dirs:
                    dirs.remove(skipped)
            basename = osp.basename(dirname)
            if basename in ('test', 'tests'):
                print "going into", dirname
                # we found a testdir, let's explore it !
                self.testonedir(dirname, exitfirst)
                dirs[:] = []

 
    def testonedir(self, testdir, exitfirst=False):
        """finds each testfile in the `testdir` and runs it"""
        for filename in abspath_listdir(testdir):
            if this_is_a_testfile(filename):
                # run test and collect information
                prog = self.testfile(filename, batchmode=True)
                if exitfirst and (prog is None or not prog.result.wasSuccessful()):
                    break
        # clean local modules
        remove_local_modules_from_sys(testdir)


    def testfile(self, filename, batchmode=False):
        """runs every test in `filename`

        :param filename: an absolute path pointing to a unittest file
        """
        here = os.getcwd()
        dirname = osp.dirname(filename)
        if dirname:
            os.chdir(dirname)
        modname = osp.basename(filename)[:-3]
        try:
            print >>sys.stderr, ('  %s  ' % osp.basename(filename)).center(70, '=')
        except TypeError: # < py 2.4 bw compat
            print >>sys.stderr, ('  %s  ' % osp.basename(filename)).center(70)
        try:
            try:
                tstart, cstart = time(), clock()
                testprog = testlib.unittest_main(modname, batchmode=batchmode, cvg=self.cvg,
                                                 options=self.options)
                tend, cend = time(), clock()
                ttime, ctime = (tend - tstart), (cend - cstart)
                self.report.feed(filename, testprog.result, ttime, ctime)
                return testprog
            except (KeyboardInterrupt, SystemExit):
                raise
            except Exception, exc:
                self.report.failed_to_test_module(filename)
                print 'unhandled exception occured while testing', modname
                import traceback
                traceback.print_exc()
                return None                
        finally:
            if dirname:
                os.chdir(here)



class DjangoTester(PyTester):

    def load_django_settings(self, dirname):
        """try to find project's setting and load it"""
        curdir = osp.abspath(dirname)
        previousdir = curdir
        while not osp.isfile(osp.join(curdir, 'settings.py')) and \
                  osp.isfile(osp.join(curdir, '__init__.py')):
            newdir = osp.normpath(osp.join(curdir, os.pardir))
            if newdir == curdir:
                raise AssertionError('could not find settings.py')
            previousdir = curdir
            curdir = newdir
        # late django initialization
        settings = load_module_from_modpath(modpath_from_file(osp.join(curdir, 'settings.py')))
        from django.core.management import setup_environ
        setup_environ(settings)
        settings.DEBUG = False
        self.settings = settings
        # add settings dir to pythonpath since it's the project's root
        if curdir not in sys.path:
            sys.path.insert(1, curdir)

    def before_testfile(self):
        # Those imports must be done **after** setup_environ was called
        from django.test.utils import setup_test_environment
        from django.test.utils import create_test_db
        setup_test_environment()
        create_test_db(verbosity=0)
        self.dbname = self.settings.TEST_DATABASE_NAME
        

    def after_testfile(self):
        # Those imports must be done **after** setup_environ was called
        from django.test.utils import teardown_test_environment
        from django.test.utils import destroy_test_db
        teardown_test_environment()
        print 'destroying', self.dbname
        destroy_test_db(self.dbname, verbosity=0)
        

    def testall(self, exitfirst=False):
        """walks trhough current working directory, finds something
        which can be considered as a testdir and runs every test there
        """
        for dirname, dirs, files in os.walk(os.getcwd()):
            for skipped in ('CVS', '.svn', '.hg'):
                if skipped in dirs:
                    dirs.remove(skipped)
            if 'tests.py' in files:
                self.testonedir(dirname, exitfirst)
                dirs[:] = []
            else:
                basename = osp.basename(dirname)
                if basename in ('test', 'tests'):
                    print "going into", dirname
                    # we found a testdir, let's explore it !
                    self.testonedir(dirname, exitfirst)
                    dirs[:] = []


    def testonedir(self, testdir, exitfirst=False):
        """finds each testfile in the `testdir` and runs it"""
        # special django behaviour : if tests are splited in several files,
        # remove the main tests.py file and tests each test file separately
        testfiles = [fpath for fpath in abspath_listdir(testdir)
                     if this_is_a_testfile(fpath)]
        if len(testfiles) > 1:
            try:
                testfiles.remove(osp.join(testdir, 'tests.py'))
            except ValueError:
                pass
        for filename in testfiles:
            # run test and collect information
            prog = self.testfile(filename, batchmode=True)
            if exitfirst and (prog is None or not prog.result.wasSuccessful()):
                break
        # clean local modules
        remove_local_modules_from_sys(testdir)


    def testfile(self, filename, batchmode=False):
        """runs every test in `filename`

        :param filename: an absolute path pointing to a unittest file
        """
        here = os.getcwd()
        dirname = osp.dirname(filename)
        if dirname:
            os.chdir(dirname)
        self.load_django_settings(dirname)
        modname = osp.basename(filename)[:-3]
        print >>sys.stderr, ('  %s  ' % osp.basename(filename)).center(70, '=')
        try:
            try:
                tstart, cstart = time(), clock()
                self.before_testfile()
                testprog = testlib.unittest_main(modname, batchmode=batchmode, cvg=self.cvg)
                tend, cend = time(), clock()
                ttime, ctime = (tend - tstart), (cend - cstart)
                self.report.feed(filename, testprog.result, ttime, ctime)
                return testprog
            except SystemExit:
                raise
            except Exception, exc:
                import traceback
                traceback.print_exc()
                self.report.failed_to_test_module(filename)
                print 'unhandled exception occured while testing', modname
                print 'error: %s' % exc
                return None                
        finally:
            self.after_testfile()
            if dirname:
                os.chdir(here)


def make_parser():
    """creates the OptionParser instance
    """
    from optparse import OptionParser
    parser = OptionParser(usage=PYTEST_DOC)

    parser.newargs = []
    def rebuild_cmdline(option, opt, value, parser):
        """carry the option to unittest_main"""
        parser.newargs.append(opt)
        

    def rebuild_and_store(option, opt, value, parser):
        """carry the option to unittest_main and store
        the value on current parser
        """
        parser.newargs.append(opt)
        setattr(parser.values, option.dest, True)

    # pytest options
    parser.add_option('-t', dest='testdir', default=None,
                      help="directory where the tests will be found")
    parser.add_option('-d', dest='dbc', default=False,
                      action="store_true", help="enable design-by-contract")
    # unittest_main options provided and passed through pytest
    parser.add_option('-v', '--verbose', callback=rebuild_cmdline,
                      action="callback", help="Verbose output")
    parser.add_option('-i', '--pdb', callback=rebuild_and_store,
                      dest="pdb", action="callback",
                      help="Enable test failure inspection (conflicts with --coverage)")
    parser.add_option('-x', '--exitfirst', callback=rebuild_and_store,
                      dest="exitfirst",
                      action="callback", help="Exit on first failure "
                      "(only make sense when pytest run one test file)")
    parser.add_option('-c', '--capture', callback=rebuild_cmdline,
                      action="callback", 
                      help="Captures and prints standard out/err only on errors "
                      "(only make sense when pytest run one test file)")
    parser.add_option('-p', '--printonly',
                      # XXX: I wish I could use the callback action but it
                      #      doesn't seem to be able to get the value
                      #      associated to the option
                      action="store", dest="printonly", default=None,
                      help="Only prints lines matching specified pattern (implies capture) "
                      "(only make sense when pytest run one test file)")
    parser.add_option('-s', '--skip',
                      # XXX: I wish I could use the callback action but it
                      #      doesn't seem to be able to get the value
                      #      associated to the option
                      action="store", dest="skipped", default=None,
                      help="test names matching this name will be skipped "
                      "to skip several patterns, use commas")
    parser.add_option('-q', '--quiet', callback=rebuild_cmdline,
                      action="callback", help="Minimal output")
    parser.add_option('-P', '--profile', default=None, dest='profile',
                      help="Profile execution and store data in the given file")

    try:
        from clonedigger.logilab.devtools.lib.coverage import Coverage
        parser.add_option('--coverage', dest="coverage", default=False,
                          action="store_true",
                          help="run tests with pycoverage (conflicts with --pdb)")
    except ImportError:
        pass

    if DJANGO_FOUND:
        parser.add_option('-J', '--django', dest='django', default=False,
                          action="store_true",
                          help='use pytest for django test cases')
    return parser


def parseargs(parser):
    """Parse the command line and return (options processed), (options to pass to
    unittest_main()), (explicitfile or None).
    """
    # parse the command line
    options, args = parser.parse_args()
    if options.pdb and getattr(options, 'coverage', False):
        parser.error("'pdb' and 'coverage' options are exclusive")
    filenames = [arg for arg in args if arg.endswith('.py')]
    if filenames:
        if len(filenames) > 1:
            parser.error("only one filename is acceptable")
        explicitfile = filenames[0]
        args.remove(explicitfile)
    else:
        explicitfile = None
    # someone wants DBC
    testlib.ENABLE_DBC = options.dbc
    newargs = parser.newargs
    if options.printonly:
        newargs.extend(['--printonly', options.printonly])
    if options.skipped:
        newargs.extend(['--skip', options.skipped])
    # append additional args to the new sys.argv and let unittest_main
    # do the rest
    newargs += args
    return options, explicitfile 



def run():
    parser = make_parser()
    rootdir, testercls = project_root(parser)
    options, explicitfile = parseargs(parser)
    # mock a new command line
    sys.argv[1:] = parser.newargs
    covermode = getattr(options, 'coverage', None)
    cvg = None
    if not '' in sys.path:
        sys.path.insert(0, '')    
    if covermode:
        # control_import_coverage(rootdir)
        from clonedigger.logilab.devtools.lib.coverage import Coverage
        cvg = Coverage([rootdir])
        cvg.erase()
        cvg.start()
    if DJANGO_FOUND and options.django:
        tester = DjangoTester(cvg, options)
    else:
        tester = testercls(cvg, options)
    if explicitfile:
        cmd, args = tester.testfile, (explicitfile,)
    elif options.testdir:
        cmd, args = tester.testonedir, (options.testdir, options.exitfirst)
    else:
        cmd, args = tester.testall, (options.exitfirst,)
    try:
        try:
            if options.profile:
                import hotshot
                prof = hotshot.Profile(options.profile)
                prof.runcall(cmd, *args)
                prof.close()
                print 'profile data saved in', options.profile
            else:
                 cmd(*args)           
        except SystemExit:
            raise
        except:
            import traceback
            traceback.print_exc()
    finally:
        errcode = tester.show_report()
        if covermode:
            cvg.stop()
            cvg.save()
            here = osp.abspath(os.getcwd())
            if this_is_a_testdir(here):
                morfdir = osp.normpath(osp.join(here, '..'))
            else:
                morfdir = here
            print "computing code coverage (%s), this might take some time" % \
                  morfdir
            cvg.annotate([morfdir])
            cvg.report([morfdir], False)
        sys.exit(errcode)
