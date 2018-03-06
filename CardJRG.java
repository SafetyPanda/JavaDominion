// James Gillman
// 2/7/2018
// Dominion P3
// Superclass that holds everything that is needed by a card(shared by all subclasses)
public abstract class CardJRG 
{
	protected String cardType; //Type of card being read in
	protected String cardName; //Name of a dominion card
	protected int cardCost; //How much does this card cost to buy?
	//protected String special; //Special moves. Used for extra credit down the line.
	
	
	CardJRG()
	{
		cardType = "NOTHING HERE BOY";
		cardName = "cardName";
		cardCost = -1;
	
	}
	
	public CardJRG(String cardType, String cardName, int cardCost)
	{
		this.cardType = cardType;
		this.cardName = cardName;
		this.cardCost = cardCost;
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

	////////////////////////////////////////////////
	//  VERY IMPORTANT             VERY IMPORTANT //
	////////////////////////////////////////////////
	//  METHOD STUBS TO MAKE victoryPoints WORK!  //
	//	METHOD STUBS TO MAKE actionCards WORK!    //
	////////////////////////////////////////////////
	//  VERY IMPORTANT             VERY IMPORTANT //
	////////////////////////////////////////////////

	public int getAddCards( )
	{
		return 0;
	}

	public int getAddAction( )
	{
		return 0;
	}

	public int getAddBuy( )
	{
		return 0;
	}

	public int getVictoryPoints( )
	{
		return 0;
	}
	
	public int getWorth()
	{
		return 0;
	}

	public void setAddCards( int addCards )
	{
	
	}

	public void setAddAction( int addAction )
	{
		
	}

	public void setAddBuy( int addBuy )
	{
		
	}

	public void setVictoryPoints( int victoryPoints )
	{

	}
	
	public void setWorth ( int worth)
	{
		
	}

	
}

//PROBLEMS: ON DOMINIONPART2JRG