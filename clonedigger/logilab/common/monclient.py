"""Simple interpreter client for monserver
provides a simple readline interface.
"""

from warnings import warn
warn('this module is deprecated and will disappear in a near release',
     DeprecationWarning, stacklevel=1)

from socket import socket, SOCK_STREAM, AF_INET
from select import select
import sys
import readline
import threading

class SocketPrinter(threading.Thread):
    """A thread that reads from a socket and output
    to stdout as data are received"""
    def __init__(self, sock):
        threading.Thread.__init__(self)
        self.socket = sock
        self.stop = False
        
    def run(self):
        """prints socket input indefinitely"""
        fd = self.socket.fileno()
        self.socket.setblocking(0)
        while not self.stop:
            iwl, _, _ = select([fd], [], [], 2)
            if fd in iwl:
                data = self.socket.recv(100)
                if data:
                    sys.stdout.write(data)
                    sys.stdout.flush()
            


def client( host, port ):
    """simple client that just sends input to the server"""
    sock = socket( AF_INET, SOCK_STREAM )
    sock.connect( (host, port) )
    sp_thread = SocketPrinter(sock)
    sp_thread.start()
    while 1:
        try:
            line = raw_input() + "\n"
            sock.send( line )
        except EOFError:
            print "Bye"
            break
        except:
            sp_thread.stop = True
            sp_thread.join()
            raise
    sp_thread.stop = True
    sp_thread.join()


if __name__ == "__main__":
    server_host = sys.argv[1]
    server_port = int(sys.argv[2])
    client(server_host, server_port)

        
        
