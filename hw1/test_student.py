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
	hashStudent = student()
	print hash(hashStudent)
	name = 'amy'
	GPA = 3.4
	age = 16
	print hash(hashStudent)
	hash2Student = student(name,GPA,age)
	hash3Student = student(name,GPA,age)
	print hash(hash2Student)
	print hash(hash3Student)
	print 'Hash test done!'


def test_eq():
	eqstudent1 = student('john',3.5,10)
	eqstudent2 = student('john',3.5,10)
	assert eqstudent1 == eqstudent2
	eqstudent1 = student('john',4.0,10)
	eqstudent2 = student('john',3.5,10)
	assert not eqstudent1 == eqstudent2
	print "Equal test done!"

def test_lt():
    ltstudent = student('amy',2.0,5)
    ltstudent2 = student('joe',2.0,10)
    assert (ltstudent < ltstudent2) == True
    ltstudent = student('amy',3.0,5)
    ltstudent2 = student('joe',2.0,10)
    assert (ltstudent < ltstudent2) == True
    ltstudent = student('amy',2.0,5)
    ltstudent2 = student('joe',3.0,10)
    assert (ltstudent < ltstudent2) == True
    ltstudent = student('amy',2.0,10)
    ltstudent2 = student('joe',2.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',3.0,10)
    ltstudent2 = student('joe',2.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',2.0,10)
    ltstudent2 = student('joe',3.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',2.0,5)
    ltstudent2 = student('joe',2.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',3.0,5)
    ltstudent2 = student('joe',2.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',2.0,5)
    ltstudent2 = student('joe',3.0,5)
    assert (ltstudent < ltstudent2) == False   
    print 'Less than test done!'

def trysorting():
	astudent = student('a','1.0','1')
	bstudent = student('b','4.0','2')
	cstudent = student('c','3.0','6')
	dstudent = student('d','2.5','9')
	estudent = student('e','1.6','3')
	fstudent = student('f','3.3','5')
	studentlist = list()
	studentlist.append(astudent)
	studentlist.append(bstudent)
	studentlist.append(cstudent)
	studentlist.append(dstudent)
	studentlist.append(estudent)
	studentlist.append(fstudent)
	sortedlist = sorted(studentlist)
	for thisstudent in sortedlist:
		print str(thisstudent)
	print 'Sorting Test Done!'	




test_create()
test_str()
test_hash()
test_eq()
test_lt()
trysorting()