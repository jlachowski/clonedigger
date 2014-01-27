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
"""Some classes used to handle advanced configuration in simple to
complex applications.

It's able to load the configuration from a file and or command line
options, to generate a sample configuration file or to display program's
usage. It basically fill the gap between optik/optparse and ConfigParser,
with some additional data types (available as standalone optik extension
in the `optik_ext` module)


Quick start: simplest usage
```````````````````````````

import sys
from clonedigger.logilab.common.configuration import Configuration

options = [('dothis', {'type':'yn', 'default': True, 'metavar': '<y or n>'}),
           ('value', {'type': 'string', 'metavar': '<string>'}),
           ('multiple', {'type': 'csv', 'default': ('yop',),
                         'metavar': '<comma separated values>',
                         'help': 'you can also document the option'}),
           ('number', {'type': 'int', 'default':2, 'metavar':'<int>'}),
           ]
config = Configuration(options=options, name='My config')
print config['dothis']
print config['value']
print config['multiple']
print config['number']

print config.help()

f = open('myconfig.ini', 'w')
f.write('''[MY CONFIG]
number = 3
dothis = no
multiple = 1,2,3
''')
f.close()
config.load_file_configuration('myconfig.ini')
print config['dothis']
print config['value']
print config['multiple']
print config['number']

sys.argv = ['mon prog', '--value', 'bacon', '--multiple', '4,5,6',
            'nonoptionargument']
print config.load_command_line_configuration()
print config['value']

config.generate_config()


:author:    Logilab
:copyright: 2003-2008 LOGILAB S.A. (Paris, FRANCE)
:contact:   http://www.logilab.fr/ -- mailto:python-projects@logilab.org
"""

from __future__ import generators 

__docformat__ = "restructuredtext en"
__all__ = ('OptionsManagerMixIn', 'OptionsProviderMixIn',
           'ConfigurationMixIn', 'Configuration',
           'OptionsManager2ConfigurationAdapter')

import os
import sys
import re
from os.path import exists
from copy import copy
from ConfigParser import ConfigParser, NoOptionError, NoSectionError

from clonedigger.logilab.common.compat import set
from clonedigger.logilab.common.textutils import normalize_text, unquote
from clonedigger.logilab.common.optik_ext import OptionParser, OptionGroup, Values, \
     OptionValueError, OptionError, HelpFormatter, generate_manpage, check_date, \
     check_yn, check_csv, check_file, check_color, check_named, check_password,\
     NO_DEFAULT, OPTPARSE_FORMAT_DEFAULT

REQUIRED = []

class UnsupportedAction(Exception):
    """raised by set_option when it doesn't know what to do for an action"""

# validation functions ########################################################

def choice_validator(opt_dict, name, value):
    """validate and return a converted value for option of type 'choice'
    """
    if not value in opt_dict['choices']:
        msg = "option %s: invalid value: %r, should be in %s"
        raise OptionValueError(msg % (name, value, opt_dict['choices']))
    return value

def multiple_choice_validator(opt_dict, name, value):
    """validate and return a converted value for option of type 'choice'
    """
    choices = opt_dict['choices']
    values = check_csv(None, name, value)
    for value in values:
        if not value in choices:
            msg = "option %s: invalid value: %r, should be in %s"
            raise OptionValueError(msg % (name, value, choices))
    return values

def csv_validator(opt_dict, name, value):
    """validate and return a converted value for option of type 'csv'
    """
    return check_csv(None, name, value)

def yn_validator(opt_dict, name, value):
    """validate and return a converted value for option of type 'yn'
    """
    return check_yn(None, name, value)

def named_validator(opt_dict, name, value):
    """validate and return a converted value for option of type 'named'
    """
    return check_named(None, name, value)

def file_validator(opt_dict, name, value):
    """validate and return a filepath for option of type 'file'"""
    return check_file(None, name, value)

def color_validator(opt_dict, name, value):
    """validate and return a valid color for option of type 'color'"""
    return check_color(None, name, value)

