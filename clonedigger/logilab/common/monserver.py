# -*- coding: iso-8859-1 -*-
"""This module implements a TCP server in a separate thread that
allows *one* client to connect and provides a command line interpreter
allowing the remote client to explore the process on the fly
"""

from warnings import warn
warn('this module is deprecated and will disappear in a near release',
     DeprecationWarning, stacklevel=1)

__revision__ = '$Id: monserver.py,v 1.2 2005-11-22 13:13:02 syt Exp $'

import threading
import SocketServer
import traceback
import code
import sys
import time


# NOTES: ce module étant utilisé pour l'introspection, il peut
# être utile de fournir dans les locales de l'interpreteur des
# objets déjà initialisés (par exemple le module __main__ ou
# bien __main__.*) ou encore des objets servant à l'introspection
# comme on en trouve dans pymonitor (qui prend la liste des objets
# maintenus par le garbage collector) ou a des statistiques
# pour faire des opérations du style:
# inspector.count_types( MyClass )
# inspector.list_types( MyClass ) etc...

class MonitorInterpreter(code.InteractiveConsole):
    """Subclasses InteractiveConsole so that all inputs
    and outputs are done through a socket"""
    def __init__(self, rfile, wfile ):
        code.InteractiveConsole.__init__(self)
        self.wfile = wfile
        self.rfile = rfile
        sys.stdout = self.wfile
        sys.stderr = self.wfile

    def write(self, data):
        """replace stderr output by writing to wfile"""
        self.wfile.write( data )
        self.wfile.flush()

    def raw_input( self, prompt = None ):
        """Provides reading lines through the network"""
        if prompt is not None:
            self.wfile.write(prompt)
            self.wfile.flush()
        line = self.rfile.readline()
        if line.endswith("\r\n"):
            line = line[:-2]
        elif line.endswith("\n"):
            line = line[:-1]
        return line
        

class MonitorRequestHandler(SocketServer.BaseRequestHandler):
    """Request handler for remote interpreter"""
    def __init__(self, request, clientaddress, server ):
        self.locals = {}
        self.globals = globals().copy()
        self.wfile = request.makefile("w")
        self.rfile = request.makefile("r")
        SocketServer.BaseRequestHandler.__init__(self, request, clientaddress,
                                                 server )
        
    def handle(self):
        """handle on request, through MonitorInterpreter"""
        saved_stdout = sys.stdout
        saved_stderr = sys.stderr
        interpreter = MonitorInterpreter(self.rfile, self.wfile)
        try:
            interpreter.interact()
        except KeyboardInterrupt:
            self.server.exit = True
        except:
            sys.stdout = saved_stdout
            sys.stderr = saved_stderr
            traceback.print_exc()
        print "Monitor handler exited"

class Monitor(threading.Thread):
    """Monitor server. monothreaded we only
    allow one client at a time"""
    def __init__(self, host, port):
        threading.Thread.__init__(self)
        self.host = host
        self.port = port
        self.exit = False


    def run(self):
        """run the server loop"""
        server = SocketServer.TCPServer( (self.host, self.port),
                                         MonitorRequestHandler )
        while not self.exit:
            server.handle_request()



def demo_forever():
    """sample demo server that outputs
    numbers on screen"""
    cnt = 1
    while 1:
        print cnt
        time.sleep(2)
        cnt += 1

if __name__ == "__main__":
    listen_port = int(sys.argv[1])
    mon = Monitor( "", listen_port )
    mon.start()
    try:
        demo_forever()
    except Exception:
        traceback.print_exc()
    mon.exit = True
    mon.join()
