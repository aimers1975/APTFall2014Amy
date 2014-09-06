import gofish1

def create_deck():

   deck = list()
   royalty = {11:'J',12:'Q',13:'K',14:'A'}
   suits = {1:'spades',2:'hearts',3:'diamonds',4:'clubs'}
   for x in range(2,15):
       for y in range(1,5):
           #build tuple ('rank','suit')
           suit = suits[y]
           if(x<11):
               rank = str(x)
           else:
           	   rank = royalty[x]
           card = (rank,suit)
           deck.append(card)

   #print str(deck)
   return deck

def create_hand(deck):
  thishand = dict(list())

  for n in range(0,4):
 #     print ('drawing card' + str(n))
      if(len(deck) > 0):
          mycard = gofish1.getCard(deck)
          print str(mycard)
          if(thishand.has_key(mycard[0])):
            thishand[mycard[0]].append(mycard[1])
          else:
            blanklist = list()
            thishand[mycard[0]] = blanklist
            thishand[mycard[0]].append(mycard[1])
  return thishand

thisdeck = create_deck()
assert len(thisdeck) == 52
#assert each card is unique
myhand = create_hand(thisdeck)
assert len(thisdeck) == 48
#print str(myhand)
logfiles = open('cardlog.txt','w')
while len(thisdeck) > 0:
  logfiles.write('Deck length: ' + str(len(thisdeck)) + '\n')
  logfiles.write('My hand: ' + str(myhand) + '\n')
  gofish1.drawCard('Amy', thisdeck,myhand)
  logfiles.write('My hand: ' + str(myhand) + '\n')
logfiles.close()   