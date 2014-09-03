class student(object):
	def __init__(self,inname='student',inGPA=0.0,inage=16): 
	    self.name = inname
	    self.GPA = inGPA
	    self.age = inage
		d = {'name':self.name,'GPA':self.GPA,'age':self.age}

	def __str__(self):
		return str(d)

	def  __lt__():
		return 
	def  __eq__():
	    return 

    def __hash__():
    	return hash(self.name)
