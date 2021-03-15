package com.comp.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//nlog(n) complexity
public class PairSums {
	public static void main(String[] args) {
		MyScanner s= new MyScanner();
		int a = s.nextInt();
		int b = s.nextInt();
		int check =0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<a; i++) {
			arr.add(s.nextInt());
		}
		Collections.sort(arr);
		for(int i=0; i<a; i++) {
			int m = arr.get(i);
			int in = Collections.binarySearch(arr, b - m);
			if(in > 0 && in!=i) {


				check =1;
				break;
			}
		}
		if(check == 1)
			System.out.print("YES");
		else
			System.out.print("NO");
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
