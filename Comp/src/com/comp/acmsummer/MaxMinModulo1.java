package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class MaxMinModulo1 {
    static int max = 1000000007;

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int k = s.nextInt();
		long p = 0; 
		long q = 0;
//		LinkedList<Integer> hset1 = new LinkedList<Integer>();
//		LinkedList<Integer> hset2 = new LinkedList<Integer>();
		LinkedHashSet<Integer> hset1 = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> hset2 = new LinkedHashSet<Integer>();
		LinkedHashMap<Integer,Integer> hmap1 = new LinkedHashMap<>();
		for(int i=0; i<n; i++) {
			int val = s.nextInt();
			hset1.add(val);
			hset2.add(val);
			if(hmap1.containsKey(val))
				hmap1.put(val, hmap1.get(val) + 1);
			else
				hmap1.put(val, 0);
			if( i>=k-1 ) {
				int max = Collections.max(hset1);
				int min = Collections.min(hset2);
//				System.out.println(max + "-" + min);

				p += (long)max;
				q += (long)min;
//				hset1.remove(hset1.indexOf(max));
//				hset2.remove(hset1.indexOf(min));

				hset1.remove(max);
				hset2.remove(min);
			}
			
		}

    	long g = gcd(p,q);
    	p /= g;
    	q /= g;
    	long ans = (p%max + q%max)%max;
    	System.out.println(ans);
		
	}
    public static long gcd(long a, long b) {
    	
    	if(b==0)
    		return a;
    	return gcd(b, a%b);
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
