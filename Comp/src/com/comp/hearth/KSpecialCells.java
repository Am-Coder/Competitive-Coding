package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KSpecialCells {
	static int max = (int )1e9 + 7;
	static long sum = 0;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		Print p = new Print();
		
		int t = s.nextInt();
		for( int i=0; i<t; i++ ){
		    N = s.nextInt();
		    M = s.nextInt();
		    int k = s.nextInt();
		    int[][] arr = new int[N][M];
		    sum = 0;
		    for( int j=0; j<k; j++ ){
		        arr[s.nextInt()-1][s.nextInt()-1] = s.nextInt();
		    }
		    calc( arr, 0, 0 );
		    p.print(sum);
		}
		p.close();
	}
	
	public static void calc( int[][] arr, int n, int m ){
	    if( n == N-1 && m == M-1 ){
	        sum += arr[n][m];
	        return;
	    }
	    
	    sum += (long)arr[n][m];
	    if( n+1 <= N - 1){
	        calc( arr, n+1, m );     
	    }
	    
	    if( m+1 <= M - 1 ){
	        calc( arr, n, m+1 );
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
