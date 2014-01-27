#!/usr/bin/python

#    Copyright 2008 Peter Bulychev
#
#    This file is part of Clone Digger.
#
#    Clone Digger is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    Clone Digger is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#   You should have received a copy of the GNU General Public License
#   along with Clone Digger.  If not, see <http://www.gnu.org/licenses/>.
import sys

if __name__ == '__main__':
    sys.modules['clonedigger.logilab'] = __import__('logilab')

import re
import os
import traceback
from optparse import OptionParser
from fnmatch import fnmatch

import ast_suppliers
import clone_detection_algorithm
import arguments 
import html_report

def main():
    cmdline = OptionParser(usage="""To run Clone Digger type:
python clonedigger.py [OPTION]... [SOURCE FILE OR DIRECTORY]...

The typical usage is:
python clonedigger.py source_file_1 source_file_2 ...
  or
python clonedigger.py path_to_source_tree
Don't forget to remove automatically generated sources, tests and third party libraries from the source tree.

Notice:
The semantics of threshold options is discussed in the paper "Duplicate code detection using anti-unification", which can be downloaded from the site http://clonedigger.sourceforge.net . All arguments are optional. Supported options are: 
""")
    cmdline.add_option('-l', '--language', dest='language',
                       type='choice', choices=['python', 'java', 'lua', 'javascript', 'js'],
                       help='the programming language')
    cmdline.add_option('--no-recursion', dest='no_recursion',
                       action='store_true', 
                       help='do not traverse directions recursively')    
    cmdline.add_option('-o', '--output', dest='output',
                       help='the name of the output file ("output.html" by default)')
    cmdline.add_option('--clustering-threshold', 
                       type='int', dest='clustering_threshold',
                       help='read the paper for semantics')
    cmdline.add_option('--distance-threshold', 
                       type='int', dest='distance_threshold',
                       help='the maximum amount of differences between pair of sequences in clone pair (5 by default). Larger value leads to larger amount of false positives')
    cmdline.add_option('--hashing-depth', 
                       type='int', dest='hashing_depth',
                       help='default value if 1, read the paper for semantics. Computation can be speeded up by increasing this value (but some clones can be missed)')
    cmdline.add_option('--size-threshold', 
                       type='int', dest='size_threshold',
                       help='the minimum clone size. The clone size for its turn is equal to the count of lines of code in its the largest fragment')
    cmdline.add_option('--clusterize-using-dcup', 
                       action='store_true', dest='clusterize_using_dcup',
                       help='mark each statement with its D-cup value instead of the most similar pattern. This option together with --hashing-depth=0 make it possible to catch all considered clones (but it is slow and applicable only to small programs)')
    cmdline.add_option('--dont-print-time', 
                       action='store_false', dest='print_time',
                       help='do not print time')
    cmdline.add_option('-f', '--force', 
                       action='store_true', dest='force',
                       help='')
    cmdline.add_option('--force-diff', 
                       action='store_true', dest='use_diff',
                       help='force highlighting of differences based on the diff algorithm')
    cmdline.add_option('--fast', 
                       action='store_true', dest='clusterize_using_hash',
                       help='find only clones, which differ in variable and function names and constants')
    cmdline.add_option('--ignore-dir', 
                       action='append', dest='ignore_dirs',
                       help='exclude directories from parsing')
    cmdline.add_option('--eclipse-output', 
                       dest='eclipse_output',
                       help='for internal usage only')
    cmdline.add_option('--cpd-output', 
                       action='store_true', dest='cpd_output',
                       help='output as PMD''s CPD''s XML format. If output file not defined, output.xml is generated')
    cmdline.add_option('--report-unifiers', 
                       action='store_true', dest='report_unifiers',
                       help='')
    cmdline.add_option('--func-prefixes',
                      action='store',
                       dest='f_prefixes',
                      help='skip functions/methods with these prefixes (provide a CSV string as argument)')
    cmdline.add_option('--file-list', dest='file_list',
                      help='a file that contains a list of file names that must be processed by Clone Digger')

    cmdline.set_defaults(language='python', 
                         ingore_dirs=[],
                         f_prefixes = None,
                         **arguments.__dict__)

    (options, source_file_names) = cmdline.parse_args()
    if options.f_prefixes != None:
       func_prefixes = tuple([x.strip() for x in options.f_prefixes.split(',')])
    else:
       func_prefixes = ()
    source_files = [] 

    supplier = ast_suppliers.abstract_syntax_tree_suppliers[options.language]
    if options.language != 'python':
        options.use_diff = True

    if options.cpd_output:
        if options.output is None:
	    options.output = 'output.xml'
	report = html_report.CPDXMLReport()
    else:
    	report = html_report.HTMLReport()    

    if options.output is None:
    	options.output = 'output.html'

    output_file_name = options.output

    for option in cmdline.option_list:
        if option.dest == 'file_list' and options.file_list != None:           
            source_file_names.extend(open(options.file_list).read().split())
            continue
        elif option.dest is None:
            continue
        setattr(arguments, option.dest, getattr(options, option.dest))

    if options.distance_threshold is None:
        arguments.distance_threshold = supplier.distance_threshold
    if options.size_threshold is None:
        arguments.size_threshold = supplier.size_threshold
    
    report.startTimer('Construction of AST')

    def parse_file(file_name, func_prefixes):
        try:
            print 'Parsing ', file_name, '...',
            sys.stdout.flush()
            if options.language=='python':
                source_file = supplier(file_name, func_prefixes)
            else:
                # TODO implement func_prefixes for java also
                source_file = supplier(file_name)
            source_file.getTree().propagateCoveredLineNumbers()
            source_file.getTree().propagateHeight()
            source_files.append(source_file)
            report.addFileName(file_name)                
            print 'done'
        except:
            s = 'Error: can\'t parse "%s" \n: '%(file_name,) + traceback.format_exc()
            report.addErrorInformation(s)
            print s

    def walk(dirname):
        for dirpath, dirs, files in os.walk(file_name):
            dirs[:] = (not options.ignore_dirs and dirs)  or [d for d in dirs if d not in options.ignore_dirs]
            # Skip all non-parseable files
            files[:] = [f for f in files 
                        if os.path.splitext(f)[1][1:] == supplier.extension]
            yield (dirpath, dirs, files)

    for file_name in source_file_names:
        if os.path.isdir(file_name):
            if arguments.no_recursion:
                dirpath = file_name
                files = [os.path.join(file_name, f) for f in os.listdir(file_name) 
                        if os.path.splitext(f)[1][1:] == supplier.extension]
                for f in files:
                    parse_file(f, func_prefixes)
            else:
                for dirpath, dirnames, filenames in walk(file_name):
                    for f in filenames:
                        parse_file(os.path.join(dirpath, f), func_prefixes)
        else:
            parse_file(file_name, func_prefixes)
        
    report.stopTimer()
    duplicates = clone_detection_algorithm.findDuplicateCode(source_files, report)
    for duplicate in duplicates:
        report.addClone(duplicate)
    report.sortByCloneSize()
    try:
        report.writeReport(output_file_name)
    except:
        print "catched error, removing output file"
        if os.path.exists(output_file_name):
            os.remove(output_file_name)
        raise 

if __name__ == '__main__':
    main()

