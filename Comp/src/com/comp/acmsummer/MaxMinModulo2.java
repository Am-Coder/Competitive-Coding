package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MaxMinModulo2 {
    static int maxi = 1000000007;

	public static void main(String[] arfs) {

		MyScanner s =new MyScanner();
		int n = s.nextInt();
		int k = s.nextInt();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		long p = 0;
		long q = 0;
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();

		for(int i=0; i<n; i++) {
			int val = s.nextInt();
			pq1.add(val);
			pq2.add(val);
			
			if( i>=k-1 ) {
				int max = pq1.poll();
				int min = pq2.poll();
				str1.append(max);
				str1.append(" ");
				str2.append(min);
				str2.append(" ");
				p += (long)max;
				q += (long)min;

			}
			
		}

    	long g = gcd(p,q);
    	p /= g;
    	q /= g;
    	long ans = (p%maxi + q%maxi)%maxi;
    	System.out.println(str1);
    	System.out.println(str2);
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
