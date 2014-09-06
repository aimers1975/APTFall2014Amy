import random

def create_floats(number):
	numbers = list()
	for x in range(0,number):
		numbers.append(random.random())
	return numbers