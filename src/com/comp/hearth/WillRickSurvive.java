package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class WillRickSurvive {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
			
		int n = s.nextInt();
		for(int i=0; i<n; i++) {
			int a = s.nextInt();
			int[] arr = new int[a];
			
			for(int j=0; j<a; j++) {
				
				arr[j] = s.nextInt();
				
			}
			Arrays.sort(arr);
			int b = 6;
			int ch = 0;
			int count = 0;
			for(int j=0; j<a; j++) {
				
				if(arr[j] == 0) {
					ch = 1;
					break;
				}
				
				if( b==0 ) {
					
					move(arr);
					b = 6;
					j--;
					continue;
				}
				
				b-- ;
				arr[j] = -1 ;
				count++;
				move(arr) ;
				
			}
				
			if(ch == 0) {
				System.out.println("Rick now go and save Carl and Judas");
			}else {
				System.out.println("Goodbye Rick");
				System.out.println(count);

			}
			
		}	
			
	}		
			
	static void move(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if( arr[i] > 0 )
				arr[i] -= 1;
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
