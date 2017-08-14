import java.util.*;


class Array1
{
	public static void main(String args[])
	{
	Prime1 p=new Prime1();
	Scanner sc=new Scanner(System.in);	
	
	p.prime();
	p.print();	
		
	}
}




class Prime1
	{
	
	int[][] brr=new int[100][100];
	int[] arr=new int[1000];
	int k=0,l=0,m=0,i,dd;
	
	void prime()
	{
			
		for(i=1;i<1000;i++)
		{
			int d=0;

			if(i==0 || i==1)
			{
				d=1;
			}
			
			for(int j=2;j<i;j++)
			{
				if(i%j==0 || i==0 || i==1)
				{
					d=1;
					break;			
				}
			}
			
			if(d==0)
			{
				arr[m]=i;
				m++;
				
			}
			
			
		int z=0;
		for(l=0;l<10;l++)
		{
			
				
			for(k=0;k<25;k++)
			{
				if(arr[z]==check(200,300) || arr[z]==check(300,400) || arr[z]==check(400,500) || arr[z]==check(500,600) || 		arr[z]==check(600,700) || arr[z]==check(700,800) || arr[z]==check(800,900) || arr[z]==check(900,1000) )
				
				{
					k=0;l++;
				}
			
				brr[k][l]=arr[z];
				z++;
				
			
			}
		}

			
		
		
		}
		
		
		
	}
	int check(int a,int b)
	{
		for(int i=a;i<b;i++)
		{
			int d=0;
			if(i==0 || i==1)
			{
				d=1;
			}
			
			for(int j=2;j<i;j++)
			{
				if(i%j==0 || i==0 || i==1)
				{
					d=1;
					break;			
				}
			}
			
			if(d==0)
			{
			
				dd=i;
				break;
				
			}
		
		}
		return dd;
	}
	
	
	void print()
	{
		int z=0;
		for(k=0;k<25;k++)
		
		{
			
				
			for(l=0;l<10;l++)
			{
			
				if(brr[k][l]==0)
				{
				break;
				}
				System.out.print("   "+brr[k][l]);
			
			}
			System.out.println();
		}
	}
}



