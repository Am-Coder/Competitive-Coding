package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class StackExSum {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		Deque<Long> dq = new LinkedList<Long>();
		int t =s.nextInt();
		long val,n1,n2;
		long sum = 0;
		for( int i=0; i<t; i++ ) {
			int n = s.nextInt();
			int k = s.nextInt();
			sum = 0;
			for( int j=0; j<n; j++) {
				val = s.nextLong();
				if(j<k){
				sum += (long)val;
				dq.addLast(val);
				}
			}
			
			while(dq.isEmpty() == false) {
				n1 = dq.pollFirst();
				if(dq.isEmpty()) {
				// 	System.out.println("i");
//					if(sum - (long)n1 > sum) {
//						sum = sum - (long)n1;
//					}
					break;
				}
				n2 = dq.pollLast();
				if( sum - (long)n1 - (long)n2 > sum) {
				// 	System.out.println("H");
//					n1 = dq.pollFirst();
//					if(dq.isEmpty()) {
//						sum = sum - (long)n1;
//					}
//					else {
//						n2 = dq.pollLast();
						sum = sum - (long)n1 - (long)n2;
//					}
					
				}else {
					
					break;
					
				}
			}
			
			System.out.println(sum);
			dq.clear();
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
