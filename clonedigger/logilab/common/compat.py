# pylint: disable-msg=E0601,W0622,W0611
#
# Copyright (c) 2004-2006 LOGILAB S.A. (Paris, FRANCE).
# http://www.logilab.fr/ -- mailto:contact@logilab.fr
#
# This program is free software; you can redistribute it and/or modify it under
# the terms of the GNU General Public License as published by the Free Software
# Foundation; either version 2 of the License, or (at your option) any later
# version.
#
# This program is distributed in the hope that it will be useful, but WITHOUT
# ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
# FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details
#
# You should have received a copy of the GNU General Public License along with
# this program; if not, write to the Free Software Foundation, Inc.,
# 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
"""some wrapper around some builtins introduced in python 2.3, 2.4 and
2.5, making them available in for earlier versions of python.
"""
from __future__ import generators

from warnings import warn

from clonedigger.logilab.common.deprecation import class_renamed

try:
    set = set
    frozenset = frozenset
except NameError:
    try:
        from sets import Set as set, ImmutableSet as frozenset
    except ImportError:
        class _baseset(object):
            def __init__(self, values=()):
                self._data = {}
                warn("This implementation of Set is not complete !",
                     stacklevel=2)
                for v in values:
                    self._data[v] = 1

            def __or__(self, other):
                result = self.__class__(self._data.keys())
                for val in other:
                    result.add(val)
                return result
            __add__ = __or__
            
            def __and__(self, other):
                result = self.__class__()
                for val in other:
                    if val in self._data:
                        result.add(val)
                return result
            
            def __sub__(self, other):
                result = self.__class__(self._data.keys())
                for val in other:
                    if val in self._data:
                        result.remove(val)
                return result
            
            def __cmp__(self, other):
                keys = self._data.keys()
                okeys = other._data.keys()
                keys.sort()
                okeys.sort()
                return cmp(keys, okeys)
            
            def __len__(self):
                return len(self._data)

            def __repr__(self):
                elements = self._data.keys()
                return 'lcc.%s(%r)' % (self.__class__.__name__, elements)
            __str__ = __repr__

            def __iter__(self):
                return iter(self._data)

        class frozenset(_baseset):
            """immutable set (can be set in dictionnaries)"""
            def __init__(self, values=()):
                super(frozenset, self).__init__(values)
                self._hashcode = None
                
            def _compute_hash(self):
                """taken from python stdlib (sets.py)"""
                # Calculate hash code for a set by xor'ing the hash codes of
                # the elements.  This ensures that the hash code does not depend
                # on the order in which elements are added to the set.  This is
                # not called __hash__ because a BaseSet should not be hashable;
                # only an ImmutableSet is hashable.
                result = 0
                for elt in self:
                    result ^= hash(elt)
                return result
            
            def __hash__(self):
                """taken from python stdlib (sets.py)"""
                if self._hashcode is None:
                    self._hashcode = self._compute_hash()
                return self._hashcode

            
        class set(_baseset):
            """mutable set"""
            def add(self, value):
                self._data[value] = 1

            def remove(self, element):
                """removes <element> from set"""
                del self._data[element]

            def pop(self):
                """pops an arbitrary element from set"""
                return self._data.popitem()[0]

            def __hash__(self):
                """mutable et cannot be hashed."""
                raise TypeError("set objects are not hashable")

        del _baseset # don't explicity provide this class

Set = class_renamed('Set', set, 'logilab.common.compat.Set is deprecated, '
                    'use logilab.common.compat.set instead')

try:
    from itertools import izip, chain, imap
except ImportError:
    # from itertools documentation ###
    def izip(*iterables):
        iterables = map(iter, iterables)
        while iterables:
            result = [i.next() for i in iterables]
            yield tuple(result)

    def chain(*iterables):
        for it in iterables:
            for element in it:
                yield element
                
    def imap(function, *iterables):
        iterables = map(iter, iterables)
        while True:
            args = [i.next() for i in iterables]
            if function is None:
                yield tuple(args)
            else:
                yield function(*args)                
try:
    sum = sum
    enumerate = enumerate
except NameError:
    # define the sum and enumerate functions (builtins introduced in py 2.3)
    import operator
    def sum(seq, start=0):
        """Returns the sum of all elements in the sequence"""
        return reduce(operator.add, seq, start)

    def enumerate(iterable):
        """emulates the python2.3 enumerate() function"""
        i = 0
        for val in iterable:
            yield i, val
            i += 1
        #return zip(range(len(iterable)), iterable)
try:
    sorted = sorted
    reversed = reversed
except NameError:
    
    def sorted(iterable, cmp=None, key=None, reverse=False):
        original = list(iterable)
        if key:
            l2 = [(key(elt), index) for index, elt in enumerate(original)]
        else:
            l2 = original
        l2.sort(cmp)
        if reverse:
            l2.reverse()
        if key:
            return [original[index] for elt, index in l2]
        return l2
    
    def reversed(l):
        l2 = list(l)
        l2.reverse()
        return l2

# Python2.5 builtins
try:
    any = any
    all = all
except NameError:
    def any(iterable):
        """any(iterable) -> bool

        Return True if bool(x) is True for any x in the iterable.
        """
        for elt in iterable:
            if elt:
                return True
        return False
    
    def all(iterable):
        """all(iterable) -> bool

        Return True if bool(x) is True for all values x in the iterable.
        """
        for elt in iterable:
            if not elt:
                return False
        return True
