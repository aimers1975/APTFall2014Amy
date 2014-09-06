class student(object):
	def __init__(self,inname='student',inGPA=0.0,inage=16): 
	    self.name = inname
	    self.GPA = inGPA
	    self.age = inage

	def __str__(self):
	    self.d = {'name':self.name,'GPA':self.GPA,'age':self.age}
	    return str(self.d)

	def  __lt__(self,obj):
		if isinstance(obj,student):
			if(self.GPA < obj.GPA):
				return True
			elif(self.GPA == obj.GPA):
				if(self.name < obj.name):
					return True
				elif(self.name == obj.name):
					if(self.age < obj.age):
						return True
					else:
						return False
				else:
					return False
			else:
				return False
		else:
			return NotImplemented


	def  __eq__(self,obj):
		return (isinstance(obj,student) and (obj.name == self.name) and (obj.GPA == self.GPA) and (obj.age == self.age))

	def __hash__(self):
		self.d = {'name':self.name,'GPA':self.GPA,'age':self.age}
		return hash(str(self.d))

	def __getitem__(self,itemstr):
		if(itemstr == 'name'):
			return self.name
		elif(itemstr == 'GPA'):
			return self.GPA
		elif(itemstr == 'age'):
			return self.age
		else:
		    return None 
