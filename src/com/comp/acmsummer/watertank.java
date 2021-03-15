package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class watertank {
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int k = s.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		int global = 0;
		for(int i=0; i<n - 1; i++) {
			int val1 = arr[i];
			int max = arr[i+1];
			for(int j=i+1; j<n; j++) {
				if(arr[j] - val1 > 0 && arr[j] > max)
					max = arr[j];
			}
			if(max - val1 < 0)
				continue;
			if(global<max - arr[i])
				global = max - arr[i];
		}
		System.out.println(global*k);
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
