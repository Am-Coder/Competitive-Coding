package com.comp.hearth;

import java.util.*;
import java.io.*;
class dexteralgo3 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		String[] big = new String[a];
		for(int i=0; i<a; i++) {
			big[i] = (s.next());
		}
		int i=1;
		while(i>=1) {
			int st = 4*i - 4;
			int end = 4*i - 1;
			int brcount = 0;
			val[] wt = new val[a];
			for(int j=0; j<a; j++) {
				if(big[j].length()-end-1 < 0 && big[j].length() - 1 - st >=0) {
					val myval = new val(j, Long.parseLong(big[j].substring(0, big[j].length() -st  )));
//					System.out.print(myval.value + "1-");
					wt[j] = myval;
 
				}else if(big[j].length() - st -1< 0 && big[j].length()-end-1 < 0) {
					val myval = new val(j, 0);
					brcount++;
 
//					System.out.print(myval.value + "2-");
 
					wt[j] = myval;
				}else {
					val myval = new val(j, Long.parseLong(big[j].substring(big[j].length() - end - 1, big[j].length() -st  )));
//					System.out.print(myval.value + "3-");
 
					wt[j] = myval;
				}
			}
			if(brcount == a ) {
				
				break;
			}
			
			Arrays.sort(wt, new Comparator<val>(){
 
				@Override
				public int compare(val a, val b) {
					// TODO Auto-generated method stub
					if(a.value == b.value) {
						return a.index - b.index;
					}
					long res = a.value - b.value;
					if (res>0)
						return 1;
					else return -1;
				}
				
			});
			String[] nbig = new String[a];
			int j = 0;
			for(val value:wt) {
				System.out.print(big[value.index] + " ");
				nbig[j] = big[value.index];
				j++;
			}
			System.out.print("\n");
			
			for(int k=0; k<a; k++) {
				big[k] = nbig[k];
			}
			
			
			i++;
		}
	}
	
	static class val{
		int index;
		long value;
		public val(int index, long value) {
			super();
			this.index = index;
			this.value = value;
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