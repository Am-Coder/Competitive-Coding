package com.comp.algos.graph;

import java.util.LinkedList;

//Cycles of length n in an undirected and connected graph
public class CycleCountOfGivenLength {
	
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
		
		int count=0;

		void isCyclicUtil(int v, Boolean visited[], int parent, int len, int curlen, int start) 
	    { 	
//			System.out.println(parent+"-"+v+"-"+curlen);
			if( curlen > len ) {
				visited[v] = false;
				return;
			}
			visited[v] = true; 
	  
	        for (int i: adj[v]) 
	        { 
	            if (!visited[i]) 
	            { 
	                isCyclicUtil(i, visited, v, len, curlen+1, start); 
	            } 
	  
	            else if (i != parent && curlen + 1== len && i == start) { 
//	            	System.out.println("Count- "+i );
	            	count++;
//	    	        visited[v] = false;
	            }
	        }
	        
	        visited[v] = false;
	    } 
	  
	    // Returns true if the graph contains a cycle, else false. 
	    int countCycles(int len) 
	    { 

	        Boolean visited[] = new Boolean[V]; 
	        for (int i = 0; i < V; i++) 
	            visited[i] = false; 
	  

	        for( int i=0; i<V; i++) {
	        	if( !visited[i] ) {
//		        	System.out.println("NEXT" + i);
		            isCyclicUtil(i, visited, -1, len, 0, i);
	        	}
		        visited[i] = true;    	
	        }         
	  
	        return count/2; 
	    } 
		
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		System.out.println(g.countCycles(4));
		
	}
}
