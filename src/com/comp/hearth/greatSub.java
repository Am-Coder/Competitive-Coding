package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class greatSub {
	static int Row , Col ; 

	public static void main(String[] args) throws IOException {
		
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int[][] arr = new int[n][n];
		Row = n;
		Col = n;
		for( int i=0; i<n; i++ ) {
			for( int j=0; j<n; j++ ) {
				arr[i][j] = s.nextInt();
			}
		}
//		int[][] arr = {{2,5,3,8,3},{1,4,6,8,4},{3,6,7,9,5},{1,3,6,4,2},{2,6,4,3,1}};
		int ans = largestKSubmatrix(arr);
		System.out.println(ans*ans);
	}
    

    static int largestKSubmatrix(int [][]a) 
    { 
        int [][]dp = new int [Row][Col]; 
        int result = 0; 
        for (int i = 0 ;  
                 i < Row ; i++) 
        { 
            for (int j = 0 ; 
                     j < Col ; j++) 
            { 

                if (i == 0 || j == 0) 
                    dp[i][j] = 1; 
  
                else
                { 

                    if ( a[i][j] > a[i - 1][j] &&  
                        a[i][j] > a[i][j - 1] ) 
                    { 
                    dp[i][j] = (dp[i - 1][j] > dp[i][j - 1] && 
                                dp[i - 1][j] > dp[i - 1][j - 1] + 1) ?  
                                                        dp[i - 1][j] : 
                               (dp[i][j - 1] > dp[i - 1][j] &&  
                                dp[i][j - 1] > dp[i - 1][j - 1] + 1) ?  
                                                        dp[i][j - 1] : 
                                                 dp[i - 1][j - 1] + 1; 
                    }              
  

                    else dp[i][j] = 1; 
                } 
              
                result = result > dp[i][j] ? 
                                    result : dp[i][j]; 
            } 
        } 
        return result; 
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
