// James Gillman
// 3/5/2018
// Dominion P3
// Holds all data on Victory type dominion cards.
public class VictoryJRG extends CardJRG
{

	private int victoryPoints; //How many victory points are we getting from our victory card?
	
	
	VictoryJRG()
	{
		super();
		victoryPoints = -1;	
	}

	VictoryJRG(String cardType, String cardName, int cardCost, int victoryPoints)
	{
		super(cardType,cardName,cardCost);
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
