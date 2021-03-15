package com.comp.algos.graph;
import java.util.*;
//What is a Mother Vertex?
//A mother vertex in a graph G = (V,E) is a vertex v such that all other vertices in G 
//can be reached by a path from v.

//Uses Kosarajus Algo ( See Strongly Connected Components)
public class MotherVertex {
	
	static class Graph{
		LinkedList<Integer>[] adj;
		int V;
		
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int u, int v) {
			adj[u].add(v);
		}
		
		void DFSutil(int v, boolean[] boo) {
			if( boo[v] )
				return;
			boo[v] = true;
			for( int ch: adj[v] ) {
				if( !boo[ch] )
					DFSutil(ch, boo);
			}
		}
		
		int motherVertex() {
			boolean[] arr = new boolean[V];
			int n=-1;
			for( int i=0; i<V; i++ ) {
				if( !arr[i] ) {
					DFSutil(i,arr);
					n=i;
				}
			}
			Arrays.fill(arr, false);
			DFSutil(n,arr);
			for( int i=0; i<V; i++ ) {
				if( !arr[i] ) {
					System.out.println(i);
					return -1;
				}
					
			}
			return n;
		}
	}
	
	public static void main(String[] args) {
	    Graph g = new Graph(7); 
	    g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(4, 1); 
	    g.addEdge(6, 4); 
	    g.addEdge(5, 6); 
	    g.addEdge(5, 2); 
	    g.addEdge(6, 0); 
//	    for( int i=0; i<7; i++) {
//	    	for( int j=0; j<g.adj[i].size(); j++ ) {
//	    		System.out.print(g.adj[i].get(j)+" ");
//	    	}
//	    	System.out.println();
//	    }
	    System.out.println("Mother Vertex is => " + g.motherVertex());
	}
}
