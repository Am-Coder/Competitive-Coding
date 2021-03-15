package com.comp.hearth;

import java.util.*;
import java.io.*;

public class RepeatKtimes {

	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
        Print p = new Print();
        int n = s.nextInt();
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        for( int i=0; i<n; i++ ){
            int a = s.nextInt();
            if ( tmap.containsKey(a)) {
            	tmap.replace(a, tmap.get(a)+1);
            	
            }else {
            	tmap.put(a, 1);
            }
        }
        int k = s.nextInt();
        for( int key: tmap.keySet()) {
        	if(tmap.get(key) == k) {
        		p.println(key);
        		break;
        	}
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
