package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class numtheoryq9 {
		
		public static void main(String[] args) {
			MyScanner s = new MyScanner();
			int si = s.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0 ; i < si ; i++) {
				arr.add(s.nextInt());
			}
//			System.out.println(arr);
			
			int a = s.nextInt();
			for(int i=0 ; i<a ; i++) {
				int count=0;
				int p = s.nextInt();
				int q = s.nextInt();
				for(int j=0 ; j<si ; j++) {
					if(arr.get(j)%p==0 || arr.get(j)%q==0 || arr.get(j)%(p*q)==0)
						count++;
				}
				System.out.println(count);
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
