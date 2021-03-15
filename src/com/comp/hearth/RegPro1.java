package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

//class TrieNode{
//    TrieNode[] child = new TrieNode[26];
//    boolean isEnd;
//    int pcount;
//    public TrieNode(){
//        isEnd = false;
//        pcount = -1;
//    }
//}

//class Trie{
//    
//    TrieNode root = new TrieNode();
//    int count = 0;
//    public void insert( char[] arr ){
//        
//        TrieNode cur = root;
//        int val;
//        for( int i=0; i<arr.length; i++ ){
//            val = arr[i] - 'a';
//            if(cur.child[ val ] == null ){
//                cur.child[ val ] = new TrieNode();
//            }
//            cur = cur.child[ val ];
//        }
//        
//        cur.isEnd = true;
//        
//    }
//    
//    public void doer(char[] arr){
//        if( search(arr) ){
//            String str = String.valueOf(arr);
//            for( int i=0; i<count; i++ ){
//                str = str + String.valueOf(i);
//                arr = str.toCharArray();
//                if(!search(arr)){
//                    insert(arr);
//                    System.out.println(str);
//                    return;
//                }
//            }
//        }else{
//            insert(arr);
//            System.out.println(String.valueOf(arr));
//        }    
//    }
//    
//    public boolean search( char[] arr ){
//        TrieNode cur = root;
//        int val;
//        for( int i=0; i<arr.length; i++ ){
//            val = arr[i] - 'a' ;
//            if(cur.child[ val ] != null ){
//                cur = cur.child[ val ] ;
//            }else{
//                return false;
//            }   
//                
//        }       
//        return cur.isEnd;    
//    }       
//            
//            
//}
public class RegPro1 {
	
	
	
	static class TrieNode{
	    TrieNode[] child = new TrieNode[100];
	    boolean isEnd;
	    int pcount;
	    public TrieNode(){
	        isEnd = false;
	        pcount = -1;
	    }
	}

	static class Trie{
	    
	    TrieNode root = new TrieNode();
	    int count = 0;
	    public void insert( char[] arr ){
	        
	        TrieNode cur = root;
	        int val;
	        for( int i=0; i<arr.length; i++ ){
	            val = arr[i] - '0';
	            if(cur.child[ val ] == null ){
	                cur.child[ val ] = new TrieNode();
	            }
	            cur = cur.child[ val ];
	        }
	        count++;
	        cur.isEnd = true;
	        
	    }
	    
	    public void doer(char[] arr){
	        if( search(arr) ){
	            String str = String.valueOf(arr);
	            for( int i=0; i<count; i++ ){
	                String st = str + String.valueOf(i);
	                arr = st.toCharArray();
	                if(!search(arr)){
	                    insert(arr);
	                    System.out.println(st);
	                    return;
	                }
	            }
	        }else{
	            insert(arr);
	            System.out.println(String.valueOf(arr));
	        }    
	    }
	    
	    public boolean search( char[] arr ){
	        TrieNode cur = root;
	        int val;
	        for( int i=0; i<arr.length; i++ ){
	            val = arr[i] - '0' ;
	            if(cur.child[ val ] != null ){
	                cur = cur.child[ val ] ;
	            }else{
	                return false;
	            }   
	                
	        }       
	        return cur.isEnd;    
	    }       
	            
	            
	}
	
	
	
	
	public static void main(String[] args) {
		
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		Trie t = new Trie();
		String sa;
		PrintWriter p = new PrintWriter(System.out);
		for( int i=0; i<n; i++ ) {
			sa = s.nextLine();
			t.doer(sa.toCharArray());
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
