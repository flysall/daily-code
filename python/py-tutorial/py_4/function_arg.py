def ask_ok(prompt, retries=4, remainder='Please try again!'):
    while True:
        ok = input(prompt)
        if ok in ('y', 'yes', 'yes'):
            return True
        if ok in ('n', 'no', 'nop', 'nope'):
            return False
        retries = retries - 1
        if retries < 0:
            raise ValueError("invalid user response")
        print(remainder)
i = 5
def f(arg=i):
    print(arg)
i = 6
f()
print('--->')
def f(a, L=[]):
    L.append(a)
    return L
print(f(1))
print(f(2))
print(f(3))
print('--->')
print('L is None')
def f1(a, L=None):
    if L is None:
        L = []
    L.append(a)
    return L
print(f1(1))
print(f1(2))
print('===keyword arguments===')
def parrot(voltage, state='a stiff', action='voom', type='Norwegian Blue'):
        print("--This parrot wouldn't", action, end=' ')
        print("if you put", voltage, "volts through it.")
        print("--Lovely plumage, the", type)
        print("--Its's", state, "!")
parrot(100)
parrot(voltage=100)
parrot('a thousand', 'bereft of life', 'jump')
print('===Arbitrary argument list===')
def write_multiple_items(file, separator, *args):
    file.write(separator.join(args))
def concat(*args, sep="/"):
    return sep.join(args)
print(concat("earth", "mars", 'venus'))
print('====lambda===')
def make_incrementor(n):
    return lambda x: x + n
f = make_incrementor(42)
print(f(1))
print(f(2))
print('the type of f() is:')
print(type(f))
print('--->')
pairs = [(1,'one'), (2,'two'), (3,'three'), (4,'four')]
pairs.sort(key=lambda pair:pair[1])
print(pairs)
print('===Documentation Strings===')
def my_function():
    """Do nothing, but document is.
    No, really, it doesn't do anything.
    """
print(my_function.__doc__)    
def f(han:str, eggs:str='eggs') -> str:
    print('Annotations:', f.__annotations__)
    print("Arguments:", han, eggs)
    return han + ' and ' + eggs
print(f('spam'))
