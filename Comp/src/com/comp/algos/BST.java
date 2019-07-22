package com.comp.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node<E extends Comparable<E>> {
	
	Node<E> left;
	Node<E> right;
	E val;
	
	public Node(E val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
}



public class BST<E extends Comparable<E>> {
	Node<E> root ;
	
	
	public BST() {
		this.root = null;
	}

	public BST(Node<E> root) {
		super();
		this.root = root;
	}
	
//	public Node<E> add(Node<E> root,E value) {
//		if(root == null) {
//			root = new Node<>(value) ;
//			return root;
//		}
//		Node<E> nd = root;
//		
//		System.out.print(value.compareTo(nd.val));
//		while(nd != null) {
//			if(value.compareTo(nd.val) <= 0) {
//				nd = nd.left;
//			}else {
//				nd = nd.right;
//			}
//		}
//		nd = new Node<>(value);
//		return root;
//	}
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
	
	//Insertion in BST
	public void add(E value) {
	    root = addRecursive(this.root, value);
	}
	
	//Deletion in BST
	public Node<E> deleteRecursive(Node<E> node,E value) {
		
		if(node == null)
			return null;
		
		if(node.val.compareTo(value) == 0) {
			
			if(node.left == null && node.right == null) {
				return null;
			}
			else if(node.left != null && node.right == null) {
				return node.left;
			}
			else if( node.left == null && node.right != null) {
				return node.right;
			}else {
				E min = findMin(node.right);
				node.val = min;
				node.right = deleteRecursive(node.right,min);
				return node;
			}
			
		}
		
		
		if(node.val.compareTo(value) < 0) {
			node.right = deleteRecursive(node.right, value);
			return node;
		}
		node.left = deleteRecursive(node.left, value);
		return node;		

	}
	public void delete(E value) {
	    root = deleteRecursive(this.root, value);
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
	
	//Inorder Traversal ---> DFS
	public void inorder(Node<E> node) {
		if(node != null) {
			inorder(node.left);
			System.out.println(node.val);
			inorder(node.right);
		}
	}
	//Postorder Traversal ---> DFS
	public void postorder(Node<E> node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.val);
		}
	}
	//Preorder Traversal ---> DFS
	public void preorder(Node<E> node) {
		if(node != null) {
			System.out.println(node.val);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	// Levelorder Traversal ---> BFS
	public void levelorder(Node<E> node) {
		Queue<Node<E>> q = new LinkedList<>();
		q.add(node);
		while(q.isEmpty() != true) {
			Node<E> n = q.poll();
			if(n.left != null)
				q.add(n.left);
			if(n.right != null)
				q.add(n.right);
			
			System.out.print(n.val);
			}
	}
	
	//Search an element
	public boolean find(Node<E> node,E val) {
		if(node == null)
			return false;	
		if( node.val == val )
			return true;

		if(val.compareTo(node.val)>0)
			return find(node.right, val);
		else 
			return find(node.left, val);

	}
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		BST<Integer> bst = new BST<>();
		
		for(int i=0; i<a; i++) {
			bst.add( s.nextInt() );
		}
		System.out.println(bst.find(bst.root, 6));
		bst.delete( 6);
		System.out.println(bst.root.val);
		System.out.println(bst.find(bst.root, 6));
	}
	
	
	
	
	
	public int max(int a, int b) {
		if(a < b)
			return b;
		else 
			return a;
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
