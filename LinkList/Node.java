//James Gillman
//3/5/18
//Dominion 3
//Node for Link list.

package LinkList;
public class Node implements LinkList
{
	private int num; //Number in link.
	private Node link; //Link of the linklist

	public Node ()
	{
		num = -1;
		link = null; 
	}


	public Node(int num, Node link)
	{
		this.num = num;
		this.link = link;
	}

	
	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	public int getNum()
	{
		return num;
	}


	public void setNum(int num)
	{
		this.num = num;
	}

	public Node getLink()
	{
		return link;
	}


	public void setLink(Node link)
	{
		this.link = link;
	}


	public String toString()
	{
		return "Node [num=" + num + ", link=" + link + "]";
	}
	
}
//PROBLEMS: SEE DOMINIONPART3JRG
