package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import com.comp.hearth.basecode.MyScanner;

public class Hari {
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int d = s.nextInt();
		int p = s.nextInt();
		int k = s.nextInt();
		
		int[] D = new int[n];
		int[] P = new int[n];
		for( int i=0; i<n; i++ ) {
			D[i] = s.nextInt();
		}
		for( int i=0; i<n; i++ ) {
			P[i] = s.nextInt();
		}
		
		int[][] dp = new int[n+1][d+1];
		for( int i=0; i<=n; i++ ) {
			dp[i][0] = 0;
		}
		for( int i=1; i<=d; i++ ) {
			if( i<=p )
				dp[0][i] = i;
			else
				dp[0][i] = p+ (i-p)*5;
		}
		
		for( int i=1; i<=d; i++ ) {
			
			for( int j=1; j<=n; j++ ) {
				if( p < D[j] && D[j] < j ) {
					
//					dp[i][j] = Math.min( , );
					
				}else if( p < D[j] && p < j ) {
					
					
					
				}	
			}
			
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
