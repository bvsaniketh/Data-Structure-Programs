import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
	char data;
	Node link;

	Node()
	{
		data=' ';
		link=null;
	}
	Node(char d,Node n)
	{
		data=d;
		link=n;
	}

	void SetLink(Node n)
	{
		link=n;
	}

	void SetData(char d)
	{
		data=d;
	}

	Node GetLink()
	{
		return link;
	}
	char GetData()
	{
		return data;
	}
}
class DeQueue
{
	Node front;
	Node rear;
	int size;
	int count;

	DeQueue()
	{
		front=null;
		rear=null;
		count=0;
	}
	
	boolean isempty()
	{
		return (front==null);
	}

	void insertatfront(char d)
	{
		Node temp=new Node(d,null);
		count++;
		if(front==null)
		{
			front=temp;
			rear=front;
		}
		else
		{
			temp.SetLink(front);
			front=temp;
		}
	}
	void insertatrear(char d)
	{
		Node temp=new Node(d,null);
		count++;
		if(rear==null)
		{
			rear=temp;
			front=rear;
		}
		else
		{
			rear.SetLink(temp);
			rear=temp;
		}
	}

	char delatfront()
	{
		if(isempty())
		{
			System.out.println("Underflow");	
			throw new NoSuchElementException("Underflow Exception");
		}
		Node temp1=front;
		front=front.GetLink();

		if(front==null)
			rear=null;
		count--;
		return temp1.GetData();

	}

	char delatend()
	{	
		char vall=rear.GetData(); 
		Node f1=front;
		Node f2=front;
		while(f1!=rear)
		{
			f2=f1;
			f1=f1.GetLink();
		}
		rear=f2;
		rear.SetLink(null);
		count--;
		return vall;

	}
	void display()
	{
		if(count==0)
		{
			System.out.println("Empty Queue");
				return ;
		}
		Node temp=front;
		while(temp!=rear.GetLink())
		{	
			System.out.print(temp.GetData()+"->");
			temp=temp.GetLink();
		}
		System.out.println();

	}

	void checkpallindrome()
	{
		int mid=count/2;
		int flag=0;
		for(int i=0;i<mid;i++)
		{
			if(rear.GetData()==front.GetData())
			{
				delatend();
				delatfront();
				//System.out.println("Okay!");
				flag=1;
			}
		}
			if(flag==1)
			{
				System.out.println("Pallindrome");
			}
			else
				System.out.println("Not a Pallindrome");
		
	}
}
class Deq
{
	public static void main(String args[])
	{
		DeQueue d1=new DeQueue();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String s1=sc.next();
		int n=s1.length();
		char c[]=s1.toCharArray();

		for(int i=0;i<n;i++)
		{	
			d1.insertatrear(c[i]);

		}
		System.out.println("The count of total characters is " + d1.count);
		// d1.insertatfront('a');
		// d1.insertatfront('b');
		// d1.insertatfront('c');
		// d1.insertatrear('d');
		// d1.insertatrear('f');
		d1.display();
		d1.checkpallindrome();
		d1.display();

	}
}