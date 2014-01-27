# Copyright (c) 2002-2007 LOGILAB S.A. (Paris, FRANCE).
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
"""
 bases class for interfaces to provide "light" interface handling.

 TODO:
  _ implements a check method which check that an object implements the
    interface
  _ Attribute objects

  This module requires at least python 2.2
"""

from types import ListType, TupleType

class Interface:
    """base class for interfaces"""
    def is_implemented_by(cls, instance):
        return implements(instance, cls)
    is_implemented_by = classmethod(is_implemented_by)

    
def implements(obj, interface):
    """return true if the give object (maybe an instance or class) implements
    the interface
    """
    kimplements = getattr(obj, '__implements__', ())
    if not isinstance(kimplements, (list, tuple)):
        kimplements = (kimplements,)
    for implementedinterface in kimplements:
        if issubclass(implementedinterface, interface):
            return True
    return False


def extend(klass, interface, _recurs=False):
    """add interface to klass'__implements__ if not already implemented in.

    if klass is subclassed, ensure subclasses __implements__ it as well.
    
    NOTE: klass should be e new class.
    """
    if not implements(klass, interface):
        try:
            kimplements = klass.__implements__
            kimplementsklass = type(kimplements)
            kimplements = list(kimplements)
        except AttributeError:
            kimplementsklass = tuple
            kimplements = []
        kimplements.append(interface)
        klass.__implements__ = kimplementsklass(kimplements)
        for subklass in klass.__subclasses__():
            extend(subklass, interface, _recurs=True)
    elif _recurs:
        for subklass in klass.__subclasses__():
            extend(subklass, interface, _recurs=True)
