package com.comp.hearth;

import java.util.*;
import java.io.*;

public class FallingEagle {


	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
        Print p = new Print();
        int t = s.nextInt();
        for( int i=0; i<t; i++ ){
            int n=s.nextInt();
            boolean bol[] = new boolean[n];
            Pair[] ar1 = new Pair[n];
            int[] ori = new int[n];
            for( int j=0; j<n; j++ ){
                bol[j] = false;
                ori[j] = s.nextInt();
                ar1[j] = new Pair(ori[j],j);
            }
            Arrays.sort(ar1);
            long sum=0;
            int min;
            for( int j=0; j<n; j++ ){
            	min = Integer.MAX_VALUE;
                bol[ar1[j].second] = true;
                if( ar1[j].second+1<n ){
                    int k= ar1[j].second+1;
                    while(k<n && bol[k] != false )
                        k++;
                    min = k<n ?ori[k]:min;
                }
                    
                if( ar1[j].second -1 >=0 ){
                    int k= ar1[j].second-1;
                    while( k >= 0 && bol[k] != false )
                        k--;
                    min = k >= 0 ? Math.min(ori[k],min):min;    
                }
//                System.out.println(min);
                if( min != Integer.MAX_VALUE )
                	sum += (long)min;
            }
            p.println(sum);
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
			return first - o.first;
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
