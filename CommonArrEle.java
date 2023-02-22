import java.util.*;

class CommonArrEle
{
	static Scanner sc = new Scanner(System.in);
	static void accept(int[] x, int size)
	{
		System.out.println("Enter array element : ");
		for(int i=0 ; i<size ; i++)
		{
			x[i] = sc.nextInt();
			
		}
	}
	static void display(int[] x, int size)
	{
		System.out.println("Sorted Array element are : ");
		Arrays.sort(x);
		for(int i=0 ; i<size ; i++)
		{
			System.out.print(x[i]+"  ");
			
		}
		System.out.println();
	}
	static void commonElements(int[] a , int[] b , int[] c , boolean bvar)
	{
		int i=0 , j=0 , k=0;
		int al = a.length ;
		int bl = b.length ;
		int cl = c.length ;
		while(i<al && j<bl && k<cl)
		{
			if(a[i]==b[j] && b[j]==c[k] )
			{
				System.out.println("Common element is : "+a[i]);
			
				i++;
				j++;
				k++;
				bvar = true ;
			}
			else if(a[i]<a[j])
			{
				i++;
			}
			else if(a[j]<a[k])
			{
				j++;
			}
			else
			{
				k++;
			} 
			/*System.out.println("Common Elements : ");
			for(i=0 ; i<al ; i++ )
			{
				for( j=0 ; j<bl ; j++)
				{
					for( k=0 ; k<cl ; k++)
					{
						if(a[i]==b[j] && b[j]==c[k])
							System.out.print(a[i]+"  ");
					}
				}
			}*/
		}
	}
	public static void main(String args[])
	{
		boolean bvar = false ;
		System.out.println("Enter size for a[] :");
		int size = sc.nextInt();
		int[] a = new int[size];
		CommonArrEle.accept(a , size);
		System.out.println("Element of a[] :");
		
		CommonArrEle.display(a , size);
		System.out.println("---------------------------------------");
		
		//----------------------------------------
		System.out.println("Enter size for b[] :");
		size = sc.nextInt();
		int[] b = new int[size];
		CommonArrEle.accept(b , size);
		
		System.out.println("Element of b[] :");
		CommonArrEle.display(b , size);
		System.out.println("---------------------------------------");
		
		//----------------------------------------
		System.out.println("Enter size for c[] :");
		size = sc.nextInt();
		int[] c = new int[size];
		CommonArrEle.accept(c , size);
		System.out.println("Element of c[] :");
		
		CommonArrEle.display(c , size);
		System.out.println();
		System.out.println("---------------------------------------");
		if(bvar == true)
			CommonArrEle.commonElements(a , b ,c ,bvar);
		else
			System.out.println("No common element .");
		System.out.println("---------------------------------------");
	}
}