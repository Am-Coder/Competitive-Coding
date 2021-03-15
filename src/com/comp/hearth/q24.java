package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class q24 {
	static int max = 1000001;
    static boolean prime[] = new boolean[max+1]; 
    static void sieveOfEratosthenes() 
    { 
 
        for(int i=0;i<max;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=max; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= max; i += p) 
                    prime[i] = false; 
            } 
        } 
          
 
    }
	public static void main(String[] args) {
		   	PrintWriter wr = new PrintWriter(System.out);
			MyScanner s = new MyScanner();
			sieveOfEratosthenes();
			int a = s.nextInt();
	        int ar1[] = new int[a];
	        int ar2[] = new int[a];
	        int cnt1 = 0, cnt2 = 0;
	        for(int i = 0; i < a; i++)
	        {	int b = s.nextInt();
	            if(prime[b] == true)
	            {
	                ar1[cnt1++] = b;
	            }
	            else
	            {
	                ar2[cnt2++] = b;
	            }
	        }
	        
	        int ar[][] = new int[2][];
	        ar[0] = new int[cnt1];
	        ar[1] = new int[cnt2];
	        
	        
	        for(int i = 0; i < cnt1; i++)
	        {
	            ar[0][i] = ar1[i];
	        }
	        
	        for(int i = cnt2 -1; i >= 0; i--)
	        {
	            ar[1][cnt2-i-1] = ar2[i];
	        }
	        
	        
	        
	         int[][] out_ = ar;
	         for(int i_out_=0; i_out_<out_.length; i_out_++)
	         {
	         	wr.print(out_[i_out_][0]);
	         	for(int j_out_=1; j_out_<out_[i_out_].length; j_out_++)
	         	{
	         		wr.print(" " + out_[i_out_][j_out_]);
	         	}
	         	wr.println("");
	         }
	         wr.flush();
//			StringBuilder str = new StringBuilder();
//			for(int i=0; i<a; i++) {
//				int b = s.nextInt();
//				
//				if(prime[b] == false )
//				 //   st.push(b);
//					str.insert(0, b+" ");
//				else
//					wr.print(b+" ");
//			}
//			wr.print("\n");
//			wr.println(str);
//	        wr.flush();
//	 		while(st.isEmpty()!=true) {
//	 			System.out.print(st.pop()+" ");
//	 		}
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
