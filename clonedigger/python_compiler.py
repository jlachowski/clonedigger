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

import compiler
import types
import logilab.astng.nodes

from abstract_syntax_tree import *

class PythonNodeLeaf:
    def __init__(self, val):
        self._val = val
    def getVal(self):
        return self._val
    def as_string(self):
        return str(self.getVal())
    def __str__(self):
        return self.as_string()

class PythonCompilerSourceFile (SourceFile):
    extension = 'py'
    distance_threshold = 5
    size_threshold = 5
    ignored_statements = ['Import', 'From']
    def __init__(self, file_name, func_prefixes = ()):
        SourceFile.__init__(self, file_name)
        self._func_prefixes = func_prefixes
        def rec_build_tree(compiler_ast_node, is_statement=False):
            def flatten(list):
                l = []
                for elt in list:
                    t = type(elt)
                    if t is tuple or t is list:
                        for elt2 in flatten(elt):
                            l.append(elt2)
                    else:
                        l.append(elt)
                return l
            def add_childs(childs):             
                assert(type(childs) == type([]))
                for child in childs:                
                    assert(isinstance(child, compiler.ast.Node))
                    t = rec_build_tree(child, is_statement)     
                    if t.getName() in self.ignored_statements:
                        # TODO move it up
                        continue
                    t.setParent(r)
                    r.addChild(t)                   
            def add_leaf_child(child, name):
                assert(not (type(child) == type([])))
                assert(not isinstance(child, compiler.ast.Node))                                
                t = AbstractSyntaxTree(repr(child))
                t.setParent(r)
                l = PythonNodeLeaf(child)
                t.ast_node = l 
                r.addChild(t)               
                setattr(r.ast_node, name, l)
                return t
            def add_leaf_childs(childs, name):
                assert(type(childs) == type([]) or type(childs) == type((0,)))
                a = getattr(r.ast_node, name)
                for i in range(len(childs)):
                    child = childs[i]
                    assert(not isinstance(child, compiler.ast.Node))
                    t = AbstractSyntaxTree(repr(child))
                    t.setParent(r)
                    l = PythonNodeLeaf(child)
                    t.ast_node = l 
                    r.addChild(t)                   
                    a[i] = l
            def add_leaf_string_childs(childs):
                assert(type(childs) == type([]))
                for child in childs:
                    assert(not isinstance(child, compiler.ast.Node))
                    t = AbstractSyntaxTree(repr(child))
                    t.setParent(t)
                    r.addChild(t)                   

            if isinstance(compiler_ast_node, compiler.ast.Node):                
                name = compiler_ast_node.__class__.__name__
                if name == 'Function':
                   for prefix in self._func_prefixes:
                       if compiler_ast_node.name.startswith(prefix):
                           # skip function that matches pattern
                           return AbstractSyntaxTree('none')
                if name in ['Function', 'Class']:
                    # ignoring class and function docs
                    compiler_ast_node.doc = None
                if compiler_ast_node.lineno:
                    lines = [compiler_ast_node.lineno-1]
                else:
                    lines = []      
                r = AbstractSyntaxTree(name, lines, self)
                r.ast_node = compiler_ast_node
                if is_statement and compiler_ast_node.lineno: 
                    r.markAsStatement()
                is_statement = (name == 'Stmt')
                if name == "AssAttr":
                    add_childs([compiler_ast_node.expr])
                    add_leaf_child(compiler_ast_node.attrname, 'attrname')
                    add_leaf_string_childs([compiler_ast_node.flags])
                elif name == "AssName":
                    add_leaf_child(compiler_ast_node.name, 'name')
#                   add_leaf_child(compiler_ast_node.flags, 'flags')
                elif name == "AugAssign":
                    add_childs([compiler_ast_node.node])
                    add_leaf_child(compiler_ast_node.op, 'op')
                    add_childs([compiler_ast_node.expr])
                elif name == "Class":
                    add_leaf_child(compiler_ast_node.name, 'name')
#                   print '>>>>>>>>>>>>>>>>>>>>', flatten(compiler_ast_node.bases)
                    add_childs(flatten(compiler_ast_node.bases)) 
#                   add_leaf_child(compiler_ast_node.doc, 'doc') we don't want class docs in our tree, do we?
                    add_childs([compiler_ast_node.code])
                elif name == "Compare":
                    add_childs([compiler_ast_node.expr])
                    for i in range(len(compiler_ast_node.ops)):
                        (op, expr) = compiler_ast_node.ops[i]
                        t = add_leaf_child(op, 'op')
                        add_childs([expr])
                        compiler_ast_node.ops[i] = (t.ast_node, expr)
                elif name == "Const":
                    add_leaf_child(repr(compiler_ast_node.value), "value")
#               elif name == "From":
#                   add_leaf_child(compiler_ast_node.modname, "modname")
#                   add_childs(compiler_ast_node.names)
                elif name == "Function":
#                   add_childs(compiler_ast_node.decorators)  FIXME do we need that?
                    add_leaf_child(compiler_ast_node.name, "name")
                    add_leaf_childs(compiler_ast_node.argnames, "argnames")
                    if compiler_ast_node.defaults == ():
                        compiler_ast_node.defaults = []
                    add_childs(compiler_ast_node.defaults) #TODO incomment and fix
                    add_leaf_string_childs([compiler_ast_node.flags])
#                   add_leaf_child(compiler_ast_node.doc, "doc") same as class docs... we don't need them
                    add_childs([compiler_ast_node.code])
                elif name == "Getattr":
                    add_childs([compiler_ast_node.expr])
                    add_leaf_child(compiler_ast_node.attrname, "attrname")
                elif name == "Global":
                    add_leaf_childs(compiler_ast_node.names, "names")
#               elif name == "Import":
#                   add_leaf_childs(compiler_ast_node.names, "names")
                elif name == "Keyword":
                    add_leaf_child(compiler_ast_node.name, "name")
                    add_childs([compiler_ast_node.expr])
                elif name == "Lambda": 
#                   TODO: uncomment and fix
                    add_leaf_childs(compiler_ast_node.argnames, "argnames")                    
                    if compiler_ast_node.defaults == ():
                        compiler_ast_node.defaults = []
                    add_childs(compiler_ast_node.defaults)              
                    add_childs([compiler_ast_node.code])
                elif name == "Name":
                    # the most important one :)
                    add_leaf_child(compiler_ast_node.name, "name")
                else:
                    for c in compiler_ast_node.getChildren():               
                        t = rec_build_tree(c, is_statement)
                        if t.getName() in self.ignored_statements:
                            continue                    
                        t.setParent(r)
                        r.addChild(t)
                return r
            else:
                return AbstractSyntaxTree(repr(compiler_ast_node))
        self._setTree(rec_build_tree(compiler.parseFile(file_name)))
