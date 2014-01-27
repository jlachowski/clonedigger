"""some various graph manipuliation utilities

(dot generation adapted from pypy/translator/tool/make_dot.py)

:organization: Logilab
:copyright: 2003-2007 LOGILAB S.A. (Paris, FRANCE), all rights reserved.
:contact: http://www.logilab.fr/ -- mailto:contact@logilab.fr
"""

__docformat__ = "restructuredtext en"
__metaclass__ = type

import os.path as osp
import os

def escape(value):
    """make <value> usable in a dot file"""
    lines = [line.replace('"', '\\"') for line in value.split('\n')]
    data = '\\l'.join(lines)
    return '\\n' + data

def target_info_from_filename(filename):
    """transforms /some/path/foo.png into ('/some/path', 'foo.png', 'png')"""
    abspath = osp.abspath(filename)
    basename = osp.basename(filename)
    storedir = osp.dirname(abspath)
    target = filename.split('.')[-1]
    return storedir, basename, target


class DotBackend:
    """Dot File backend"""
    def __init__(self, graphname, rankdir=None, size=None, ratio=None, charset='utf-8'):
        self.graphname = graphname
        self.lines = []
        self._source = None
        self.emit("digraph %s {" % normalize_node_id(graphname))
        if rankdir:
            self.emit('rankdir=%s' % rankdir)
        if ratio:
            self.emit('ratio=%s' % ratio)
        if size:
            self.emit('size="%s"' % size)
        if charset:
            assert charset.lower() in ('utf-8', 'iso-8859-1', 'latin1'), \
                   'unsupported charset %s' % charset
            self.emit('charset="%s"' % charset)

    def get_source(self):
        """returns self._source"""
        if self._source is None:
            self.emit("}")
            self._source = '\n'.join(self.lines)
            del self.lines
        return self._source

    source = property(get_source)
    
    def generate(self, outputfile=None, dotfile=None):
        """generates a graph file
        :param target: output format ('png', 'ps', etc.). If None,
                       the raw dot source will be returned
        :return: a path to the generated file
        """
        if outputfile is not None:
            storedir, basename, target = target_info_from_filename(outputfile)
        else:
            storedir = '/tmp'
            basename = '%s.png' % (self.graphname)
            target = 'png'
            outputfile = osp.join(storedir, basename)
        dotfile = dotfile or ('%s.dot' % self.graphname)
        dot_sourcepath = osp.join(storedir, dotfile)
        pdot = file(dot_sourcepath, 'w')
        if isinstance(self.source, unicode):
            pdot.write(self.source.encode('UTF8'))
        else:
            pdot.write(self.source)
        pdot.close()
        if target != 'dot':
            os.system('dot -T%s %s -o%s' % (target, dot_sourcepath, outputfile))
            os.unlink(dot_sourcepath)
        return outputfile

    def emit(self, line):
        """adds <line> to final output"""
        self.lines.append(line)

    def emit_edge(self, name1, name2, **props):
        """emits edge from <name1> to <name2>
        
        authorized props: see http://www.graphviz.org/doc/info/attrs.html
        """
        attrs = ['%s="%s"' % (prop, value) for prop, value in props.items()]
        self.emit('edge [%s];' % ", ".join(attrs))
        self.emit('%s -> %s' % (normalize_node_id(name1), normalize_node_id(name2)))

    def emit_node(self, name, **props):
        """authorized props: see http://www.graphviz.org/doc/info/attrs.html
        """
        attrs = ['%s="%s"' % (prop, value) for prop, value in props.items()]
        self.emit('%s [%s];' % (normalize_node_id(name), ", ".join(attrs)))

def normalize_node_id(nid):
    """returns a suitable DOT node id for `nid`"""
    return '"%s"' % nid

class GraphGenerator:
    def __init__(self, backend):
        # the backend is responsible to output the graph is a particular format
        self.backend = backend

    def generate(self, visitor, propshdlr, outputfile=None):
        # the visitor 
        # the properties handler is used to get nodes and edges properties
        # according to the graph and to the backend
        self.propshdlr = propshdlr
        for nodeid, node in visitor.nodes():
            props = propshdlr.node_properties(node)
            self.backend.emit_node(nodeid, **props)
        for subjnode, objnode, edge in visitor.edges():
            props = propshdlr.edge_properties(edge, subjnode, objnode)
            self.backend.emit_edge(subjnode, objnode, **props)
        return self.backend.generate(outputfile)



def get_cycles(graph_dict, vertices=None):
    '''given a dictionnary representing an ordered graph (i.e. key are vertices
    and values is a list of destination vertices representing edges), return a
    list of detected cycles
    '''
    if not graph_dict:
        return ()
    result = []
    if vertices is None:
        vertices = graph_dict.keys()
    for vertice in vertices:
        _get_cycles(graph_dict, vertice, [], result)
    return result

def _get_cycles(graph_dict, vertice=None, path=None, result=None):
    """recursive function doing the real work for get_cycles"""
    if vertice in path:
        cycle = [vertice]
        for i in range(len(path)-1, 0, -1):
            node = path[i]
            if node == vertice:
                break
            cycle.insert(0, node)
        # make a canonical representation
        start_from = min(cycle)
        index = cycle.index(start_from)
        cycle = cycle[index:] + cycle[0:index]
        # append it to result if not already in
        if not cycle in result:
            result.append(cycle)
        return
    path.append(vertice)
    try:
        for node in graph_dict[vertice]:
            _get_cycles(graph_dict, node, path, result)
    except KeyError:
        pass
    path.pop()
