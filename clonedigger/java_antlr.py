#    Copyright 2008 Peter Bulychev
#    http://clonedigger.sourceforge.net
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

import os
import xml.parsers.expat

from abstract_syntax_tree import *


class JavaANTLRSourceFile (SourceFile):
    extension = 'java'
    size_threshold = 10
    distance_threshold = 7

    def __init__(self, file_name):
        SourceFile.__init__(self, file_name)

        class ExpatHandler:
            def __init__(self, start_node, parent):
                self.parent = parent
                self.stack = [start_node]

            def start_element(expat_self, xml_node_name, attrs):
                line_number = int(attrs["line_number"]) - 1
                line_numbers = [line_number]
                if line_numbers == [-1]:
                    line_numbers = []
                name = attrs["name"]
                r = AbstractSyntaxTree(name, line_numbers, self)
                if xml_node_name == "statement_node":
                    r.markAsStatement()
                else:
                    assert(xml_node_name == "node")
                expat_self.stack[-1].addChild(r)
                expat_self.stack.append(r)

            def end_element(self, name):
                self.stack.pop()

        tree_file_name = 'temporary_ast.xml'
        current_directory = os.path.realpath(os.path.dirname(__file__))
        producer_class_path = os.path.join(
            current_directory, 'java_antlr', 'TreeProducer.jar')
        antlr_class_path = os.path.join(
            current_directory, 'antlr_runtime', 'runtime-2008-01-10.16.jar')
        if os.name in ['mac', 'posix']:
            class_path_delimeter = ':'
        elif os.name in ['nt', 'dos', 'ce']:
            class_path_delimeter = ';'
        else:
            print 'unsupported OS'
            assert(0)
        command = (
            'java -classpath ' + producer_class_path
            + class_path_delimeter + antlr_class_path
            + ' TreeProducer %s %s 2>err.log' % (file_name, tree_file_name))
        if os.system(command):
            f = open('err.log')
            s = f.read()
            f.close()
            raise Exception(s)

        self._tree = AbstractSyntaxTree('program')
        handler = ExpatHandler(self._tree, self)
        p = xml.parsers.expat.ParserCreate()
        p.StartElementHandler = handler.start_element
        p.EndElementHandler = handler.end_element
        f = open(tree_file_name)
        p.ParseFile(f)
        f.close()
        os.remove(tree_file_name)
