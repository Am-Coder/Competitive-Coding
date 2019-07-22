package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class limitedEdietion {
    public static void main(String args[] ) throws Exception {
        
        MyScanner s = new MyScanner();
        int a = s.nextInt();
        String[] arr = new String[a];
        
        for(int i=0; i<a; i++){
            arr[i] = s.nextLine();
            
        }
        
        Arrays.sort(arr, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				int a = arg0.length() - arg1.length();
				
				if(a == 0) {
					return -arg0.compareTo(arg1);
				}
				return a;
			}
            
        });

        int q = s.nextInt(),c;
        for(int i=0; i<q; i++){
            c = s.nextInt();
            System.out.println(arr[c - 1]);
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
