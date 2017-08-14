import java.util.*;
import java.io.*;
import java.lang.*;

class Prime2D
{
	public static void main(String args[])
	{
		findPrime();
	}

	static void findPrime()
	{
		int arr[]=new int[1000];
		int num=0;
		int flag;
		for(int i=2;i<1000;i++)
		{	
			flag=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				arr[num]=i;
				//System.out.println(arr[num]);
				num++;

				//count++;
			}
		}
		print2D(arr,num);
	}

	static void print2D(int arr[],int num)
	{
		int a[][]=new int[100][10];
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<10;j++)
			{	
				a[i][j]=arr[i];
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
			// System.out.print(i+ "-" + " " +(i*100) + "\t");
		}
	}
}