//James Gillman
//3/5/18
//Dominion 3
//Node for Link list.


public class Node 
{
	
	private Node link; //Link of the linklist
	private CardJRG aCard;

	public Node ()
	{
		aCard = null;
	}


	public Node(CardJRG aCard, Node link)
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


	public Node getLink()
	{
		return link;
	}


	public void setLink(Node link)
	{
		this.link = link;
	}
	
}
//PROBLEMS: SEE DOMINIONPART3JRG