def password_validator(opt_dict, name, value):
    """validate and return a string for option of type 'password'"""
    return check_password(None, name, value)

def date_validator(opt_dict, name, value):
    """validate and return a mx DateTime object for option of type 'date'"""
    return check_password(None, name, value)


VALIDATORS = {'string' : unquote,
              'int' : int,
              'float': float,
              'file': file_validator,
              'font': unquote,
              'color': color_validator,
              'regexp': re.compile,
              'csv': csv_validator,
              'yn': yn_validator,
              'bool': yn_validator,
              'named': named_validator,
              'password': password_validator,
              'date': date_validator,
              'choice': choice_validator,
              'multiple_choice': multiple_choice_validator,
              }

def _call_validator(opttype, optdict, option, value):
    if not VALIDATORS.has_key(opttype):
        raise Exception('Unsupported type "%s"' % opttype)
    try:
        return VALIDATORS[opttype](optdict, option, value)
    except TypeError:
        try:
            return VALIDATORS[opttype](value)
        except OptionValueError:
            raise
        except:
            raise OptionValueError('%s value (%r) should be of type %s' %
                                   (option, value, opttype))

# user input functions ########################################################

def input_password(optdict, question='password:'):
    from getpass import getpass
    while True:
        value = getpass(question)
        value2 = getpass('confirm: ')
        if value == value2:
            return value
        print 'password mismatch, try again'

def input_string(optdict, question):
    value = raw_input(question).strip()
    return value or None

def _make_input_function(opttype):
    def input_validator(optdict, question):
        while True:
            value = raw_input(question)
            if not value.strip():
                return None
            try:
                return _call_validator(opttype, optdict, None, value)
            except OptionValueError, ex:
                msg = str(ex).split(':', 1)[-1].strip()
                print 'bad value: %s' % msg
    return input_validator

INPUT_FUNCTIONS = {
    'string': input_string,
    'password': input_password,
    }

for opttype in VALIDATORS.keys():
    INPUT_FUNCTIONS.setdefault(opttype, _make_input_function(opttype))
    
def expand_default(self, option):
    """monkey patch OptionParser.expand_default since we have a particular
    way to handle defaults to avoid overriding values in the configuration
    file
    """
    if self.parser is None or not self.default_tag:
        return option.help
    optname = option._long_opts[0][2:]
    try:
        provider = self.parser.options_manager._all_options[optname]
    except KeyError:
        value = None
    else:
        optdict = provider.get_option_def(optname)
        optname = provider.option_name(optname, optdict)
        value = getattr(provider.config, optname, optdict)
        value = format_option_value(optdict, value)
    if value is NO_DEFAULT or not value:
        value = self.NO_DEFAULT_VALUE
    return option.help.replace(self.default_tag, str(value))

    
def convert(value, opt_dict, name=''):
    """return a validated value for an option according to its type
    
    optional argument name is only used for error message formatting
    """
    try:
        _type = opt_dict['type']
    except KeyError:
        # FIXME
        return value
    return _call_validator(_type, opt_dict, name, value)

def comment(string):
    """return string as a comment"""
    lines = [line.strip() for line in string.splitlines()]
    return '# ' + ('%s# ' % os.linesep).join(lines)

def format_option_value(optdict, value):
    """return the user input's value from a 'compiled' value"""
    if isinstance(value, (list, tuple)):
        value = ','.join(value)
    elif isinstance(value, dict):
        value = ','.join(['%s:%s' % (k,v) for k,v in value.items()])    
    elif hasattr(value, 'match'): # optdict.get('type') == 'regexp'
        # compiled regexp
        value = value.pattern
    elif optdict.get('type') == 'yn':
        value = value and 'yes' or 'no'
    elif isinstance(value, (str, unicode)) and value.isspace():
        value = "'%s'" % value
    return value

