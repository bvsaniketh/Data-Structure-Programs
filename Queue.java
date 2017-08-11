import java.util.*;
import java.io.*;
import java.lang.*;

class Queue
{
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number of people for transactions");
		int n=sc.nextInt();
		int amt;
		int num;
		QueueL q1 =new QueueL(n);

		// char opt=sc.next().charAt(0);
		for(int p=0;p<n;p++)
		{
			System.out.println("Enter the option of transaction");
			char opt=sc.next().charAt(0);
			switch(opt)
			{
			case 'd':
			System.out.println("Enter the value to deposit");
			amt=sc.nextInt();
			num=q1.enqueue(amt);
			System.out.println(num+ " " + "is amount inserted");
			break;

			case 'w':
			System.out.println("Enter the value to withdraw");
			amt=sc.nextInt();
			q1.deposit(amt);
			num=q1.dequeue();
			System.out.println(num+ " " + "is amount withdraw");
			break;

			case 's':
			int size1=q1.size();
			System.out.println(size1 + " " + "are the  number of users till now");
			p--;
			}	
		}

			int size1=q1.size();
			System.out.println(size1+1 + " " + "are the  number of users till now");
		// int num=q1.enqueue(50);
		// System.out.println(num+ " " + "is inserted");
		// num=q1.enqueue(20);
		// System.out.println(num+ " " + "is inserted");
		// //num=q1.enqueue(20);
		// int num1=q1.dequeue();
		// System.out.println(num1+ " " + "is deleted");
		// num1=q1.dequeue();
		// System.out.println(num1+ " " + "is deleted");
		// num1=q1.dequeue();
		//System.out.println(num1+ " " + "is deleted");
	}
}

class QueueL
{
	int rear,front;
	int size;
	int arr[];
	int count;
	int amts;
	int length=1;

	QueueL(int n)
	{
		size=n;
		rear=-1;
		front=-1;
		arr=new int[size];
		
	}

	public boolean isfull()
	{
		return (front==0&&rear==size-1);
	}

	public boolean isempty()
	{
		return (front==-1);
	}

	public int enqueue(int num)
	{
		if(rear==-1)
		{
			rear=0;
			front=0;
			arr[rear]=num;
			amts=amts+num;
			System.out.println(amts+" "+ "is the available balance");
			return num;
		}
		else
		{
			if(rear+1<size)
			{
				arr[++rear]=num;
				length++;
				count++;
				amts=amts+num;
				System.out.println(amts+" "+ "is the available balance");
				return num;
				
			}
			else
			{
				throw new IndexOutOfBoundsException("Overflow");
			}
		}
		
	}

	public int dequeue()
	{

			if(isempty())
			{
				System.out.println("Underflow");
			}
			else
			{
				count--;
				length++;
				int a=arr[front];
			if(front==rear)
			{
				front=-1;
				rear=-1;
			}
			else
			
				front++;
				// amts=amts-num;
				// if(amts<=0)
				// {
				// System.out.println("Balance is below than zero ");
				// }
				// else	
				// System.out.println(amts+" "+ "is the available balance");
				return a;
			
		}
		return 0;
	}

	public void deposit(int num)
	{
				amts=amts-num;
				if(amts<=0)
				{
				System.out.println("Balance is below than zero ");
				}
				else	
				System.out.println(amts+" "+ "is the available balance");
	}

	public int size()
	{
		return length;
	}
}