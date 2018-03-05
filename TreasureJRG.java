// James Gillman
// 2/7/2018
// Dominion P2
// Holds all extraneous data for treasure type dominion cards
public class TreasureJRG extends CardJRG

{
	private int worth; //How much is this card worth?
	
	TreasureJRG()
	{
		super();
		worth = -1;
	}
	
	TreasureJRG(String cardType, String cardName, int cardCost, int numberOfCards, int worth)
	{
		super(cardType,cardName,cardCost,numberOfCards);
		this.worth = worth;	
	}
	
	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	public int getWorth( )
	{
		return worth;
	}

	public void setWorth( int worth )
	{
		this.worth = worth;
	}
	
}

//Problems: On Dominion Part2 JRG