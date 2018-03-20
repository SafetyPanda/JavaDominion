
public class PlayerNode 
{
	private PlayerNode next; //Link of the linklist
	private Player aPlayer;

	public PlayerNode (Player onePlayer)
	{
		aPlayer = onePlayer;
	}
	
	
	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	
	public PlayerNode getNext() {
		return next;
	}

	public void setNext(PlayerNode next) {
		this.next = next;
	}

	public Player getaPlayer() {
		return aPlayer;
	}

	public void setaPlayer(Player aPlayer) {
		this.aPlayer = aPlayer;
	}
}
