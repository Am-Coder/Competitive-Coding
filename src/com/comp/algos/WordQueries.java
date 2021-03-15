package com.comp.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class TrieNode{
    HashMap<Character, TrieNode> child = new HashMap<>();
    boolean isEnd;
    int pcount;
    public TrieNode(){
        isEnd = false;
        pcount = 1;
    }
}

class Trie1{
    
    TrieNode root = new TrieNode();
    public void insert( char[] arr ){
        
        TrieNode cur = root;
        
        for( int i=0; i<arr.length; i++ ){
   
            if(!cur.child.containsKey(arr[i])){
                cur.child.put(arr[i],new TrieNode());
            }
            cur = cur.child.get(arr[i]);
            cur.pcount ++;
        }
        
        cur.isEnd = true;
        
    }
    
    public int search( char[] arr ){
        TrieNode cur = root;
        for( int i=0; i<arr.length; i++ ){
                
            if( cur.child.containsKey(arr[i]) ){
                cur = cur.child.get(arr[i]);
            }else{
                return 0;
            }   
                
        }       
        return cur.pcount-1;    
    }       
            
            
}

//Insertion in trie and then finding number of words with given prefix
//***********Array based trie is much faster then Hashmap based trie *************
public class WordQueries {
	public static void main(String[] args) {
		
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int q = s.nextInt();
		Trie1 t = new Trie1();
		char[] arr;
		PrintWriter p = new PrintWriter(System.out);
		for( int i=0; i<n; i++ ) {
			arr = s.nextLine().toCharArray();
			t.insert(arr);
		}
		for( int i=0; i<q; i++ ) {
			arr = s.nextLine().toCharArray();
			p.println(t.search(arr));
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


