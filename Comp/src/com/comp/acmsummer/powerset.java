package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class powerset {
	  static void printPowerSet(char []set, int set_size) 
		{ 
			
			/*set_size of power set of a set 
			with set_size n is (2**n -1)*/
			long pow_set_size =  
			(long)Math.pow(2, set_size); 
			int counter, j; 
			
			/*Run from counter 000..0 to 
			111..1*/
			for(counter = 0; counter < pow_set_size; counter++) 
			{ 
				for(j = 0; j < set_size; j++) 
				{ 
					  /* Check if jth bit in the  
					  counter is set If set then  
					  print jth element from set */
					if((counter & (1 << j)) > 0) 
						System.out.print(set[j]);
					
				} 
				
				System.out.println(); 
			} 
		} 
			
			// Driver program to test printPowerSet 
		public static void main (String[] args) 
		{ 
			char []set = {'a', 'b', 'c'}; 
			printPowerSet(set, 3); 
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
