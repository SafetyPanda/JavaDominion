
public class PlayerList 
{
	private PlayerNode head;
			
	public PlayerList()
	{
		head = null;
	}
			
	public PlayerNode insertAthead(Player aPlayer, PlayerNode head)
	{
		
		PlayerNode newptr = new PlayerNode(null,aPlayer);
		
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
