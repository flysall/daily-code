def fib(n):
    a,b = 0,1
    while a < n:
        print(a, end=' ')
        a, b = b, a + b
    print()
fib(10)    
f = fib
print('---->')
f(3)
print('---->')
fib(4)
print(fib(3))
print('---->')
def fib2(n):
    """Return a list containing the fibnonacci series up to n."""
    result = []
    a, b = 0, 1
    while a < n:
        result.append(a)
        a,b = b, a+b
    return result
f100 = fib2(100)
print(fib2(100))
