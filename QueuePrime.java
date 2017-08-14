import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	Node link;
	int data;

	Node(int val)
	{
		link=null;
		data=val;
	}

}

class Queue
{

	Node front;
	Node rear;
	int size;
	int count=0;
	 Queue()
	 {
	 	front=null;
	 	rear=null;
	 	size=0;
	 }

	 void enqueue(int val)
	 {
	 	Node n1=new Node(val);
	 	size++;
	 	if(rear==null)
	 	{
	 		rear=n1;
	 		front=rear;
	 		return;
	 	}
	 	rear.link=n1;
	 	rear=n1;

	 }

	 int dequeue()
	 {
	 	if(front==null)
	 	{
	 		System.out.println("Empty");
	 		return 0;	
	 	}
	 	if(front==rear)
	 	{	
	 		int temp;
	 		temp=front.data;
	 		front=null;
	 		rear=null;
	 		return temp;
	 	}
	 	int temp1;
	 	Node t1;
	 	t1=front;
	 	temp1=t1.data;
	 	front=front.link;
	 	return temp1;

	 }

	 void display()
	 {
	 	Node temp1=front;
	 	while(temp1!=null)
	 	
	 	{
	 		System.out.print(temp1.data + "->");
	 		temp1=temp1.link;

		}


	 }
	 boolean search(int val)
	 {
	 	Node temp1=front;
	 	if(temp1.data==val)
	 	{
	 		return true;
	 	}
	 	while(temp1.link!=null && temp1.data!=val)
	 	{
	 		temp1=temp1.link;
	 	}
	 	if(temp1.data==val)
	 	{
	 		return true;
	 	}
		return false;

	}
}

class QueuePrime
{	
	public static void main(String args[])
	{
	Queue q1= new Queue();
	q1.enqueue(100);
	int p=q1.dequeue();
	System.out.println(p);
	q1.enqueue(500);
	q1.enqueue(1000);
	q1.dequeue();
	q1.display();

	Prime(q1);
	AnaPrime(q1);
	// System.out.println(q1.search(5));


	}

	static void Prime(Queue q1)
	{
		int c1,flag=0;
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
				q1.enqueue(i);
			}
			
		}
		//q1.display();
	}

	static void AnaPrime(Queue q1)
	{

		int arr[]=new int[q1.size];
		int brr[]=new int[q1.size];
		int i=0;

		Node temp=q1.front;

		while(temp!=null)
		{
			arr[i]=temp.data;
			temp=temp.link;
			//System.out.print(arr[i] + "->");
			i++;
			
		}


		for(int j=0;j<q1.size;j++)
		{

			String str=String.valueOf(arr[j]);
			char b[]=str.toCharArray();
			Arrays.sort(b);
			str=String.valueOf(b);
			int num=Integer.parseInt(str);
			brr[j]=num;
			// System.out.println(brr[j] + "->");

		}

		for(int p=0;p<q1.size;p++)
		{
			for(int m=p+1;m<q1.size;m++)
			{
				if(brr[p]==brr[m])
					System.out.println("Now the anagrams are as follows : " + arr[p]+"->"+ arr[m]);
			}
		}




























																// 		Queue temp2=front;
																// 	for(int i=0;i<q1.size-2;i++)
																// 	{
																// 		int p=q1.front.data;
																// 		String st =String.valueOf(p);
																// 		char s[]=st.toCharArray();
																// 		Arrays.sort(s);
																// 		st=String.valueOf(s);
																// 		//System.out.println(st + "is anagram");
																// 		p=Integer.parseInt(st);

																// 		 if(q1.search(p))
																// 		 {
																// 			System.out.println(p + "is anagram");
																// 		 }

																// 		 q1.front=q1.front.link;



																// 	}
																// 	System.out.println(q1.size + "is the size of the queue");
																// }
}
}


