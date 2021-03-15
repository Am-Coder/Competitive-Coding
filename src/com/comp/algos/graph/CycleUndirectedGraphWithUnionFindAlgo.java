package com.comp.algos.graph;
import java.util.*;

//		Do Union(0, 1)
//		1   2   3  
//		/
//		0
//		
//		Do Union(1, 2)
//		  2   3   
//		 /
//		1
//		/
//		0
//		
//		Do Union(2, 3)
//		      3    
//		     /
//		   2
//		  /
//		1
//		/
//		0
//Can be used to check if an edge is a part of cycle 
//Union Rank is better than this
public class CycleUndirectedGraphWithUnionFindAlgo {
	static class Edge{
		int src;
		int dest;
		Edge(int s, int d){
			this.src = s;
			this.dest = d;
		}
	}
	
	static class Graph{
		int V;
		LinkedList<Edge> edge;
		//V subsets
		int[] parent;
		
		Graph(int V){
			this.V = V;
			edge = new LinkedList<>();
			parent = new int[this.V];
		}
		
		void addEdge(int s, int d) {
			edge.add(new Edge(s,d));
		}
		
		//In worst case find takes O(V) time
		int find(int[] parent, int s) {
			if ( parent[s] == s ) {
				return s;
			}
			return find(parent, parent[s]);
		}
		
		//Since find takes O(n) , therfore this also takes O(V)
		void unionOfSubset( int[] parent, int x, int y ) {
			int xset = find(parent,x);
			int yset = find(parent,y);
			
			parent[xset] = yset;
		}
		
		//takes O(VE)
		boolean isCycle() {
			
			for( int i=0; i<V; i++ ) {
				parent[i] = i;
			}

			for( int i=0; i<edge.size(); i++ ) {
				int x = find(parent, edge.get(i).src);
				int y = find(parent, edge.get(i).dest);
				if( x == y )
					return true;
				unionOfSubset(parent,x,y);
			}
			return false;
		}
	}
	
	public static void main (String[] args) 
    { 
        /* Let us create following graph 
         0 
        |  \ 
        |    \ 
        1-----2 */
        int V = 3, E = 3; 
        Graph graph = new Graph(V); 
  
        // add edge 0-1 
        graph.addEdge(0, 1);

        // add edge 1-2 
        graph.addEdge(1, 2);
  
        // add edge 0-2 
        graph.addEdge(0, 2);
  
        if (graph.isCycle()) 
            System.out.println( "graph contains cycle" ); 
        else
            System.out.println( "graph doesn't contain cycle" ); 
    } 
	
}
