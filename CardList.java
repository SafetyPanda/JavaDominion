
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
			
		}
		
		public void addToDecks(CardJRG aSingularCard)
		{
						
			CardNode newNode;
			CardNode prev;
			CardNode cur;
			
			newNode = new CardNode();
			
			newNode.setACard(aSingularCard);
			newNode.setLink(head);
			head = newNode;
			
			prev = head;
			cur = head;
			while(cur != null)
			{
				prev = cur;
				cur = cur.getLink();
			}
			
			prev.setLink(newNode);
			newNode.setLink(cur);	
		}
		
		//MethodName: removeCard
		//Parameters: TBD
		//Return: NONE
		//Description: Remove card from Players Hand
		public void removeCard()
		{
			
		}
		
		//MethodName:reviveGraveyard
		//Parameters:TBD
		//Return:None
		//Description: Grab Cards from Graveyard and shuffle back into deck
		public void reviveGraveyard()
		{
			
		}
		
		//MethodName: moveCardToHand()
		//Parameters: TBD
		//Return: NONE
		//Description: Grab card from deck and move to players hand.
		public void moveCardToHand()
		{
			
		}
		

		public void findStartingCards(CardList playerDeck, PileJRG [] stacksOfCards, String cardNeeded)
		{
			int cardAmount;
			String cardName;
			
			
			for ( int i = 0; i < 20; i++)
			{
				cardName = stacksOfCards[i].getaSingularCard().getCardName();
				if (cardName.equalsIgnoreCase(cardNeeded))
				{
					if(stacksOfCards[i].getaSingularCard().getCardName().equalsIgnoreCase("Copper"))
					{
						cardAmount = stacksOfCards[i].getCardAmount();
						for (int x = 0; x < 7; x++) 
						{
							playerDeck.addToDecks(stacksOfCards[i].getaSingularCard());
							stacksOfCards[i].setCardAmount(cardAmount - 1);	
						}
					}
					else if (cardName.equalsIgnoreCase(cardNeeded))
					{
						cardAmount = stacksOfCards[i].getCardAmount();
						for (int y = 0; y < 7; y++) 
						{
							playerDeck.addToDecks(stacksOfCards[i].getaSingularCard());
							stacksOfCards[i].setCardAmount(cardAmount - 1);
						}	
					}		
				}
			}
		}
		
		public void printLink()
		{
			CardNode cur = head;
			
			while (cur != null)
			{
				System.out.println(cur.getACard().cardName + " " + cur.getACard().cardCost + " " + cur.getACard().cardType);
				cur = cur.getLink();
			}
		}


		
	
}
