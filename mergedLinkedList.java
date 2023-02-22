import java.util.Scanner;

class mergedList
{
	Node head ;
	static class Node
	{
		
		String data ;
		Node next ;
		Node()
		{
			data = null ;
			next = null ;
		}
	}
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		if(head == null )
		{
			head = newNode ;
		}
		else
		{
			Node trav = head ;
			while(trav.next != null )
			{
				trav = trav.next ; 
			}
			trav.next = newNode ;
		}
	}
	public void display()
	{
		System.out.println("Linked List : ");
		while(trav != null )
		{
			System.out.print(trav.data+"  ");
			trav = trav.next ;
		}
	}
	public void mergeList()
	{
		
	}
}

class mergedLinkedList
{
	static Scnner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		mergedLinkedList l1 = new mergedLinkedList();
		mergedLinkedList l2 = new mergedLinkedList();
	}

}