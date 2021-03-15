package com.comp.hearth;
		
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
		
public class LittleShinoAndPairs {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<a; i++) {
			arr.add(s.nextInt());
		}
		for(int i=0; i<a; i++) {
			
			for(int j=a-1; j>=i; j--) {
				
				for(int k=i; k<j; k++) {
					
				}
				
			}
			
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
