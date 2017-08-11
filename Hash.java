import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node next;

	Node(int val)
	{
		data=val;
		next=null;
	}
}

class Hash
{
	Node[] table;
	int size=0;
	int length1=0;

	Hash(int tabsize)
	{
		table=new Node[tabsize];
		size=0;
		length1=tabsize;
	}
	void makeempty()
	{
		int n1=table.length;
		table=new Node[n1];
		size=0;
	}
	int getsize()
	{
		return size;
	}

	void insert(int val)
	{	
		size++;
		int pos=hashCheck(val);

		Node temp=new Node(val);
		if(table[pos]==null)
		{
			table[pos]=temp;
		}
		else
		{
			temp.next=table[pos];
			table[pos]=temp;
		}
	}

	void remove(int val)
	{
		int pos=hashCheck(val);
		Node start=table[pos];
		Node end=start;

		if(start.data==val) //if element is at start
		{
			size--;
			table[pos]=start.next;
			return;
		}
		while(end.next!=null && end.next.data!=val)
			end=end.next;
		if(end.next==null) //if element is not found
		{
			System.out.println("Not found");
			return;
		}
		size--;
		if(end.next.next==null) //if it is the last element
		{
			end.next=null;
			return;
		}
		end.next=end.next.next;
		table[pos]=start;

	}

	int hashCheck(Integer val)
	{
		int x=val.hashCode();
		x=(x%length1);

		return x;
	}

	void display()
	{
		for(int i=0;i<length1;i++)
		{
			System.out.print("Bucket "+ " " + i);
			Node temp=table[i];
			while(temp!=null)
			{
				System.out.print(" "+ temp.data + " ");
				temp=temp.next;
			}
			System.out.println();

		}
	}
	void search(int val)
	{
		int flag1=0;
			for(int i=0;i<length1;i++)
			{
			// System.out.print("Bucket "+ " " + i);
			Node temp=table[i];
			while(temp!=null)
			{
				if(temp.data==val)
				{
					flag1=1;
				}
				temp=temp.next;
			}
			// System.out.println();

			}
			if(flag1==1)
			{
				remove(val);
			}
			else
			{
				insert(val);
			}


	}
	void updatefile(File f1) throws IOException
	{
		FileOutputStream fout = new FileOutputStream(f1);

		for(int i=0;i<length1;i++)
		{
			// System.out.print("Bucket "+ " " + i);
			Node temp=table[i];
			while(temp!=null)
			{

				byte b[]=String.valueOf(temp.data).getBytes();
				fout.write(b);
				fout.write(',');

				temp=temp.next;
			}

			// System.out.println();

		}
		fout.close();
	}


}

class Hashing
{
	public static void main(String args[]) throws FileNotFoundException,IOException
	{
		Scanner sc =new Scanner(System.in);
		//int num=sc.nextInt();
		System.out.println("Enter the size of the table");
		Hash h1=new Hash(sc.nextInt());



		File f1= new File("Index.txt");
		Scanner sc1=new Scanner(f1);
		sc1.useDelimiter(",");

		try
		{while(sc1.hasNext())
		{
			int temp=sc1.nextInt();
			h1.insert(temp);
			
		}
		}catch(InputMismatchException d)
		{//System.out.println(d);
		}
		h1.display();
		System.out.println("Enter the element to search");
		int val=sc.nextInt();
		h1.search(val);
		System.out.println("After seraching the elements are");
		h1.display();

		h1.updatefile(f1);


		// for(int j=0;j<h1.length1;j++)
		// {
		// 	System.out.println("Enter the element to insert");
		// 	int tp=sc.nextInt();
		// 	h1.insert(tp);
		// 	h1.display();
		// }



	}
}