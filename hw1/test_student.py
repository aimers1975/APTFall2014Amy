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
	if(hash2Student == hash3Student):
		assert (hash(hash2Student) == hash(hash3Student))
	if(not hashStudent == hash2Student):
		assert (not hash(hashStudent) == hash(hash2Student))
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
    ltstudent = student('amy',2.0,5)
    ltstudent2 = student('amy',2.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('Joe',3.0,5)
    ltstudent2 = student('joe',3.0,5)
    assert (ltstudent < ltstudent2) == True
    ltstudent = student('amy',2.0,10)
    ltstudent2 = student('amy',2.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',3.0,5)
    ltstudent2 = student('joe',2.0,10)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',3.0,10)
    ltstudent2 = student('joe',2.0,5)
    assert (ltstudent < ltstudent2) == False
    ltstudent = student('amy',3.0,5)
    ltstudent2 = student('joe',2.0,5)
    assert (ltstudent < ltstudent2) == False 
    ltstudent = student('amy',2.0,5)
    ltstudent2 = student('joe',3.0,10)
    assert (ltstudent < ltstudent2) == True
    ltstudent = student('amy',2.0,10)
    ltstudent2 = student('joe',3.0,5)
    assert (ltstudent < ltstudent2) == True  
    ltstudent = student('joe',2.0,10)
    ltstudent2 = student('joe',3.0,5)
    assert (ltstudent < ltstudent2) == True
    ltstudent = student('Joe',2.0,10)
    ltstudent2 = student('joe',3.0,5)
    assert (ltstudent < ltstudent2) == True
    print 'Less than test done!'

def trysorting():
    c3student = student('c',3.0,6)
    c2student = student('c',3.0,7)
    astudent = student('a',1.0,1)
    F3student = student('F',1.0,3)
    Fstudent = student('F',1.0,1)
    bstudent = student('b',4.0,2)
    Estudent = student('E',3.8,4)
    cstudent = student('c',3.0,6)
    Dstudent = student('D',3.0,3)
    dstudent = student('d',2.5,9)
    Cstudent = student('C',2.5,4)
    a2student = student('a',2.5,9)
    estudent = student('e',1.6,3)
    Bstudent = student('B',4.0,11)
    fstudent = student('f',3.3,5)
    Astudent = student('f',1.5,12)
    studentlist = list()
    studentlist.append(c3student)
    studentlist.append(c2student)
    studentlist.append(astudent)
    studentlist.append(F3student)
    studentlist.append(Fstudent)
    studentlist.append(bstudent)
    studentlist.append(Estudent)
    studentlist.append(cstudent)
    studentlist.append(Dstudent)
    studentlist.append(dstudent)
    studentlist.append(Cstudent)
    studentlist.append(a2student)
    studentlist.append(estudent)
    studentlist.append(Bstudent)
    studentlist.append(fstudent)
    studentlist.append(Astudent)
    sortedlist = sorted(studentlist)
    sortedcheck = list()
    sortedcheck.append(Fstudent)
    sortedcheck.append(F3student)
    sortedcheck.append(astudent)
    sortedcheck.append(Astudent)
    sortedcheck.append(estudent)
    sortedcheck.append(Cstudent)
    sortedcheck.append(a2student)
    sortedcheck.append(dstudent)
    sortedcheck.append(Dstudent)
    sortedcheck.append(cstudent)
    sortedcheck.append(c3student)
    sortedcheck.append(c2student)
    sortedcheck.append(fstudent)
    sortedcheck.append(Estudent)
    sortedcheck.append(Bstudent)
    sortedcheck.append(bstudent)
    for thisstudent in sortedlist:
    	print str(thisstudent)
    for checkstudent in sortedcheck:
    	print str(checkstudent)
    print str(sortedlist)
    print str(sortedcheck)
    assert str(sortedlist) == str(sortedcheck)
    print 'Sorting Test Done!'	

test_create()
test_str()
test_hash()
test_eq()
test_lt()
trysorting()