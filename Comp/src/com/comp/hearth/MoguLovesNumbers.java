package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MoguLovesNumbers {
    static int[] arr = new int[1000001];
    static int val = 1000000;
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr[0] = 0;
        arr[1] = 0;
        sieve();
        int c = 0;
        for( int i=0; i<n; i++ ){
            c=0;
            int l = s.nextInt();
            int r = s.nextInt();
            if(l<=r)
                System.out.println( arr[r] - arr[l-1] ) ;
            else
                System.out.println( arr[l] - arr[r-1] ) ;                
        }       
                
    }           
    
    
    public static void sieve(){
        boolean[] prime = new boolean[val+1];
        Arrays.fill(prime,true);
        
        for(int p=2; p*p<=val; p++){
            if(prime[p] == true)
                for( int i=p*p; i <= val; i += p ){
                    prime[i] = false;
                }
        }
        
        int c=0;
        for ( int i = 2; i<=val; i++ ){
            if(prime[i] == true)
                c++;
            arr[i] = c;
            
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
