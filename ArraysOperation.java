import java.util.*;

class ArraysOperation
{
	static Scanner sc = new Scanner(System.in);
	static void add(int[] a, int size)
	{
		
		if( size == 0)
		{
			System.out.println("Array is Empty .");
			
		}
		else
		{
			System.out.println("Enter Array "+size+" Element : ");
			for(int i=0 ; i<size ; i++)
			{
				a[i] = sc.nextInt();
			}
		}
		
			
	}
	static int search(int[] a , int size , int key )
	{
		int i;
		if( size == 0)
		{
			System.out.println("Array is Empty .");
			return 1;
		}	
		else
		{
			for( i=0 ; i<size ; i++)
			{
				if(a[i] == key)
					break;
				
			}
			return i ;
		}	
	}
	static void remove(int[] a , int size, int index)
	{
    
		for(int j=index ; j<size-1 ; j++ )
		{
			a[j] = a[j+1] ;		
		}
		size--;
		for(int x : a)
		{	
			a[size] = 0 ;
			System.out.println(x+"  ");
		}

	}
	static void display(int[]a)
	{
		for(int x : a)
		{
			System.out.println(x+"  ");
		}
	}
	public static void main(String args[])
	{
		System.out.println("Enter size : ");
		int size = sc.nextInt();
		int[] a = new int[size];
		
		int choice ;
		do
		{
			System.out.println("Enter choice :\n0) Exit\n1) Insert Element\n2) Search Element\n3) Remove Element\n4) Display Array Element");
			choice = sc.nextInt();
			switch(choice)
			{
				case 0 :
					break;
				case 1 :
					ArraysOperation.add(a ,size);
					System.out.println("Array elements are : ");
					ArraysOperation.display(a);
					break;
				case 2 :
					System.out.println("Enter key :");
					int key = sc.nextInt();
				
					int index = ArraysOperation.search(a,size,key);
					if(index == size)
					{
						System.out.println("Element "+key+" not found .");
					}
					else
					{
						System.out.println("Element "+key+" found at position "+index+" .");
					}
					
					break;
				case 3 :
					System.out.println("Enter key :");
					key = sc.nextInt();
					index = ArraysOperation.search(a,size,key);
					if(index == size)
					{
						System.out.println("Element "+key+" not found .");
					}
					else
					{
						System.out.println("Element "+key+" found at position "+index+" .");
					
						ArraysOperation.remove(a,size,index);
						//System.out.println("After removing element array elements are :");
						//ArraysOperation.display(a);
						break;
					}
				case 4 :
					ArraysOperation.display(a);
					break;					
				
			}
		}
		while(choice != 0);
	}

}                                                             