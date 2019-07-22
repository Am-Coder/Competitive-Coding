package com.comp.hearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class CheckItOut {
 
	public static void main(String[] args) {
		
	      MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      
	      // Start writing your solution here. -------------------------------------
	   
	      /*
	      int n      = sc.nextInt();        // read input as integer
	      long k     = sc.nextLong();       // read input as long
	      double d   = sc.nextDouble();     // read input as double
	      String str = sc.next();           // read input as String
	      String s   = sc.nextLine();       // read whole line as String
 
	      int result = 3*n;
	      out.println(result);                    // print via PrintWriter
	      */
	      String string = sc.next();
	      int k = sc.nextInt();
	      helper(string, k);
	      // Stop writing your solution here. -------------------------------------
	      out.close();
	   }
	
	public static void helper(String s, int k){
		ArrayList<String> list = new ArrayList<>(s.length());
		for(int i=0; i<s.length(); i++){
			list.add(s.substring(i));
		}
		
		Collections.sort(list);
		out.println(list.get(k-1));
	}
	
 
	   //-----------PrintWriter for faster output---------------------------------
	   public static PrintWriter out;
	      
	   //-----------MyScanner class for faster input----------
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
