import json
import sys
import re
import urllib
from bs4 import BeautifulSoup 

def contractAsJson(filename):
  jsonQuoteData = "[]"
  return jsonQuoteData

def get_text(filename):
	fhand = open(filename)
	text = fhand.read()
	return text

def get_stock_price(input):
	for link in soup.find_all('span'):
		if(link['id'] == 'yfs_l84_aapl'):
			return link.string

datafile = raw_input("Enter the text file: ")
data = get_text(datafile)
soup = BeautifulSoup(data)
print get_stock_price(soup)


#a JSON object with 3 fields. 
#The first is the current price of the stock 
#he second is the URLs corresponding to the 
#other expiration days; the third is a list 
#of the detailed individual contracts sorted 
#in decreasing order of open interest.
#<span class="time_rtq_ticker"><span id="yfs_l84_aapl">
