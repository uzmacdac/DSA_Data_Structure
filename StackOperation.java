import java.util.Scanner ;

class Stack
{
	int noOfElement ;
	int[] a ;
	int top ;
	Stack(int size)
	{
		a = new int[size] ;
		top = -1 ;
	}
	public void  push(int val)
	{
		noOfElement++ ;
		top++;
		a[top] = val ;
		
	}
	public void pop()
	{
		top--;
			
	}
	public int peek()
	{
		return a[top] ;
	}
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true ;
		}
		return false ;
		
	}
	public boolean isFull()
	{
		if(top == a.length-1)
		{
			return true ;
		}
		return false ;
	
	}
	public void display()
	{
		System.out.println("Stack element are : ");
		for(int i=0 ; i<a.length ; i++)
		{
			System.out.println(a[i]);
		}
	}
}
class StackOperation
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = sc.nextInt();
		Stack s = new Stack(size);
		int val=0;
		int data ;
		int choice ;
		do
		{
			System.out.println("Enter choice :\n0) Exit\n1) Push\n2) Pop\n3) peek\n4) Display\n5) Count the number of elements");
			System.out.println("6) To check Stack Full r not\n7) To check Stack Empty or not");
			choice = sc.nextInt();
			switch(choice)
			{
				case 0 :
						System.out.println("");
					break ;
				case 1 :
						if(s.isFull())
						{
							System.out.println("Stack is Overflow");
						}
						else
						{
							System.out.println("Enter elements : ");
							data = sc.nextInt();
							s.push(data);
						}	
					break ;
				case 2 :
						if(s.isEmpty())
						{
							System.out.println("Stack is underflow");
						}
						else
						{
							val = s.peek();
							s.pop();
							System.out.println("Element "+val+" is deleted from Stack. ");
						}	
					break ;
				case 3 :
						if(s.isEmpty())
						{
							System.out.println("Stack is Empty .So we can't peek cause there is no element.");
						}
						else
						{
							val =s.peek();
							System.out.println("Value peek : "+val);
						}
					break ;
				case 4 :
						s.display();
					break ;
				case 5 :
						System.out.println("Element present in Stack is : "+s.noOfElement);
					break ;
				case 6 :
						System.out.println("Stack is Full : "+s.isFull());
				
					break ;
				case  7 :
						System.out.println("Stack is Empty : "+s.isEmpty());
					break ;
			}				
		}
		while(choice != 0);
			
	}


}