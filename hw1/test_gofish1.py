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

   print str(deck)
   return deck

thisdeck = create_deck()
assert len(thisdeck) == 52
logfiles = open('cardlog.txt','w')
for x in range(1,53):
  if(len(thisdeck) > 0):
    logfiles.write(str(gofish1.getCard(thisdeck)))
    logfiles.write('\n')
    logfiles.write(str(len(thisdeck)))
    logfiles.write('\n')

logfiles.close()   