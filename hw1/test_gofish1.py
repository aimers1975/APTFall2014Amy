import gofish1

def create_deck():

   deck = list()
   royalty = {11:'J',12:'Q',13:'K',14:'A'}
   suits = {1:'spades',2:'hearts',3:'diamonds',4:'clubs'}
   for x in range(2,15):
       for y in range(1,5):
           suit = suits[y]
           if(x<11):
               rank = str(x)
           else:
           	   rank = royalty[x]
           card = (rank,suit)
           deck.append(card)
   return deck

def create_hand(deck):
  thishand = dict(list())
  for n in range(0,4):
      if(len(deck) > 0):
          mycard = gofish1.getCard(deck)
          if(thishand.has_key(mycard[0])):
            thishand[mycard[0]].append(mycard[1])
          else:
            blanklist = list()
            thishand[mycard[0]] = blanklist
            thishand[mycard[0]].append(mycard[1])
  return thishand

def play_game(deck,hand):
  logfiles = open('cardlog.txt','w')
  previousturnlength = 48
  while len(deck) > 0:
    logfiles.write('Deck length: ' + str(len(deck)) + '\n')
    logfiles.write('My hand: ' + str(hand) + '\n')
    gofish1.drawCard('Amy',deck,hand)
    assert len(deck) == (previousturnlength-1), 'Deck does not have one less card'
    previousturnlength = len(deck)
    logfiles.write('My hand: ' + str(hand) + '\n')
    if len(deck) < 13:
      for x in range(12,0,-1):
        if len(deck) == x:
          assert (len(hand) + len(deck)) <= x*4, 'Card not removed from hand'
  logfiles.close()   

thisdeck = create_deck()
assert len(thisdeck) == 52, 'Deck was not created correctly, too few cards.'
myhand = create_hand(thisdeck)
assert len(thisdeck) == 48, 'First hand left incorrect number of cards in deck'
play_game(thisdeck,myhand)
assert len(thisdeck) == 0, 'Cards remaining in deck after game'
assert len(myhand) == 0, 'Cards remaining in hand after game'











