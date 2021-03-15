package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class q19 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		BST bst = new BST();
		
		for(int i=0; i<a; i++) {
			bst.add( s.nextInt() );
		}
		Node root = bst.root;

		int st = s.nextInt() ;
		int end = s.nextInt() ;
//		System.out.println(st+" "+end);
		System.out.println(bst.findMaxBetween(root, st, end));
		

		
		
		
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
		
		public int findMaxBetween(Node root,int val1, int val2) {
			int max = root.val ;
//			int max2 = max1;
			Node nd1 =root;
			Node nd2 = root;
			
			while((nd1.val > val1 && nd2.val > val2)||(nd1.val <  val1 && nd2.val < val2)) {
				
				if(nd1.val > val1 && nd2.val > val2) {
					nd1 = nd1.left ;
					nd2 = nd2.left ;
				}else if(nd1.val <  val1 && nd2.val < val2) {
					nd1 = nd1.right;
					nd2 = nd2.right;
				}
			}

			if( val1 > nd1.val ) {
				nd1 = nd1.right ;
				if(nd1.val > max)
					max = nd1.val;
				while(nd1.val != val1) {
					if(val1 > nd1.val) {
						nd1 = nd1.right;
					}else { 
						nd1 = nd1.left;
					}
					if(nd1.val > max)
						max = nd1.val;
				}
				
			}else if( val2 > nd2.val )	{
				nd2 = nd2.right ;
				if(nd2.val > max)
					max = nd2.val;
				while(nd2.val != val2) {
					if(val2 > nd2.val) {
						nd2 = nd2.right;
					}else { 
						nd2 = nd2.left;
					}
					if(nd2.val > max)
						max = nd2.val;
				}
			}
			return max;
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
