import java.util.Scanner;

class TowerOfHanoi
{

	static void toh(int n,char s,char inter, char d)
	{	
		if(n==1)
			System.out.println("Disk from"+s+"to "+d);
		else
		{
				toh(n-1,s,d,inter);
				System.out.println("Disk from"+s+"to "+d);
				toh(n-1,inter,s,d);
		}
		
	}
	
	public static void main(String args[])
	{	
		int n=34;
		toh(n,'A','B','C');
	
	
	}



}