package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ItsSimple {
		
	static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	
	static int prop(int n, int m, int k) {
		TreeSet<Integer> hset = new TreeSet<>(Collections.reverseOrder());
		int num = -1;
		for(int i=2; i<=Math.sqrt(n); i++) {
			
			if(n%i == 0) {
				hset.add(i);
				hset.add(n/i);
			}
			
		}
		hset.add(1);
		
		for(int e:hset) {
			int val = gcd(e,m);
			if(val>k) {
				num = val;
				break;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a=s.nextInt();
		for(int i=0; i<a; i++) {
			System.out.println(prop(s.nextInt(),s.nextInt(),s.nextInt()));
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
