class MyClass:
    """ A simple example class """
    i = 12345
    def f(self):
        return 'hello flysall'
x = MyClass()
print('x is:', x)
print('MyClass is:', MyClass)
print('x.i is:', x.i)
print('MyClass.i:', MyClass.i)
print('type of x.i is:', type(x.i))
print('type of MyClass.i is:', type(MyClass.i))
print('__doc__ of x is:', x.__doc__)
print('type of x.__doc__ is:', type(x.__doc__))
print('type of MyClass.__doc__ is:', type(MyClass.__doc__))
print('x.f is:', x.f)
print('MyClass.f is:', MyClass.f)
print('x.f() is:', x.f())
print('MyClass.f() is error')
print('type of x.f is:', type(x.f))
print('type of MyClass.f is:', type(MyClass.f))
print('x.f() is:', x.f())
print('MyClass.f() is: error')
print('type of x.f() is:', type(x.f()))
print('type of MyClass.f() is error')

# Err
# print(type(MyClass.f()))

print('---__init()__---')
class Complex:
    def __init__(self, realpart, imagpart):
        self.r = realpart
        self.i = imagpart
x = Complex(3.0, -4.5)
print('the attribute of Complex:')
print(x.r, x.i)

print('<<<')
x.counter = 1
print(type(x))
while x.counter < 10:
    x.counter = x.counter * 2
print(x.counter)
print(type(x))
del x.counter
print(type(x))

x = MyClass()
xf = x.f
print(xf())

