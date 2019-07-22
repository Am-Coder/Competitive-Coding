package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Statistics {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		HashMap<String,Integer> hmap = new HashMap<String,Integer>();
		HashSet<String> hset = new HashSet<>();
		int a = s.nextInt();
		for(int i=0; i<a; i++) {
			String name = s.next();
			String sp = s.next();
			if(hset.contains(name) == true) {
				continue;
			}
			else {
				hset.add(name);
				if(hmap.containsKey(sp) == false) {
					hmap.put(sp,1);
				}else {
					hmap.replace(sp, hmap.get(sp)+1);
				}
			}
		}
		Set<String> key = hmap.keySet();
		int max = 0;
		String ans = "";
		for (String string : key) {
			int c = hmap.get(string);
			if( c > max ) {
				max =c;
				ans = string;
			}
			if( c == max ) {
				if(ans.compareTo(string) > 0)
					ans = string;
			}
		}
		System.out.println(ans);
		System.out.println(hmap.get("football"));
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
