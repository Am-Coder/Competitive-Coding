package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class PinkFloydAndHappinessq23 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		int cur = 1;
		ArrayList<Integer> arr = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<a; i++) {
			int c = s.nextInt();
			while(st.empty() != true && st.peek() == cur) {
				arr.add(st.pop());
				cur += 1;
			}
			if(c == cur) {
				arr.add(c);
				cur += 1;
				continue;
			}
			st.push(c);
				
		}
		int si = st.size();
		for(int i=0; i<si; i++) {
			
				
			arr.add(st.pop());
		}
//		System.out.println(arr.size() );

		for(int i=1; i<arr.size(); i++) {
			if((arr.get(i) - arr.get(i - 1)) < 0) {
				cur = -1;
				break;
			}
		}
		if(cur < 0 || arr.size() != a) {
			System.out.println("Sad");
		}else 	{
	
			System.out.println("Happy");
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
