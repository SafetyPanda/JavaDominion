
public class PlayerList 
{
	protected PlayerNode start;
	protected PlayerNode end;
	public int size;
			
	public PlayerList()
	{
		start = null;
		end = null;
		size = 0;
	}
			
	public void insertAtStart(Player aPlayer)
	{
		PlayerNode newptr = new PlayerNode(null,aPlayer);
		newptr.setLink(start);
		if(start == null)
		{
			start = newptr;
			newptr.setLink(start);
			end = start;
		}
		else
		{
			end.setLink(newptr);
			start = newptr;
		}
			size++;
		}
			
	
}
