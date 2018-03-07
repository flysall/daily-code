def reverse(data):
    for index in range(len(data)-1, -1, -1):
        yield data[index]
for char in reverse('golf'):
    print(char)

print('---Generator Expression---')
tp = sum(i*i for i in range(10))
print(tp)
print('<<<')
xvec = [10, 20, 30]
yvec = [7, 5, 3]
tp = sum(x * y for x,y in zip(xvec, yvec))
print(tp)

from math import pi, sin
sine_table = {x: sin(x*pi/180) for x in range(0, 91)}
print(sine_table)

