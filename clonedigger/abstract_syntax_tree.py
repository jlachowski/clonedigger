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

import types

import arguments

free_variable_cost = 0.5

class ParseError:    
    def __init__(self, descr):
        self._descr = descr
    def __str__(self):
        return self._descr

class SourceFile:        
    size_threshold = 5
    distance_threshold = 5
    def __init__(self, file_name):      
        f = open(file_name, 'r')
        def filter_func(s):
            for i in range(len(s)-1, -2, -1):
                if i<0 or not s[i].isspace():
                    break
            if i>=0:
                return s[:i+1]
            else:
                return s
        self._source_lines = [filter_func(s) for s in f.readlines()]
        f.close()
        self._file_name = file_name
    def getSourceLine(self, n):
#       if n >= len(self._source_lines):
#           return ''
#TODO
#error here
        return self._source_lines[n] 
    def _setTree(self, tree):
        self._tree = tree
    def getTree(self):
        return self._tree
    def getFileName(self):
        return self._file_name

class AbstractSyntaxTree:
    def __init__(self, name=None, line_numbers=[], source_file=None):
        self._childs = []
        self._line_numbers= line_numbers
        self._covered_line_numbers = None
        self._parent = None
        self._hash = None
        self._source_file = source_file
        self._is_statement = False
        if name != None:
            self.setName(name)
    def getSourceFile(self):
        return self._source_file
    def setMark(self, mark):
        self._mark = mark 
    def getMark(self):
        return self._mark
    def markAsStatement(self, val=True):
        self._is_statement = val
    def isStatement(self):
        return self._is_statement
    def setName(self, name):
        self._name = name
    def getLineNumbers(self):
        return self._line_numbers   
    def getCoveredLineNumbers(self):
        return self._covered_line_numbers
    def getParent(self):
        return self._parent
    def setParent(self, parent):
        self._parent = parent
    def getAncestors(self):
        r = []
        t = self.getParent()    
        while t:
            if t.isStatement():
                r.append(t)
            t = t.getParent()
        return r
    def getSourceLines(self):
        source_line_numbers = set([])
        r = []  
        source_line_numbers = self.getCoveredLineNumbers()
        source_line_numbers_list = list(range(min(source_line_numbers), max(source_line_numbers)+1))
        source_line_numbers_list.sort()
        for source_line_number in source_line_numbers_list:
            r.append(self.getSourceFile().getSourceLine(source_line_number) ) 
        return r
    def getName(self):
        return self._name
    def getChilds(self):
        return self._childs
    def getChildCount(self):
        return len(self._childs)
    def propagateCoveredLineNumbers(self):
        self._covered_line_numbers = set(self._line_numbers)
        for child in self.getChilds():
            self._covered_line_numbers.update(child.propagateCoveredLineNumbers())
        return self._covered_line_numbers
    def propagateHeight(self):
        if self.getChildCount()==0:
            self._height = 0
        else:
            self._height = max([c.propagateHeight() for c in self.getChilds()])+1
        return self._height
    def getHeight(self):
        return self._height
    def addChild(self, child, save_parent = False):
        if not save_parent:
            child.setParent(self)
        self._childs.append(child)
    def setChildCount(self, count):
        assert(not self._childs)
        self._childs = count * [None]
    def setNextUndefinedChild(self, c):
        for i in range(len(self.getChilds())):
            if self.getChilds()[i] == None:
                self._childs[i] = c
        assert()
    def __str__(self):
        return ' ( ' + self.getName() + ' '.join([str(child) for child in self.getChilds()]) + ' ) '
    def getFullHash(self):
        return self.getDCupHash(-1) 
    def getDCupHash(self, level):
        if len(self._childs) == 0:
            ret = 0 # in case of names and constants
        else:
            ret = (level+1) * hash(self._name) * len(self._childs)
        # if level == -1, it will not stop until it reaches the leaves 
        if level != 0:
            for i in range(len(self._childs)):
                child = self._childs[i]
                ret += (i+1)*child.getDCupHash(level-1)
        return hash(ret)
    def __hash__(self):
        #TODO check correctness
        if not self._hash:
            self._hash =  hash(self.getDCupHash(3) + hash(self.getName()))
        return self._hash
