# -*- coding: utf-8 -*-
"""
This module contains the tool of collective.recipe.buildbot
"""

from ez_setup import use_setuptools
use_setuptools()

import os
from setuptools import setup, find_packages

def read(*rnames):
    return open(os.path.join(os.getcwd(), *rnames)).read()

version = '1.0.4-beta'

long_description = "" 

entry_points = {"console_scripts": [
                    "clonedigger = clonedigger.clonedigger:main"
                    ],
                }

setup(name='clonedigger',
      version=version,
      description=("Clone Digger aimed to detect similar code in Python "
                   "and Java programs."),
      long_description=long_description,
      # Get more strings from http://www.python.org/pypi?%3Aaction=list_classifiers
      classifiers=[
        'Intended Audience :: Developers',
        'Topic :: Software Development :: Libraries :: Python Modules',
        ],
      keywords='buildout buildbot',
      author='Peter Bulychev',
      author_email='peter.bulychev@gmail.com',
      url='http://clonedigger.sourceforge.net',
      license='GPL',
      packages=find_packages(),
      include_package_data=True,
      zip_safe=False,
      install_requires=['setuptools'],
      entry_points=entry_points,
      )

