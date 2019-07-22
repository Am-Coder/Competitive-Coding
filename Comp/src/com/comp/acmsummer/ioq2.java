package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ioq2 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		String[] str = s.nextLine().split("");
		int sum = 0;
		for(int i = 0; i<a; i++) {
			sum = sum + Integer.parseInt(str[i]);
		}
		if(sum%3 == 0)
			System.out.println("YES");
		else 
			System.out.println("NO");
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
