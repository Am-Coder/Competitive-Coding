package com.comp.hearth;

import java.util.*;
import java.io.*;

public class rooms {

	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
        Print p = new Print();
        int t = s.nextInt();
        for( int l=0; l<t; l++ ){
            int n = s.nextInt();
            int[] arr = new int[n];
            int[] dep = new int[n];
            for( int j=0; j<n; j++ ){
                arr[j] = s.nextInt();
            }
            for( int j=0; j<n; j++ ){
                dep[j] = arr[j]+s.nextInt();
            }
            Arrays.sort(arr);
            Arrays.sort(dep);
            int guests_in = 1, max_guests = 1, time = arr[0]; 
            int i = 1, j = 0; 
            while (i < n && j < n) 
            { 
                if (arr[i] < dep[j]) 
                { 
                    guests_in++; 
        
                    if (guests_in > max_guests) 
                    { 
                        max_guests = guests_in; 
                        time = arr[i]; 
                    } 
                    i++; 
                } 
                else  
                {  
                    guests_in--; 
                    j++; 
                } 
            } 
            p.println(max_guests);
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
