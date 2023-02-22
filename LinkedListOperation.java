import java.util.Scanner;
class LLOperation
{
	Scanner sc = new Scanner(System.in);
	Node head ;
	Node mid ;
	Node loopNode ;
	LLOperation()
	{
		head = null ;
	}
	// -----  class Node ------
	
	static class Node
	{
		int data ;
		Node next ;
		Node()
		{
			data = 0 ;
			next = null ;
		}
		Node(int val)
		{
			data = val ;
			next = null ;
		}
	}
	
	//-------------------------------------------
	public void addFirst(int val)
	{
		// generate new Node
		Node newNode = new Node(val);
		// assign head to newnode next to create link
		newNode.next = head ;
		head         = newNode ;
		
	}
	public void addAfter(Node prev,int new_data)
	{
		if(prev == null)
		{
			System.out.println("Insertion is not possible.");
		}
		else
		{
			// create a node 
			Node newNode = new Node(new_data);
			
			newNode.next = prev.next ;
			prev.next    = newNode ;
			
		}
	}
	public void addAtPosition(int new_data,int index)
	{
		// add at position is also called as append method
		Node newNode = new Node(new_data);
		if(head == null || index == 1)
		{
			addFirst(new_data);
		}
		else 
		{
			Node trav = head ;
			for(int i=1 ; i<index-1 ; i++)
			{
				if(trav.next == null)
				{
					break;
				}
				trav = trav.next ;
			}
			newNode.next =trav.next  ;
			trav.next = newNode  ;
			
		}	
	
		
		/*
		void insertIndex(int index, int new_data)
		{
			Node temp = head, prev = null;
			int k=0;
			Node new_node = new Node(new_data);
			if(index == 0)
			{
				new_node.next = head;
				head=new_node;
				return;
			}
			while(temp !=null && k != index)
			{
				prev = temp;
				temp = temp.next;
				k++;
			}
		}

	*/

		
			
	}
	public void addLast(int new_data)
	{
		Node newNode = new Node(new_data);
		if(head == null)
		{
			head = newNode ;
		}
		else
		{	
			Node trav  = head ;
			while(trav.next != null )
			{
				trav = trav.next ;
			}
			trav.next = newNode;
		}
	}
	public void removeFirst()
	{
		if(head == null)
		{
			return ;
		}
		else  // (head != null)
		{
			head = head.next ;
		}
	}
	public void removeAtPosition(int index )
	{
		if(head == null || index == 1)
		{
			removeFirst();
		}
		else
		{
			Node prev = null ;
			Node trav = head ;
			for(int i=1 ; i<index ; i++)
			{
				if(trav==null)
				{
					System.out.println("Node is null");
					return ;
				}
				prev = trav ;
				trav = trav.next;
			}
			prev.next = trav.next;
		}
		
		/*
			void delIndex(int index)
			{
				Node temp = head, prev = null;
				int k=0;
				while(temp !=null && k != index)
				{
					prev = temp;
					temp = temp.next;
					k++;
				}
				if(temp==null)
					return;
					prev.next = temp.next;
			}
		
		*/
		
		
	}
	// remove last element  from linked list 
	public void removeLast()
	{
		if(head == null)
			return ;
		if(head.next == null)
		{
			head = null ;
		}
		else
		{
			Node prev = null ;
			Node trav = head ;
			while(trav.next != null)
			{
				prev = trav ;
				trav = trav.next ;
			}
			prev.next = null ;
			
		}
	}
	public void search(int key , boolean b)
	{
		
		int index = 0;
		Node trav = head ;
		while(trav !=  null )
		{
			if(trav.data == key)
			{
				b = true ;
				break ;
			}	
			index++;
			trav = trav.next ;	
		}
		
		if(b == true)
		{
			System.out.println("Key present at "+index+" position.");
		}
		else
		{
			System.out.println("Key not found .");
		}
	}
	public void display() {
		System.out.print("Linked List : ");
		//we  start traversing from first node
		Node trav = head;
		// repeat for all nodes
		while(trav != null) {
			// print data of the node
				
			System.out.print(trav.data + " -> ");
			// go to the next node
			trav = trav.next;
		}
		System.out.println();
	}
	public int  nodeCount()
	{
		Node trav = head ;
		int count=0 ;
		while(trav != null)
		{
			count++ ;
			trav = trav.next ;
		}
		return count ;
	}
	public int  recNodeCount(Node trav)
	{
 		if(trav == null)
			return 0 ;
		else
			return 1+recNodeCount(trav.next);
		
	}
	static Node reverseList(Node head)
	{
		
		Node trav = head ;
		Node prev = null ;
		while(trav != null)
		{
			Node temp = trav.next ;  // store trav(current node) in temp node to maintain link
			trav.next = prev ;       // now we are assigning prev to trav's next 
			prev = trav ;
			trav = temp ;
		}
		
				
		return prev;
	}
	/*
			//Reverse linnked list Using recursive method
		public Node reverseListUsingRecursion(Node head)
		{
			Node trav = head ;
			if(head==null || head.next == null )
			{	
				return head ;
			}
			else
			{
				Node newHead = reverseListUsingRecursion(head.next);
				Node headNext = head.next ;
				head.next = null ;
				return newHead ;
			}
		
		}
	*/	
	public Node middleNode(Node head )
	{
		Node fast = head ;
		Node slow = head ;
		while(fast != null && fast.next != null)
		{
			
			slow = slow.next ;
			fast = fast.next.next ;
			
		}
		return slow ;
	
		
	}	
		/*
		static int midUsingSinglePointer(Node head , int count)
		{
			Node trav = head ;
			int max=0 ;
			if(head == null ||head.next == null)
			{
				max = count ;
				return 0;
			}
			int mid = midUsingSinglePointer(trav.next , count++);
			if(mid == max/2)
			{
				mid = trav.data ;
				
			}
			return mid ;
		}
		*/
	
