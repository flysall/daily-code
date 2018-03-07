def f1(self, x, y):
    return min(x, x+y)
class C:
    f = f1
    
    def g(self):
        return 'remark'
    h = g
c = C()
print(c.f(-2, 1))
print(c.g())
print(c.g)
print(c.h())

print('<<<')
class Bag:
    def __init__(self):
        self.data = []
    def add(self, x):
        self.data.append(x)
    def addtwice(self,x):
        for i in range(2):
            self.add(x)
bag = Bag()
bag.addtwice(1)
print('bag.data is:', bag.data)
print('bag is a object:', bag.__class__)

