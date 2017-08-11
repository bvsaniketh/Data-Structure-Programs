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
	Node GetData()
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
		}
		Node temp=front;
		while(temp!=rear.GetLink())
		{
			System.out.print(temp.GetData()+"->");
			temp=temp.GetLink();
		}
	}
}
class Deq
{
	public static void main(String args[])
	{
		DeQueue d1=new DeQueue();
		d1.insertatfront('a');
		d1.insertatfront('b');
		d1.insertatfront('c');
		d1.insertatrear('d');
		d1.insertatrear('f');

	}
}