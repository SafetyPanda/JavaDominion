

public class CardList implements Linkable
{
	private CardNode head;
	
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
		    System.out.println("SHUFFLING THAT DECK!");
		}
		
		
		public void addToDecks(CardJRG aSingularCard)
		{
			CardNode new_node = new CardNode();
			new_node.setACard(aSingularCard);
			new_node.setLink(head);
			head = new_node;	
		}
		
		//
		//
		//
		//
		public void removeCardFromDiscard(CardList playerDeck)
		{
			CardNode cur = head;
			if (head != null)
		    {
		    	playerDeck.addToDecks(cur.getACard());
				head = head.getLink();
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
			System.out.println("CREATING DECK FROM GRAVEYARD");
		}
		
		//MethodName: moveCardToHand()
		//Parameters: TBD
		//Return: NONE
		//Description: Grab cards from deck and move to players hand.
		public void moveCardToHand(CardList playerDeck, CardList playerHand, CardList playerDiscard, int cardDraw)
		{
			int count = 0;
			
			
			while(count < 5) //always draw 5.
			{
				CardNode cur = playerDeck.head;
				if (cur == null)
				{
					System.out.println("DECK IS EMPTY, GOING TO DISCARD AND ");
					playerDiscard.reviveGraveyard(playerDeck, playerDiscard);
					cur = playerDeck.head;
				}
				
				CardNode new_node = new CardNode();
				
				new_node.setACard(cur.getACard());
				new_node.setLink(head);
				
				head = new_node;
				playerDeck.removeCardFromDeck(playerDiscard);
				cur = cur.getLink();
				count++;
			}
			
		}
		

		public void findStartingCards(CardList playerDeck, PileJRG [] stacksOfCards)
		{
			String cardNeeded = "Copper";
			int cardAmount;			
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
		
		public void printLink()
		{
			CardNode cur = head;
			
			while (cur != null)
			{
				System.out.println(cur.getACard().cardName);
				cur = cur.getLink();
			}
		}

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
		
		public int calculateGold()
		{
			CardNode cur = head;
			int goldAmount = 0;
			
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


		
	
}
