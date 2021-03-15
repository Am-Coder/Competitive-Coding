package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class binosum {
    static long mod = (long)1e9 + 7;
    static long[] fac;
    
    static void fact(int n) {
    	fac = new long[n+1];
    	fac[0] = 1;
    	for( int i=1; i<n; i++ ) {
    		fac[i] = (fac[i-1]*i)%mod;
    	}
    	
    }
 static long power(long x, long y, long p) 
    { 
          
        // Initialize result 
        long res = 1; 
      
        // Update x if it is more than or 
        // equal to p 
        x = x % p; 
                      
        while (y > 0) 
        { 
              
            // If y is odd, multiply x 
            // with result 
            if (y % 2 == 1) 
                res = (res * x) % p; 
      
            // y must be even now 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        } 
          
        return res; 
    } 
      
    // Returns n^(-1) mod p 
    static long modInverse(long n, long p) 
    { 
        return power(n, p-2, p); 
    } 
      
    // Returns nCr % p using Fermat's 
    // little theorem. 
    static long nCrModPFermat(int n, int r, 
                                    long p) 
    { 
          
        // Base case 
        if (r == 0) 
            return 1; 
      
      
        return (fac[n]* modInverse(fac[r], p) 
                % p * modInverse(fac[n-r], p) 
                                    % p) % p; 
    } 
    
    
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int t = s.nextInt();
		fact(10000);
		for( int i=0; i<t; i++ ){
		    int n = s.nextInt();
		    int k = s.nextInt();
		    long sum = 0;
		    for( int j=0; j<=k; j++ ){
		    	long val = nCrModPFermat(n,j,mod);
		        sum = (sum%mod + val%mod)%mod;
		    	System.out.println(val+"-"+sum);

		    }
		    System.out.println(sum);
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
