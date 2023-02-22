import java.util.Scanner;

class MUS
{  
	
	//   	Incomplete 
		
	static Node head ;
	MUS()
	{
		head = null ;
	}
	static class Node
	{
		int data ;
		Node next ;
		Node()
		{
			data = 0;
			next = null;
		}
		Node(int val)
		{
			data =val ;
			next = null;
		}
	}
		static void add(int data)
		{
			Node newNode = new Node(data);
			Node trav = head ;	
		/*	if(head == null)
			{
				head = newNode ;
			}*/
		//	else
		//	{
				//Node trav = head ;	
				while(trav.next != null)
				{
					trav = trav.next ;
				}
				trav.next = newNode ;
		//	}
		}
		static void display(Node head)
		{
			Node trav = head ;
			System.out.println("Linked List Elements are : ");
			while(trav != null)
			{
				System.out.print(trav.data+"  ");
				trav = trav.next ;
			}
			System.out.println();
		}
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
	
}

class MiddleUsingSingle
{
	
	public static void main(String args[])
	{
		MUS list = new MUS();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		int count =0 ;
		int middle = list.midUsingSinglePointer(list.head,count);
		list.display(MUS.head);
	}


}