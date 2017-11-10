with open('D:\Python\learn-code\mydict.py', 'r') as f:
	print(f.read())

from io import StringIO
from io import BytesIO
f = StringIO('Hello!\nHi!\nGoodbye!')
while True:
	s = f.readline()
	if s == '':
	    break
	print(s.strip())

from io import BytesIO
f = BytesIO()
f.write('中文'.encode('utf-8')
print('some')