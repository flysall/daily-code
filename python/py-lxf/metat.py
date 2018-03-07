class listMetaclass(type):
	def __new__(cls, name, bases, attrs):
		attrs['add'] = lambda self, value: self.append(value)
		return type.__new__(cls, name, bases, attrs)
class MyList(list, metaclass=listMetaclass):
	pass
L = MyList()
L.add(1)
print(L)
L2 = List()
L2.add(1)
