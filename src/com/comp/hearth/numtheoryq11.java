package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numtheoryq11 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		long a,b,c;
		for(int i=0; i<n ; i++) {
			a = s.nextLong();
			b = s.nextLong();
			c = s.nextLong();
			
			
		}
	}
	
	
	
    static int power(int x, int y, int p) 
    { 
        // Initialize result 
        int res = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
      
        while (y > 0) 
        { 
            // If y is odd, multiply x 
            // with result 
            if((y & 1)==1) 
                res = (res * x) % p; 
      
            // y must be even now 
            // y = y / 2 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
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
