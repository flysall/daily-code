def add(x, y, f):
	return f(x) + f(y)
x = add(-5, 6, abs)
print(x)


print('--->')

def normalize(name):
    return name.lower().capitalize()

L1 = ['adam', 'LISA', 'barT']
L2 = list(map(normalize, L1))
print(L2)
print('------------------------')



L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]
def by_name(t):
	l = []
	for x in L:
		l.append(str((x[:0].lower())))
	return l
L2 = sorted(L, key=by_name)
print(L2)


