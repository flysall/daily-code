def triangles(s):
    L = [1]
    while len(L) < s:
        yield L
        L = [1] + [L[x] + L[x + 1] for x in range(len(L) - 1)] + [1]

for i in triangles(3):
	print(i)
  