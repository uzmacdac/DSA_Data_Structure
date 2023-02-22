import java.util.Scanner;
class Recursion
{
	public int fact(int n)
	{
		if(n==1 || n==0)
		{
			return 1;
		}
		else
		{
			return n*fact(n-1);
		}	
	}
	public int fib(int n)
	{
		if(n<=1)
		{
			return n;
		}
		else
		{
			return fib(n-1)+fib(n-2);
		}	
	}
	public int power(int n1 , int index)
	{
		if(index <= 0)
		{
			return 1 ;
		}
		else
		{
			return n1*power(n1 , index-1);
		}
	}
	public int gcd(int n1 , int n2 , int rem)
	{
		int rem1 = n2%rem ;
		if(rem1 == 0)
			return rem ;
		else
			return gcd(n2 , rem , rem1);
	}
	public int printFib(int a,int b,int n)
	{
		if(n == 0)
		{
			return 0;
		}
		else
		{
			int c = a+b ;
			System.out.println(c);
			return printFib(b , c , n-1);
		}	
	}
	public int naturalNum(int n , int count)
	{
		// not optimized
		
		if(n<0)
			return 0 ;
		else 
		{
			//System.out.print(n+"  ");
			System.out.print(count+"  ");			
			return  naturalNum(n-1 ,++count);
		}	
	}
	public int sumOfNumSeries(int n)
	{
		if(n==0)
			return 0 ;
		else
		    return n + sumOfNumSeries(n-1);
	}
	public int optNaturalNumSeries(int n1 , int count)
	{
		if(count == n1)
		{
			return count ;
		}
		else
		{
			System.out.println(count);
			return optNaturalNumSeries(n1 , ++count);
		}
	}
	public int palindromeUsingRecursion(int n1 ,int revNum )
	{
		// Palindrome using recursion
		if(n1 == 0)
		{
			return revNum;
		}
		else
		{
			revNum =revNum*10 + (n1%10) ;
			return palindromeUsingRecursion(n1/10 ,revNum);
		}
	}
}
class RecursionMain
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		Recursion r = new Recursion();
		int choice ;
		int n1 , n2 ;
		
		do
		{
			System.out.println("Enter choice :\n0) Exit\n1) Factorial\n2) Fibonnaci series\n3) power\n4) GCD of two number   ");
			System.out.println("5) Print fibonacci series\n6) Natural number series\n7) Sum Of Number series\n8) Optimize Natural number series ");
			System.out.println("9) Recursive method to check Palindrome ");
			choice = sc.nextInt();
			switch(choice)
			{
				case 0 :
					break ;
				case 1 :
					System.out.println("Enter number : ");
		            n1 = sc.nextInt();
					System.out.println("Factorial of number "+n1+" is : "+r.fact(n1));
					break ;
				case 2 :
					System.out.println("Enter number : ");
					n1 = sc.nextInt();
					System.out.println("Fibonnaci at position "+n1+" is : "+r.fib(n1));
					break ;
				case 3 :
					System.out.println("Enter number : ");
					n1 = sc.nextInt();
					System.out.println("Enter index : ");
					int index = sc.nextInt();
					System.out.println("Power of number "+n1+" of index "+index+" is : "+r.power(n1,index));					
					break ;	
				case 4 :
					System.out.println("Enter number n1 : ");
					n1 = sc.nextInt();
					System.out.println("Enter number n2 : ");
					n2 = sc.nextInt();
					int rem ;
					if(n1 > n2)
					{
						rem = n1 % n2;
						
					}
					else
					{
						int temp = n1 ;
						n1 		 = n2 ;
						n2       = temp ;
						rem      = n1 % n2;
					}
					System.out.println("GCD of number "+n1+" and "+n2+" is : "+r.gcd(n1 , n2 , rem));	
					break ;
				case 5 :
					System.out.println("Enter number : ");
					n1 = sc.nextInt();
					System.out.println("Fibonacci series of "+n1+" : ");
					int a=0 , b=1 ;
					System.out.println(a);
					System.out.println(b);
					r.printFib(a,b,n1-1);
					break ;
				case 6 :
					System.out.println("Enter number : ");
					n1 = sc.nextInt();
					int count = 0 ;
					r.naturalNum(n1 , count);	
					System.out.println();
					break ;
				case 7 :
					System.out.println("Enter number : ");
					n1 = sc.nextInt();
					System.out.println("Sum Of "+n1+" of series : "+r.sumOfNumSeries(n1));
					break ;
				case 8 :
					System.out.println("Enter number : ");
					n1 = sc.nextInt();
					int count1 = 0 ;
					r.optNaturalNumSeries( n1 ,  count1);
					break ;
				case 9 :
					System.out.println("Enter number : ");
					n1 = sc.nextInt();
					int revNum =0 ;
					int result=r.palindromeUsingRecursion(n1 , revNum  );                                                                                                                                                                                                                                                                                                 );
					if(result == n1)
					{
						System.out.println("Number is Palindrome.");
					}		
					else
					{
						System.out.println("Number is not Palindrome.");
					}
			}
		}
		while(choice != 0);
	}
	
}