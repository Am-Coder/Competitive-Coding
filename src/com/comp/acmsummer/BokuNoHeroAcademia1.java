package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BokuNoHeroAcademia1 {
    public static void main(String args[] ) throws Exception {
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        int q = s.nextInt();
        long[] arr1 = new long[n];
        long[] arr2 = new long[n];
        HashMap<Long,Long> hmap = new HashMap<Long,Long>();
        for( int i=0; i<n; i++){
            arr1[i] = s.nextInt();
        }
        
        for( int i=0; i<n; i++){
            arr2[i] = s.nextInt();
            hmap.put(arr2[i], hmap.getOrDefault(arr2[i], 0l)+1);

            
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        long num1,check,in,c,d,k;
        double val;
        for( int i=0; i<q; i++){
            c = s.nextInt();
            d = s.nextInt();
            k = s.nextInt();
            check = 0;

            for( int j=0; j<n; j++){
                
                num1 = arr1[j];
                val =((double)d*(double)num1);
                val /= (double)c;
                if( Math.floor(val) == Math.ceil(val)) {
	                in = Arrays.binarySearch(arr2,(long)val);
	                if( in >= 0 ){
	                    check += hmap.get((long)val);
	                    if(check >= k){
	                        System.out.println(num1+" "+(long)val);
	                        break;
	                    }
	                }
                }
               
                
            }
            
            if( check < k){
                System.out.println("NIE");
            }

        }
    }
    
    static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
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
