package LinkList;

public class Node implements LinkList
{
	private int num; 
	private Node link;

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
