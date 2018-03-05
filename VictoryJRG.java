// James Gillman
// 2/7/2018
// Dominion P2
// Holds all data on Victory type dominion cards.
public class VictoryJRG extends CardJRG
{

	private int victoryPoints; //How many victory points are we getting from our victory card?
	
	
	VictoryJRG()
	{
		super();
		victoryPoints = -1;	
	}

	VictoryJRG(String cardType, String cardName, int cardCost, int numberOfCards, int victoryPoints)
	{
		super(cardType,cardName,cardCost,numberOfCards);
		this.victoryPoints = victoryPoints;
	}

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	public int getVictoryPoints( ) //Overrides method stub in CardJRG
	{
		return victoryPoints;
	}

	public void setVictoryPoints( int victoryPoints )
	{
		this.victoryPoints = victoryPoints;
	}

	
}
