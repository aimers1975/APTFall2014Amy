from bs4 import BeautifulSoup
import requests

def get_text(filename):
	fhand = open(filename)
	text = fhand.read()
	return text

datafile = raw_input("Enter the text file: ")
data = get_text(datafile)
soup = BeautifulSoup(data)
for link in soup.find_all('a'):
    print(link.get('href'))

