package com.comp.algos.graph;

import java.util.Arrays;
import java.util.LinkedList;

//WHITE : Vertex is not processed yet.  Initially
//all vertices are WHITE.
//
//GRAY : Vertex is being processed (DFS for this 
//vertex has started, but not finished which means
//that all descendants (ind DFS tree) of this vertex
//are not processed yet (or this vertex is in function
//call stack)
//
//BLACK : Vertex and all its descendants are 
//processed.
//
//While doing DFS, if we encounter an edge from current 
//vertex to a GRAY vertex, then this edge is back edge 
//and hence there is a cycle.
public class CycleDirectedGraphUsingColors {
	
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
		void cyclicUtil(int u, char[] color) {
			
			color[u] = 'G';
			
			
			for( int ch: adj[u] ) {
				if( color[ch] == 'G' ) {
					cyclic = true;
					return;
				}
				if( color[ch] == 'W')
					cyclicUtil(ch,color);
				
			}
			color[u] = 'B';
		}
		
		boolean isCyclic() {
			char[] color = new char[V];
			Arrays.fill(color, 'W');
			for( int i=0; i<V; i++ ) {
				if( color[i] == 'W' ) {
					cyclicUtil(0, color);		
				}
			}
			
			return cyclic;
		}
		
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		
		System.out.println(g.isCyclic());
		
	}
}
