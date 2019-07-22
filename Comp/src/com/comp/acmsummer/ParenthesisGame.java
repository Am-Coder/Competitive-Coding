package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParenthesisGame {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		HashMap<String,Integer> hmap = new HashMap<>();
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		for( int i=0; i<n; i++) {
			
			String str = s.nextLine();
			String sol = check(str.toCharArray(), str.length());
			arr.add(sol);
			if(hmap.containsKey(sol))
				hmap.replace(sol, hmap.get(sol) + 1) ;
			else
				hmap.put(sol, 1) ;
		}
		int count = 0;
		for(String st: arr) {
			System.out.println(st);
		}
		for(String st: arr) {
			String ss = "";
			if(st.contains("("))
				ss = st.replace('(', ')');
			else
				ss = st.replace(')', '(');
			if(hmap.containsKey(ss) && hmap.get(ss)>0) {
				count++;
				hmap.replace(st, hmap.get(st) - 1);
				hmap.replace(ss, hmap.get(ss) - 1);
			}
		}
		System.out.println(count);
		
	}
	
	public static String check(char[] str, int n) {
		Stack<Character> st = new Stack<>();
		for(int i=0; i<n ; i++) {
			char c = str[i];
			if(st.isEmpty()) {
				st.push(c);
			}
			else if(c == ')' && st.peek() == '(') {
				st.pop();
			}else {
				st.push(c);
			}
		}
		String s = "";
		while(!st.isEmpty()) {
			s = s.concat(st.pop().toString());
		}
		
		return s;
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
