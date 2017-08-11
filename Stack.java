import java.util.*;
import java.io.*;
import java.lang.*;

class BP
{
	public static void main(String args[])
	{	
		//Stack s=new Stack();
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the expression");
		String exp=sc.next();
		int n1=exp.length();
		System.out.println(n1);
		Stack st1 =new Stack(n1);
		for(int i=0;i<n1;i++)
		{
			char ch =exp.charAt(i);
			if(ch=='(')
			{
				st1.push(i);
			}
			else if(ch==')')
			{
				try{
					long a=st1.pop()+1;
					System.out.println(") at position " + (i+1)+" is balanced with the position" +a);
					}
				catch(Exception e)
					{
						System.out.println(") at index "+(i+1)+" is unmatched");
					}
			}
		}

		while(!st1.isempty())
		{
			System.out.println(" ( at index "+(st1.pop() +1)+" is unmatched");
			break;
		}


	}
}

class Node
{

	
}

class Stack
{
	long exp1[];
	int top;
	int n1;
	int m1;
	
	Stack(int n1)
	{
	//stackinit(n1);
		m1=n1;
	top=-1;
	exp1=new long[m1];
	}

	public void push(long i)
	{
		exp1[++top]=i;

	}
	public long pop()
	{
		return exp1[top--];
	}
	public long peek()
	{
		return exp1[top];
	}
	public boolean isempty()
	{
		return (top==-1);
	}
	public boolean isfull()
	{
		return (top==(n1-1));
	}

	// char[]expb=exp.toCharArray();
	
	// for(int i=0;i<expb.length;i++)
	// System.out.print(expb[i]);
	// int n1=expb.length;
	// // stackinit(n1);
	// System.out.println(n1);
	}

	 //  public void stackinit(int n1)
	 // {
		


	 // }



