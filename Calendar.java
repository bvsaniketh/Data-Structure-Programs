import java.util.*;
import java.io.*;
import java.lang.*;

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

class Queue
{
	Node front;
	Node rear;
	int size=0;

	Queue()
	{
		front=null;
		rear=null;
	}

	void enqueue(int val)
	{
		Node n1= new Node(val);
		size++;
		if(rear==null)
		{
			rear=n1;
			n1=front;
			return;
		}
		else
		{
			rear.link=n1;
			rear=n1;
		}

	}
	Node dequeue()
	{
		if(front==null)
		return null;
		Node temp=front;
		front=front.link;

		if(front==null)
		{
			rear=null;
		}
		return temp;
	}
	
}

class Calendar
{
	public static void main(String args[])
	{
		int year=Integer.parseInt(args[0]);
		int month=Integer.parseInt(args[1]);

	String[] months={"", "January","February", "March","April", "May", "June","July", "August", "September","October", "November", 				"December"};
	int [] days={0,31,28,31,30,31,30,31,31,30,31,30,31};


	if(month==2&&checkleap(year))
	days[2]=29;

	System.out.println(" Calendar is " +" "+ months[month] + " "+ year);
	System.out.println(" S  M  Tu W Th  F  Sa ");

	int d=daycheck(year,1,month);
	for(int i=0;i<d;i++)
	{
		System.out.print("   ");
	}
	for(int i=1;i<=days[month];i++)
	{
		System.out.printf("%2d ",i);
		if(((i+d)%7==0)||i==days[month])
		System.out.println();
	}


}

	static boolean checkleap(int year)
	{
		if((year%4==0)&&(year%100!=0))
		return true;
		if(year%400==0)
		return true;
		return false;
	}

	static int daycheck(int year,int day,int month)
	{
					int y = year - (14 - month) / 12;
					int x = y + y/4 - y/100 + y/400;
					int m = month + 12 * ((14 - month) / 12) - 2;
					int d = (day + x + (31*m)/12) % 7;
					 return d;
	}
}
