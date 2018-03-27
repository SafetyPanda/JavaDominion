//James Gillman
// mar 26 2018 
// Dominion P7
// description: Holds all of the things and methods needed to deal with a linklist of players

public class PlayerList 
{
	private PlayerNode head;
			
	public PlayerList()
	{
		head = null;
	}
	
	//MethodName: insertAtHead
	//Parameters: Adds a player to the circular link list.
	//Return: playerNode
	//Description: Inserts a new player at the front of the circular linked list.
	public PlayerNode insertAthead(Player aPlayer, PlayerNode head)
	{
		PlayerNode newptr = new PlayerNode(null,aPlayer); //newptr to be used for the new node to be added!
		
		if(head.getLink() == null)
		{
			head.setLink(newptr); //sets newptr to link to head
			newptr.setLink(head);
			newptr.setaPlayer(aPlayer);			
		}
		
		else
		{
			newptr.setLink(head.getLink());
			head.setLink(newptr);
			newptr.setaPlayer(aPlayer);
		}			
		return head; //if head can change you want to return it
	}
	
}
