package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class xorAndInsert1 {
	static class TrieNode{
	    
	    TrieNode[] child = new TrieNode[2];
	    boolean isLeaf;
	    
	    public TrieNode(){
	        child[0] = null;
	        child[1] = null;
	        isLeaf = false;
	    } 
	    
	    
	}
    static TrieNode root = new TrieNode();
    
    static int check(int N, int i){
        return (N & 1<<i)>0?1:0;
    }	
    	
    static void insert(int num){
        TrieNode cur = root;
        for( int i = 31; i>=0; i-- ){
            int f = check(num,i);
            if( cur.child[f] == null )
                cur.child[f] = new TrieNode();
            cur = cur.child[f];
        }
        
        cur.isLeaf = true;
    }	
    	
    	
    static long query( int val ){
    	
    	TrieNode cur = root;
    	long ans = 0;
    	for( int i=31; i>=0; i-- ) {
    		
    		int f = check(val,i);
    		if( cur.child[f] != null ) {
    			ans += 1<<i;
    			cur = cur.child[f];
    		}
    		else {
    			cur = cur.child[f^1];
    		}
    	}

    	return ans;
    }	
    	
    	
    public static void main(String args[] ) throws Exception {
        MyScanner s = new MyScanner();
        insert(10);
        insert(13);
        System.out.println(query(10));
        insert(9);
        insert(5);
        System.out.println(query(6));
        
        
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
		