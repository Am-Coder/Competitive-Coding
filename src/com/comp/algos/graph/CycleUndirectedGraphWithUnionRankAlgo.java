package com.comp.algos.graph;

import java.util.Arrays;
import java.util.LinkedList;


//				Do Union(0, 1)
//				1   2   3  
//				/
//				0
//				
//				Do Union(1, 2)
//				1    3
//				/  \
//				0    2
//				
//				Do Union(2, 3)
//				 1    
//				/  |  \
//				0   2   3

public class CycleUndirectedGraphWithUnionRankAlgo {
	static class Edge{
		int src;
		int dest;
		Edge(int s, int d){
			this.src = s;
			this.dest = d;
		}
	}
	
	static class Subset{
		int parent;
		int rank;
	}
	
	static class Graph{
		int V;
		LinkedList<Edge> edge;
		//V subsets
		Subset[] subsets;
		
		Graph(int V){
			this.V = V;
			edge = new LinkedList<>();
			subsets = new Subset[this.V];
		}
		
		void addEdge(int s, int d) {
			edge.add(new Edge(s,d));
		}
		
		
		//In worst case find takes O(logV) time, see how compression is used here
		int find(Subset[] subsets, int s) {
			if ( subsets[s].parent != s ) {
				subsets[s].parent = find( subsets, subsets[s].parent);
			}
			return subsets[s].parent;
		}
		
		//Since find takes O(logn) , therfore this also takes O(logv)
		void unionOfSubset( Subset[] subsets, int x, int y ) {
			int xset = find(subsets, x);
			int yset = find(subsets, y);
			if( subsets[xset].rank < subsets[yset].rank ) {
				subsets[xset].parent = yset;
			}else if( subsets[yset].rank < subsets[xset].rank ) {
				subsets[yset].parent = xset;
			}else {
				subsets[xset].rank++;
				subsets[xset].parent = yset;
			}
		}
		
		//takes O(ElogV)
		boolean isCycle() {
			
			for( int i=0; i<V; i++ ) {
				subsets[i] = new Subset();
				subsets[i].parent = i;
				subsets[i].rank = 0;
			}
			
			for( int i=0; i<edge.size(); i++ ) {
				int x = find(subsets, edge.get(i).src);
				int y = find(subsets, edge.get(i).dest);
				if( x == y )
					return true;
				unionOfSubset(subsets,x,y);
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
