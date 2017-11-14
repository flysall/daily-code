s = 'Hello, World'
print(str(s))
print(repr(s))
print(str(1/7))

print('<<<')
hello = 'hello, world\n'
x = 10 * 3.25
y = 200 * 200
hellos = repr(hello)
print(hellos)
print(repr((x, y, ('spam', 'eggs'))))

print('<<<')
for x in range(1, 11):
    print(repr(x).rjust(2), repr(x*x).rjust(3), end='     ')
    print(repr(x*x*x).rjust(4))

print('<<<')
for x in range(1, 11):
    print('{0:2d} {1:3d}      {2:4d}'.format(x, x*x, x*x*x))
print('----------------')

print('<<<')
print('12'.zfill(10))
pi = '3.14159265359'
print('pi is: ', pi)
print('pi is: ', pi.zfill(5))

print('<<<')
print('{0} and {1}'.format('spam', 'eggs'))
print('{1} and {0}'.format('spam', 'eggs'))
print('{0} and {1}'.format('{', '}'))
print('This {food} is {adjective}.'.format(food='spam', adjective='absolutely horrible'))

print('<<<')
contents = 'eels'
print('My coat is full of {}.'.format(contents))
print('My coat is full of {!r}.'.format(contents))

print('<<<')
import math
print('The value of PI is approximately {0:.3f}.'.format(math.pi))

# synax sugar in dict
table = {'Sjoerd': 4127, 'Jack': 4098, 'Dcab': 7678}
for name, phone in table.items():
    print('{0:10} ==> {1:10d}'.format(name, phone))

table = {'Sjoerd': 4127, 'Jack': 4098, 'Dcab': 7678}
print('Jack: {0[Jack]:d}; Sjoerd: {0[Sjoerd]:d};''Dcab:{0[Dcab]:d}'.format(table))
print('Jack: {Jack:d}; Sjoerd: {Sjoerd:d}; Dcab:{Dcab:d}'.format(**table))

print('<<<')
print('The value of 10000000*PI is approximately %5.3f.' % (math.pi * 10000000))

