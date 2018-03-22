import java.util.Collections;

public class Player
{
	private int playerID;
	private CardList playerDeck; //
	private CardList playerHand; // head to list
	private CardList playerDiscard;
	
	public Player()
	{
		playerDeck = null;
		playerHand = null;
		playerDiscard = null;
	}
	
	public Player(int pNum, PileJRG[] stackOfCards)
	{
		playerDiscard = new CardList();
		playerDeck  = new CardList();
		playerHand  = new CardList();
		
		this.playerID = pNum;
		
		playerDeck.findStartingCards(playerDeck, stackOfCards);
		playerDeck.shuffleDeck();
		
		playerHand.moveCardToHand(playerDeck,playerHand,playerDiscard, 4);
		System.out.println("PRINTING HAND");
		playerHand.printLink();
		
		
	}

	//
	// GETTERS AND SETTERS //
	//					   //
	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public CardList getPlayerDeck() {
		return playerDeck;
	}

	public void setPlayerDeck(CardList playerDeck) {
		this.playerDeck = playerDeck;
	}

	public CardList getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(CardList playerHand) {
		this.playerHand = playerHand;
	}

	public CardList getPlayerDiscard() {
		return playerDiscard;
	}

	public void setPlayerDiscard(CardList playerDiscard) {
		this.playerDiscard = playerDiscard;
	}
	
	
}
