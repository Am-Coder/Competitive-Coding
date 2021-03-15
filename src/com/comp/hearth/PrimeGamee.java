package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrimeGamee {

    static int count = 0;
    static int max = 1000001;
    static int[] si = new int[max];
    
    public static void sieve(){
        si[0] = 1;
        si[1] = 1;
        
        for( int i=2; i*i<max; i++ ){
            
            if( si[i] == 0 ){
               for( int j=i*i; j<max; j+=i ){
                   si[j] = 1;
               } 
            }
            
        }   
    }
    static int solve(String str){
    	System.out.println(str);
        int len = str.length();
        if(len == 1 || si[Integer.parseInt(str)]==0){
            return -1;
        }
    
    
        return 1 + Math.min(solve(str.substring(0, len -1 )), solve(str.substring(1, len )));
        
    }




    public static void main(String[] args) throws Exception {
    	MyScanner s = new MyScanner();
        int t = s.nextInt();
        Print p = new Print();
        sieve();
        for( int i=0; i<t; i++ ){
            
            String str = s.nextLine();
            int n = solve(str);
            if(n%2 == 0) {
            	System.out.println("Bob-"+n);
            }else {
            	System.out.println("Alice-"+n);
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
