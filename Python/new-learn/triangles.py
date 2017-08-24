def triangles():
	L1 = [1]
	i = 1
	L2 = L1
	while True:
		yield L2
		L2.append(1)
		i = i + 1
		if i > 2:
			for j in range(1, i - 1):
				L2[j] = L1[j] + L1[j-1]
		L1 = L2

n = 0
for t in triangles():
	print(t)
	n = n + 1
	if n == 10:
		break
