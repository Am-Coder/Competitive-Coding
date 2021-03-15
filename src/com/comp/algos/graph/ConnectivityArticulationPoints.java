package com.comp.algos.graph;

import java.util.*;


/*	The idea is to use DFS (Depth First Search). 
	In DFS, we follow vertices in tree form called DFS tree. In DFS tree, a vertex u is parent 
	of another vertex v, if v is discovered by u (obviously v is an adjacent of u in graph). 
	In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
	1) u is root of DFS tree and it has at least two children.
	2) u is not root of DFS tree and it has a child v such that no vertex in subtree 
		rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
*/

/*	Disc: This is the time when a node is visited 1st time while DFS traversal. 
 *  
  	Low:“Low” value of a node tells the topmost reachable ancestor (with minimum possible Disc value) via the subtree 
  	of that node. So for any node, Low value equal to its Disc value anyway (A node is ancestor of itself). 
  	Then we look into its subtree and see if there is any node which can take us to any of its ancestor. If there are multiple back edges 
  	in subtree which take us to different ancestors, then we take the one with minimum Disc value (i.e. the topmost one). 
  	
  	
  	low[u] indicates earliest visited vertex (the vertex with minimum discovery time) 
	that can be reached from subtree rooted with u. A node u is head if disc[u] = low[u].
*/

public class ConnectivityArticulationPoints {
	static class Graph{
		int V;
		LinkedList<Integer>[] adj;
		static int time = 0;
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge( int u, int v ) {
			adj[u].add(v);
			adj[v].add(u);
		}
		
		void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {
			int children = 0;
			visited[u] = true;
			disc[u] = low[u] = time++;
			
			for( int ch: adj[u] ) {
				if( !visited[ch] ) {
					children++;
					parent[ch] = u;
					APUtil(ch, visited, disc, low, parent, ap);
					
					low[u] = Math.min(low[u], low[ch]);
					if( parent[u] == -1 && children > 1 ) {
						ap[u] = true;
					}
					
					if( parent[u] != -1 && low[ch] >= disc[u] ) {
						ap[u] = true;
					}
				}else if( ch != parent[u] ) {
					low[u] = Math.min(low[u], disc[ch]);
				}
			}
		}
		
		void AP() 
	    { 
	        // Mark all the vertices as not visited 
	        boolean visited[] = new boolean[V]; 
	        int disc[] = new int[V]; 
	        int low[] = new int[V]; 
	        int parent[] = new int[V]; 
	        boolean ap[] = new boolean[V]; // To store articulation points 
	  
	        // Initialize parent and visited, and ap(articulation point) 
	        // arrays 
	        for (int i = 0; i < V; i++) 
	        { 
	            parent[i] = -1; 
	            visited[i] = false; 
	            ap[i] = false; 
	        } 
	  
	        // Call the recursive helper function to find articulation 
	        // points in DFS tree rooted with vertex 'i' 
	        for (int i = 0; i < V; i++) 
	            if (visited[i] == false) 
	                APUtil(i, visited, disc, low, parent, ap); 
	  
	        // Now ap[] contains articulation points, print them 
	        for (int i = 0; i < V; i++) 
	            if (ap[i] == true) 
	                System.out.print(i+" "); 
	    } 
	}
	
	public static void main(String args[]) 
    { 
        // Create graphs given in above diagrams 
        System.out.println("Articulation points in first graph "); 
        Graph g1 = new Graph(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.AP(); 
        System.out.println(); 
  
        System.out.println("Articulation points in Second graph"); 
        Graph g2 = new Graph(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3); 
        g2.AP(); 
        System.out.println(); 
  
        System.out.println("Articulation points in Third graph "); 
        Graph g3 = new Graph(7); 
        g3.addEdge(0, 1); 
        g3.addEdge(1, 2); 
        g3.addEdge(2, 0); 
        g3.addEdge(1, 3); 
        g3.addEdge(1, 4); 
        g3.addEdge(1, 6); 
        g3.addEdge(3, 5); 
        g3.addEdge(4, 5); 
        g3.AP(); 
    } 
}
