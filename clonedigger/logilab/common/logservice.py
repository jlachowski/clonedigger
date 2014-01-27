"""log utilities

Copyright (c) 2003-2004 LOGILAB S.A. (Paris, FRANCE), all rights reserved.
http://www.logilab.fr/ -- mailto:contact@logilab.fr
"""

from warnings import warn
warn('logservice module is deprecated and will disappear in a near release. \
use logging module instead.',
     DeprecationWarning, stacklevel=2)

__revision__ = "$Id: logservice.py,v 1.5 2006-03-05 16:13:28 syt Exp $"

from clonedigger.logilab.common.logger import make_logger, LOG_ERR, LOG_WARN, LOG_NOTICE, \
     LOG_INFO, LOG_CRIT, LOG_DEBUG

def init_log(treshold, method='eprint', sid='common-log-service',
             logger=None, output=None):
    """init the logging system and and log methods to builtins"""
    if logger is None:
        logger = make_logger(method, treshold, sid, output=output)
    # add log functions and constants to builtins
    __builtins__.update({'log': logger.log,
                         'log_traceback' : logger.log_traceback,
                         'LOG_CRIT':   LOG_CRIT,
                         'LOG_ERR':    LOG_ERR,
                         'LOG_WARN':   LOG_WARN,
                         'LOG_NOTICE': LOG_NOTICE,
                         'LOG_INFO' :  LOG_INFO,
                         'LOG_DEBUG':  LOG_DEBUG,
                         })

init_log(LOG_ERR)


