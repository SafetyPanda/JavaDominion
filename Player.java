
public class Player
{
	private int playerID;
	private CardList playerDeck;
	private CardList playerHand;
	private CardList playerDiscard;
	
	
	private PlayerNode tail;
	private PlayerNode head;
	private int size;
	
	public Player()
	{
		////////////////////////
	   ///default constructor//
	  ////////////////////////
	}
	
	public Player(int pNum, PileJRG[] stackOfCards)
	{
		String cardNeeded = "Copper";
		this.playerID = pNum;
		
		playerDeck  = new CardList();
		
		for( int i = 0; i < 2; i++)
		{
			playerDeck.findStartingCards(playerDeck, stackOfCards, cardNeeded);
			cardNeeded = "Estate";
		}
		
		playerHand  = new CardList();
		playerDiscard = new CardList();
		
		
		
		
	}

	//MethodName: createPlayers
	//Parameters: MaxPlayers: How many players are going to be playing?
	//Return: NONE
	//Description: Creates a circular link list to keep track of players and their decks, hand, pile
	public void createPlayers(int maxPlayers, PileJRG[] stacksOfCards)
	{
		int count = 1; 
		
		
		while(count < maxPlayers + 1)
		{
			Player meow = new Player(count, stacksOfCards);
			PlayerNode temp;
			System.out.println("Adding Node " + size + "at Start" );
			PlayerNode n = new PlayerNode(meow);
			if(size == 0)
			{
				head = n;
				tail = n;
				n.setNext(head);
			}
			else
			{
				temp = head;
				n.setNext(temp);
				head = n;
				tail.setNext(head);
			}
			size ++;
			count++;
			meow.playerDeck.printLink();
		}
	}
	
	//MethodName: printPlayerList
	//Parameters: NONE
	//Return: NONE
	//Description: 
	public void printPlayerList()
	 {
	        System.out.print("Circular Linked List:");
	        PlayerNode temp = head;
	        if(size<=0)
	        {
	            System.out.print("List is empty");
	        }
	        else
	        {
	            do 
	            {
	                System.out.print(" " + temp.getaPlayer());
	                temp = temp.getNext();
	            }while(temp!=head);
	        }
	        System.out.println();
	    }
}
