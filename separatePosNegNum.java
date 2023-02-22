import java.util.Scanner;
/*
4. Move all negative numbers to beginning and positive to end with constant extra space. An array contains both positive and negative numbers in random order.    Rearrange the array elements so that all negative numbers appear before all positive numbers.
		Examples : 

		Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
		Output: -12 -13 -5 -7 -3 -6 11 6 5
*/		

class separatePosNegNum
{
	static Scanner sc = new Scanner(System.in);
	static void accept(int[] a , int size)
	{
		System.out.println("Enter array elements : ");	
		for(int i=0 ;i<size ; i++)
		{
			a[i] = sc.nextInt();
		}
		//System.out.println();
	}
	static void display(int[] a ,int size)
	{
		System.out.println("Enter array elements : ");	
		for(int i=0 ;i<size ; i++)
		{
			System.out.print(a[i]+"   ");	
		}
		//System.out.println();
	}
	static void separateNum(int[] a , int size)
	{
		int j=0 ;
		for(int i=0 ;i<size ; i++)
		{
			if(a[i]<0)
			{
				if(i != j)
				{
					int temp = a[i];
					a[i]     = a[j];
					a[j]   = temp ;
				}	
				j++ ;	
			}
			
		}			
		
	}
	public static void main(String args[])
	{
		System.out.println("Enter size of array : ");
		int size = sc.nextInt();
		int[] a  = new int[size];
		separatePosNegNum.accept( a ,  size);
		separateNum( a , size);
		display( a , size);
	}


}