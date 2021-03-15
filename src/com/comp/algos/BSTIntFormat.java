package com.comp.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BSTIntFormat {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		BST bst = new BST();
		Node root = bst.root;
		
		for(int i=0; i<a; i++) {
			bst.add( s.nextInt() );
		}		
	}
	
	static boolean check2treesAreMirror(Node n1, Node n2) {
		if( n1 == null && n2 == null )
			return true;
		
		if( n1 == null || n2 == null ) {
			return false;
		}
		
		return n1.val == n2.val && check2treesAreMirror(n1.left, n2.right) && check2treesAreMirror(n1.right, n2.left);
	}
	static public class Node {
		
		Node left;
		Node right;
		int val;
		
		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
		
	}



	static public class BST {
		Node root ;
		
		
		public BST() {
			this.root = null;
		}

		public BST(Node root) {
			super();
			this.root = root;
		}
		
		private Node addRecursive(Node current, int value) {
		    if (current == null) {
		        return new Node(value);
		    }
		 
		    if (value<=(current.val)) {
		        current.left = addRecursive(current.left, value);
		    } else if (value > (current.val) ) {
		        current.right = addRecursive(current.right, value);
		    } else {
		        // value already exists
		        return current;
		    }
		 
		    return current;
		}
		public void add(int value) {
		    root = addRecursive(this.root, value);
		}
		
		//Height of BST
		public int getHeight(Node nd) {
			
			if(nd == null)
				return 0;
			return 1 + max(getHeight(nd.left),getHeight(nd.right));
		}
		
		
		//Minimum element in BST
		public int findMin(Node nd) {
			if(nd.left == null)
				return nd.val;
			return findMin(nd.left);
			
		}
		
		//Maximum element in BST
		public int findMax(Node nd) {
			if(nd.right == null)
				return nd.val;
			return findMax(nd.right);
			
		}	
		
		public int max(int a, int b) {
			if(a < b)
				return b;
			else 
				return a;
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
