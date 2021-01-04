package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;


public class threeblockpalin {

	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int t = s.nextInt();
		while( t --> 0 ) {
			int n = s.nextInt();
			int[] arr = new int[n+1];
			int[][] pref = new int[27][n+1];
			for( int i=1; i<n+1; i++ ) {
				arr[i] = s.nextInt();
			}
			int max = Integer.MIN_VALUE;
			for( int i=1; i<n+1; i++ ) {
				for( int j=1; j<n+1; j++ ) {
					
					pref[arr[i]][j] = arr[i]==arr[j]?pref[arr[i]][j-1]+1:pref[arr[i]][j-1];
				}
//				pref[arr[i]][i]++;
				max = Math.max(max, pref[arr[i]][i]);
			}
			int ans =0;
//			for( int i=1; i<27; i++ ) {
//				for( int j=1; j<n+1; j++ ) {
//					System.out.print(pref[i][j]+" ");
//				}
//				System.out.println("");
//			}
			for( int i=1; i<n+1; i++) {
				
				for( int j=i; j<n+1; j++ ) {
					int cnt1 = 0;
					int cnt2 = 0;
					for( int k=1; k<27; k++ ) {
						cnt1 = Math.max(cnt1, pref[k][j] - pref[k][i-1]);
						cnt2 = Math.max(cnt2, Math.min(pref[k][i-1], pref[k][n] - pref[k][j]));
					}
					ans = Math.max(ans, cnt1 + 2*cnt2);	
				}
				
			}
			p.println(Math.max(max, ans));
		}
		p.close();
	}
	
	public static class Pair implements Comparable<Pair> {
		int first;
		int second;
		
		public Pair( int a, int b ) {
			this.first = a;
			this.second = b;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.first - first;
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
