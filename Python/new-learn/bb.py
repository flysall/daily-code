def count():
    def f(j):
        def g():
            return j*j
        return g
    fs = []
    #print(fs)
    for i in range(1, 4):
        fs.append(f(i)) # f(i)立刻被执行，因此i的当前值被传入f()
	print(fs)
    return fs
f1 , f3,  f2 = count()
print(f1)
print(f2)
print(f3)
print(f1())
print(f2())
print(f3())