package com.comp.algos;


public class BSTnodeRange {
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node( int data ) {
			
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BST{
		
		Node root;
		
		public BST(int data) {
			this.root = new Node(data);
		}
		
		public Node addRecursively(Node cur, int data) {
			
			if(cur == null) {
				return new Node(data);
			}
			
			if(data>cur.data)
				cur.right = addRecursively( cur.right, data );
			
			else 
				cur.left = addRecursively( cur.left, data );
			
			return cur;
		}
		
		public void add(int data) {
			
			addRecursively(this.root, data);
		}
		
		public int countNodeInRange(int l, int r, Node cur) {
			
			
			if(cur == null) {
				return 0;
			}
			
			if( cur.data<=r && cur.data>=l ) {
				
				return 1 + countNodeInRange(l,r,cur.left)+countNodeInRange(l,r,cur.right);
				
			}else if(cur.data<l) {
				return countNodeInRange(l,r,cur.right);
			} else {
				return countNodeInRange(l, r, cur.left);
			}
		}
		
		public int distanceBtwTwoNodes(int a, int b, Node cur) {
			
			if (a < cur.data && b < cur.data) {
				return distanceBtwTwoNodes(a, b, cur.left);
			} else if (a > cur.data && b > cur.data) {
				return distanceBtwTwoNodes(a, b, cur.right);
			} else {
				//Common Ancestor Found
				return findDistFromRoot(cur, a) + findDistFromRoot(cur, b);
			}
		}
		
		public int findDistFromRoot(Node root, int a) {
			if (root.data == a)
				return 0;
			
			if (a > root.data) {
				return 1 + findDistFromRoot(root.right, a);
			} else {
				return 1 + findDistFromRoot(root.left, a);
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		BST tree = new BST(4);
		tree.add(5);
		tree.add(10);
		tree.add(9);
		tree.add(2);
		tree.add(6);
		tree.add(7);
		tree.add(20);
		System.out.println(tree.countNodeInRange(7, 10, tree.root));
		System.out.println(tree.findDistFromRoot(tree.root, 20));
		System.out.println(tree.distanceBtwTwoNodes(20, 20, tree.root));
		
	}
}
