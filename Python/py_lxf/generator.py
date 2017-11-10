L = [x * x for x in range(10)]
print(L)

g = (x * x for x in range(10))
print(g)

print(next(g))
print(next(g))
print('-->')
for n in g:
	print(g)
print('-->')
def fib(max):
	n, a, b = 0, 0, 1
	while n < max:
		print(b)
		print('n is', n)
		a, b = b, a + b
		n = n + 1
	return 'done'
fib(6)
print('-->')
def fib2(max):
	n, a, b = 0, 0, 1
	while n < max:
		yield b 
		print(b)
		print('n is', n)
		a, b = b, a + b
		n = n + 1
	return 'done'
fib2(6)
print('-->')
def odd():
	print('step 1')
	yield 1
	print('step 2')
	yield(3)
	print('step 3')
	yield(5)
o = odd()
next(o)
print('-->')
g = fib(6)
while True:
	try:
		x = next(g)
		print('g:', x)
	except StopIteration as e:
		print('Generator return value:', e.value)
		break