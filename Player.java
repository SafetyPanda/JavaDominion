//James Gillman
//March 26th 2018
//Dominion Part 7
//Description: Holds all of the things that a player needs to grow and be strong

public class Player
{
	private int playerID; //Which player is it?
	private CardList playerDeck; // Current players deck.
	private CardList playerHand; // Current players hand.
	private CardList playerDiscard; //Current players discard pile.
	
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
		playerHand.moveCardToHand(playerDeck,playerHand,playerDiscard,5);		
	}

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
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
