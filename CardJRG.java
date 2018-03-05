// James Gillman
// 2/7/2018
// Dominion P2
// Superclass that holds everything that is needed by a card(shared by all subclasses)
public abstract class CardJRG 
{
	protected String cardType; //Type of card being read in
	protected String cardName; //Name of a dominion card
	protected int cardCost; //How much does this card cost to buy?
	protected int numberOfCards; //How many cards are of a certain type?
	//protected String special; //Special moves. Used for extra credit down the line.
	
	
	CardJRG()
	{
		cardType = "NOTHING HERE BOY";
		cardName = "cardName";
		cardCost = -1;
		numberOfCards = -1;
	
	}
	
	public CardJRG(String cardType, String cardName, int cardCost, int numberOfCards)
	{
		this.cardType = cardType;
		this.cardName = cardName;
		this.cardCost = cardCost;
		this.numberOfCards = numberOfCards;
	}

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////

	
	public String getCardType( )
	{
		return cardType;
	}

	public String getCardName( )
	{
		return cardName;
	}

	public int getCardCost( )
	{
		return cardCost;
	}
	
	public int getNumberOfCards()
	{
		return numberOfCards;
	}


	public void setCardType( String cardType )
	{
		this.cardType = cardType;
	}

	public void setCardName( String cardName )
	{
		this.cardName = cardName;
	}

	public void setCardCost( int cardCost )
	{
		this.cardCost = cardCost;
	}
	
	public void setNumberOfCards(int numberOfCards)
	{
		this.numberOfCards = numberOfCards;
	}

	////////////////////////////////////////////////
	//  VERY IMPORTANT             VERY IMPORTANT //
	////////////////////////////////////////////////
	//  METHOD STUBS TO MAKE victoryPoints WORK!  //
	////////////////////////////////////////////////
	//  VERY IMPORTANT             VERY IMPORTANT //
	////////////////////////////////////////////////

	public int getVictoryPoints( )
	{
		return 0;
	}

	public void setVictoryPoints( int victoryPoints )
	{
		//this.victoryPoints = victoryPoints;
	}

}

//PROBLEMS: ON DOMINIONPART2JRG