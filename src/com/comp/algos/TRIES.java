package com.comp.algos;

import java.util.HashMap;

class Tnode{
	HashMap<Character,Tnode> children;
	boolean eow;
	public Tnode() {
		children = new HashMap<>();
		this.eow = false;
		
	}
}

//***********Array based trie is much faster then Hashmap based trie *************

class Trie{
	static Tnode root;
	
	public Trie() {
		this.root = new Tnode();
	}
	
	public void add(String s) {
		
		Tnode cur = root;
		int len = s.length();
		
		for( int i=0; i<len; i++ ) {
			char ch = s.charAt(i);
			  Tnode n = cur.children.get(s.charAt(i));
			  if(n == null) {
				  
				  n = new Tnode();
				  cur.children.put( ch, n );

			  }
			  cur = n;
		}
		
		cur.eow = true;
		
		
	}	
		
	public boolean search(String s) {
		
		Tnode cur = root;
		
		for( int i=0; i<s.length(); i++ ) {
			char ch = s.charAt(i);
			
			Tnode n = cur.children.get(ch);
			if(n==null) {
				return false;
			}
			cur = n;
		}
		return cur.eow;
		
	}	
	
	public boolean delete(String s) {
		return deleteUtil(root, s, 0);
	}
	
	public boolean deleteUtil( Tnode cur, String s, int ind ) {
		
		if( ind  == s.length() ) {
			
			if(!cur.eow) {
				return false;
			}
			
			cur.eow = false;
			return cur.children.size() == 0;
		}
		char ch = s.charAt(ind);
		Tnode n = cur.children.get(ch);
		if( n == null ) {
			return false;
		}
		
		boolean shouldDeleteCurrentNode = deleteUtil( n, s, ind + 1 );
//		System.out.println(shouldDeleteCurrentNode+"-"+ch);
		if( shouldDeleteCurrentNode ) {
			cur.children.remove(ch);
			if( cur.eow == false )
				return cur.children.size() == 0;
		}
		
		return false;
	}	
}

public class TRIES {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("Aman");
		t.add("Amani");
		t.add("Nikunj");
		System.out.println(t.search("Amani"));
		t.delete("Amani");
		System.out.println(t.search("Amani"));
		System.out.println(t.search("Aman"));

		
	}
}
