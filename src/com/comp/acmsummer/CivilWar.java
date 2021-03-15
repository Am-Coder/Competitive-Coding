package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class CivilWar {
			
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
//		ArrayList<Integer> arr = new ArrayList<>();
		int a = s.nextInt();
		for(int i=0; i<a; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] arr = new int[n];
			for(int j=0; j<n; j++) {
				arr[j] = s.nextInt();
			}
			System.out.println(powerset(arr,arr.length,k));
			
		}	
	}		
	
	static int powerset(int[] arr, int si, int k) {
				
				
		long psize = (long)Math.pow(2,si);
				
		int counter;
		int count = 0;
		for(counter=0; counter<psize; counter++) {
			int sum = 0;
			for(int j = 0; j < si; j++) {
				
				if( (counter & (1 << j)) >0) {
					sum += arr[j];
				}
				
			}
			
			if(sum%k == 0 ) {
				count++;
			}
		}		
		return count;
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
