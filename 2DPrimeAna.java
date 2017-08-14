import java.util.*;

class D12{

	public static void main(String args[])
	{
	int temp,count=0,check=0,z=0;
	int[] arr=new int[1000];
	int[] brr=new int[1000];
	
	
		for(int i=0;i<1000;i++)
		{
			int d=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0 || i==0 || i==1)
				{
					d=1;
					break;			
				}
			}

			if(d==0)
			{
				count++;
				arr[count]=i;
			}

		}

		for(int l=1;l<count;l++)
		{
			String data=String.valueOf(arr[l]);
			char[] c1=data.toCharArray();
			Arrays.sort(c1);
			String data1=String.valueOf(c1);
			brr[l] = Integer.parseInt(data1);
		}

		int[] n1=new int[1000];
		int[] n2=new int[1000];
		int[][] array=new int[50][50];

		System.out.println("The Anagrams available now are :");
		for(int i=1;i<count;i++)
		{
			for(int j=i+1;j<count;j++)
			{
				if(brr[i]==brr[j])
				{
					int len = (int)(Math.log10(arr[i])+1);
					int len1 = (int)(Math.log10(arr[j])+1);					
					if(len==len1)
					{					
					
					n1[z]=arr[i];
					n2[z]=arr[j];
					z++;
				
					}

				}

			}	

		}
		int v=0,v1=0;
		for(int p=0;p<2;p++)
		{
			for(int q=0;q<30;q++)
			{
				array[p][q]=n1[v];
				if(p==1)
				{
				array[p][q]=n2[v1];
				v1++;
				}
				v++;
			}
			
			
		}
		for(int q=0;q<30;q++)
		{
			for(int p=0;p<2;p++)
		
			{
				
				System.out.print(array[p][q]+" ");
			}
			
			System.out.println();
			
		}
		
	}

}
