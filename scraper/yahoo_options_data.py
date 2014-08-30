import json
import sys
import re
import urllib
from bs4 import BeautifulSoup
import collections 

def contractAsJson(filename):
  jsonQuoteData = "[]"
  return jsonQuoteData

def get_text(filename):
	fhand = open(filename)
	text = fhand.read()
	return text

def get_stock_price_from_soup(inputsoup):
	  for link in inputsoup.find_all('span'):
	  	  idfield = link.get('id')
	  	  if (not idfield == None):
	  	    if(idfield.startswith('yfs_l84')):
	  	    	floatprice = float(link.string)
	  	    	return floatprice

def get_expiration_urls_from_soup(inputsoup,data):
	  expirationdatalist = re.findall('By\sExpiration:(.+?)<table',data)
	  expirationdata = expirationdatalist.pop()
	  expirationsoup = BeautifulSoup(expirationdata) 
	  experationlinklist = []
	  for link in expirationsoup.find_all('a'):
	  	thislink = link.get('href')
	  	yahoolink = 'http://finance.yahoo.com' + thislink
	  	experationlinklist.append(yahoolink)
	  return experationlinklist  	

def get_sorted_contracts_from_soup(inputsoup):
	return

def createstockdict():
    stockdict = collections.OrderedDict()
    stockdict['Ask'] = ''
    stockdict['Bid'] = ''
    stockdict['Change'] = ''
    stockdict['Date'] = ''
    stockdict['Last'] = ''
    stockdict['Open'] = ''
    stockdict['Strike'] = ''
    stockdict['Symbol'] = ''
    stockdict['Type'] = ''
    stockdict['Vol'] = ''
    return stockdict

def get_call_options(data):
	calloptionlist = re.findall('Call\sOptions.+?(<td class="yfnc_h.+)Put\sOptions',data)
	wfile = open('list.txt','w')
	calloptiondata = calloptionlist.pop()
	calloptionsoup = BeautifulSoup(calloptiondata)
	calllist = list()
	calllistitem = createstockdict()
	iter = 'strike'
	for link in calloptionsoup.find_all('td'):
	  thislink = link.get('class')
	  if(thislink == None):
	  	continue
	  if(thislink.pop().startswith('yfnc_h')):
	  	if (iter == 'strike'):
	  		calllistitem['Strike'] = str(link.string)
	  		iter = 'symbol'
	  	elif (iter == 'symbol'):
	  		calllistitem['Symbol'] = get_symbol(link.string)
	  		calllistitem['Date'] = get_date(link.string)
	  		calllistitem['Type'] = get_type(link.string)
	  		iter = 'last'
	  	elif (iter == 'last'):
	  		calllistitem['Last'] = str(link.string)
	  		iter = 'change'
	  	elif (iter == 'change'):
	  		calllistitem['Change'] = str(link.string)
	  		iter = 'bid'
	  	elif (iter == 'bid'):
	  		calllistitem['Bid'] = str(link.string)
	  		iter = 'ask'
	  	elif (iter == 'ask'):
	  		calllistitem['Ask'] = str(link.string)
	  		iter = 'vol'
	  	elif (iter == 'vol'):
	  		calllistitem['Vol'] = str(link.string)
	  		iter = 'open'
	  	elif (iter == 'open'):
	  		calllistitem['Open'] = str(link.string).replace(',','')
	  		iter = 'strike'
	  		if(len(calllist) == 0):
	  			calllist.append(calllistitem)
	  		else:
	  			looprange = len(calllist)
	  			wfile.write('looprange: ')
	  			wfile.write('\n')
	  			wfile.write(str(looprange))
	  			wfile.write('\n')
	  			for x in range(looprange):
	  				if(float(calllistitem['Open']) < float(calllist[x]['Open'])):
	  					continue
	  				else:
	  					calllist.insert(x,calllistitem)	  	
	  					wfile.write('inserting calllistitem')
	  					break		
	  				print x
	  				wfile.write(str(x))
	  				wfile.write('\n')
	  		calllistitem = createstockdict()
	wfile.close()
	#print calllist
	return calllist

def get_symbol(inputstring):
	if(len(check_date(inputstring)) > 6):
		symbol = re.findall('([A-a]+[0-9])[0-9]*.*', inputstring)
		return symbol.pop()
	else:
		symbol = re.findall('([A-a]+)[0-9]*.*', inputstring)
		return symbol.pop()

def check_date(inputstring):
	symbol = re.findall('[A-a]+([0-9]*)[A-a].*', inputstring)
	return symbol.pop()

def get_date(inputstring):
	symbol = re.findall('[A-a]+([0-9]*)[A-a].*', inputstring)
	testforextrachar = symbol.pop()
	if(len(testforextrachar) > 6):
		return testforextrachar[1:]
	else:
		return testforextrachar

def get_type(inputstring):
	symbol = re.findall('[A-a]+[0-9]*([A-a]).*', inputstring)
	return symbol.pop()

def build_json(stockprice,expirations,contracts):
	pricedict = collections.OrderedDict()
	pricedict['currPrice'] = stockprice
	pricedict['dateUrls'] = expirations
	pricedict['optionQuotes'] = contracts
	jsonstring = json.dumps(pricedict)
	return jsonstring

datafile = raw_input("Enter the text file: ")
data = get_text(datafile)
soup = BeautifulSoup(data)
stockpriceval = get_stock_price_from_soup(soup)
expyurlsvallist = get_expiration_urls_from_soup(soup,data)
contstring = get_call_options(data)
print 'List of options length: '
print len(contstring)
print build_json(stockpriceval,expyurlsvallist, contstring)




#a JSON object with 3 fields. 
#The first is the current price of the stock 
#he second is the URLs corresponding to the 
#other expiration days; the third is a list 
#of the detailed individual contracts sorted 
#in decreasing order of open interest.
#<span class="time_rtq_ticker"><span id="yfs_l84_aapl">
