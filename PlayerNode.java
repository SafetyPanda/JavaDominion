//James Gillman
//mar 28th 2018
//Dominion p7
//Description: Holds all the methods and things pertaining to a player node.

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
	
	
	//methodName: createPLayers
	//parameters:maxPlayers: how many players are playing? stacksOfCards: array of all cards in the game.
	//return: none
	//Description: create the players and assign them a deck, discard and hand in the process.
	public void createPlayers(int maxPlayers, PileJRG[] stacksOfCards)
	{
		
		int count = 1; //What player are we currently at?
		PlayerList listOfPlayers = new PlayerList(); //List of all players that will be in the game.
		Player firstPlayer = new Player(0,stacksOfCards); // the first player ever made.
		PlayerNode head = new PlayerNode(null, firstPlayer);
		
		while(count < maxPlayers)
		{
			Player meow = new Player(count, stacksOfCards); //new instantiation of a player
			head = listOfPlayers.insertAthead(meow, head);
			//listOfPlayers.printCircleList();
			count++;
			//meow.getPlayerDeck().shuffleDeck(maxPlayers);	
		}
		this.setLink(head);
		
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
