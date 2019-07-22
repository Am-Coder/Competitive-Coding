package com.comp.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BSTformat {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		BST<Integer> bst = new BST<>();
		
		for(int i=0; i<a; i++) {
			bst.add( s.nextInt() );
		}
	}
	
	
	static public class Node<E extends Comparable<E>> {
		
		Node<E> left;
		Node<E> right;
		E val;
		
		public Node(E val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
		
	}



	static public class BST<E extends Comparable<E>> {
		Node<E> root ;
		
		
		public BST() {
			this.root = null;
		}

		public BST(Node<E> root) {
			super();
			this.root = root;
		}
		
//		public Node<E> add(Node<E> root,E value) {
//			if(root == null) {
//				root = new Node<>(value) ;
//				return root;
//			}
//			Node<E> nd = root;
//			
//			System.out.print(value.compareTo(nd.val));
//			while(nd != null) {
//				if(value.compareTo(nd.val) <= 0) {
//					nd = nd.left;
//				}else {
//					nd = nd.right;
//				}
//			}
//			nd = new Node<>(value);
//			return root;
//		}
		private Node<E> addRecursive(Node<E> current, E value) {
		    if (current == null) {
		        return new Node<E>(value);
		    }
		 
		    if (value.compareTo(current.val) <= 0) {
		        current.left = addRecursive(current.left, value);
		    } else if (value.compareTo(current.val) > 0) {
		        current.right = addRecursive(current.right, value);
		    } else {
		        // value already exists
		        return current;
		    }
		 
		    return current;
		}
		public void add(E value) {
		    root = addRecursive(this.root, value);
		}
		
		//Height of BST
		public int getHeight(Node<E> nd) {
			
			if(nd == null)
				return 0;
			return 1 + max(getHeight(nd.left),getHeight(nd.right));
		}
		
		
		//Minimum element in BST
		public E findMin(Node<E> nd) {
			if(nd.left == null)
				return nd.val;
			return findMin(nd.left);
			
		}
		
		//Maximum element in BST
		public E findMax(Node<E> nd) {
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
