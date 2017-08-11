import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
  int data;
  Node link;

  Node()
  {
    data=0;
    link=null;
  }
  Node(int val,Node l)
  {
    data=val;
    link=l;
  }
  void SetLink(Node l)
  {
    link=l;
  }
  void SetData(int val)
  {
    data=val;
  }
  Node GetLink()
  { 
    return link;
  }
  int GetData()
  {
    return data;
  }

}

class LinkedList
{
  Node start;
  Node end;
  int size;
  int count;

  LinkedList()
  {
    start=null;
    end=null;

  }
  void insertintoend(int val)
  {
    Node n1=new Node(val,null);
    if(start==null)
    {
      start=n1;
      end=start;
    }
    else
    {
      end.SetLink(n1);
      end=n1;
    }
    count++;
  }

  void display()
  {
    //count++;
    Node temp=start;
    System.out.print(temp.GetData() + "-->");
    temp=start.GetLink();
    while(temp.GetLink()!=null)
    {
      System.out.print(temp.GetData() + "-->" );
      temp=temp.GetLink();
    }
    System.out.println(temp.GetData());
  }

  void delete(int val)
  {
    Node prev=null;
    Node temp=start;
    if(temp!=null&&temp.GetData()==val)
    {
      start=temp.GetLink();
      return;
    }
    while(temp!=null&&temp.GetData()!=val)
    {
      prev=temp;
      temp=temp.GetLink();
    }

    prev.SetLink(temp.GetLink());
    count--;

  }
  void sort(Node start)
  {

    // Node head=start;
    // Node temp=head.GetLink();
    for(int i=0;i<count;i++)
    {
      Node head=start;
      Node temp=head.GetLink();
        for(int j=0;j<count-1;j++)
          {
            if(head.GetData()>temp.GetData())
            {  
            int temp1=head.GetData();
            head.data=temp.GetData();
            temp.data=temp1;
            }
            head=temp;
            temp=temp.GetLink();
          }
    }
  }
  void update(File f1) throws IOException
  {
    FileOutputStream fout=new FileOutputStream(f1);
    Node temp=start;
    while(temp!=null)
    {
      byte b[]=String.valueOf(temp.GetData()).getBytes();
      fout.write(b);
      fout.write(' ');
      temp=temp.GetLink();
    }
    fout.close();

  }

}

class OL
{
  public static void main(String args[]) throws IOException
  {
    LinkedList l1=new LinkedList();
    Scanner sc =new Scanner(System.in);
    // l1.insertintoend(90);
    // l1.insertintoend(60);
    // l1.insertintoend(70);
    // l1.display(); 
    // //l1.delete(70);
    // l1.display();
    // l1.sort(l1.start);
    // l1.display();
    // System.out.println("The total count is " + l1.count);
    System.out.println("Enter the integers");
    String input=sc.next();
    File f1=new File("ghi.txt");
    FileOutputStream fout=new FileOutputStream(f1);
    byte b[]=input.getBytes();
    fout.write(b);
    fout.close();

    Scanner sc1=new Scanner(f1);
    sc1.useDelimiter(",");
    while(sc1.hasNext())
    {
      int num=sc1.nextInt();
      l1.insertintoend(num);

    }
    System.out.println("The elements are now after insertion:");
    l1.display();
    System.out.println("The elements after sorting:");
    // System.out.println("The total count is " + l1.count);
    l1.sort(l1.start);
    l1.display();
    System.out.println("The total count is " + l1.count);

    l1.update(f1);


      
      // System.out.println("Enter the number of elements");
      // int n=sc.nextInt();
      // String arr[]=new String[n];
      // byte b[]=new byte[n];

      // for(int i=0;i<n;i++)
      // {
      //   arr[i]=sc.next();
      //   byte b[i]=
      // }
      // for(int i=0;i<n;i++)
      // {
      //   fout.write(arr[i]);

      // }

    

  }
}