package com.comp.acmsummer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;



//class Graph{
//	public int V;
//	public LinkedList<Integer> adj[];
//	
//	public Graph(int a) {
//		this.V = a;
//		adj = new LinkedList[V];
//		for(int i=0; i<a; i++) {
//			adj[i] = new LinkedList<Integer>();
//		}
//	}
//	
//	public void addEdge(int u, int v) {
//		
//		adj[u].add(v);
//		
//	}
//	
//	public void dfsutil(int v,boolean[] visited) {
//		visited[v] = true;
//		System.out.println(v + 1 + " ");
//		Iterator<Integer> it = adj[v].listIterator();
//		while(it.hasNext()) {
//			int n = it.next();
//			if(!visited[n]) {
//				dfsutil(n,visited);
//			}
//		}
//		
//	}
//	
//	public void dfs(int v) {
//		
//		boolean[] check = new boolean[V];
//		dfsutil(v,check);
//	}
//}
public class UltraInstinct11 {
		

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		LinkedList<Integer>[] la = new LinkedList[n];
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
//			la[i] = new LinkedList<Integer>();
		}
		Graph g = new Graph(n);
		
		
		for( int i = 0; i < n - 1; i++ ) {
			int u = s.nextInt();
			int v = s.nextInt();
			g.addEdge(u-1, v-1);
//			g.addEdge(v - 1, u - 1);
		}
//		g.dfs(1);
	}	
		
}		
