package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class dexteralgo2 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		Long[] big = new Long[a];
		for(int i=0; i<a; i++) {
			big[i] = (s.nextLong());
		}
		int i=1,brcount;
		val[] wt ;
		while(i>=1) {

			brcount = 0;
			wt = new val[a];
			for(int k=0; k<a; k++) {
				
				long num = (big[k]/(long)Math.pow(10, 4*(i - 1)))%(long)Math.pow(10, 4);
				if(num == 0) {
					brcount++;
				}
				wt[k] = new val(k,num,big[k]);

			}
			if(brcount == a ) {
				
				break;
			}
			
			Arrays.sort(wt, new Comparator<val>(){
 
				@Override
				public int compare(val a, val b) {
					if(a.value == b.value) {
						return a.index - b.index;
					}
					if (a.value - b.value>0)
						return 1;
					else return -1;
				}
				
			});
			
			for(int j=0; j<wt.length; j++) {
				val value = wt[j];
				System.out.print(value.orig + " ");
				big[j] = value.orig;
				
			}
			System.out.print("\n");
			
			wt = null;
			i++;
		}
	}
	
	static class val{
		int index;
		long value;
		long orig;
		public val(int index, long value, long orig) {
			super();
			this.index = index;
			this.value = value;
			this.orig = orig;
		}
		
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
