package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class q23 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int k = s.nextInt();
		long globmax=0;
		Stack<Long> st = new Stack<>();
		for(int i=0; i<n; i++) {
			long put = s.nextLong();
			if(put > globmax)
				globmax = put;
			st.push(put);
		}
		Collections.reverse(st);
//		System.out.println(st.peek());
		if(k < n && n != 1) {
			
				long max = st.peek();
				for(int i=1; i<=k-1; i++) {
					long num = st.pop();
					if(max < num) {
						max = num;
					}
					
				}
				st.pop();
				long n2 = st.pop();
				if(n2>max)
					max = n2;
				System.out.println(max);
				
		}else if(n==1 & (k&1)==1) {
			System.out.println("-1");
		}
		else if(n < k) {
			System.out.println(globmax);
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
