
public class PlayerNode 
{
	protected Player aPlayer;
	protected PlayerNode link;
	
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
    public Player getData()
    {
        return aPlayer;
    }
   
}
