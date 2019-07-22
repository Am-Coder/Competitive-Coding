package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14 {
    public static void main(String args[] ) throws Exception {
        MyScanner s = new MyScanner();
        int a = s.nextInt(),count=0;
        for(int i=0 ; i<a ; i++){
            int b = s.nextInt(),min;
            min = s.nextInt();
            count = 1;
//            arr.add(min);
//            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0 ; j<b-1 ; j++){
                int c = s.nextInt();
                if(c<min){
                    min = c;
                    count = 1;
                }else if(c == min){
                    count+=1;
                }
//                arr.add(c)
            }
//            System.out.println(count);
            if(count % 2 != 0 )
            	System.out.println("Lucky");
            else
            	System.out.println("Unlucky");
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
