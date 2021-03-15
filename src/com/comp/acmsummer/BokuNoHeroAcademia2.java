package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BokuNoHeroAcademia2 {
    public static void main(String args[] ) throws Exception {
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        int q = s.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
//        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        HashMap<Double,LinkedList<Pair>> hm = new HashMap<Double,LinkedList<Pair>>();
//        HashMap<String,LinkedList<Pair>> hm = new HashMap<String,LinkedList<Pair>>();

        for( int i=0; i<n; i++){
            arr1[i] = s.nextInt();
        }
        for( int i=0; i<n; i++){
            arr2[i] = s.nextInt();   
        }
        Arrays.sort(arr1);
//        System.out.print(arr1[0]);
        for( int i=0; i<n; i++){
        	int val = arr1[i];
        	for(int j=0; j<n; j++) {
        		double fl = ((double)val)/((double)(arr2[j]));
//        		int g = gcd(val,arr2[j]);
//        		String fl = (val/g)+"/"+(arr2[j]/g);
        		LinkedList<Pair> ll = hm.getOrDefault(fl, new LinkedList<Pair>());
        		ll.add(new Pair(val, arr2[j]));
        		hm.put(fl, ll);
        	}
            
        }

        int c,d,k;
        double key;
//        String key;
        for( int i=0; i<q; i++){
            
        	c = s.nextInt();
            d = s.nextInt();
            k = s.nextInt();
            key = (double)c/(double)d;
//            int g = gcd(c,d);
//            key = c/g+"/"+d/g;
            if(hm.containsKey(key)) {
            	LinkedList<Pair> ll = hm.get(key);
            	try {
            		Pair p = ll.get(k-1);
            		System.out.println(p.x + " " + p.y );
            	}catch(Exception e) {
            		System.out.println("NIE");
            	}
            }

        }
    }
    
//    static int gcd(int a, int b){
//        if(b == 0)
//            return a;
//        return gcd(b, a%b);
//    }
    static class Pair{
        
        long x;
        long y;
        
        public  Pair(long x, long y){
            this.x = x;
            this.y = y;
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
