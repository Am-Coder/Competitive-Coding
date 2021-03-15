package com.comp.algos.graph;
import java.util.*;


/*	Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
	A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in 
	the graph) from the last vertex to the first vertex of the Hamiltonian Path. Determine whether 
	a given graph contains Hamiltonian Cycle or not.
*/
public class BacktrackHamiltonianPath {
	static class Graph{
		int V;
		int[][] adj;
		
		Graph(int V){
			this.V = V;
			adj = new int[V][V];
		}
		
		void addEdge( int u, int v ) {
			adj[u][v] = 1;
			adj[v][u] = 1;
		}
		
		boolean isSafe( int[] path, int v, int pos ) {
			
			if( adj[path[pos-1]][v] == 0 )
				return false;
			
			for( int i=0; i<pos; i++ ) {
				if( path[i] == v)
					return false;
			}
			
			return true;
		}
		
		boolean isHamiltonianUtil( int pos, int[] path ) {
			if ( pos == V ) {
				if( adj[path[pos - 1]][path[0]] == 1) {
					return true;
				}else {
					return false;
				}
			}
			for( int i=1; i<V; i++ ) {
				if( isSafe(path, i, pos) ) {
					path[pos] = i;
					
					if ( isHamiltonianUtil(pos+1, path) )
						return true;
					
					path[pos] = -1;
				}
			}
			return false;
		}
		
		boolean hamiltonianCycle() {
			int[] path = new int[V];
			Arrays.fill(path, -1);
			path[0] = 0;
			if( isHamiltonianUtil(1, path) ) {
				System.out.println("Exist");
				for( int i=0; i<V; i++ ) {
					System.out.print(path[i] + " ");
				}
				System.out.println();
				return true;
			}
			System.out.println("Does Not Exist");
			return false;
		}
	}
	
	 // driver program to test above function 
    public static void main(String args[]) 
    { 
        Graph hamiltonian = 
                                new Graph(5); 
        /* Let us create the following graph 
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 1, 0}, 
        }; 
  
        hamiltonian.adj = graph1;
        hamiltonian.hamiltonianCycle();
        
        
        /* Let us create the following graph 
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 0}, 
            {0, 1, 1, 0, 0}, 
        }; 
        hamiltonian.adj = graph2;
        hamiltonian.hamiltonianCycle(); 
    } 
}
