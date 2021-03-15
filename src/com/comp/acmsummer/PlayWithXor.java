package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlayWithXor {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int a = s.nextInt();
//		System.out.println(1^2^3);
		for(int i=0; i<a; i++) {
			int l = s.nextInt();
			int r = s.nextInt();
			int ans = mynum(l - 1) ^ mynum(r);
//			if(l == r) {
//				System.out.println(l);
//				continue;
//			}
//			else
				System.out.println(ans);
			
		}
		
	}
	static int mynum(int a) {
		int c = a%4;
		if(c == 0)
			return a;
		else if( c == 1)
			return 1;
		else if(c == 3)
			return 0;
		else 
			return a+1;
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
