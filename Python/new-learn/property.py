class Student(object):
	@property
	def birth(sef):
		return self._birth
	@birth.setter
	def birth(self, value):
		self._birth = value
	@property
	def age(self):
		return 2015 - self._birth