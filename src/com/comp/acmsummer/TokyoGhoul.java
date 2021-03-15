package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class TokyoGhoul {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int t = s.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<t; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			
			for(int j=0; j<n; j++) {
				int e = s.nextInt();
				pq.add(e);
			}
			int e = 0;
			for(int j=0; j<k; j++) {
				if(pq.size() == 0) {
					e = -1;
					break;
				}
				e = pq.poll();
				ArrayList<Integer> arr = getFactors(e);
				for(int l=0; l<arr.size(); l++) {
					pq.add(arr.get(l));
				}
			}
			if(e == -1) {
				System.out.println("It was easy!!");
			}
			else {
				System.out.println(pq.size());
			}
			pq.clear();
		}
	}
	static ArrayList<Integer> getFactors(int n) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=2; i<=Math.sqrt(n); i++) {
			
			if( n % i == 0 ) {
				if(n/i == i) {
					arr.add(i);
					
				}else {
					arr.add(i);
					arr.add(n/i);
				}
				
			}
		}
		return arr;
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