	public boolean checkPlindrome(Node head)
	{
		if(head == null)
		{
			return true ;
		}
		Node midNode  = middleNode(head);
		Node lastNode = reverseList(midNode.next);
		Node cur = head ;
		while(lastNode != null)
		{
			if(lastNode.data != cur.data)
			{
				return false ;
			}
			lastNode = lastNode.next ;
			cur = cur.next ;
		}
		return true ;
	}	
	public Node detectLoop(Node head)
	{
		Node slow = head ;
		Node fast = head ;
		while(fast != null && fast.next != null )
		{
			slow = slow.next ;
			fast = fast.next.next ;
			/*if(slow == fast )
			{
				return slow ;
			}*/
		}
		if(slow == fast )
			{
				return slow ;
			}
		else
		{
			return null ;
		}
		//return null ;
	}
	public void reverseDisplay(Node head)
	{
		Node trav = head ;
		if(trav.next == null)
		{
			System.out.print(trav.data+" -> ");
		
		}
		else
		{
			reverseDisplay(trav.next);
			System.out.print(trav.data+" -> ");
		}
	}		

}
class LinkedListOperation
{
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[])
	{
		LLOperation list = new LLOperation();
		int data ;
		int index ;
		int size=0 ;
		//System.out.println("Enter data to insert : ");
		//data = sc.nextInt();
		int choice;
		do
		{
			System.out.println("Enter choice :\n0) Exit\n1) Insert after node  (Add Node)\n2) Add At First\n3) Add At Position\n4) Add At Last");
			System.out.println("5) Remove First\n6) Remove At Position\n7) Remove last ");
			System.out.println("8) Search\n9) display\n10) Node Count\n11) Reverse Linked List\n12) Middle of list\n13) check Palindrome  ");
			System.out.println("14) detect Loop in list\n15) Display Reverse List");
			choice = scan.nextInt();
			switch(choice)
			{
				case 0 :
					break ;
				case 1 :
						System.out.println("Enter data to insert : ");
						data = scan.nextInt();
						list.addAfter(list.head , data);
						
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
						
						list.removeFirst();
					break ;
				case 6 :
						/*System.out.println("Enter data to insert : ");
						data = scan.nextInt();*/
						System.out.println("Enter position of node to add  : ");
						index = scan.nextInt();
						list.removeAtPosition( index );
					break ;
				case 7 :
						/*System.out.println("Enter data to insert : ");
						data = scan.nextInt();*/
						list.removeLast();
					break ;	
				case 8 :
						System.out.println("Enter Key : ");
						int key = scan.nextInt();
						boolean b = false ;
						list.search(key , b);
					break ;		
				case 9 :
						list.display();
				    break ;
				case 10 :
						System.out.println("Number of node in list : "+list.nodeCount());
					break;
				case 11 :
						list.head = list.reverseList(list.head);
						list.display();
					break ;	
				case 12 :
						list.mid = list.middleNode(list.head );
						System.out.println("Middle Node of List : "+list.mid.data);
						//System.out.println("Size of Linked list "+size );
					break ;
				case 13 :
					boolean pb = list.checkPlindrome(list.head) ;
					if(pb == true)
						System.out.println("List is Palindrome .");
					else
						System.out.println("List in not Palindrome.");
					break ;
				case 14 :
						list.loopNode =list.detectLoop(list.head);
						if(list.loopNode == null )
							System.out.println("No Cycle (or loop) present .");
						else
							System.out.println("Cycle (or Loop) is present .");
						System.out.println();

					break ;
				case 15 :
						list.reverseDisplay(list.head);
						System.out.println();

			}
		}
		while(choice != 0);
		
		
	}
}