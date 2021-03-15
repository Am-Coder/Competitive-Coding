package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class MonkAndHisFrined {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		
		int a = s.nextInt();
		TreeSet<Long> set = new TreeSet<>();
		for(int i=0; i<a; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			for(int j=0; j<n; j++) {
				set.add(s.nextLong());
			}
			
			for(int k=0; k<m; k++) {
				long c = s.nextLong();
				if(set.contains(c)) {
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}
				set.add(c);
			}
			set.clear();
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
