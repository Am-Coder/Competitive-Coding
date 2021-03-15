package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class MonkAndBST {
		
	public static int log2(int x)
	{
	    return (int) (Math.log(x) / Math.log(2) + 1e-10);
	}
	
	public static void main(String[] args) {
		
		MyScanner s = new MyScanner();
		PrintWriter p = new PrintWriter(System.out);
		int L = s.nextInt();
		long S = s.nextLong();
		long[] pow = new long[100];
		pow[0] = 1;
		long pro = 1;
		for( int i=1; i<=L-1; i++ ) {
			pro *= 2;
			pow[i] = pro;
		}
		
		long x;
		if ( L > 1 )
//			x = (long)Math.floor(( S - L*L )/(2*L + 1)) + 1;
			x = (S-((pro-1)*(pro-1)))/(pro*2-1)+1;
		else 
			x = S + 1;
		
		
		int q = s.nextInt(),type,cnt,k;
		long val,root=((L<2)?0:pow[L-2]-1);
    
		while( q != 0 ) {
			
			type = s.nextInt();
			if( type == 0 ) {
				
				val = s.nextLong();
				cnt= L-3;
				val-=x;
				if(L>1 && val==pow[L-1]-1)
				{
					for(int i=1;i<=L-1;i++)p.print("r");
					p.print("\n");
				}
				else
				{
					long temp=root;
					if(val==temp)p.print("root\n");
					else
					{
						while(temp!=val)
						{
							if(temp>val)
							{
								p.print("l");temp=temp-pow[(int)cnt--];
							}
							else
							{
								p.print("r");temp=temp+pow[(int)cnt--];
							}
						}
						p.print("\n");
					}
				}
				
			}else {
				
				k = s.nextInt();
				int l = log2(k) + 1;
				long a;
				if( l == L )a=x;
				else a=x+pow[L-l-1]-1;
				long n=k-pow[l-1]+1;
				long d=pow[L-l];
				p.print(a+(n-1)*d + "\n");
			}
			p.flush();
			q--;
		}
		
		p.close();
	}
	

	

	
    public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }
	}
}