def ini_format_section(stream, section, options, doc=None):
    """format an options section using the INI format"""
    if doc:
        print >> stream, comment(doc)
    print >> stream, '[%s]' % section
    for optname, optdict, value in options:
        value = format_option_value(optdict, value)
        help = optdict.get('help')
        if help:
            print >> stream
            print >> stream, normalize_text(help, line_len=79, indent='# ')
        else:
            print >> stream
        if value is None:
            print >> stream, '#%s=' % optname
        else:
            print >> stream, '%s=%s' % (optname, str(value).strip())
        
format_section = ini_format_section

def rest_format_section(stream, section, options, doc=None):
    """format an options section using the INI format"""
    if section:
        print >> stream, '%s\n%s' % (section, "'"*len(section))
    if doc:
        print >> stream, normalize_text(doc, line_len=79, indent='')
        print >> stream
    for optname, optdict, value in options:
        help = optdict.get('help')
        print >> stream, ':%s:' % optname
        if help:
            print >> stream, normalize_text(help, line_len=79, indent='  ')
        if value:
            print >> stream, '  Default: %s' % format_option_value(optdict, value)


class OptionsManagerMixIn(object):
    """MixIn to handle a configuration from both a configuration file and
    command line options
    """
    
    def __init__(self, usage, config_file=None, version=None, quiet=0):
        self.config_file = config_file
        self.reset_parsers(usage, version=version)
        # list of registered options providers
        self.options_providers = []
        # dictionary assocating option name to checker
        self._all_options = {}
        self._short_options = {}
        self._nocallback_options = {}
        # verbosity
        self.quiet = quiet

    def reset_parsers(self, usage='', version=None):
        # configuration file parser
        self._config_parser = ConfigParser()
        # command line parser
        self._optik_parser = OptionParser(usage=usage, version=version)
        self._optik_parser.options_manager = self
        
    def register_options_provider(self, provider, own_group=True):
        """register an options provider"""
        assert provider.priority <= 0, "provider's priority can't be >= 0"
        for i in range(len(self.options_providers)):
            if provider.priority > self.options_providers[i].priority:
                self.options_providers.insert(i, provider)
                break
        else:
            self.options_providers.append(provider)
        non_group_spec_options = [option for option in provider.options
                                  if not option[1].has_key('group')]
        groups = getattr(provider, 'option_groups', ())
        if own_group:
            self.add_option_group(provider.name.upper(), provider.__doc__,
                                  non_group_spec_options, provider)
        else:
            for opt_name, opt_dict in non_group_spec_options:
                args, opt_dict = self.optik_option(provider, opt_name, opt_dict)
                self._optik_parser.add_option(*args, **opt_dict)
                self._all_options[opt_name] = provider                
        for gname, gdoc in groups:
            goptions = [option for option in provider.options
                        if option[1].get('group') == gname]
            self.add_option_group(gname, gdoc, goptions, provider)
        
    def add_option_group(self, group_name, doc, options, provider):
        """add an option group including the listed options
        """
        # add section to the config file
        self._config_parser.add_section(group_name)
        # add option group to the command line parser
        if options:
            group = OptionGroup(self._optik_parser,
                                title=group_name.capitalize())
            self._optik_parser.add_option_group(group)
        # add provider's specific options
        for opt_name, opt_dict in options:
            args, opt_dict = self.optik_option(provider, opt_name, opt_dict)
            group.add_option(*args, **opt_dict)
            self._all_options[opt_name] = provider
            
    def optik_option(self, provider, opt_name, opt_dict):
        """get our personal option definition and return a suitable form for
        use with optik/optparse
        """
        opt_dict = copy(opt_dict)
        if opt_dict.has_key('action'):
            self._nocallback_options[provider] = opt_name
        else:
            opt_dict['action'] = 'callback'
            opt_dict['callback'] = self.cb_set_provider_option
        for specific in ('default', 'group', 'inputlevel'):
            if opt_dict.has_key(specific):
                del opt_dict[specific]
                if (OPTPARSE_FORMAT_DEFAULT
                    and specific == 'default' and opt_dict.has_key('help')):
                    opt_dict['help'] += ' [current: %default]'
        args = ['--' + opt_name]
        if opt_dict.has_key('short'):
            self._short_options[opt_dict['short']] = opt_name
            args.append('-' + opt_dict['short'])
            del opt_dict['short']
        available_keys = set(self._optik_parser.option_class.ATTRS)
        for key in opt_dict.keys():
            if not key in available_keys:
                opt_dict.pop(key)
        return args, opt_dict
            
    def cb_set_provider_option(self, option, opt_name, value, parser):
        """optik callback for option setting"""
        if opt_name.startswith('--'):
            # remove -- on long option
            opt_name = opt_name[2:]
        else:
            # short option, get its long equivalent
            opt_name = self._short_options[opt_name[1:]]
        # trick since we can't set action='store_true' on options
        if value is None:
            value = 1
        self.global_set_option(opt_name, value)
        
    def global_set_option(self, opt_name, value):
        """set option on the correct option provider"""
        self._all_options[opt_name].set_option(opt_name, value)

    def generate_config(self, stream=None, skipsections=()):
        """write a configuration file according to the current configuration
        into the given stream or stdout
        """
        stream = stream or sys.stdout
        printed = False
        for provider in self.options_providers:
            default_options = []
            sections = {}
            for section, options in provider.options_by_section():
                if section in skipsections:
                    continue
                options = [(n, d, v) for (n, d, v) in options
                           if d.get('type') is not None]
                if not options:
                    continue
                if section is None:
                    section = provider.name
                    doc = provider.__doc__
                else:
                    doc = None
                if printed:
                    print >> stream, '\n'
                format_section(stream, section.upper(), options, doc)
                printed = True

    def generate_manpage(self, pkginfo, section=1, stream=None):
        """write a man page for the current configuration into the given
        stream or stdout
        """
        generate_manpage(self._optik_parser, pkginfo,
                         section, stream=stream or sys.stdout)
        
    # initialization methods ##################################################

    def load_provider_defaults(self):
        """initialize configuration using default values"""
        for provider in self.options_providers:
            provider.load_defaults()
            
    def load_file_configuration(self, config_file=None):
        """load the configuration from file"""
        self.read_config_file(config_file)
        self.load_config_file()
        
    def read_config_file(self, config_file=None):
        """read the configuration file but do not load it (ie dispatching
        values to each options provider)
        """
        if config_file is None:
            config_file = self.config_file
        if config_file and exists(config_file):
            self._config_parser.read([config_file])
        elif not self.quiet:
            msg = 'No config file found, using default configuration'
            print >> sys.stderr, msg
            return
    
    def input_config(self, onlysection=None, inputlevel=0, stream=None):
        """interactivly get configuration values by asking to the user and generate
        a configuration file
        """
        if onlysection is not None:
            onlysection = onlysection.upper()
        for provider in self.options_providers:
            for section, option, optdict in provider.all_options():
                if onlysection is not None and section != onlysection:
                    continue
                provider.input_option(option, optdict, inputlevel)
        # now we can generate the configuration file
        if stream is not None:
            self.generate_config(stream)

    def load_config_file(self):
        """dispatch values previously read from a configuration file to each
        options provider)
        """
        parser = self._config_parser        
        for provider in self.options_providers:
            for section, option, optdict in provider.all_options():
                try:
                    value = parser.get(section, option)
                    provider.set_option(option, value, opt_dict=optdict)
                except (NoSectionError, NoOptionError), ex:
                    continue

    def load_configuration(self, **kwargs):
        """override configuration according to given parameters
        """
        for opt_name, opt_value in kwargs.items():
            opt_name = opt_name.replace('_', '-')
            provider = self._all_options[opt_name]
            provider.set_option(opt_name, opt_value)
            
    def load_command_line_configuration(self, args=None):
        """override configuration according to command line parameters

        return additional arguments
        """
        # monkey patch optparse to deal with our default values
        try:
            expand_default_backup = HelpFormatter.expand_default
            HelpFormatter.expand_default = expand_default
        except AttributeError:
            # python < 2.4: nothing to be done
            pass
        try:
            if args is None:
                args = sys.argv[1:]
            else:
                args = list(args)
            (options, args) = self._optik_parser.parse_args(args=args)
            for provider in self._nocallback_options.keys():
                config = provider.config
                for attr in config.__dict__.keys():
                    value = getattr(options, attr, None)
                    if value is None:
                        continue
                    setattr(config, attr, value)
            return args
        finally:
            if hasattr(HelpFormatter, 'expand_default'):
                # unpatch optparse to avoid side effects
                HelpFormatter.expand_default = expand_default_backup


    # help methods ############################################################

    def add_help_section(self, title, description):
        """add a dummy option section for help purpose """
        group = OptionGroup(self._optik_parser,
                            title=title.capitalize(),
                            description=description)
        self._optik_parser.add_option_group(group)
        
    def help(self):
        """return the usage string for available options """
        return self._optik_parser.format_help()
    

