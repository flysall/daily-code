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

