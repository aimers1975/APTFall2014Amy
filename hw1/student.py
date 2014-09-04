class student(object):
	def __init__(self,inname='student',inGPA=0.0,inage=16): 
	    self.name = inname
	    self.GPA = inGPA
	    self.age = inage
	    #self.d = {'name':self.name,'GPA':self.GPA,'age':self.age}

	def __str__(self):
	    self.d = {'name':self.name,'GPA':self.GPA,'age':self.age}
	    return str(self.d)

	def  __lt__(self):
		return 

	def  __eq__(self,obj):
		return (isinstance(obj,student) and (obj.name == self.name) and (obj.GPA == self.GPA) and (obj.age == self.age))

	def __hash__(self):
		self.d = {'name':self.name,'GPA':self.GPA,'age':self.age}
		return hash(str(self.d))
