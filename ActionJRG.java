// James Gillman
// 3/5/2018
// Dominion P3
// Holds all of the info for Action cards!
public class ActionJRG extends CardJRG
{
	private int addCards; //Action move to add a card
	private int addAction; // Lets you add an action to your turn.
	private int addBuy; //Action move to buy things.
	private int victoryPoints; //The amount of victory points the card gives.
	private int worth;//How much does it cost to buy the card?
	
	
	
	ActionJRG()
	{
		super();
		addCards = -1;
		addAction = -1;
		addBuy = -1;
		victoryPoints = -1;
	}
	
	ActionJRG(String cardType, String cardName, int cardCost, int worth, int addCards, int addAction, int addBuy, int victoryPoints)
	{
		super(cardType,cardName,cardCost);
		this.addCards = addCards;
		this.addAction = addAction;
		this.addBuy = addBuy;
		this.victoryPoints = victoryPoints;
		this.worth = worth;
		
	}
	
	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	public int getAddCards( )
	{
		return addCards;
	}

	public int getAddAction( )
	{
		return addAction;
	}

	public int getAddBuy( )
	{
		return addBuy;
	}

	public int getVictoryPoints( )
	{
		return victoryPoints;
	}
	
	public int getWorth()
	{
		return worth;
	}

	public void setAddCards( int addCards )
	{
		this.addCards = addCards;
	}

	public void setAddAction( int addAction )
	{
		this.addAction = addAction;
	}

	public void setAddBuy( int addBuy )
	{
		this.addBuy = addBuy;
	}

	public void setVictoryPoints( int victoryPoints )
	{
		this.victoryPoints = victoryPoints;
	}
	
	public void setWorth ( int worth)
	{
		this.worth = worth;
	}
	

	
	
	
	
}