class Method(object):
    """used to ease late binding of default method (so you can define options
    on the class using default methods on the configuration instance)
    """
    def __init__(self, methname):
        self.method = methname
        self._inst = None
        
    def bind(self, instance):
        """bind the method to its instance"""
        if self._inst is None:
            self._inst = instance
        
    def __call__(self):
        assert self._inst, 'unbound method'
        return getattr(self._inst, self.method)()

        
class OptionsProviderMixIn(object):
    """Mixin to provide options to an OptionsManager"""
    
    # those attributes should be overridden
    priority = -1
    name = 'default'
    options = ()

    def __init__(self):
        self.config = Values()
        for option in self.options:
            try:
                option, optdict = option
            except ValueError:
                raise Exception('Bad option: %r' % option)
            if isinstance(optdict.get('default'), Method):
                optdict['default'].bind(self)
        self.load_defaults()
                
    def load_defaults(self):
        """initialize the provider using default values"""
        for opt_name, opt_dict in self.options:
            action = opt_dict.get('action')
            if action != 'callback':
                # callback action have no default
                default = self.option_default(opt_name, opt_dict)
                if default is REQUIRED:
                    continue
                self.set_option(opt_name, default, action, opt_dict)

    def option_default(self, opt_name, opt_dict=None):
        """return the default value for an option"""
        if opt_dict is None:
            opt_dict = self.get_option_def(opt_name)
        default = opt_dict.get('default')
        if callable(default):
            default = default()
        return default
        
    def option_name(self, opt_name, opt_dict=None):
        """get the config attribute corresponding to opt_name
        """
        if opt_dict is None:
            opt_dict = self.get_option_def(opt_name)
        return opt_dict.get('dest', opt_name.replace('-', '_'))
    
    def option_value(self, opt_name):
        """get the current value for the given option"""
        return getattr(self.config, self.option_name(opt_name), None)
        
    def set_option(self, opt_name, value, action=None, opt_dict=None):
        """method called to set an option (registered in the options list)
        """
        # print "************ setting option", opt_name," to value", value
        if opt_dict is None:
            opt_dict = self.get_option_def(opt_name)
        if value is not None:
            value = convert(value, opt_dict, opt_name)
        if action is None:
            action = opt_dict.get('action', 'store')
        if opt_dict.get('type') == 'named': # XXX need specific handling
            optname = self.option_name(opt_name, opt_dict)
            currentvalue = getattr(self.config, optname, None)
            if currentvalue:
                currentvalue.update(value)
                value = currentvalue
        if action == 'store':
            setattr(self.config, self.option_name(opt_name, opt_dict), value)
        elif action in ('store_true', 'count'):
            setattr(self.config, self.option_name(opt_name, opt_dict), 0)
        elif action == 'store_false':
            setattr(self.config, self.option_name(opt_name, opt_dict), 1)
        elif action == 'append':
            opt_name = self.option_name(opt_name, opt_dict)
            _list = getattr(self.config, opt_name, None)
            if _list is None:
                if type(value) in (type(()), type([])):
                    _list = value
                elif value is not None:
                    _list = []
                    _list.append(value)
                setattr(self.config, opt_name, _list)
            elif type(_list) is type(()):
                setattr(self.config, opt_name, _list + (value,))
            else:
                _list.append(value)
        else:
            raise UnsupportedAction(action)

    def input_option(self, option, optdict, inputlevel=99):
        default = self.option_default(option, optdict)
        if default is REQUIRED:
            defaultstr = '(required): '
        elif optdict.get('inputlevel', 0) > inputlevel:
            self.set_option(option, default, opt_dict=optdict)
            return
        elif optdict['type'] == 'password' or default is None:
            defaultstr = ': '
        else:
            defaultstr = '(default: %s): ' % format_option_value(optdict, default)
        print ':%s:' % option
        print optdict.get('help') or option
        inputfunc = INPUT_FUNCTIONS[optdict['type']]
        value = inputfunc(optdict, defaultstr)
        while default is REQUIRED and not value:
            print 'please specify a value'
            value = inputfunc(optdict, '%s: ' % option)
        if value is None and default is not None:
            value = default
        self.set_option(option, value, opt_dict=optdict)
            
    def get_option_def(self, opt_name):
        """return the dictionary defining an option given it's name"""
        assert self.options
        for opt in self.options:
            if opt[0] == opt_name:
                return opt[1]
        raise OptionError('no such option in section %r' % self.name, opt_name)


    def all_options(self):
        """return an iterator on available options for this provider
        option are actually described by a 3-uple:
        (section, option name, option dictionary)
        """        
        for section, options in self.options_by_section():
            if section is None:
                section = self.name.upper()
            for option, optiondict, value in options:
                yield section, option, optiondict
                
    def options_by_section(self):
        """return an iterator on options grouped by section
        
        (section, [list of (optname, optdict, optvalue)])
        """
        sections = {}
        for optname, optdict in self.options:
            sections.setdefault(optdict.get('group'), []).append(
                (optname, optdict, self.option_value(optname)))
        if None in sections:
            yield None, sections.pop(None)
        for section, options in sections.items():
            yield section.upper(), options
       

