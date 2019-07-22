package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BSqequence {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		
		int a = s.nextInt();
		TreeSet<Long> set = new TreeSet<>();
		TreeSet<Long> set2 = new TreeSet<>(Collections.reverseOrder());

		long prev = s.nextLong();
		set.add(prev);
		long max = prev;
		for(int i=1; i<a; i++) {
			long n = s.nextLong();
			if(n>max) {
				max = n;
			}
			if(prev>n) {
				set2.add(n);
				prev = n;
				continue;
			}
			set.add(n);
			prev = n;
		}

		int c = s.nextInt();
		for(int i=0; i<c; i++) {
			long d = s.nextLong();
			if(d>=max) {
				max = d;
				set.add(d);
			}
			else if( set.contains(d) == false) {
				set.add(d);
			}else if( set.contains(d) == true) {
				set2.add(d);
			}
			System.out.println(set.size() + set2.size());
		}
		
		
		
		for (Long long1 : set) {
		System.out.print(long1+" ");
		}
		for (Long long1 : set2) {
			System.out.print(long1+" ");
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
