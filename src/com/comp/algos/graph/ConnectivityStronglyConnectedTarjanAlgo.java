package com.comp.algos.graph;

import java.util.*;


//SCC is only for Directed Graphs
/*	Disc: This is the time when a node is visited 1st time while DFS traversal. 
 *  
  	Low:“Low” value of a node tells the topmost reachable ancestor (with minimum possible Disc value) via the subtree 
  	of that node. So for any node, Low value equal to its Disc value anyway (A node is ancestor of itself). 
  	Then we look into its subtree and see if there is any node which can take us to any of its ancestor. If there are multiple back edges 
  	in subtree which take us to different ancestors, then we take the one with minimum Disc value (i.e. the topmost one). 
  	
  	
  	low[u] indicates earliest visited vertex (the vertex with minimum discovery time) 
	that can be reached from subtree rooted with u. A node u is head if disc[u] = low[u].
*/

public class ConnectivityStronglyConnectedTarjanAlgo {
	
	static class Graph{
		int V;
		LinkedList<Integer>[] adj;
		int time = 0;
		
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<Integer>();
			}
			
		}
		
		void addEdge( int u, int v ) {
			adj[u].add(v);
		}
		
		void SCCUtil(int u, int[] low, int[] disc, boolean[] stackMember, LinkedList<Integer> st) {
			stackMember[u] = true;
			disc[u] = low[u] = ++time;
			st.add(u);
			for( int v: adj[u] ) {
				if( disc[v] == -1 ) {
					SCCUtil(v, low, disc, stackMember, st);
					low[u] = Math.min(low[u], low[v]);

				}else if( stackMember[v] == true) {
					low[u] = Math.min(low[u], disc[v]);
				}
			}
			
			//Only for head of dfs tree
			if( low[u] == disc[u] ) {
				while( st.peekLast() != u ) {
					System.out.print(st.peekLast() + " ");
					stackMember[st.peekLast()] = false;
					st.removeLast();
					
				}
				System.out.print(st.peekLast() + " ");
				stackMember[st.peekLast()] = false;
				st.removeLast();
				System.out.println();
			
			}
		}
		
		void SCC() { 
	        boolean stackMember[] = new boolean[V]; 
	        int disc[] = new int[V]; 
	        int low[] = new int[V]; 
	        LinkedList<Integer> st = new LinkedList<>();

	        for (int i = 0; i < V; i++) 
	        { 	disc[i] = -1;
	        stackMember[i] = false; 
	        } 
	  
	        for (int i = 0; i < V; i++) 
	            if (disc[i] == -1) 
	                SCCUtil(i, low, disc, stackMember, st); 
	  
	    
		}
	}	
	
	public static void main( String[] args ) {
		
		System.out.println("SCCs in first graph"); 
	    Graph g1 = new Graph(5);
		g1.addEdge(1, 0); 
	    g1.addEdge(0, 2); 
	    g1.addEdge(2, 1); 
	    g1.addEdge(0, 3); 
	    g1.addEdge(3, 4); 
	    g1.SCC(); 
	  
	    System.out.println("\nSCCs in second graph"); 
	    Graph g2 = new Graph(4); 
	    g2.addEdge(0, 1); 
	    g2.addEdge(1, 2); 
	    g2.addEdge(2, 3); 
	    g2.SCC(); 
	  
	    System.out.println("\nSCCs in third graph"); 
	    Graph g3 = new Graph(7); 
	    g3.addEdge(0, 1); 
	    g3.addEdge(1, 2); 
	    g3.addEdge(2, 0); 
	    g3.addEdge(1, 3); 
	    g3.addEdge(1, 4); 
	    g3.addEdge(1, 6); 
	    g3.addEdge(3, 5); 
	    g3.addEdge(4, 5); 
	    g3.SCC(); 
	  
	    System.out.println("\nSCCs in fourth graph"); 
	    Graph g4 = new Graph(11); 
	    g4.addEdge(0,1);g4.addEdge(0,3); 
	    g4.addEdge(1,2);g4.addEdge(1,4); 
	    g4.addEdge(2,0);g4.addEdge(2,6); 
	    g4.addEdge(3,2); 
	    g4.addEdge(4,5);g4.addEdge(4,6); 
	    g4.addEdge(5,6);g4.addEdge(5,7);g4.addEdge(5,8);g4.addEdge(5,9); 
	    g4.addEdge(6,4); 
	    g4.addEdge(7,9); 
	    g4.addEdge(8,9); 
	    g4.addEdge(9,8); 
	    g4.SCC(); 
	  
	    System.out.println("\nSCCs in fifth graph"); 
	    Graph g5 = new Graph(5); 
	    g5.addEdge(0,1); 
	    g5.addEdge(1,2); 
	    g5.addEdge(2,3); 
	    g5.addEdge(2,4); 
	    g5.addEdge(3,0); 
	    g5.addEdge(4,2); 
	    g5.SCC(); 
	}
}
