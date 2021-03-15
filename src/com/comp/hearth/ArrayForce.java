package com.comp.hearth;

import java.util.*;
import java.io.*;
public class ArrayForce {

	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		Print p = new Print();
        int t = s.nextInt();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for( int i=0; i<t; i++ ){
        	hmap.clear();
            int a0= s.nextInt();
            int a1= s.nextInt();
            int n= s.nextInt();
            int mod= s.nextInt();
            hmap.put(a0,1);
            if (hmap.containsKey(a1)){
            	hmap.replace(a1 , hmap.get(a1)+1);
            }else
            	hmap.put(a1,1);
            for( int j=0; j<n-2; j++ ){
                int temp = a1;
                a1 = (a1 + a0)%mod;
                a0 = temp;
                if( hmap.containsKey(a1) ){
                    hmap.replace(a1 , hmap.get(a1)+1);
                }else{
                    hmap.put(a1, 1);
                }
            }
            Set<Integer> ks = hmap.keySet();
            long sum =0;
            for( int key: ks ) {
            	sum += (long)((long)hmap.get(key)*(long)hmap.get(key));
            }
            p.println(sum);
        }
        p.close();
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
