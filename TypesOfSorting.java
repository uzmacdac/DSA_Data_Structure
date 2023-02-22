import java.util.*;

class Sorting
{
	public void display(int[] a , int size)
	{
		System.out.println("Array elements are : ");
		for(int i=0 ; i<size ; i++)
		{
			System.out.println(a[i]+"  "); 
		}
	}
	public int LinearSearch(int[] a ,int size , int key , int index)
	{
		
		for(int i=0 ; i<size ; i++)
		{
			index++ ;
			if(a[i] == key)
			{
				return 1 ;
			}
			
		}
		return -1 ;
	}
	public int binarySearch(int[] a , int key , int left , int right)
	{

		if(left <= right)
		{
				int mid = left +(right-left)/2 ;
			
			if(key == a[mid])
				return mid ;
			
			if(key < a[mid])
				binarySearch(a , key , left , mid-1);
			else
				binarySearch(a , key , mid+1 , right);
		}	
		return -1 ;
	}
	public void  bubbleSort(int[] a , int size)
	{
		for(int i=0 ;i<size-1 ; i++)
		{
			for(int j=0 ; j<size-i-1 ; j++)
			{
				if(a[j] > a[j+1])
				{
					int temp = a[j] ;
					a[j]     = a[j+1] ;
					a[j+1]   = temp ;
				}
			}
		}
		
	}
	public void selectionSort(int[] a , int size)
	{
		// One by one move boundary of unsorted subarray
        for (int i = 0; i < size-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < size; j++)
                if (a[j] < a[min])
                    min = j;
  
            // Swap the found minimum element with the first
            // element
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
		/*
			for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		*/
	}
	public void insertionSort(int[] a , int key , int left , int right)
	{
		  int n = a.length;
        for (int i = 1; i < n; ++i) {
             key = a[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
	}
	public static void insertionSrt(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j, temp = arr[i];
			for(j = i-1; j >= 0 && arr[j] > temp; j--) {
				arr[j+1] = arr[j]; 
			}
			arr[j+1] = temp;
		}
	}
	public int mergeSort()
	{
		 // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
		{
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
	void msort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            msort(a, l, m);
            msort(a, m + 1, r);
  
            // Merge the sorted halves
            mergeSort(a, l, m, r);
        }
    }
	
}

class TypesOfSorting
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = sc.nextInt();
		int[] a = new int[size] ;
	/*	for(int i=0 ; i<size ; i++)
		{
			a[i] = sc.nextInt();
		}*/
		Sorting s = new Sorting();
		int choice ; 
		do
		{
			System.out.println("Enter choice :\n0) Exit\n1) Linear search\n2) Binary Search\n3) Bubble Sort\n4) Selection Sort");
			System.out.println("5) Insertion Sort\n6) Merge Sort\n7) Quick Sort\n8) Display");
			choice = sc.nextInt();
			switch(choice)
			{
				case 0 :
				
					break ;
				case 1 :
						int index = 0 ;
						System.out.println("Enter key to find : ");
						int key = sc.nextInt();
						int i = s.linearSearch(a,size,key, index);
						if(i == 1)
							System.out.println("Key "+key+" is found at position "+index+" .");
						else
							System.out.println("Key is not found.");
							
					break ;
				case 2 :
						int index = 0;
						System.out.println("Enter key to find : ");
						int key = sc.nextInt();
						int left = 0 ;
						int right = size-1 ;
						int i = s.binarySearch(a,key,left ,right );
						if(i == -1)
							System.out.println("Key is not found.");
						else
							System.out.println("Key "+key+" is found at position "+i+" .");
					break ;
				case 3 :
						s.bubbleSort(a , size);
						s.display(a,size);
						
					break ;
				case 4 :
						s.selectionSort(a , size);
						s.display(a,size);
					break ;
				case 5 :
					break ;
				case 6 :
					break ;
				case 7 :
					break ;
				case 8 :
						s.display(a , size);
					break ;	
					
			}
		}
		while(choice != 0 );
	}	
}