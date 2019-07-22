package com.comp.algos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fermat_nCr {
    
    static int max = (int)1e9 + 7 ;
    static int[] arr ;
    static void fact(int n){
        arr = new int[n+1];
        arr[0] = 1;
        
        for( int i=1; i<=n; i++ ){
            arr[i] = (i*arr[i-1])%max;
        }
        
    }
    
    static int power( int x, int y, int p ) {
    	
    	int res = 1;
    	x = x%p;
    	
    	while( y > 0 ) {
    		
    		if( y%2 == 1 ) {
    			res = (res*x)%p;
    		}
    		
    		y = y >> 1;
    		x = (x*x)%p;
    		
    		
    	}
    	return res;
    }
    
    static int modInverse( int n, int p ) {
    	return power(n,p-2,p);
    }
    
    static int nCrmodPFermat(int n, int r, int p) {
    	
    	if(r==0)
    		return 1;
    	
//    	for( int i=1; i<=n; i++ ) {
//    		
//    	}
    	return (arr[n]*modInverse(arr[r], p)%p*modInverse(arr[n-r],p)%p)%p;
    }

    
    
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		fact(1000);
		System.out.println(arr[10]+"-"+arr[2]);
		System.out.println(nCrmodPFermat(10, 2, max));
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
