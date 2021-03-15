package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ioq1 {
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		Stack<Character> st = new Stack<>();
		char[] str = s.nextLine().toCharArray();
		for( int i=0; i<a; i++) {
			st.push(str[i]);
		}
		char ch = st.pop();
		int res;
		while(true) {
			if(st.size() == 0) {
				res = 0;
				break;
			}
				
			char c = st.pop();
			if( ch != c ) {
				res = st.size() + 1;
				
				break;
			}
				
			
		}
		
		System.out.println(res);
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
