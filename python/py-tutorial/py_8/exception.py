while True:
    try:
        x = int(input("please enter a number: "))
        break
    except ValueError:
        print("Oops! That was no valid number, Try again...")
class B(Exception):
    pass
class C(B):
    pass
class D(C):
    pass
for cls in [B, C, D]:
    try:
        raise cls()
    except D:
        print("D")
    except C:
        print("C")
    except B:
        print("B")

for cls in [B, C, D]:
    try:
        raise cls()
    except B:
        print("B")
    except C:
        print("C")
    except D:
        print("D")

print('<<<')
import sys
try:
    f= open('temp.txt')
    s = f.readline()
    print('type of s is: ', type(s))    
    i = int(s.strip())
except OSError as err:
    print('type of err is ', type(err))
    print("OS error: {0}".format(err))
except ValueError as err:
    print("Could not convert data to an integer.")
except:
    print("Unexpected error:", sys.exc_info()[0])
    raise

print('<<<')
for arg in sys.argv[1:]:
    try:
        f = open(arg, 'r')
    except OSError:
        print('cannot open', arg)
    else:
        print(arg, 'has', len(f.readlines()), 'lines')
        f.close()

print('<<<')
try:
    raise Exception('spam', 'eggs')
except Exception as inst:
    print('type of inst is', type(inst))
    print(inst.args)
    print(inst)
    x, y = inst.args
    print('x =', x)
    print('y =', y)
   
print('<<<')
def this_fails():
    x = 1 /0
try:
    this_fails()
except ZeroDivisionError as err:
    print('Handling run-time error:', err)
   
print('---raise excepton---')
try:
    raise NameError('Hi flysall')
except NameError:
    print('An Exception flew by!')
    raise

