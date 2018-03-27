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
	
	//ALL METHODS IN THE INTERFACE HAVE TO BE IN HERE...
	
	//MethodName:ShuffleDeck
		//Parameters: TBD
		//Return: None
		//Description: Shuffle decks!
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
		
		//MethodName:addToDecks
		//Paramaters: aSingularCard: 
		//Return: NONE
		//Description: Adds card to decks, either discard or player.
		public void addToDecks(CardJRG aSingularCard)
		{
			CardNode new_node = new CardNode();
			new_node.setACard(aSingularCard);
			new_node.setLink(head);
			head = new_node;	
		}
		
		//MethodName:removeCardFromDiscard
		//Parameters:PlayerDeck: Current players deck of cards
		//Return: none
		//Description Remove card from discard and transfer it to playerDeck
		public void removeCardFromDiscard(CardList playerDeck)
		{
			CardNode cur = head;
			if (head != null)
		    {
		    	playerDeck.addToDecks(cur.getACard());
				head = head.getLink();
				cur.getLink();
		    }
		    else
		    {
		    	System.out.println("NO CARDS, Something went wrong...");
		    	System.exit(0);
		    }
		}
		
		//MethodName: removeCard
		//Parameters: TBD
		//Return: NONE
		//Description: Remove card from Players Hand
		public void removeCardFromDeck(CardList playerDiscard)
		{
			CardNode cur = head;
			if (head != null)
		    {
		    	playerDiscard.addToDecks(cur.getACard());
				head = head.getLink();
		    }
		    else
		    {
		    	System.out.println("NO CARDS, Something went wrong...");
		    }
		}
		
		//MethodName:reviveGraveyard
		//Parameters:TBD
		//Return:None
		//Description: Grab Cards from Graveyard and shuffle back into deck
		public void reviveGraveyard(CardList playerDeck, CardList playerDiscard)
		{
			CardNode cur = head;
			
			while(cur != null)
			{
				playerDeck.addToDecks(cur.getACard());
				playerDiscard.removeCardFromDiscard(playerDeck);
				cur = cur.getLink();
			}
		}
		
		//MethodName: moveCardToHand()
		//Parameters: TBD
		//Return: NONE
		//Description: Grab cards from deck and move to players hand.
		public void moveCardToHand(CardList playerDeck, CardList playerHand, CardList playerDiscard, int cardDraw)
		{
			int count = 0; //how many cards has the player drawn?
		
			while(count < 5) //always draw 5.
			{
				CardNode cur = playerDeck.head;
				if (cur == null)
				{
					playerDiscard.reviveGraveyard(playerDeck, playerDiscard);
					cur = playerDeck.head;
				}
				
				CardNode newNode = new CardNode();
				
				newNode.setACard(cur.getACard());
				newNode.setLink(head);
				
				head = newNode;
				playerDeck.removeCardFromDeck(playerDiscard);
				cur = cur.getLink();
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
		public void cleanHand(CardList playerDeck, CardList playerHand, CardList playerDiscard)
		{
			for(int i = 0; i < 5; i++)
			{
				if (head != null)
				{
					head = head.getLink();
				}
			}
			moveCardToHand(playerDeck, playerHand, playerDiscard, 5);	
		}
		
		//MethodName: printHand
		//Parameters: None
		//Return: None
		//Description: Prints out current players hand.
		public void printHand()
		{
			CardNode cur = head;
		
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("CURRENT HAND:");
			System.out.println("----------------------------------------------------------------------------------------");
			while (cur != null)
			{
				
				System.out.println("Card Type: [" + cur.getACard().cardType + "] Card Name: [" + cur.getACard().cardName + "] Card Cost: [" + cur.getACard().cardCost + "]");
				System.out.println("");
				cur = cur.getLink();
			}
		}
		
		//methodName: calculateGold
		//Parameters: NONE
		//Return: goldAmount: amount of gold the current players cards totals to.
		//Description: Quick method to calculate current players gold amount in cards.
		public int calculateGold()
		{
			CardNode cur = head;
			int goldAmount = 0; //players current goldAmount
			
			while (cur != null)
			{
				
				if(cur.getACard().getCardType().equalsIgnoreCase("treasure"))
				{
					goldAmount = goldAmount + cur.getACard().getWorth(); 
				}
				cur = cur.getLink();
			}
			return goldAmount;
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
			int actionAmount = 0; //Total amount of actions in players hand.
			
			while (cur != null)
			{
				
				if(cur.getACard().getCardType().equalsIgnoreCase("action"))
				{
					actionAmount = actionAmount + cur.getACard().getAddBuy(); 
				}
				cur = cur.getLink();
			}
			return actionAmount;
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
}
