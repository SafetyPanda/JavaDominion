
public class Player
{
	private int playerID;
	private CardList playerDeck; //
	private CardList playerHand; // head to list
	private CardList playerDiscard;
	
	public Player()
	{
		//DEFAULT CONSTRUCTOR//
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
		playerDeck.printLink();
	}
	
	public void createPlayers(int maxPlayers, PileJRG[] stacksOfCards)
	{
		int count = 1; 
		PlayerList listOfPlayers = new PlayerList();
		
		while(count < maxPlayers + 1)
		{
			Player meow = new Player(count, stacksOfCards);
			System.out.println("Adding Node " + count + "at Start" );
			listOfPlayers.insertAtStart(meow);
			meow.playerDeck.printLink();
			count++;
		}
	}
	
}
