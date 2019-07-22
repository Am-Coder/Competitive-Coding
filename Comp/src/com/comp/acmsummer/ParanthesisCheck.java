package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParanthesisCheck {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		String a = s.nextLine(); 
		Stack<Integer> st = new Stack<>();
		Stack<Integer> sup = new Stack<>();
		st.push(0);
		sup.push(0);
		for(int i=0; i<a.length(); i++) {
				if(a.charAt(i) == '(')
				    st.push(1);
			    else
			        st.push(-1);
			}
		while(st.peek()>0) {
			st.pop();
		}
		int si = st.size(),count=0,max=0;
		while(st.peek()!=0) {
		    int ch = st.pop();
		    if(ch<0) {
		    	sup.push(ch);
		    }else if(ch>0 && sup.size()==0) {

		    }else if(ch>0 && sup.peek()+ch == 0) {
		    	sup.pop();
		    	count += 2;
		    	if(max<count)
		    		max = count;

		    }else if(ch>0 && sup.peek()+ch != 0) {
		    	sup.clear();
		    	if(max<count)
		    		max = count;
		    	count=0;

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
