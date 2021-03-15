package com.comp.algos;


//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class MaxPathSumInBinaryTree {
	
	static class Node {
		
		int data;
		
		Node left;
		
		Node right;
		
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static Node buildTree(String str) {
		
		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}
		
		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		// Starting from the second element
		
		int i = 1;
		while (queue.size() > 0 && i < ip.length) {
			
			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();
			
			// Get the current node's value from the string
			String currVal = ip[i];
			
			// If the left child is not null
			if (!currVal.equals("N")) {
				
				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}
			
			// For the right child
			i++;
			if (i >= ip.length)
				break;
			
			currVal = ip[i];
			
			// If the right child is not null
			if (!currVal.equals("N")) {
				
				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));
				
				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}
		
		return root;
	}
	
	static void printInorder(Node root) {
		if (root == null)
			return;
		
		printInorder(root.left);
		System.out.print(root.data + " ");
		
		printInorder(root.right);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
	
		while (t > 0) {
			String s = br.readLine();
			Node root = buildTree(s);
			
			Tree g = new Tree();
			System.out.println(g.maxPathSum(root));
			t--;
		}
	}
	//} Driver Code Ends
	
	static class Tree {
		
		static class Res {
			
			int val = Integer.MIN_VALUE;
		}
		
		int maxPathSum(Node root) {
			Res res = new Res();
			util(root, res);
			return res.val;
		}
		
		int util(Node root, Res res) {
			if (root == null)
				return 0;
			
			if (root.left == null && root.right == null)
				return root.data;
			
			int ls = util(root.left, res);
			int rs = util(root.right, res);
			if (root.left != null && root.right != null) {
				res.val = Math.max(res.val, rs + ls + root.data);
				return Math.max(ls, rs) + root.data;
			}
			
			return root.left == null ? rs + root.data : ls + root.data;
		}
	}
}

//User function Template for Java

/* class Node
{
 int data;
 Node left, right;

 Node(int item)
 {
     data = item;
     left = right = null;
 }
} */

