package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class LittleDepuAndArray {

	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int[] arr = new int[n];
		TreeSet<Integer> tset = new TreeSet<>();
		
		for( int i=0; i<n; i++ ) {
			
			arr[i] = s.nextInt();
			
		}
		
		int q = s.nextInt();
		int a;
		for( int i=0; i<q; i++ ) {
			
			a = s.nextInt(); 
			for( int j=0; j<n; j++ ) {
				if( arr[j]>a ) {
					arr[j]-- ;
				}
			}
			
		}
		
		for( int i=0; i<n; i++ ) {
			System.out.print(arr[i] + " ");
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
