L1 = ['Hello', 'World', 18, 'Apple', None]
L2 = [d.lower() for d in L1 if isinstance(d, str)]
print(L2)