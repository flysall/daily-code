class Dog:
    kind = 'canine'
    def __init__(self, name):
        self.name = name
d = Dog('Fido')
e = Dog('Buddy')
print(d.kind)
print(e.kind)
print(d.name)
print(e.name)

class Dog2:
    tricks = []
    def __init__(self, name):
        self.name = name
    def add_trick(self, trick):
        self.tricks.append(trick)
d = Dog2('Fido')
e = Dog2('Budy')
d.add_trick('roll over')
e.add_trick('play deal')
print('---Bad use---')
print(d.tricks)
print(e.tricks)

class Dog3:
    def __init__(self, name):
        self.name = name
        self.tricks = []
    def add_trick(self, trick):
        self.tricks.append(trick)
d = Dog3('Fido')
e = Dog3('Buddy')
d.add_trick('roll over')
e.add_trick('play dead')
print('---Good use---')
print(d.tricks)
print(e.tricks)
print('>>>You can do that by keyword \'static\' in Java<<<')

print('---private variable---')
class Mapping:
    def __init__(self, iterable):
        self.items_list = []
        self.__update(iterable)
    def update(self, iterable):
        for item in iterable:
            self.items_list.append(item)
    __update = update  #private copy of original update() method
class MappingSubclass(Mapping):
    def update(self, keys, values):
        #provieds new signature for update()
        #but does not break __init__()
        for item in zip(keys, values):
            self.items_list.append(item)
list = [1,3,5,7]            
ms = MappingSubclass(list)
print(ms.items_list)
list2 = [2,4,6,8]
list3 = [22,44,66,88]
ms.update(list2, list3)
print(ms.items_list)

print('---empty class---')
class Employee:
    pass
john = Employee()
john.name = 'John doe'
john.dept = 'computer lab'
john.salary = 1000
print('john is:', john.name, john.dept, john.salary)

