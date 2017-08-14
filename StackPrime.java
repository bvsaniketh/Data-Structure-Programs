import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node link;

	Node(int val)
	{
		data=val;
		link=null;
	}
}

class Stack
{
	Node top;
	int size;
	int count;

	Stack()
	{
		top=null;
		size=0;
	}

	void push(int val)
	{
		Node t1=new Node(val);
		t1.link=top;
		//t1.data=val;
		top=t1;
		size++;

	}

	int pop()
	{
		Node temp=top;
		top=top.link;
		size--;
		return temp.data;

	}

	void display()
	{
		Node temp=top;
		System.out.println(size + " is the total number of elements left");
		while(temp!=null)
		{
			System.out.println(temp.data + "->");
			temp=temp.link;

		}
	}
}

class PrimeStack
{
	public static void main (String args[])
	{
		Stack s1= new Stack();
		findprime(s1);
		printana(s1);
	}

	static void findprime(Stack s1)
	{
		
		int flag;
		for(int i=1;i<1000;i++)
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

				s1.push(i); 
			}
		}
		// s1.display();
	}

	static void printana(Stack s1)
	{
		int arr[]=new int[s1.size];
		int brr[]=new int[s1.size];

		for(int i=0;i<s1.size;i++)
		{
			arr[i]=s1.top.data;
			s1.top=s1.top.link;
			// System.out.println(arr[i] + "->");
		}
		for(int i=0;i<s1.size;i++)
		{
			String str=String.valueOf(arr[i]);
			char b[]=str.toCharArray();
			Arrays.sort(b);
			str=String.valueOf(b);
			brr[i]=Integer.parseInt(str);
			// System.out.println(brr[i] + "->");

		}


		for(int m=0;m<s1.size;m++)
		{
			for(int p=m+1;p<s1.size;p++)
			{
				if(brr[m]==brr[p])
				{
					System.out.println("Now the anagrams are as :" + arr[m] + "->" + arr[p]);
				}
			}
		}
	}
}

