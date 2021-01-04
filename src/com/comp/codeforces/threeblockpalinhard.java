package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class threeblockpalinhard {

	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int t = s.nextInt();
		while( t --> 0 ) {
			int n = s.nextInt();
			int[] arr = new int[n+1];
			int[][] pref = new int[201][n+1];
			ArrayList<Integer>[] ind = new ArrayList[201];
			for (int i = 0; i <= 200; i++)
				ind[i] = new ArrayList<Integer>();
			
			for( int i=1; i<n+1; i++ ) {
				arr[i] = s.nextInt();
				ind[arr[i]].add(i);
			}
			for( int i=1; i<n+1; i++ ) {
				pref[arr[i]][i] = pref[arr[i]][i-1]+1;
				for( int j=1; j<201; j++ ) {
					if( j!=arr[i])
						pref[j][i] = pref[j][i-1];
				}
			}
			
			int ans =0;
			for (int i = 1; i <= 200; i++) {
				ans = Math.max(ans, ind[i].size());
				for (int j = 1; j <= (ind[i].size() / 2); j++) {
					int l = ind[i].get(j - 1), r = ind[i].get(ind[i].size() - j);
					for (int k = 1; k <= 200; k++) {
						int val = pref[k][r - 1] - pref[k][l];
						ans = Math.max(ans, 2*j + val);
					}
				}
			}
			p.println(ans);
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
