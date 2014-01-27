===================
Clone Digger README
===================

available at http://clonedigger.sourceforge.net

Clone Digger is the tool for finding software clones. 
Currently only Python language is supported, Java support will be added soon.
See the site for details.

Usage
=====

The simplest way of running Clone Digger is::

    clonedigger source_file_1 source_file_2 ...

Or::

    clonedigger --recursive path_to_source_tree

Don't forget to remove automatically generated sources, tests and third party libraries from the source tree.

See http://clonedigger.sourceforge.net/documentation.html for more complex arguments.

The available arguments can be obtained using '--help' also.
