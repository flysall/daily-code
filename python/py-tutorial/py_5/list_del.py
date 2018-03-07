a = [-1, 1, 66.25, 333, 333, 1234.5]
print(a)
print('After del:')
del  a[0]
print(a)
print('After pop():')
print(a.pop(0))
print(a)
print('After del slices:')
del a[2:4]
print(a)
print(type(a))
del a
