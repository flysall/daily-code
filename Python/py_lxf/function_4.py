import math

 a = int(input("Please enter a:"))
 b = int(input("Please enter b:"))
 c = int(input("Please enter c:"))

def quadratic(a, b, c):
	if a == 0:
		print('a不能等于0')
	elif 2 * b - 4*a*c >= 0:
		x1 = (-b + math.sqrt(b * b - 4 * a *c)) / (2 * a)
		x2 = (-b - math.sqrt(b * b - 4 * a  * c))  / (2 * a)
		print(x1, x2)
	else:
		print('no answer')

 quadratic(a, b, c)