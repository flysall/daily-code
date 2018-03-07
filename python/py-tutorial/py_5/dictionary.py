import math
tel = {'jack':4098, 'space':4139}
tel['guido'] = 4127
print(tel)
print('After del:')
del tel['jack']
print(tel)
tel['irv'] = 4127
print(tel)

print('<<<')
print(list(tel.keys()))
print(sorted(tel.keys()))
print('guido' in tel)

print('<<<')
print({x:x**2 for x in (2, 4, 6)})

print('<<<')
knights = {'gallahad':'the pure', 'robin':'the brave'}
for k,v in knights.items():
    print(k, v)
for i,v in enumerate(['tic', 'tac', 'toe']):
    print(i, v)

print('<<<')
question = ['name', 'question', 'favorite color']
answer = ['lancelot', 'the only grail', 'blue']
for q,a in zip(question, answer):
    print('what is your {1}? It is {0}.'.format(q,a))

print('<<<')
for i in reversed(range(1,10,2)):
    print(i)

print('<<<')
raw_data = [56.2, float('NaN'), 51.7, 55.3, 52.5, float('NaN'), 47.8]
filtered_data =[]
for value in raw_data:
    if not math.isnan(value):
        filtered_data.append(value)
print(filtered_data)

