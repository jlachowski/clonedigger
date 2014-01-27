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
Some shell/term utilities, useful to write some python scripts instead of shell
scripts

:author:    Logilab
:copyright: 2003-2008 LOGILAB S.A. (Paris, FRANCE)
:contact:   http://www.logilab.fr/ -- mailto:python-projects@logilab.org
"""
__docformat__ = "restructuredtext en"

import os        
import glob
import shutil
import sys
import tempfile
import time
from os.path import exists, isdir, islink, basename, join, walk

from clonedigger.logilab.common import STD_BLACKLIST


def chown(path, login=None, group=None):
    """same as `os.chown` function but accepting user login or group name as
    argument. If login or group is omitted, it's left unchanged.

    Note: you must own the file to chown it (or be root). Otherwise OSError is raised. 
    """
    if login is None:
        uid = -1
    else:
        try:
            uid = int(login)
        except ValueError:
            import pwd
            uid = pwd.getpwnam(login).pw_uid
    if group is None:
        gid = -1
    else:
        try:
            gid = int(group)
        except ValueError:
            import grp
            gid = grp.getgrname(group).gr_gid
    os.chown(path, uid, gid)
        

def mv(source, destination, _action=shutil.move):
    """a shell like mv, supporting wildcards
    """
    sources = glob.glob(source)
    if len(sources) > 1:
        assert isdir(destination)
        for filename in sources:
            _action(filename, join(destination, basename(filename)))
    else:
        try:
            source = sources[0]
        except IndexError:
            raise OSError('No file matching %s' % source)
        if isdir(destination) and exists(destination):
            destination = join(destination, basename(source))
        try:
            _action(source, destination)
        except OSError, ex:
            raise OSError('Unable to move %r to %r (%s)' % (
                source, destination, ex))
        
def rm(*files):
    """a shell like rm, supporting wildcards
    """
    for wfile in files:
        for filename in glob.glob(wfile):
            if islink(filename):
                os.remove(filename)
            elif isdir(filename):
                shutil.rmtree(filename)
            else:
                os.remove(filename)
    
def cp(source, destination):
    """a shell like cp, supporting wildcards
    """
    mv(source, destination, _action=shutil.copy)


def find(directory, exts, exclude=False, blacklist=STD_BLACKLIST):
    """recursivly find files ending with the given extensions from the directory

    :type directory: str
    :param directory:
      directory where the search should start

    :type exts: basestring or list or tuple
    :param exts:
      extensions or lists or extensions to search

    :type exclude: boolean
    :param exts:
      if this argument is True, returning files NOT ending with the given
      extensions

    :type blacklist: list or tuple
    :param blacklist:
      optional list of files or directory to ignore, default to the value of
      `logilab.common.STD_BLACKLIST`

    :rtype: list
    :return:
      the list of all matching files
    """
    if isinstance(exts, basestring):
        exts = (exts,)
    if exclude:
        def match(filename, exts):
            for ext in exts:
                if filename.endswith(ext):
                    return False
            return True
    else:
        def match(filename, exts):
            for ext in exts:
                if filename.endswith(ext):
                    return True
            return False
    def func(files, directory, fnames):
        """walk handler"""
        # remove files/directories in the black list
        for norecurs in blacklist:
            try:
                fnames.remove(norecurs)
            except ValueError:
                continue
        for filename in fnames:
            src = join(directory, filename)
            if isdir(src):
                continue
            if match(filename, exts):
                files.append(src)
    files = []
    walk(directory, func, files)
    return files


class Execute:
    """This is a deadlock safe version of popen2 (no stdin), that returns
    an object with errorlevel, out and err
    """
    
    def __init__(self, command):
        outfile = tempfile.mktemp()
        errfile = tempfile.mktemp()
        self.status = os.system("( %s ) >%s 2>%s" %
                                (command, outfile, errfile)) >> 8
        self.out = open(outfile,"r").read()
        self.err = open(errfile,"r").read()
        os.remove(outfile)
        os.remove(errfile)


def acquire_lock(lock_file, max_try=10, delay=10):
    """acquire a lock represented by a file on the file system"""
    count = 0
    while max_try <= 0 or count < max_try:
        if not exists(lock_file):
            break
        count += 1
        time.sleep(delay)
    else:
        raise Exception('Unable to acquire %s' % lock_file)
    stream = open(lock_file, 'w')
    stream.write(str(os.getpid()))
    stream.close()
    
def release_lock(lock_file):
    """release a lock represented by a file on the file system"""
    os.remove(lock_file)


class ProgressBar(object):
    """a simple text progression bar"""
    
    def __init__(self, nbops, size=20., stream=sys.stdout):
        self._dotevery = max(nbops / size, 1)
        self._fstr = '\r[%-20s]'
        self._dotcount, self._dots = 1, []
        self._stream = stream

    def update(self):
        """update the progression bar"""
        self._dotcount += 1
        if self._dotcount >= self._dotevery:
            self._dotcount = 1
            self._dots.append('.')
            self._stream.write(self._fstr % ''.join(self._dots))
            self._stream.flush()
