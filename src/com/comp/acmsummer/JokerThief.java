package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class JokerThief {
	static int max = 1000000007;
    public static void main(String args[] ) throws Exception {
    	MyScanner s = new MyScanner();
        HashSet<Integer> a = new HashSet<Integer>();
        HashSet<Integer> b = new HashSet<Integer>();
        
        int n = s.nextInt();
        
        for( int i=0; i<n; i++ ) {
        	int val = s.nextInt();
        	if(a.contains(val)) {
        		a.remove(val);
        	}else {
        		a.add(val);
        	}
        	
        }
        for( int i=0; i<n; i++ ) {
        	int val = s.nextInt();
        	if(b.contains(val)) {
        		b.remove(val);
        	}else {
        		b.add(val);
        	}
        	
        }
        long s1 = 0;
        long s2 = 0;
        
        for(Integer e: a) {
        	s1 = s1%max + e%max;
        }
        for(Integer e: b) {
        	s2 = s2%max + e%max;
        }
        
        System.out.println(s1);
        System.out.println(s2);
        if(s1>s2)
        	System.out.println("Alice");
        else if(s2>s1) {
        	System.out.println("Bob");
        }else {
        	System.out.println("Tie");
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
