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
"""Deprecation utilities

:author:    Logilab
:copyright: 2006-2008 LOGILAB S.A. (Paris, FRANCE)
:contact:   http://www.logilab.fr/ -- mailto:python-projects@logilab.org
"""
__docformat__ = "restructuredtext en"

import sys
from warnings import warn

from clonedigger.logilab.common.modutils import LazyObject, load_module_from_name


class deprecated(type):
    """metaclass to print a warning on instantiation of a deprecated class"""
    
    def __call__(cls, *args, **kwargs):
        msg = getattr(cls, "__deprecation_warning__",
                      "%s is deprecated" % cls.__name__)
        warn(msg, DeprecationWarning, stacklevel=2)
        return type.__call__(cls, *args, **kwargs)


def class_renamed(old_name, new_class, message=None):
    """automatically creates a class which fires a DeprecationWarning
    when instantiated.
    
    >>> Set = class_renamed('Set', set, 'Set is now replaced by set')
    >>> s = Set()
    sample.py:57: DeprecationWarning: Set is now replaced by set
      s = Set()
    >>>
    """
    clsdict = {}
    if message is None:
        message = '%s is deprecated' % old_name
    clsdict['__deprecation_warning__'] = message
    try:
        # new-style class
        return deprecated(old_name, (new_class,), clsdict)
    except (NameError, TypeError):
        # old-style class
        class DeprecatedClass(new_class):
            """FIXME: There might be a better way to handle old/new-style class
            """
            def __init__(self, *args, **kwargs):
                warn(message, DeprecationWarning, stacklevel=2)
                new_class.__init__(self, *args, **kwargs)
        return DeprecatedClass


def class_moved(new_class, old_name=None, message=None):
    """nice wrapper around class_renamed when a class has been moved into
    another module
    """
    if old_name is None:
        old_name = new_class.__name__
    if message is None:
        message = 'class %s is now available as %s.%s' % (
            old_name, new_class.__module__, new_class.__name__)
    return class_renamed(old_name, new_class, message)


def deprecated_function(new_func, message=None):
    """creates a function which fires a DeprecationWarning when used

    For example, if <bar> is deprecated in favour of <foo> :
    >>> bar = deprecated_function(foo, 'bar is deprecated')
    >>> bar()
    sample.py:57: DeprecationWarning: bar is deprecated
      bar()
    >>>
    """
    if message is None:
        message = "this function is deprecated, use %s instead" % (
            new_func.func_name)
    def deprecated(*args, **kwargs):
        warn(message, DeprecationWarning, stacklevel=2)
        return new_func(*args, **kwargs)
    return deprecated


def moved(modpath, objname):
    """use to tell that a callable has been moved to a new module.

    It returns a callable wrapper, so that when its called a warning is printed
    telling where the object can be found, import is done (and not before) and
    the actual object is called.

    NOTE: the usage is somewhat limited on classes since it will fail if the
    wrapper is use in a class ancestors list, use the `class_moved` function
    instead (which has no lazy import feature though).
    """
    def callnew(*args, **kwargs):
        message = "object %s has been moved to module %s" % (objname, modpath)
        warn(message, DeprecationWarning, stacklevel=2)
        m = load_module_from_name(modpath)
        return getattr(m, objname)(*args, **kwargs)
    return callnew


class WarnLazyObject(LazyObject):
    def __init__(self, oldname, newname):
        # XXX doesn't work if module isn't in a package
        package, module = newname.rsplit('.', 1)
        super(WarnLazyObject, self).__init__(package, module)
        self.oldname = oldname
        self.newname = newname
        print 'hop', oldname, newname
        sys.modules[oldname] = self

    def __getobj(self):
        if self._imported is None:
            message = "module %s has moved, it's now %s" % (
                self.oldname, self.newname)
            warn(message, DeprecationWarning, stacklevel=2)
        return super(WarnLazyObject, self).__getobj()

module_moved = WarnLazyObject

def obsolete(reason="This function is obsolete"):
    """this function is an alternative to `deprecated_function`
    when there's no real replacement for the deprecated function
    """
    def newdecorator(func):
        def wrapped(*args, **kwargs):
            warn(reason, DeprecationWarning, stacklevel=2)
            return func(*args, **kwargs)
        return wrapped
    return newdecorator

