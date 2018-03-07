import os
x2 = [d for d in os.listdir('.')]
print(x2)


y = [x * x for x in range(1, 11)]
print(y)

x1 = [m + n for m in 'ABC' for n in 'xyz']
print(x1)


d = {'X':'A', 'y':'B', 'z':'C'}
for k,v in d.items():
	print(k, '=', v)

x3 = [k + '=' + v for k, v in d.items()]
print(x3)
