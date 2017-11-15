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

print('---Internet access---')
from urllib.request import urlopen
with urlopen('http://www.sina.com.cn') as response:
    for line in response:
        line = line.decode('utf-8')
        print(line)
            
