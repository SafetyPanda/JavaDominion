//James Gillman
//3/5/18
//Dominion 3
//Node for Link list.


public class CardNode 
{
	
	private CardNode link; //Link of the linklist
	private CardJRG aCard;

	public CardNode ()
	{
		aCard = null;
	}


	public CardNode(CardJRG aCard, CardNode link)
	{
		this.aCard = aCard;
		this.link = link;
	}

	
	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	public CardJRG getACard() 
	{
		return aCard;
	}


	public void setACard(CardJRG aCard) 
	{
		this.aCard = aCard;
	}


	public CardNode getLink()
	{
		return link;
	}


	public void setLink(CardNode link)
	{
		this.link = link;
	}
	
}
//PROBLEMS: SEE DOMINIONPART3JRG
