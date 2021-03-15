package com.comp.algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinTree {
	
}

class View {
	
	static class Node {
		
		int data;
		
		Node left, right;
		
		Node(int item) {
			data = item;
			left = right = null;
		}
	}
	static class QNode {
		
		Node n;
		
		int hd;
		
		QNode(Node n, int hd) {
			this.n = n;
			this.hd = hd;
		}
	}
	
	// function should print the topView of the binary tree
	static void topView(Node root) {
		TreeMap<Integer, Integer> hm = new TreeMap<>();
		Queue<QNode> q = new LinkedList<>();
		ArrayList<QNode> arr = new ArrayList<>();
		q.add(new QNode(root, 0));
		while (!q.isEmpty()) {
			QNode qn = q.poll();
			arr.add(qn);
			if (qn.n.left != null)
				q.add(new QNode(qn.n.left, qn.hd - 1));
			
			if (qn.n.right != null)
				q.add(new QNode(qn.n.right, qn.hd + 1));
		}
		
		for (int i = 0; i < arr.size(); i++) {
			QNode qn = arr.get(i);
			if (!hm.containsKey(qn.hd)) {
				hm.put(qn.hd, qn.n.data);
			}
		}
		
		for (int key : hm.keySet()) {
			System.out.print(hm.get(key) + " ");
		}
		System.out.println("");
	}
	
}
