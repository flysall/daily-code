import os
print(os.name)
#print(os.environ)
print(os.environ.get('PATH'))
print(os.path.abspath('.'))
os.path.join(os.path.abspath('.'),'testdir')
os.mkdir(os.path.abspath('.'))