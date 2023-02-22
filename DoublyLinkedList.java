import java.util.Scanner;

class DoublyList
{
	Node head ;
	DoublyList()
	{
		head = null ;
	}
	class Node
	{
		int data ;
		Node next ;
		Node prev ;
		Node()
		{
			data = 0 ;
			next = null ;
			prev = null ;
		}
		Node(int val)
		{
			data = val ;
			next = null ;
			prev = null ;
		}
	}
	public void ForwardDisplay()
	{
		System.out.println("Forward Doubly Linked List : ");
		Node trav = head ;
		while(trav != null)
		{
			System.out.print(trav.data+"  ");
			trav = trav.next ;
		}
		System.out.println();
	}
	public void reverseDisplay()
	{
		System.out.println("Reverse display Doubly Linked List : ");
		if(head != null)
		{
			Node trav = head ;
			while(trav.next != null)
			{
				trav = trav.next ;
			}
			while(trav != null)
			{
				System.out.print(trav.data+"  ");
				trav = trav.prev ;
			}
		}
		System.out.println();
	}
	public void addFirst(int val)
	{
		// create new node 
		Node newNode = new Node(val);
		if(head == null)
		{
			head = newNode ;
			/*
			// if we don't write return statement and else part then it will work like recursive
			// means the node you first enter will print infinite time because these two link 
			// are point each other in below code 
						|
						^
			if(head == null)
			{
				head = newNode;
			}	
				newNode.next = head;
				head.prev = newNode ;
				head = newNode ;
			*/	
		}
		else
		{
			newNode.next = head ;
			head.prev = newNode ;
			head = newNode ;
		}
	}
	public void addLast(int val)
	{
		Node newNode = new Node(val);
		if(head == null)
		{
			head = newNode ; 	
		}
		else
		{
			Node trav = head ;
			while(trav.next != null)
			{
				trav = trav.next ;
			}
			trav.next = newNode ;
			newNode.prev = trav ;
		}
	}	
	 void addAtPosition(int data ,int index )                                                                                                                                
	 {
		Node newNode = new Node(data);
		if(head == null || index == 1)
		{
			addFirst( data);
		}
		else
		{
			Node trav = head ;
			for(int i=1 ; i<index-1 ; i++)
			{
				if(trav.next == null)
				{
					break ;
				}
				trav = trav.next ;	
			}
			Node temp = trav.next ;
			newNode.next = temp ;
			newNode.prev = trav ;
			trav.next = newNode ;
			if(temp != null)
				temp.prev = newNode ;
		}
	}
	public void delFirst()
	{
		if(head == null)
		{
			return ;
		}
		if(head.next == null )
		{
			head = null ;
		}
		else
		{
			head = head.next ;
			head.prev = null ;
		}				
	}
	public void delAtPosition(int index)
	{
		if(head == null || index == 1)
		{
			delFirst();
		}
		else
		{
			Node trav = head ;
			for(int i=0 ; i<index-1 ;i++)
			{
				if(trav == null)
				{
					break ;
				}
				trav = trav.next ;
			}
			trav.prev.next = trav.next ;
			if(trav.next != null)
				trav.next.prev = trav.prev ;
			
		}
	}	
	public void delLast()
	{
		Node trav = head ;
		while(trav.next != null)
		{
			trav = trav.next ;
		}
		trav.prev.next = null ;
	}
}
class DoublyLinkedList
{
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[])
	{
		DoublyList list = new DoublyList();
		int data ;
		int index ;
		int size=0 ;
		//System.out.println("Enter data to insert : ");
		//data = sc.nextInt();
		int choice;
		do
		{
			System.out.println("Enter choice :\n0) Exit\n1) Insert after node  (Add Node)\n2) Add At First\n3) Add At Position\n4) Add At Last");
			System.out.println("5) Remove First\n6) Remove At Position\n7) Remove last\n8) Forward Display\n9) Reverse Display ");
			System.out.println("  ");
			System.out.println("");
			choice = scan.nextInt();
			switch(choice)
			{
				case 0 :
					break ;
				case 1 :
						System.out.println("Enter data to insert : ");
						data = scan.nextInt();
						//list.addAfter(list.head , data);
						
					break ;
				case 2 :
						System.out.println("Enter data to insert : ");
						data = scan.nextInt();
						list.addFirst(data);
					break ;
				case 3 :
						System.out.println("Enter data to insert : ");
						data = scan.nextInt();
						System.out.println("Enter position of node to add  : ");
						index = scan.nextInt();
						list.addAtPosition(data, index);
					break ;
				case 4 :
						System.out.println("Enter data to insert : ");
						data = scan.nextInt();
						list.addLast(data);
					break ;
				case 5 :
						
						list.delFirst();
					break ;
				case 6 :
						/*System.out.println("Enter data to insert : ");
						data = scan.nextInt();*/
						System.out.println("Enter position of node to add  : ");
						index = scan.nextInt();
						list.delAtPosition( index );
					break ;
				case 7 :
						
						list.delLast();
					break ;	
				case 8 :
						list.ForwardDisplay();
					break ;
				case 9 :	
						list.reverseDisplay();
					break ;
			}
		}
		while(choice != 0);
	}
}