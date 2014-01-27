# Copyright (c) 2003-2006 LOGILAB S.A. (Paris, FRANCE).
# http://www.logilab.fr/ -- mailto:contact@logilab.fr
#
# This program is free software; you can redistribute it and/or modify it under
# the terms of the GNU General Public License as published by the Free Software
# Foundation; either version 2 of the License, or (at your option) any later
# version.
#
# This program is distributed in the hope that it will be useful, but WITHOUT
# ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
# FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License along with
# this program; if not, write to the Free Software Foundation, Inc.,
# 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
"""Logilab common libraries:

a set of common functionnalities shared among logilab projects


:type STD_BLACKLIST: tuple
:var STD_BLACKLIST:
  directories ignored by default by the functions in this package which have
  to recurse into directories

:type IGNORED_EXTENSIONS: tuple
:var IGNORED_EXTENSIONS:
  file extensions that may usually be ignored
"""

STD_BLACKLIST = ('CVS', '.svn', '.hg', 'debian', 'dist', 'build')

IGNORED_EXTENSIONS = ('.pyc', '.pyo', '.elc', '~')



from clonedigger.logilab.common.deprecation import moved

get_cycles = moved('logilab.common.graph', 'get_cycles')
cached = moved('logilab.common.decorators', 'cached')
ProgressBar = moved('logilab.common.shellutils', 'ProgressBar')
Execute = moved('logilab.common.shellutils', 'Execute')
acquire_lock = moved('logilab.common.shellutils', 'acquire_lock')
release_lock = moved('logilab.common.shellutils', 'release_lock')
deprecated_function = moved('logilab.common.deprecation', 'deprecated_function')
class_renamed = moved('logilab.common.deprecation', 'class_renamed')

def intersection(list1, list2):
    """return the intersection of list1 and list2"""
    warn('this function is deprecated, use a set instead', DeprecationWarning,
         stacklevel=2)
    intersect_dict, result = {}, []
    for item in list1:
        intersect_dict[item] = 1
    for item in list2:
        if intersect_dict.has_key(item):
            result.append(item)
    return result

def difference(list1, list2):
    """return elements of list1 not in list2"""
    warn('this function is deprecated, use a set instead', DeprecationWarning,
         stacklevel=2)
    tmp, result = {}, []
    for i in list2:
        tmp[i] = 1
    for i in list1:
        if not tmp.has_key(i):
            result.append(i)
    return result

def union(list1, list2):
    """return list1 union list2"""
    warn('this function is deprecated, use a set instead', DeprecationWarning,
         stacklevel=2)
    tmp = {}
    for i in list1:
        tmp[i] = 1
    for i in list2:
        tmp[i] = 1
    return tmp.keys()


class attrdict(dict):
    """a dictionary whose keys are also accessible as attributes"""
    def __getattr__(self, attr):
        try:
            return self[attr]
        except KeyError:
            raise AttributeError(attr)
        
class nullobject(object):
    def __nonzero__(self):
        return False

# flatten -----
# XXX move in a specific module and use yield instead
# do not mix flatten and translate
#
# def iterable(obj):
#    try: iter(obj)
#    except: return False
#    return True
#
# def is_string_like(obj):
#    try: obj +''
#    except (TypeError, ValueError): return False
#    return True
#
#def is_scalar(obj):
#    return is_string_like(obj) or not iterable(obj)
#
#def flatten(seq):
#    for item in seq:
#        if is_scalar(item): 
#            yield item
#        else:
#            for subitem in flatten(item):
#               yield subitem

def flatten(iterable, tr_func=None, results=None):
    """flatten a list of list with any level

    if tr_func is not None, it should be a one argument function that'll be called
    on each final element
    """
    if results is None:
        results = []
    for val in iterable:
        if isinstance(val, (list, tuple)):
            flatten(val, tr_func, results)
        elif tr_func is None:
            results.append(val)
        else:
            results.append(tr_func(val))
    return results


# XXX is function below still used ?

def make_domains(lists):
    """
    given a list of lists, return a list of domain for each list to produce all
    combinaisons of possibles values

    ex: (['a', 'b'], ['c','d', 'e'])
       -> (['a', 'b', 'a', 'b', 'a', 'b'],
           ['c', 'c', 'd', 'd', 'e', 'e'])
    """
    domains = []
    for iterable in lists:
        new_domain = iterable[:]
        for i in range(len(domains)):
            domains[i] = domains[i]*len(iterable)
        if domains:
            missing = (len(domains[0]) - len(iterable)) / len(iterable)
            i = 0
            for j in range(len(iterable)):
                value = iterable[j]
                for dummy in range(missing):
                    new_domain.insert(i, value)
                    i += 1
                i += 1
        domains.append(new_domain)
    return domains
