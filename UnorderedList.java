import java.util.*;
import java.lang.*;
import java.io.*;



class UnList
{

	public static void main(String args[]) throws IOException
	{
		LinkedList ls =new LinkedList();
		Scanner sc=new Scanner(System.in);
		File f1=new File("abc.txt");
		// try{
		
		//File f1=new File("abc.txt");
		FileOutputStream fout =new FileOutputStream(f1);
		System.out.println("Enter the words to add in the file");
		
		String str=sc.nextLine();
		byte b[]=str.getBytes();

		fout.write(b);
		fout.close();
			// }catch(IOException e)
			// {System.out.println(e);}

		// try{
			// File f1 =new File("abc.txt");
			Scanner sc1=new Scanner(f1);
			sc1.useDelimiter(" ");

		while(sc1.hasNext())
		{
			String data=sc1.next();
			ls.insertatlast(data);
		}
		// }catch(FileNotFoundException e)
		// {System.out.println(e);}
		// ls.insertatstart(50);
		// ls.insertatstart(60);
		// ls.insertatstart(70);
		// ls.insertatstart(80);
		// ls.insertatstart(90);
		ls.display();
		System.out.println("Enter the key to search");
		String key=sc.next();
		int f5=ls.search(key);
		if(f5==1)
		{
			ls.delete(key);

		}
		else
		{
			ls.insertatlast(key);

		}
			ls.display();

		//ls.fileout();

	}
}
 class Node
{
	public String data;
	public Node link;

	public Node()
	{
		data=null;
		link=null;
	}	
	public Node(String val,Node n)
	{
		data=val;
		link=n;

	}
	public void Setlink(Node n)
	{
		link=n;	
	}
	public void Setdata(String val)
	{
		data=val;
	}
	public Node Getlink()
	{
		return link;
	}
	public String Getdata()
	{
		return data;
	}
}
 class LinkedList
{
	//LinkedList ls =new LinkedList();
	public Node start;
	public Node end;
	public int size;
	int searchc;


	public LinkedList()
	{
		start=null;
		end=null;
		int size;
	}
	public boolean isempty()
	{
		return start==null;
	}
	public int getsize()
	{
		return size;
	}
	public void insertatstart(String val)
	{
		Node n1 = new Node(val,null);
		size++;
		if(start==null)
		{
			start=n1;
			end=start;
		}
		else
		{
			n1.Setlink(start);
			start=n1;
		}
	}
	public void insertatlast(String val)
	{
		Node n1=new Node(val,null);
		size++;
		if(start==null)
		{
			start=n1;
			end=start;
		}
		end.Setlink(n1);
		end=n1;

	}

	public int search(String val)
	{
		//Node n3 =start;
		int flag = 0;
      	Node temp = start;

      while(temp != null)
      {
      	
        if(temp.Getdata().equals(val))
        {
          flag =1;
        }
        temp = temp.Getlink();
      }
      return flag;
    }


	

	public void delete(String val)
	{
		Node temp=start;
		Node prev=null;

		if(temp!=null && temp.Getdata().equals(val))
		{
			start=temp.Getlink();
			return;
		}

		while(temp!=null && !temp.Getdata().equals(val))
		{
			prev=temp;
			temp=temp.Getlink();
		}

		prev.Setlink(temp.Getlink());
		size--;
	}
	public void display()
	{
		if(size==0)
		{
			System.out.print("empty\n");
			return;
		}

		if(start.Getlink()==null)
		{
			System.out.print(start.Getdata());
			return;
		}

		Node n2=start;
		System.out.print(n2.Getdata()+ " ->");
		n2=start.Getlink();
		while(n2.Getlink()!=null)
		{
			System.out.print(n2.Getdata() + "->");
			n2=n2.Getlink();
		}
		System.out.print(n2.Getdata());
	}

	public void fileout() throws IOException
	{
		
		
		FileOutputStream fout=new FileOutputStream("abc.txt");
		Node temp=start;
		while(temp!=null)
		{
			byte brr[]=temp.Getdata().getBytes();
			fout.write(brr);
			fout.write(' ');


		}
		fout.close();
	}

}
