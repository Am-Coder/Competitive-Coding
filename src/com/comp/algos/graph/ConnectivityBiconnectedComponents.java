package com.comp.algos.graph;

import java.util.*;

/*	Idea is to store visited edges in a stack while DFS on a graph and keep looking for 
	Articulation Points (highlighted in above figure). As soon as an Articulation Point u is 
	found, all edges visited while DFS from node u onwards will form one biconnected component. 
	When DFS completes for one connected component, all edges present in stack will form a biconnected component.
	If there is no Articulation Point in graph, then graph is biconnected and so there will be one 
	biconnected component which is the graph itself.
*/
public class ConnectivityBiconnectedComponents {
	
	static class Edge{
		int s;
		int d;
		
		Edge( int s, int d ){
			this.s = s;
			this.d = d;
		}
	}
	
	static class Graph{
		int V;
		LinkedList<Integer>[] adj;
		static int time = 0, count = 0;
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
		
		void BCPUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap, LinkedList<Edge> st) {
			int children = 0;
			visited[u] = true;
			disc[u] = low[u] = time++;
			
			for( int ch: adj[u] ) {
				if( !visited[ch] ) {
					children++;
					parent[ch] = u;
					st.add(new Edge(u,ch));
					BCPUtil(ch, visited, disc, low, parent, ap, st);
					
					low[u] = Math.min(low[u], low[ch]);
					if( (parent[u] == -1 && children > 1) || (parent[u] != -1 && low[ch] >= disc[u]) ) {
						ap[u] = true;
	                    while (st.getLast().s != u || st.getLast().d != ch) { 
	                        System.out.print(st.getLast().s + "--" + st.getLast().d + " "); 
	                        st.removeLast(); 
	                    } 
	                    System.out.println(st.getLast().s + "--" + st.getLast().d + " "); 
	                    st.removeLast(); 
						count++;
					}
					
					
				}else if( ch != parent[u] && disc[ch] < disc[u]) {
					low[u] = Math.min(low[u], disc[ch]);
					st.add(new Edge(u,ch));

				}
			}
		}
		
		void BCP() 
	    { 
	        // Mark all the vertices as not visited 
	        boolean visited[] = new boolean[V]; 
	        int disc[] = new int[V]; 
	        int low[] = new int[V]; 
	        int parent[] = new int[V]; 
	        boolean ap[] = new boolean[V]; // To store articulation points 
	        LinkedList<Edge> st = new LinkedList<>();
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
	        for (int i = 0; i < V; i++) { 
	            if (visited[i] == false) 
	            	BCPUtil(i, visited, disc, low, parent, ap, st); 
	            int j = 0;
	            while( !st.isEmpty() ) {
	            	j=1;
	            	System.out.print(st.getLast().s + "-" + st.getLast().d+" ");
	            	st.removeLast();
	            }
	            if ( j == 1 ) {
	                System.out.println(); 
	            	count++;
	            }
	            
	        }

	    } 
	}
	
	public static void main(String args[]) 
    { 
        // Create graphs given in above diagrams 
        System.out.println("Articulation points in first graph "); 
        Graph g = new Graph(12); 
        g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(3, 2); 
        g.addEdge(2, 4); 
        g.addEdge(4, 3); 
        g.addEdge(5, 1); 
        g.addEdge(6, 0); 
        g.addEdge(6, 5); 
        g.addEdge(7, 5); 
        g.addEdge(8, 5); 
        g.addEdge(8, 7); 
        g.addEdge(9, 8); 
        g.addEdge(11, 10); 
        g.BCP(); 
    } 
}
