package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class numtheoryq8 {

    public static void main(String args[] ) throws Exception {
        MyScanner s = new MyScanner();
        int a = s.nextInt();
        PrintWriter out;
        for(int i = 0 ; i < a ; i++){
            long c = s.nextInt();
            long d = s.nextInt();
            long k=0;
            long ans = -1;
            for(long j=0; j<d ; j++){
                if((j*j)%d==c){
                    ans=j;
                    break;
                }
            }            
            System.out.println(ans);
            
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
