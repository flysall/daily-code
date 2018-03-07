print('---finally---')
"""try:
    raise KeyboardInterrupt
finally:
    print('Goodbye, flysall!')
"""
print('<<<')
def divide(x,y):
    try:
        result = x / y
    except ZeroDivisionError:
        print("division by zero!")
    else:
        print("result is", result)
    finally:
        print('executing finally clause')
print(divide(2,1))
print(divide(2,0))
#print(divide('2', '1'))

print('<<<')
with open('temp.txt') as f:
    for line in f:
        print(line, end=' ')
        
