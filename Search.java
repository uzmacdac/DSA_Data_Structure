import java.util.Scanner;

class Search
{
	static Scanner sc = new Scanner(System.in);
	static int binarySearch(int[] arr , int left , int right , int key )
	{
		if(left > right)
			return -1 ;
		
		int index;
		int mid = (left + right) / 2; // mid index of array 
		if(key == arr[mid])
			return mid;
		
		if(key < arr[mid])
		{
			index = binarySearch(arr, left, mid-1, key);
			return index ;
		}
		else //(key > arr[mid])
		{
			index = binarySearch(arr, mid+1, right, key);
			return index;
		}
			
		
	}
	public static void main(String args[])
	{
		int arr[] = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170};
		System.out.println("Enter key : ");
		int key = sc.nextInt();
		int res = Search.binarySearch(arr , 0 ,arr.length-1 ,key);
		if(res == -1)
		{
			System.out.println("Key not found.");
		}
		else
		{
			System.out.println("Key found at position "+res+" .");
		}
	}

}