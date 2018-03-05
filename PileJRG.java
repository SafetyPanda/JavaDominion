// James Gillman
// 2/7/2018
// Dominion P2
// Holds all of the info for the pile of cards!
public class PileJRG
{

	private CardJRG aSingularCard;
	private int cardAmount;
	
	
	public PileJRG()
	{
		aSingularCard = null; //A single card from the deck.
		cardAmount = -1; //How many cards are left?
	}

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	public CardJRG getaSingularCard( )
	{
		return aSingularCard;
	}


	public int getCardAmount( )
	{
		return cardAmount;
	}


	public void setaSingularCard( CardJRG aSingularCard )
	{
		this.aSingularCard = aSingularCard;
	}


	public void setCardAmount( int cardAmount )
	{
		this.cardAmount = cardAmount;
	}
	
	
}

//PROBLEMS: PROBLEMS ARE ON DOMINION PART2JRG