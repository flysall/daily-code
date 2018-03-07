with open('gittest.py') as f:
    read_data = f.read()
print('The read_data is: ')
print('----data of gittest.py-----')
print(read_data)

f = open('gittest.py')
print('---readline()---')
print(f.readline())
print(f.readline())
print('---read with loop----')

f = open('gittest.py')
for line in f:
    print(line, end='')
f.close()

print('---write into io.txt---')
f = open('io.txt', 'w')
f.write('This is a test\n')
print('check it in ./io.txt')
value = ('answer', 42)
print(type(value))
s = str(value)
f.write(s)
print('check it in io.txt')
f.close

print('<<<')
f = open('io.txt', 'rb+')
a = f.write(b'0123456789abcdef')
b = f.seek(5)
c = f.read(1)
d = f.seek(-3, 2)
e = f.read(1)
print(a, b, c, d, e)

