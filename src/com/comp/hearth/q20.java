package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class q20 {

		public static void main(String[] args) {
			MyScanner s = new MyScanner();
			int a = s.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			Stack<Integer> st = new Stack<>();
			Stack<Integer> sup = new Stack<>();
			
			st.push(-1);
			for(int i=0; i<a; i++) {
				arr.add(s.nextInt());
			}
//			System.out.println(st.peek());

			Collections.sort(arr);
			st.push(arr.get(0));
//			System.out.println(st.peek());
			for(int i=1; i<a; i++) {
				if(st.peek()<arr.get(i)) {
				 	st.pop();
				}
				else if(st.peek() == arr.get(i)) {
				 	while(st.peek() == arr.get(i))
				 		sup.push(st.pop());
				 	if(st.peek() != -1 && st.peek()<arr.get(i))
				 		st.pop();
				 	while(sup.empty() != true) {
				 		st.push(sup.pop());
				 	}
				}
				st.push(arr.get(i));
			}
			int sum = 0;
			while(st.peek() != -1)
				sum += st.pop();
			System.out.println(sum);
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