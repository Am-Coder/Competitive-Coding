package com.comp.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//0-1 knapsack problem
public class Knapsack {
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner() ;
		Print  p = new Print() ;
		int t = s.nextInt();
		for( int h=0; h<t; h++ ){
		    int n = s.nextInt();
		    int W = s.nextInt();
		    int[] v = new int[n+1];
		    int[] w = new int[n+1];
		    
		    for( int j=1; j<=n; j++ )
		        w[j] = s.nextInt();
		    
		    for( int j=1; j<=n; j++ )
		        v[j] = s.nextInt();
		        
	        int[][] dp = new int[n+1][W+1];
	        for( int i=1; i<=n; i++ ){
	            
	            for( int j=1; j<=W; j++ ){
	                
	                if( j<w[i] ){
	                    dp[i][j] = dp[i-1][j];
	                }else{
	                    dp[i][j] = Math.max( dp[i-1][j], dp[i-1][j - w[i] ] + v[i]);
	                }
	                
	            }
	        }
	        
	        p.println(dp[n][W]);
		}
		p.close();
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
