package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class AGameOfNumbersq24 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		long[] arr = new long[a];
		Stack<Long> st = new Stack<>();
		for(int i=0; i<a; i++) {
			arr[i] = s.nextLong();
		}
		
		int check = 0;
		for(int i=0; i<a; i++) {
			long val = arr[i];
			st.push(val);
			for(int j=i; j<a; j++) {
				if( check == 0 ) {
					if( arr[j]>val ) {
						val = arr[j];
						st.push( val );
						check = 1;
					}
				}
				else if( check == 1 ) {
					if( arr[j]<val ) {
						st.push(arr[j]);
						break;
//						check = -1;
					}
				}
			}
			if(st.size() == 3) {
				System.out.print(st.peek()+" ");
			}else {
				System.out.print("-1 ");
			}
			st.clear();
			check = 0;
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
