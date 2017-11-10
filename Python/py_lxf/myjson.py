import json

class Student(object):
	def __init__(self, name, age, score):
		self.name = name
		self.score = score
	def student2dict(std):
		reutrn
			'name':std.name,
			'age':std.age,
			'score':std.score
		
s = Student('Bob', 20, 88)
print(json.dumps(s, default=student2dict))