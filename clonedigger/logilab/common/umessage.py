"""unicode email support"""

import email
from email.Utils import parseaddr, parsedate
from email.Header import decode_header

try:
    from mx.DateTime import DateTime
except ImportError:
    def DateTime(*args): return None

def decode_QP(string):
    parts = []
    for decoded, charset in decode_header(string):
        if charset is None:
            charset = 'iso-8859-15'
        parts.append(unicode(decoded, charset, 'replace'))

    return u' '.join(parts)

def message_from_file(fd):
    try:
        return UMessage(email.message_from_file(fd))
    except email.Errors.MessageParseError:
        return ''
    
def message_from_string(string):
    try:
        return UMessage(email.message_from_string(string))
    except email.Errors.MessageParseError:
        return ''
    
class UMessage:
    """Encapsulates an email.Message instance and returns only unicode objects"""

    def __init__(self, message):
        self.message = message

    # email.Message interface #################################################
    
    def get(self, header, default=None):
        value = self.message.get(header, default)
        if value:
            return decode_QP(value)
        return value

    def get_all(self, header, default=()):
        return [decode_QP(val) for val in self.message.get_all(header, default)
                if val is not None]
    
    def get_payload(self, index=None, decode=False):
        message = self.message
        if index is None:
            payload = message.get_payload(index, decode)
            if isinstance(payload, list):
                return [UMessage(msg) for msg in payload]
            if message.get_content_maintype() != 'text':
                return payload

            charset = message.get_content_charset() or 'iso-8859-1'
            if charset == 'unknown-8bit':
                charset = 'iso-8859-1'
            return unicode(payload or '', charset)
        else:
            payload = UMessage(message.get_payload(index, decode))
        return payload

    def is_multipart(self):
        return self.message.is_multipart()

    def get_boundary(self):
        return self.message.get_boundary()

    def walk(self):
        for part in self.message.walk():
            yield UMessage(part)
    
    def get_content_maintype(self):
        return unicode(self.message.get_content_maintype())

    def get_content_type(self):
        return unicode(self.message.get_content_type())

    def get_filename(self, failobj=None):
        value = self.message.get_filename(failobj)
        if value is failobj:
            return value
        try:
            return unicode(value)
        except UnicodeDecodeError:
            return u'error decoding filename'

    # other convenience methods ###############################################

    def headers(self):
        """return an unicode string containing all the message's headers"""
        values = []
        for header in self.message.keys():
            values.append(u'%s: %s' % (header, self.get(header)))
        return '\n'.join(values)

    def multi_addrs(self, header):
        """return a list of 2-uple (name, address) for the given address (which
        is exepected to be an header containing address such as from, to, cc...)
        """
        persons = []
        for person in self.get_all(header, ()):
            name, mail = parseaddr(person)
            persons.append((name, mail))
        return persons
    
    def date(self):
        """return a mx.DateTime object for the email's date or None if no date is
        set or if it can't be parsed
        """
        value = self.get('date')
        if value:
            datetuple = parsedate(value)
            if datetuple:
                return DateTime(*datetuple[:6])
        return None

    

    
