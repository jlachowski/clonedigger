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

import copy
import sys

from abstract_syntax_tree import *
import suffix_tree
import arguments

# NOTE that everywhere is written Unifier instead of AntiUnifier, for simplicity

# Constants here
verbose = True 

class FreeVariable(AbstractSyntaxTree):
    free_variables_count = 1
    def __init__(self):
        global free_variables_count
        FreeVariable.free_variables_count += 1
        name =  'VAR(%d)'%(FreeVariable.free_variables_count, )
#       self._childs = []
        AbstractSyntaxTree.__init__(self, name)

class Substitution:
    def __init__(self, initial_value = None):
        if initial_value == None:
            initial_value = {}
        self._map = initial_value
    def substitute(self, tree, without_copying=False):  
        if tree in self._map.keys():
            return self._map[tree]
        else:
            if isinstance(tree, FreeVariable):
                return tree 
            if without_copying:
                return tree
            else:
                r = AbstractSyntaxTree(tree.getName())
                for child in tree.getChilds():
                    r.addChild(self.substitute(child, without_copying))
                return r

    def getMap(self):
        return self._map
    def getSize(self):
        ret = 0
        for (u, tree) in self.getMap().items():
            ret += tree.getSize(False) - free_variable_cost
        return ret

class Unifier:
    def __init__(self, t1, t2, ignore_parametrization=False):
        def combineSubs(node, s, t):
            # s and t are 2-tuples
            assert(s[0].getMap().keys() == s[1].getMap().keys())
            assert(t[0].getMap().keys() == t[1].getMap().keys())
            newt = (copy.copy(t[0]), copy.copy(t[1]))
            relabel = {}
            for si in s[0].getMap().keys():
                if not ignore_parametrization:
                    foundone = False
                    for ti in t[0].getMap().keys():
                        if (s[0].getMap()[si] == t[0].getMap()[ti]) and (s[1].getMap()[si] == t[1].getMap()[ti]): 
                            relabel[si] = ti
                            foundone = True
                            break
                if ignore_parametrization or not foundone:
                    newt[0].getMap()[si] = s[0].getMap()[si]
                    newt[1].getMap()[si] = s[1].getMap()[si]
            return (Substitution(relabel).substitute(node), newt)
        def unify(node1, node2):
            if node1 == node2:
                return (node1, (Substitution(), Substitution()))
            elif (node1.getName() != node2.getName()) or (node1.getChildCount() != node2.getChildCount()):
                var = FreeVariable()
                return (var, (Substitution({var:node1}), Substitution({var:node2})))
            else:
                s = (Substitution(), Substitution())
                name = node1.getName()
                retNode = AbstractSyntaxTree(name) 
                count = node1.getChildCount()
                for i in range(count):              
                    (ai, si) = unify(node1.getChilds()[i], node2.getChilds()[i])
                    (ai, s) = combineSubs(ai, si, s)
                    retNode.addChild(ai)
                return (retNode, s)
        (self._unifier, self._substitutions) = unify(t1, t2)
        self._unifier.storeSize()
        for i in (0,1):
            for key in self._substitutions[i].getMap():
                self._substitutions[i].getMap()[key].storeSize()
    def getSubstitutions(self):
        return self._substitutions
    def getUnifier(self):
        return self._unifier
    def getSize(self):
        return sum([s.getSize() for s in self.getSubstitutions()])

class Cluster:
    count = 0
    def __init__(self, tree=None):
        if tree:
            self._n = 1
            self._unifier_tree = tree
            self._trees = [tree]
            self._max_covered_lines = len(tree.getCoveredLineNumbers())
        else:
            self._n = 0
            self._trees = []
            self._max_covered_lines = 0
        Cluster.count += 1
        self._cluster_number = Cluster.count    
    def getUnifierTree(self):
        return self._unifier_tree
    def getCount(self):
        return self._n
    def getAddCost(self, tree):
        unifier = Unifier(self.getUnifierTree(), tree)
        return (self.getCount()* unifier.getSubstitutions()[0].getSize() + unifier.getSubstitutions()[1].getSize())
    def unify(self, tree):
        self._n += 1
        self._unifier_tree = Unifier(self.getUnifierTree(), tree).getUnifier()
        self._trees.append(tree)
    def eraseAllTrees(self):
        self._n = 0
        self._trees = []
    def addWithoutUnification(self, tree):
        self._n += 1
        self._trees.append(tree)
        if len(tree.getCoveredLineNumbers())>self._max_covered_lines:
            self._max_covered_lines = len(tree.getCoveredLineNumbers())
    def getMaxCoveredLines(self):
        return self._max_covered_lines
    def getUnifierSize(self):
        return self.getUnifierTree().getSize()
