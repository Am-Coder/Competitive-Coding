package com.comp.algos.graph;

import java.util.LinkedList;


public class CycleUndirectedGraph {
	
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
			adj[v].add(u);
		}
		
		// A recursive function that uses visited[] and parent to detect 
	    // cycle in subgraph reachable from vertex v. 
	    Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
	    { 
	        // Mark the current node as visited 
	        visited[v] = true; 
	  
	        for (int i: adj[v]) 
	        { 
	            // If an adjacent is not visited, then recur for that 
	            // adjacent 
	            if (!visited[i]) 
	            { 
	                if (isCyclicUtil(i, visited, v)) 
	                    return true; 
	            } 
	  
	            // If an adjacent is visited and not parent of current 
	            // vertex, then there is a cycle. 
	            else if (i != parent) 
	                return true; 
	        } 
	        return false; 
	    } 
	  
	    // Returns true if the graph contains a cycle, else false. 
	    Boolean isCyclic() 
	    { 

	        Boolean visited[] = new Boolean[V]; 
	        for (int i = 0; i < V; i++) 
	            visited[i] = false; 
	  
	        // Call the recursive helper function to detect cycle in 
	        // different DFS trees 
	        for (int u = 0; u < V; u++) 
	            if (!visited[u]) // Don't recur for u if already visited 
	                if (isCyclicUtil(u, visited, -1)) 
	                    return true; 
	  
	        return false; 
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
