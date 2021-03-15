package com.comp.algos;

import java.util.HashMap;
import java.util.Stack;

public class NextSmall_InArray {
	
	public static void nextSmallest(int[] arr, int n) {
		Stack<Integer> st = new Stack<>();
		HashMap<Integer, Integer> sol = new HashMap<>();
		st.push(arr[0]);
		
		for (int i = 1; i < n; i++) {
			
			if(st.empty()) {
				st.push(arr[i]);
				continue;
			}
			
			while (!st.empty() && arr[i] < st.peek()) {
				int a = st.pop();
				sol.put(a, arr[i]);
			}
			st.push(arr[i]);
		}
		
		while (!st.empty()) {
			sol.put(st.pop(), -1);
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + "-->" + sol.get(arr[i]));
		}
	}
	
	public static void nextLargest(int[] arr, int n) {
		
		Stack<Integer> st = new Stack<>();
		HashMap<Integer, Integer> sol = new HashMap<>();
		st.push(arr[0]);
		
		for (int i = 1; i < n; i++) {
			
			if (st.empty()) {
				st.push(arr[i]);
				continue;
			}
			
			while (!st.empty() && arr[i] > st.peek()) {
				int a = st.pop();
				sol.put(a, arr[i]);
			}
			st.push(arr[i]);
		}
		
		while (!st.empty()) {
			sol.put(st.pop(), -1);
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + "-->" + sol.get(arr[i]));
		}
	
	}
	public static void main(String[] args) {
		int[] arr = { 11, 12, 21, 3 };
		System.out.println("SMALLEST -");
		nextSmallest(arr, arr.length);
		System.out.println("LARGEST -");
		nextLargest(arr, arr.length);
		
	}
}
