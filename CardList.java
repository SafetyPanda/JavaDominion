//Author:James Gillman
//Date: Mar 25th 2018
//DOMINION PART 7
//Description: Holds all the methods for a linklist that surrounds decks, hands, and discards.

public class CardList implements Linkable
{
	private CardNode head; //head of the linklist.
	
	public CardList()
	{
		head = null;
	}
	
		//MethodName:ShuffleDeck
		//Parameters: NONE
		//Return: None
		//Description: Shuffle the deck!
		public void shuffleDeck()
		{
			CardNode cur;
		    CardNode random;
		    CardJRG temp;
		    int numCards = 0;
		    
		    int rand;
		    cur = head;
			
			while (cur != null)
			{
				cur = cur.getLink();
				numCards++;	
			}
		    
		    for (int j=0; j<numCards; j++)
		    {
		        for (int i=0; i<numCards; i++)
		        {
		            cur = head;
		            random = head;

		            rand = (int)(Math.random() * numCards);

		            for(int k = 0; k < rand; k++)
		                random = random.getLink();

		            temp = cur.getACard();
		            cur.setACard(random.getACard());

		            random.setACard(temp);
		        }
		    } 
		}
		
		//MethodName: MoveToDecks
		//Parameter: fromList: Linked List that is being called to pass a node from.
		//Return: NONE
		//Description: Grabs a Node fromList and gives it to the list that is calling the function.
		public void moveToDecks(CardList fromList)
		{
			CardNode tempNode = fromList.head;
			fromList.head = fromList.head.getLink();
			tempNode.setLink(null);
			tempNode.setLink(head);
			head = tempNode;
		}
		//MethodName:addToDecks
		//Parameters: aSingularCard: 
		//Return: NONE
		//Description: Adds card to decks, either discard or player.
		public void addToDecks(CardJRG aSingularCard)
		{
			CardNode new_node = new CardNode();
			new_node.setACard(aSingularCard);
			new_node.setLink(head);
			head = new_node;	
		}
				
		//MethodName:reviveGraveyard
		//Parameters:playerDecj: Current players available cards to be used. playerDiscard: players current unusable cards.
		//Return:None
		//Description: moves a node from playerDiscard list to playerDeck
		public void reviveGraveyard(CardList playerDeck, CardList playerDiscard)
		{			
			while(playerDiscard.head != null)
			{
				playerDeck.moveToDecks(playerDiscard); //Move discard card to deck
			}
		}
		
		//MethodName: moveCardToHand()
		//Parameters: playerDeck: Current Players available cards to be used. playerDiscard: Players current unusable cards until deck runs out. cardDraw: How many cards are we drawing?
		//Return: NONE
		//Description: Grabs nodes from deck and move to players hand. If there are too few cards in deck to make a full draw then it re makes the deck with discard
		public void moveCardToHand(CardList playerDeck, CardList playerHand, CardList playerDiscard, int cardDraw)
		{
			CardNode cur = playerDeck.head;
			int count = 0; //how many cards has the player drawn?
			int cardCount = 0; //How many cards exist in the players hand?
					
			cur = playerDeck.head;
			
			while (cur != null)
			{
				cardCount++;
				cur = cur.getLink();
			}
			if (cardCount < cardDraw)
			{	
				playerDiscard.reviveGraveyard(playerDeck, playerDiscard);
				cur = playerDeck.head;
			}
			cur = playerDeck.head;			
			while(count < cardDraw)
			{				
				playerHand.moveToDecks(playerDeck);
				count++;
			}
		}
		
		
		//MethodName: findStartingCards
		//Parameters: PlayerDeck: Current players deck of cards, stacksOfCards: array of each type of dominion card.
		//Return: NONE
		//Description: Finds starting cards for starting deck for each of the players.
		public void findStartingCards(CardList playerDeck, PileJRG [] stacksOfCards)
		{
			String cardNeeded = "Copper"; //What card is needed from the deck?
			int cardAmount;		//How many cards are currently in the deck on the board?	
			for ( int cardType = 0; cardType < 2; cardType++) 
			{
				for ( int i = 0; i < 20; i++)
				{
					if (stacksOfCards[i].getCardAmount()!= -1 && stacksOfCards[i].getaSingularCard().getCardName().equalsIgnoreCase(cardNeeded))
					{
						if(stacksOfCards[i].getaSingularCard().getCardName().equalsIgnoreCase("copper"))
						{
							cardAmount = stacksOfCards[i].getCardAmount();
							for (int x = 0; x < 7; x++) 
							{
								playerDeck.addToDecks(stacksOfCards[i].getaSingularCard());
								stacksOfCards[i].setCardAmount(cardAmount - 1);	
							}
						}
						else if (stacksOfCards[i].getaSingularCard().getCardName().equalsIgnoreCase("Estate"))
						{
							cardAmount = stacksOfCards[i].getCardAmount();
							for (int y = 0; y < 3; y++) 
							{
								playerDeck.addToDecks(stacksOfCards[i].getaSingularCard());
								stacksOfCards[i].setCardAmount(cardAmount - 1);
							}	
						}		
					}
				}
			cardNeeded = "Estate";	
			}
		}
		
