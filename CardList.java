

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
			CardNode cur = head;
			int listIndex = 1;
			
			while (cur != null)
			{
				listIndex++;
				cur = cur.getLink();
			}
			
	
		
		}
		
		
		public void addToDecks(CardJRG aSingularCard)
		{
			CardNode new_node = new CardNode();
			new_node.setACard(aSingularCard);
			new_node.setLink(head);
			head = new_node;			
			
		}
		
		//MethodName: removeCard
		//Parameters: TBD
		//Return: NONE
		//Description: Remove card from Players Hand
		public void removeCard(CardList playerDiscard)
		{
			CardNode cur = playerDiscard.head;
			if (head != null)
		    {
		    	
		    	CardJRG aSingularCard = cur.getACard();
				CardNode new_node = new CardNode();
			
				new_node.setACard(aSingularCard);
				new_node.setLink(head);
			
				head = new_node;
		    	head = head.getLink();
		    }
		    else
		    {
		    	System.out.println("NO CARDS, Something went wrong...");
		    	System.exit(0);
		    }
		}
		
		//MethodName:reviveGraveyard
		//Parameters:TBD
		//Return:None
		//Description: Grab Cards from Graveyard and shuffle back into deck
		public void reviveGraveyard(CardList playerDeck, CardList playerDiscard)
		{
			
			CardNode cur = playerDiscard.head;
			while (cur != null)
			{									
				CardJRG aSingularCard = cur.getACard();
				CardNode new_node = new CardNode();
			
				new_node.setACard(aSingularCard);
				new_node.setLink(head);
			
				head = new_node;
				playerDiscard.removeCard(playerDiscard);
				cur = cur.getLink();
			}
				
			
		}
		
		//MethodName: moveCardToHand()
		//Parameters: TBD
		//Return: NONE
		//Description: Grab cards from deck and move to players hand.
		public void moveCardToHand(CardList playerDeck, CardList playerHand, CardList playerDiscard, int cardDraw)
		{
			int count = 0;
			
			
			while(count < cardDraw)
			{
				CardNode cur = playerDeck.head;
				if (cur == null)
				{
					reviveGraveyard(playerDeck, playerDiscard);
					cur = playerDeck.head;
				}
				CardJRG aSingularCard = cur.getACard();
				CardNode new_node = new CardNode();
				
				new_node.setACard(aSingularCard);
				new_node.setLink(head);
				
				head = new_node;
				playerDeck.removeCard(playerDiscard);
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
				
				cur = cur.getLink();
			}
		}

		public void printHand()
		{
			CardNode cur = head;
			System.out.println("CURRENT HAND:");
			System.out.println("-------------------------------------------------------------------------------------");
			while (cur != null)
			{
				
				System.out.println("Card Type: [" + cur.getACard().cardType + "] Card Name: [" + cur.getACard().cardName + "] Card Cost: [" + cur.getACard().cardCost + "]");
				System.out.println("");
				cur = cur.getLink();
			}
		}


		
	
}
