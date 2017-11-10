from collections import deque
from math import pi
print('===As Stack===')
stack = [3, 4, 5]
stack.append(6)
stack.append(7)
print('After append()')
print(stack)
print(stack.pop())
print('After pop()')
print(stack)
print('===As Queue===')
queue = deque(['Eric', 'John', 'Michael'])
queue.append('Terry')
queue.append('Graham')
print('After append()')
print(queue)
print('popleft: ' + queue.popleft())
print('After popleft()')
print(queue)

print('===List Comprehensions===')
squares = []
for x in range(10):
    squares.append(x**2)
print(squares)
print('--->')
print([(x,y) for x in [1,2,3] for y in [3, 1, 4] if x != y])
print('--->')
vec = [-4, -2, 0, 2, 4]
print(vec)
print([x*2 for x in vec])
print([x for x in vec if x >= 0])
print([abs(x) for x in vec]) 

print('--->')
freshfruit = [' banana', 'loganber ', 'passion fruit ']
print(freshfruit)
print([weapon.strip() for weapon in freshfruit])

print('--->')
print([(x, x**2) for x in range(6)])

print('--->')
vec = [[1,2,3], [4,5,6], [7,8,9]]
print([num for elem in vec for num in elem])

print('--->')
print([str(round(pi,i)) for i in range(1, 6)])

print('--->')
matrix = [
        [1,2,3,4],
        [5,6,7,8],
        [9,10,11,12]]
print([[row[i] for row in matrix] for i in range(4)]) 