		//MethodName:printLink
		//Parameters: NONE
		//Return: NONE
		//Description: Prints the selected link lists nodes.
		public void printLink()
		{
			CardNode cur = head;
			
			while (cur != null)
			{
				System.out.println(cur.getACard().cardName);
				cur = cur.getLink();
			}
		}
		
		//methodName: cleanHand
		//Parameters: PlayerDeck: Current players deck of cards
		//Return: NONE
		//Description: Cleans the hand, and redraws new cards for the current player.
		public void cleanHand(CardList playerHand, CardList playerDiscard)
		{
			while (head != null)
			{
				playerDiscard.moveToDecks(playerHand);
			}
			playerHand = null;		
		}
		
		//MethodName: printHand
		//Parameters: None
		//Return: None
		//Description: Prints out current players hand.
		public void printHand()
		{
			CardNode cur = head;
			int cardNumber = 1;
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("CURRENT HAND:");
			System.out.println("----------------------------------------------------------------------------------------");
			while (cur != null)
			{
				
				System.out.print("[" + cardNumber + "] Card Type: [" + cur.getACard().cardType + "] Card Name: [" + cur.getACard().cardName + "] Card Cost: [" + cur.getACard().cardCost + "]");
				if(cur.getACard().cardType.equalsIgnoreCase("Action"))
				{
					System.out.print("Add Cards: [" + cur.getACard().getAddCards() + "] Add Buy Phase: +[" + cur.getACard().getAddBuy() + "] Add Action Phase: +[" + cur.getACard().getAddAction() + "]");
				}
				
				System.out.println("");
				cur = cur.getLink();
				cardNumber++;
			}
		}
		
		//methodName: calculateGold
		//Parameters: NONE
		//Return: goldAmount: amount of gold the current players cards totals to.
		//Description: Quick method to calculate current players gold amount in cards.
		public int calculateCurrency()
		{
			CardNode cur = head;
			int currencyAmount = 0; //players current amoutn available to spend
			
			while (cur != null)
			{
				
				if(cur.getACard().getCardType().equalsIgnoreCase("treasure"))
				{
					currencyAmount = currencyAmount + cur.getACard().getWorth(); 
				}
				cur = cur.getLink();
			}
			return currencyAmount;
		}
				
		// MethodName: calculateBuys
		// Parameters: NONE
		// Return: buyAmount
		// Description: How many buys does the player have, by running through the players hand. 
		public int calculateBuys()
		{
			CardNode cur = head;
			int buyAmount = 0; //players current amount of buys they have.
			
			while (cur != null)
			{
				
				if(cur.getACard().getCardType().equalsIgnoreCase("action"))
				{
					buyAmount = buyAmount + cur.getACard().getAddBuy(); 
				}
				cur = cur.getLink();
			}
			return buyAmount;
		}
		
		//MethodName: calculateActions
		//Parameters: none
		//Return: actionAmount
		//Description. Runs through players hand calculating how many actions they currently have.
		public int calculateActions()
		{
			CardNode cur = head;
			while (cur != null)
			{
				
				if(cur.getACard().getCardType().equalsIgnoreCase("action"))
				{
					//actionAmount++; 
					return 1;
				}
				cur = cur.getLink();
			}
			
			return 0;
		}
		
		//methodName: calculateVictoryPoints
		//Parameters: none
		//Return: finalPoints
		//Description: Runs through players decks and gets their final scores!
		public int calculateVictoryPoints()
		{
			CardNode cur = head;
			int finalPoints = 0; //Total points in players deck.
			
			while (cur != null)
			{
				
				if(cur.getACard().getCardType().equalsIgnoreCase("victory"))
				{
					finalPoints = finalPoints + cur.getACard().getVictoryPoints(); 
				}
				cur = cur.getLink();
			}
			return finalPoints;
		}
		
		// MethodName: remainingCardsInHand
		// Parameters: NONE
		// Return: numCards
		// Runs through playerHand and checks how many cards are currently there.
		public int remainingCardsInHand()
		{
			CardNode cur = head;
			int numCards = 0;
			while (cur != null)
			{
				cur = cur.getLink();
				numCards++;	
			}
			return numCards;
		}
		
		//methodName: grabbingACard
		//Parameters: card: how many cards are we drawing, playerDiscard: Players linkList of Discard.
		//Return: yourCard
		//Description: Grabs a card from players hand, and moves it to discard.
		public CardJRG grabbingACard(int card, CardList playerDiscard)
		{
			CardNode cur = head;
			CardNode prev = head;
				
			CardJRG yourCard;
			
			int count = 1;
			while(count < card && head != null)
			{
				prev = cur;
				cur = cur.getLink();
				count++;
			}
			
			yourCard = cur.getACard();
			prev.setLink(cur.getLink());
			cur.setLink(null);
			playerDiscard.addToDecks(cur.getACard());
			cur.setLink(null);
						
			return yourCard;
		}
}
