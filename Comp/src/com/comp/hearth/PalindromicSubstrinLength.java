package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PalindromicSubstrinLength {
    static int[] arr;
    public static void sieve(int n){
        arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for( int i=2; i*i<=n; i++){
            
            if( arr[i] == 0){
                
                for( int j=i*i; j<=n; j+=i ){
                    arr[j] = 1;
                }
            }
        }
    }
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int t = s.nextInt();
		sieve(10000);
		
		for( int k=0; k<t; k++ ){
		
		    String str = s.nextLine();
		    int n = str.length();	
	    	int mlen = 1;

		    for( int i=1; i<n; i++) {
		    	
		    	int low = i-1;
		    	int high = i;
		    	
		    	while( low>=0 && high<n && str.charAt(low) == str.charAt(high)) {
		    		if( high - low +1 > mlen) {
		    			mlen = high - low +1;
		    		}
		    		--low;
		    		++high;
		    	}
		    	
		    	low = i-1;
		    	high = i+1;
		    	
		    	while( low>=0 && high<n && str.charAt(low) == str.charAt(high)) {
		    		if( high - low +1 > mlen) {
		    			mlen = high - low +1;
		    		}
		    		--low;
		    		++high;
		    	}
		    	
		    }
		    
		    System.out.println(arr[mlen]==0?"PRIME":"NOT PRIME");
		}
	}
	
	
	
    static class Print {
        private BufferedWriter bw;
 
        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(Object object) throws IOException {
            bw.append("" + object);
        }
        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }
        public void close() throws IOException {
            bw.close();
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
