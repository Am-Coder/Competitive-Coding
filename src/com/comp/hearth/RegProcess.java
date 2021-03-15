package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RegProcess {
	public static void main(String[] args) {
		
		MyScanner s = new MyScanner();
		int n = s.nextInt();
//		Trie t = new Trie();
		HashSet<String> hmap = new HashSet<>();
//		char[] arr;
		String sa;
		PrintWriter p = new PrintWriter(System.out);
		for( int i=0; i<n; i++ ) {
		    sa = s.nextLine();
		  //  t.insert(sa.toCharArray());
		    if(hmap.contains(sa)){
//		        Set<String> set = hmap.keySet();
		        String str;
		        for( int k=0; k<hmap.size(); k++ ){
		            str = sa + String.valueOf(k);
		            if(!hmap.contains(str)) {
		            	hmap.add(str);
		            	System.out.println(str);
		            	break;
		            }
		        }
		    }else{
		        hmap.add(sa);
		        System.out.println(sa);
		    }
		}
		p.close();
		
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
