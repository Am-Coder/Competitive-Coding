package com.comp.algos.graph;

import java.util.*;


//Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of 
//vertices such that for every directed edge uv, vertex u comes before v in the ordering. 
//Topological Sorting for a graph is not possible if the graph is not a DAG.
public class TopologicalSortDirectAcyclicGraph {
	static class Graph{
		int V;
		LinkedList<Integer>[] adj;
		
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<>();
			}
			
		}
		
		void addEdge( int u, int v ) {
			adj[u].add(v);
		}
		
		void topoSortUtil( int v, boolean[] visited, Stack<Integer> st) {
			if( visited[v] )
				return;
			visited[v] = true;
			
			for( int ch: adj[v] ) {
				if( !visited[ch] )
					topoSortUtil( ch, visited, st );
			}
			st.push(v);
		}
		
		void topoSort() {
			Stack<Integer> st = new Stack<>();
			boolean[] visited = new boolean[V];
			Arrays.fill(visited, false);
			for( int i=0; i<V; i++ ) {
				if( !visited[i] )
					topoSortUtil(i, visited, st);
			}
			
			while( !st.isEmpty() )
				System.out.print(st.pop() + " ");
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);  
        g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1);  
    
        System.out.println("Following is a Topological " +  
                           "sort of the given graph");  
        g.topoSort();  
	}
}
