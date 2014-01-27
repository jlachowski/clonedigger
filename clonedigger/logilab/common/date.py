# Copyright (c) 2006-2006 LOGILAB S.A. (Paris, FRANCE).
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

"""date manipulation helper functions"""

import math

try:
    from mx.DateTime import RelativeDateTime, strptime, Date
    STEP = 1
except ImportError:
    from warnings import warn
    warn("mxDateTime not found, holiday management won't be available")
    from datetime import timedelta
    STEP = timedelta(days=1)
else:
    endOfMonth = RelativeDateTime(months=1, day=-1)

    FRENCH_FIXED_HOLIDAYS = {
        'jour_an'        : '%s-01-01',
        'fete_travail'   : '%s-05-01',
        'armistice1945'  : '%s-05-08',
        'fete_nat'       : '%s-07-14',
        'assomption'     : '%s-08-15',
        'toussaint'      : '%s-11-01',
        'armistice1918'  : '%s-11-11',
        'noel'           : '%s-12-25',
        }


    FRENCH_MOBILE_HOLIDAYS = {
        'paques2004'    : '2004-04-12',
        'ascension2004' : '2004-05-20',
        'pentecote2004' : '2004-05-31',

        'paques2005'    : '2005-03-28',
        'ascension2005' : '2005-05-05',
        'pentecote2005' : '2005-05-16',

        'paques2006'    : '2006-04-17',
        'ascension2006' : '2006-05-25',
        'pentecote2006' : '2006-06-05',

        'paques2007'    : '2007-04-09',
        'ascension2007' : '2007-05-17',
        'pentecote2007' : '2007-05-28',

        'paques2008'    : '2008-03-24',
        'ascension2008' : '2008-05-01',
        'pentecote2008' : '2008-05-12',
        }

    def get_national_holidays(begin, end):
        """return french national days off between begin and end"""
        begin = Date(begin.year, begin.month, begin.day)
        end = Date(end.year, end.month, end.day)
        holidays = [strptime(datestr, '%Y-%m-%d')
                    for datestr in FRENCH_MOBILE_HOLIDAYS.values()]
        for year in xrange(begin.year, end.year+1):
            for datestr in FRENCH_FIXED_HOLIDAYS.values():
                date = strptime(datestr % year, '%Y-%m-%d')
                if date not in holidays:
                    holidays.append(date)
        return [day for day in holidays if begin <= day < end]


    def add_days_worked(start, days):
        """adds date but try to only take days worked into account"""
        weeks, plus = divmod(days, 5)
        end = start+(weeks * 7) + plus
        if end.day_of_week >= 5: # saturday or sunday
            end += 2
        end += len([x for x in get_national_holidays(start, end+1)
                    if x.day_of_week < 5])
        if end.day_of_week >= 5: # saturday or sunday
            end += 2
        return end

    def nb_open_days(start, end):
        assert start <= end
        days = int(math.ceil((end - start).days))
        weeks, plus = divmod(days, 7)
        if start.day_of_week > end.day_of_week:
            plus -= 2
        elif end.day_of_week == 6:
            plus -= 1
        open_days = weeks * 5 + plus
        nb_week_holidays = len([x for x in get_national_holidays(start, end+1)
                                if x.day_of_week < 5 and x < end])
        return open_days  - nb_week_holidays


def date_range(begin, end, step=STEP):
    """
    enumerate dates between begin and end dates.

    step can either be oneDay, oneHour, oneMinute, oneSecond, oneWeek
    use endOfMonth to enumerate months
    """
    date = begin
    while date < end :
        yield date
        date += step

