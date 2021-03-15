package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class stree {
    int[] st;
    
	public static void main(String[] args) throws Exception {
		
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int q = s.nextInt();
		int[] arr = new int[n];
		TreeSet<Integer> tset = new TreeSet<>();
		for( int i=0; i<n; i++ ){
		    
		    arr[i] = s.nextInt();
		    if( arr[i] == 1 ){
		        tset.add(i);
		    }
		    
		}
		
		
		
		for( int i=0 ; i<q; i++ ){
		    int a = s.nextInt();
		    int b = s.nextInt();
		    if( a == 0 ){
		        Integer ans = tset.lower(b);
		        
		        System.out.print(ans!=null?ans:-1);
		        System.out.print(" ");
		        ans = tset.higher(b);
		        
		        System.out.print(ans!=null?ans:-1 );
		        System.out.print("\n");
		        
		        
		    }else{
		        if(arr[b] == 0)
		            arr[b] = 1;
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
