package com.comp.acmsummer;

import java.util.LinkedList;
import java.util.Scanner;

public class UltraInstinct2 {

    public static void dfs(LinkedList<Integer> list[],int node, int arrival) 
	{ 
		// Printing traversed node 
		System.out.println(node); 
		
		// Traversing adjacent edges 
		for (int i = 0; i < list[node].size(); i++) { 
		
		// Not traversing the parent node 
			if (list[node].get(i) != arrival) 
				dfs(list, list[node].get(i), node); 
		} 
    } 

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		LinkedList<Integer>[] la = new LinkedList[n+1];
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
			la[i] = new LinkedList<Integer>();
		}
		
		
		for( int i = 0; i < n - 1; i++ ) {
			int u = s.nextInt();
			int v = s.nextInt();
			la[u].add(v);
		}
		
		dfs(la,1,0);
	}	
	
}