class ConfigurationMixIn(OptionsManagerMixIn, OptionsProviderMixIn):
    """basic mixin for simple configurations which don't need the
    manager / providers model
    """
    def __init__(self, *args, **kwargs):
        if not args:
            kwargs.setdefault('usage', '')
        kwargs.setdefault('quiet', 1)
        OptionsManagerMixIn.__init__(self, *args, **kwargs)
        OptionsProviderMixIn.__init__(self)
        if not getattr(self, 'option_groups', None):
            self.option_groups = []
            for option, optdict in self.options:
                try:
                    gdef = (optdict['group'], '')
                except KeyError:
                    continue
                if not gdef in self.option_groups:
                    self.option_groups.append(gdef)
        self.register_options_provider(self, own_group=0)

    def register_options(self, options):
        """add some options to the configuration"""
        options_by_group = {}
        for optname, optdict in options:
            options_by_group.setdefault(optdict.get('group', self.name.upper()), []).append((optname, optdict))
        for group, options in options_by_group.items():
            self.add_option_group(group, None, options, self)
        self.options += tuple(options)
        
    def load_defaults(self):
        OptionsProviderMixIn.load_defaults(self)

    def __getitem__(self, key):
        try:
            return getattr(self.config, self.option_name(key))
        except (OptionValueError, AttributeError):
            raise KeyError(key)

    def __setitem__(self, key, value):
        self.set_option(self.option_name(key), value)
        
    def get(self, key, default=None):
        try:
            return getattr(self.config, self.option_name(key))
        except (OptionError, AttributeError):
            return default
        

