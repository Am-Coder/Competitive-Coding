package com.comp.algos;

import java.util.HashMap;

public class DuplicateSubtree {
	
	static HashMap<String, Integer> hm = new HashMap<>();
	
	public static boolean dupSub(Node root) {
		hm.clear();
		uponUs(root);
		for (String str : hm.keySet()) {
			if (hm.get(str) > 1 && str.length() > 3) {
				return true;
			}
		}
		return false;
	}
	
	public static String uponUs(Node root) {
		if (root == null)
			return "$";
		String str = "";
		str += String.valueOf(root.data);
		str += uponUs(root.left);
		str += uponUs(root.right);
		hm.put(str, hm.getOrDefault(str, 0) + 1);
		
		return str;
	}
	
	static class Node {
		
		char data;
		
		Node left, right;
		
		Node(char key) {
			data = key;
			left = right = null;
		}
	}
}
