package com.comp.algos.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


//***********Array based trie is much faster then Hashmap based trie *************

class TrieNode2{
    // HashMap<Character, TrieNode> child = new HashMap<>();
    TrieNode2[] child = new TrieNode2[26];
    boolean isEnd;
    int pcount;
    public TrieNode2(){
        isEnd = false;
        pcount = 1;
    }
}

class Trie2{
    
    TrieNode2 root = new TrieNode2();
    public void insert( char[] arr ){
        
        TrieNode2 cur = root;
        int val;
        for( int i=0; i<arr.length; i++ ){
            val = arr[i] - 'a';
            if(cur.child[ val ] == null ){
                cur.child[ val ] = new TrieNode2();
            }
            cur = cur.child[ val ];
            cur.pcount ++;
        }
        
        cur.isEnd = true;
        
    }
    
    public int search( char[] arr ){
        TrieNode2 cur = root;
        int val;
        for( int i=0; i<arr.length; i++ ){
            val = arr[i] - 'a';
            if(cur.child[ val ] != null ){
                cur = cur.child[ val ] ;
            }else{
                return 0;
            }   
                
        }       
        return cur.pcount-1;    
    }       
            
            
} 
public class TriesPrefix {
	public static void main(String[] args) {
		
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		Trie2 t = new Trie2();
		char[] arr;
		String sa;
		PrintWriter p = new PrintWriter(System.out);
		for( int i=0; i<n; i++ ) {
		    sa = s.next();
		    if(sa.equals("add")){
		        t.insert(s.next().toCharArray());
		    }else{
		        p.println(t.search(s.next().toCharArray()));
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
