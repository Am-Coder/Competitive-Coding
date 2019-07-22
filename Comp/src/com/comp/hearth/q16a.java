package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class q16a {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int m = s.nextInt();
		long[][] arr = new long[n][m];
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<m; j++) {
				arr[i][j] = s.nextLong();
			}
			Arrays.sort(arr[i]);
			
		}
		long min = Math.abs(arr[0][0] - arr[1][0]) ;

		for(int i=0; i<n-1; i++) {
			long prev,cur,mini=Math.abs(arr[i][0] - arr[i+1][0]);
			cur = mini;
			for(int j=0; j<m; j++) {
				long elem = arr[i][j];
				prev = Math.abs(elem - arr[i+1][0]);
				for(int k=1; k<m; k++) {
					cur = Math.abs(arr[i+1][k] - elem);
					if(cur < prev) {
						prev = cur;
					}else {
						break;
					}
						
				}
				if(mini > prev) {
					mini = prev;
				}
			}
//			System.out.println(mini);
			if(mini<min)
				min = mini;
		}
		
		System.out.println(min);
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
