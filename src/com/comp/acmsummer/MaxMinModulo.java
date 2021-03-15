package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaxMinModulo {
    static int max = 1000000007;
    public static void main(String args[] ) throws Exception {
    	MyScanner s = new MyScanner();
    	int n = s.nextInt();
    	int k = s.nextInt();
    	ArrayList<Integer> arr1 = new ArrayList<>();
    	ArrayList<Integer> arr2 = new ArrayList<>();

    	long p = 0;
    	long q = 0;
    	int maxi = 0;
    	int mini = 0;
    	
    	for(int i=0; i<n; i++) {
    		int e = s.nextInt();
    		arr1.add(e);
    		arr2.add(e);
    	}
    	for( int i=0; i<n-k+1; i++) {
    		int j=0, l = 0 ;
//    		System.out.println("HI");
    		while(j < k ) {

    			int val = arr1.get(l);
    			if(val != -1) {
	    			if(val > arr1.get(maxi))
	    				maxi = l;
	    			j++;
    			}
    			l++;
    		}
    		
    		j=0;  l=0;
    		while(j < k ) {
    			int val = arr2.get(l);
    			if(val != Integer.MAX_VALUE) {
	    			if(val < arr2.get(mini))
	    				mini = l;
	    			j++;
    			}
    			l++;
    		}
//    		System.out.println(arr1.get(maxi)+"-"+arr2.get(mini));
    		p += (long)arr1.get(maxi);
    		q += (long)arr2.get(mini);
    		arr1.set(maxi, -1);
    		arr2.set(mini, Integer.MAX_VALUE);
    		maxi = 0;
    		mini = 0;
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
