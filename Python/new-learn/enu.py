from enum import Enum, unique

Month = Enum('Month', ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'))

for name, member in Month.__members__.items():
	print(name, '=>', member, ',', member.value)

@unique
class Weekday(Enum):
	Sun = 0
	Mon = 1
	Tue = 2
day1 = Weekday.Mon
print(day1)
print(Weekday['Tue'])