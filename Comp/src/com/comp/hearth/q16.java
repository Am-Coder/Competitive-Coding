package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class q16 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int m = s.nextInt();
		long[][] arr = new long[n][m];
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<m; j++) {
				arr[i][j] = s.nextLong();
			}
			
		}
		long min = 0 ;
		ArrayList<Long> mi = new ArrayList<Long>();
		for(int i=0; i<n-1; i++) {
			min = Math.abs( arr[i][0] - arr[i+1][0]);
			for(int j=0; j<m; j++) {
				long ele = arr[i][j];
				for(int k=0; k<m; k++) {
					if( Math.abs( ele - arr[i+1][k] )<min ) {
						min = Math.abs( ele - arr[i+1][k] );
//						System.out.println("HI");
					}
				}
			}
			System.out.println(min);
			mi.add(min);
		}
		Collections.sort(mi);
//		System.out.println(mi.get(0));
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
