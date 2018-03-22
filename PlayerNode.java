
public class PlayerNode 
{
	private Player aPlayer;
	private PlayerNode link;
	
	public PlayerNode()
	{
		link = null;
		aPlayer = null;
	}
	
	public PlayerNode(PlayerNode node, Player onePlayer)
	{
		link = node;
		aPlayer = onePlayer;
	}
	
	
	
	public void createPlayers(int maxPlayers, PileJRG[] stacksOfCards)
	{
		
		int count = 1; 
		PlayerList listOfPlayers = new PlayerList();
		Player temp = new Player(0,stacksOfCards);
		//temp.setPlayerID(0);
		PlayerNode head = new PlayerNode(null, temp);
		
		while(count < maxPlayers)
		{
			Player meow = new Player(count, stacksOfCards);
			System.out.println("Adding Node " + count + " at Start" );
			head = listOfPlayers.insertAthead(meow, head);
			//listOfPlayers.printCircleList();
			count++;
			//meow.getPlayerDeck().shuffleDeck(maxPlayers);
			
		}
		this.setLink(head);
		
	}
	
	public PlayerNode nextPlayer(PlayerNode previous)
	{
		PlayerNode cur = new PlayerNode();
		cur = previous;
		cur.getLink().getLink();
		return cur;
	}
	
	
	////////////////////////
	// GETTERS AND SETTERS//
	////////////////////////
	public void setLink(PlayerNode link)
    {
       this.link = link;
    }    
    /*  Function to set data to current Node  */
    public void setaPlayer(Player aPlayer)
    {
        this.aPlayer = aPlayer;
    }    
    /*  Function to get link to next node  */
    public PlayerNode getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public Player getaPlayer()
    {
    	return aPlayer;
    }
    
   
}
