package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class numtrixq4 {
	
	
	
    static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
    
    
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		BigInteger a;
		
		int n = s.nextInt();
		int m = s.nextInt();
		int count = 0;
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = s.nextInt(); 
			}
		}
		
		for( int i=0; i<n; i++) {
			int check = 0;
			for(int j=0; j<m; j++) {
				int val = arr[i][j];
				try {
					if(gcd(val,arr[i][j+1])==1)
					check = 1;	
				}catch(Exception e) {
					
				}
				try {
					if(gcd(val,arr[i][j-1])==1)
					check = 1;	
				}catch(Exception e) {
					
				}
				try {
					if(gcd(val,arr[i+1][j])==1)
					check = 1;	
				}catch(Exception e) {
					
				}
				try {
					if(gcd(val,arr[i-1][j])==1)
					check = 1;	
				}catch(Exception e) {
					
				}
				
				if(check == 0)
					count += 1;
				
				check = 0;
			}
		}
		
		System.out.println(count);
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
