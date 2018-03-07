import os
work_dic = os.getcwd()
print(work_dic)
os.chdir('/home/flysall')
print(os.getcwd())
os.chdir('/home/flysall/fast/py_tutorial/py_10')
print(os.getcwd())
os.system('mkdir today')
os.system('ls -l')

import shutil
import glob
print(glob.glob('*.py'))

import re
print(re.findall(r'\bf[a-z]*', 'which foot or hand fell fastest'))
print(re.sub(r'(\b[a-z]+)\1', r'\1', 'cat in the the hat'))

print('---random---')
import random
print(random.choice(['apple', 'pear', 'banana']))
print(random.sample(range(100), 10))
print(random.random())
print(random.randrange(6))
"""
print('---Internet access---')
from urllib.request import urlopen
with urlopen('http://www.sina.com.cn') as response:
    for line in response:
        line = line.decode('utf-8')
        print(line)
"""

print('---datetime---')
from datetime import date
now = date.today()
print(now)
birthday = date(1964, 7, 31)
print(birthday)
age = now - birthday
print(age.days)
print(type(age))

print('---zlib---')
import zlib
s = b'witch which has which witches wrist watch'
print('length of s is: ')
print(len(s))
t = zlib.compress(s)
print('length of t is: ')
print(len(t))
zlib.decompress(t)
zlib.crc32(t)

print('---timeit---')
from timeit import Timer
print(Timer('t=a; a=b; b=t', 'a=1; b=2').timeit())
print(Timer('a,b = b,a', 'a=1; b=2').timeit())

print('---Quality Control---')
def average(values):
    """Computes the arithmetic mean of a list of number.
    >>> print(average([20, 30, 70]))
    40.0
    """
    return sum(values) / len(values)
import doctest
doctest.testmod()

print('---unittest---')
import unittest
class TestStatisticalFuctions(unittest.TestCase):
    def test_average(self):
        self.assertEqual(average([20, 30, 70]), 40.0)
        self.assertEqual(round(average([1, 5, 7]), 1), 4,3)
        with self.assertRaise(ZeroDivisionError):
            average([])
        with self.assertRaise(TypeError):
            avaerage(20, 30, 70)
unittest.main()

