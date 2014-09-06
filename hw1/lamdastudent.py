from student import student

fivestudents = [student('brad',2.0,13),student('lisa',3.4,10),student('bob',2.0,11),student('brad',2.0,12),student('susan',3.4,14)]

mystudent = student('Joe',3.4,5)
for student in fivestudents:
	print str(student)
print '\n'

fivestudents.sort(key=lambda student:student['age'])
fivestudents.sort(key=lambda student:student['name'])
fivestudents.sort(key=lambda student:student['GPA'])
for students in fivestudents:
	print students
