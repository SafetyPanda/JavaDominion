
public class CardList implements Linkable
{
	private Node head;
	
	public CardList()
	{
		
	}
	
	public CardList(CardJRG aCard, Node link)
	{
		head = new Node(aCard, link);
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
			System.out.println("IN HERE");
			
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
		public Node addToHead(CardJRG aCard)
		{
			Node current = head;
			Node card = new Node(aCard, current);
			
			while(current.getLink() != null)
			{
				curren
			}
			
			return head;
			
			
			
		}
	
	
	
}
