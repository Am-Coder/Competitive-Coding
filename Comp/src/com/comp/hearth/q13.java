package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class q13 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt(); 
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> aarr = new ArrayList<Integer>();
		
		Stack<Integer> sup = new Stack<>();
		st.push(0);
		sup.push(0);
		for(int i=0; i<a; i++) {
				int val = s.nextInt();
				st.push(val);
			}
		while(st.peek()>0) {
			st.pop();
		}
		int si = st.size(),count=0,max=0;
		while(st.peek()!=0) {
		    int ch = st.pop();
		    if(ch<0) {
		    	sup.push(ch);
//		    	System.out.println("1");
		    }else if(ch>0 && sup.size()==0) {
//		    	System.out.println("2");

		    }else if(ch>0 && sup.peek()+ch == 0) {
		    	sup.pop();
		    	count += 2;
		    	if(max<count)
		    		max = count;
//		    	System.out.println("3");

		    }else if(ch>0 && sup.peek()+ch != 0) {
		    	sup.clear();
		    	if(max<count)
		    		max = count;
		    	count=0;
//		    	System.out.println("4");

		    }
		}
		System.out.println(max);
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
