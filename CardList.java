
public class CardList implements Linkable
{
	private Node head;
	
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
		public void createDecks()
		{
			
			
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
		
		//MethodName: addToHead
		//Parameters: TBD
		//Return:None
		//Description: add Node to head..
		public void addToDeck(CardJRG aSingularCard)
		{
			Node newNode;
			Node prev;
			Node cur;
			
			newNode = new Node();
			
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


		public void printLink()
		{
			Node cur = head;
			
			while (cur != null)
			{
				System.out.println(cur.getACard().cardName + " ");
				cur = cur.getLink();
			}
		}
	
}
