from student import student

def test_create():
	name = 'student'
	GPA = 0.0
	age = 16
	amyStudent = student()
	assert amyStudent.name == name
	assert amyStudent.GPA == GPA
	assert amyStudent.age == age	
	name = '1'
	GPA = 1
	age = 2
	amyStudent = student(name,GPA,age)
	assert amyStudent.name == name
	assert amyStudent.GPA == GPA
	assert amyStudent.age == age
	print 'Create test done!'

def test_str():
	name = 'student'
	GPA = 0.0
	age = 16
	amyStudent = student()
	d = "{'age': " + str(age) + ", 'name': '" + name + "', 'GPA': " + str(GPA) + "}"
	print d
	print amyStudent
	assert str(amyStudent) == d
	name = '1'
	GPA = 1.0
	age = 2
	amyStudent = student(name,GPA,age)
	d = "{'age': " + str(age) + ", 'name': '" + name + "', 'GPA': " + str(GPA) + "}"
	print d
	print amyStudent
	assert str(amyStudent) == d
	print 'String test done!'

def test_hash():
	amyStudent = student()
	print hash(amyStudent)
	name = 'amy'
	GPA = 3.4
	age = 16
	amyStudent = student(name,GPA,age)
	print hash(amyStudent)
test_create()
test_str()
test_hash()