#       return  hash(self.getDCupHash(3) + hash(self.getName()))
 
    def __eq__(self, tree2):
        tree1 = self
        if type(tree2) == types.NoneType:
            return False
        if tree1.getName() != tree2.getName():
            return False
        if tree1.getChildCount() != tree2.getChildCount():
            return False
        for i in range(tree1.getChildCount()):
            if tree1.getChilds()[i] != tree2.getChilds()[i]:
                return False
        return True
    def getAllStatementSequences(self):
        r = []
        current = StatementSequence()
        for child in self.getChilds():
            if child.isStatement():
                current.addStatement(child)
            else:
                if (not current.isEmpty()) and len(current.getCoveredLineNumbers())>=arguments.size_threshold:
                    r.append(current)
                    current = StatementSequence() 
            r.extend(child.getAllStatementSequences())
        if (not current.isEmpty()) and len(current.getCoveredLineNumbers())>=arguments.size_threshold:
            r.append(current)
        return r
    def storeSize(self):
        observed = set()
        self._none_count = 0
        def rec_calc_size(t):
            r = 0
            if not t in observed:
                if t.getChildCount():
                    for c in t.getChilds():
                        r += rec_calc_size(c)
                else:
                    observed.add(t)
                    if t.getName()=='None':
                        self._none_count += 1
                    if t.__class__.__name__ == 'FreeVariable':
                        r+= free_variable_cost
                    else:
                        r+= 1
            return r
        if not hasattr(self, '_size'):
            self._size = rec_calc_size(self)
    def getSize(self, ignore_none = True):
        ret = self._size
        if ignore_none:
            ret -= self._none_count
        return ret    
    def getTokenCount(self):
        def rec_calc_size(t):
            if t.getChildCount():
                if t.getName() in ['Add', 'Assign', 'Sub', 'Div', 'Mul', 'Mod', 'Function', 'If', 'Class', 'Raise']:
                    r = 1
                else:
                    r = 0
                for c in t.getChilds():
                    r += rec_calc_size(c)
            else:
                if t.getName()[0] != "'" and t.getName() != 'Pass':
                    return 0
                else:
                    return 1
            return r
        return rec_calc_size(self)

class StatementSequence:
    def __init__(self, sequence = []):
        self._sequence = []
        self._source_file = None
        for s in sequence:
            self.addStatement(s)
    def getCoveredLineNumbers(self):
        r = set()
        for s in self:
            r.update(s.getCoveredLineNumbers())
        return r
    def getAncestors(self):
        return self[0].getAncestors()
    def isEmpty(self):
        return (self._sequence == [])
    def addStatement(self, statement):
        self._sequence.append(statement)
        if self._source_file == None:
            self._source_file = statement.getSourceFile()
        else:
            assert(self._source_file == statement.getSourceFile())
    def __getitem__(self, *args):
        return self._sequence.__getitem__(*args)
    def __len__(self):
        return self._sequence.__len__()
    def __str__(self):
        return ','.join([str(s) for s in self])
    def getWeight(self):
        return sum([s.getCluster().getUnifierSize() for s in self._sequence])
    def getSourceFile(self):
        return self._source_file
    def getSourceLines(self):
        source_line_numbers = set([])
        r = []
        for statement in self:
            r.extend(statement.getSourceLines())
        return r
    def getLineNumbers(self):
        r = []
        for statement in self:
            r.extend(statement.getLineNumbers())
        return r
    def getLineNumberHashables(self):   
        source_file_name = self.getSourceFile().getFileName()
        line_numbers = self.getCoveredLineNumbers()
        return set([(source_file_name, line_number) for line_number in line_numbers])
    def constructTree(self):
        tree = AbstractSyntaxTree('__SEQUENCE__')
        for statement in self:
            tree.addChild(statement, True)
        return tree    
    def getLength(self):
        return len(self)
    def getCoveredLineNumbersCount(self):
        covered = set()
        for t in self:
            covered.update(t.getCoveredLineNumbers())
        return len(covered)

class PairSequences:
    def __init__(self, sequences):
        self._sequences = sequences
    def __getitem__(self, *args):
        return self._sequences.__getitem__(*args)
    def __str__(self):
        return ';\t'.join([str(s) for s in self])
    def getWeight(self):
        assert(self[0].getWeight() == self[1].getWeight())
        return self[0].getWeight()
    def calcDistance(self):
        import anti_unification
        trees = [s.constructTree() for s in self]
        unifier = anti_unification.Unifier(trees[0], trees[1])
        return unifier.getSize()
    def subSequence(self, first, length):
        return PairSequences([StatementSequence(self[0][first:first+length]), StatementSequence(self[1][first:first+length])])
    def getLength(self):
        return self[0].getLength()
    def getMaxCoveredLineNumbersCount(self):
        return min([s.getCoveredLineNumbersCount() for s in self])
