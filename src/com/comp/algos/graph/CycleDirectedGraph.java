package com.comp.algos.graph;
import java.util.*;
import java.io.*;

public class CycleDirectedGraph {
	
	static class Graph{
		int V;
		LinkedList<Integer>[] adj;
		
		Graph( int V ){
			this.V = V;
			adj = new LinkedList[V];
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge( int u, int v ) {
			adj[u].add(v);
		}
		
		boolean cyclic = false;
		void cyclicUtil(int u, boolean[] st, boolean[] vis) {
			if( st[u] ) {
				cyclic = true;
				return;
			}
			
			if( vis[u] ) {
				return;
			}
			
			vis[u] = true;
			st[u] = true;
			for( int ch: adj[u] ) {
				cyclicUtil(ch,st,vis);
			}
			st[u] = false;
		}
		
		boolean isCyclic() {
			boolean[] st = new boolean[V];
			boolean[] vis = new boolean[V];
			
			for( int i=0; i<V; i++ ) {
				if( !vis[i] ) {
					cyclicUtil(0, st, vis);		
				}
			}
			
			return cyclic;
		}
		
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		//		g.addEdge(0, 2);
		g.addEdge(2, 3);
		//		g.addEdge(3, 0);
		
		System.out.println(g.isCyclic());
		
	}
}