class Configuration(ConfigurationMixIn):
    """class for simple configurations which don't need the
    manager / providers model and prefer delegation to inheritance

    configuration values are accessible through a dict like interface
    """

    def __init__(self, config_file=None, options=None, name=None,
                 usage=None, doc=None, version=None):
        if options is not None:
            self.options = options
        if name is not None:
            self.name = name
        if doc is not None:
            self.__doc__ = doc
        super(Configuration, self).__init__(config_file=config_file, usage=usage, version=version)


class OptionsManager2ConfigurationAdapter(object):
    """Adapt an option manager to behave like a
    `logilab.common.configuration.Configuration` instance
    """
    def __init__(self, provider):
        self.config = provider
        
    def __getattr__(self, key):
        return getattr(self.config, key)
        
    def __getitem__(self, key):
        provider = self.config._all_options[key]
        try:
            return getattr(provider.config, provider.option_name(key))
        except AttributeError:
            raise KeyError(key)

    def __setitem__(self, key, value):
        self.config.global_set_option(self.config.option_name(key), value)

    def get(self, key, default=None):
        provider = self.config._all_options[key]
        try:
            return getattr(provider.config, provider.option_name(key))
        except AttributeError:
            return default


def read_old_config(newconfig, changes, configfile):
    """initialize newconfig from a deprecated configuration file
    
    possible changes:
    * ('renamed', oldname, newname)
    * ('moved', option, oldgroup, newgroup)
    * ('typechanged', option, oldtype, newvalue)
    """
    # build an index of changes
    changesindex = {}
    for action in changes:
        if action[0] == 'moved':
            option, oldgroup, newgroup = action[1:]
            changesindex.setdefault(option, []).append((action[0], oldgroup, newgroup))
            continue
        if action[0] == 'renamed':
            oldname, newname = action[1:]
            changesindex.setdefault(newname, []).append((action[0], oldname))
            continue
        if action[0] == 'typechanged':
            option, oldtype, newvalue = action[1:]
            changesindex.setdefault(option, []).append((action[0], oldtype, newvalue))
            continue        
        if action[1] in ('added', 'removed'):
            continue # nothing to do here
        raise Exception('unknown change %s' % action[0])    
    # build a config object able to read the old config
    options = []
    for optname, optdef in newconfig.options:
        for action in changesindex.pop(optname, ()):
            if action[0] == 'moved':
                oldgroup, newgroup = action[1:]
                optdef = optdef.copy()
                optdef['group'] = oldgroup
            elif action[0] == 'renamed':
                optname = action[1]
            elif action[0] == 'typechanged':
                oldtype = action[1]
                optdef = optdef.copy()
                optdef['type'] = oldtype
        options.append((optname, optdef))
    if changesindex:
        raise Exception('unapplied changes: %s' % changesindex)
    oldconfig = Configuration(options=options, name=newconfig.name)
    # read the old config
    oldconfig.load_file_configuration(configfile)
    # apply values reverting changes
    changes.reverse()
    done = set()
    for action in changes:
        if action[0] == 'renamed':
            oldname, newname = action[1:]
            newconfig[newname] = oldconfig[oldname]
            done.add(newname)
        elif action[0] == 'typechanged':
            optname, oldtype, newvalue = action[1:]
            newconfig[optname] = newvalue
            done.add(optname)
    for optname, optdef in newconfig.options:
        if not optname in done:
            newconfig.set_option(optname, oldconfig[optname], opt_dict=optdef)


def merge_options(options):
    """preprocess options to remove duplicate"""
    alloptions = {}
    options = list(options)
    for i in range(len(options)-1, -1, -1):
        optname, optdict = options[i]
        if optname in alloptions:
            options.pop(i)
            alloptions[optname].update(optdict)
        else:
            alloptions[optname] = optdict
    return tuple(options)
