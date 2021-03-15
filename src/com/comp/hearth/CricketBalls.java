package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CricketBalls {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
//		HashSet<Integer> hset = new HashSet<>();
		HashMap<Integer,Integer> hmap = new HashMap<>();
		for(int i=0; i<a; i++) {
			int n = s.nextInt();
			for(int j=0; j<n; j++) {
				int val = s.nextInt();
				arr.add(val);
				if(hmap.containsKey(val) == false)
					hmap.put(val,1);
				else {
					hmap.replace(val, hmap.get(val)+1);
				}
//				hset.add(val);
			}		
			int k = s.nextInt();
			int count = 0;
//			System.out.println("----"+hmap.get(3)+"---");
			for(int j=0; j<n; j++) {
				int val = arr.get(j);
				if( k - val == val) {
					
					count += hmap.get(k -val)-1;
					
				}
				else if(hmap.containsKey(k - val)) {
//					System.out.println("YES");
					count += hmap.get(k - val);
				}	
					
			}		
			System.out.println(count/2);
			hmap.clear();
//			hset.clear();
			arr.clear();
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
