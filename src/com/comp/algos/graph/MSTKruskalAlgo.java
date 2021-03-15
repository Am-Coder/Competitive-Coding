package com.comp.algos.graph;
import java.util.*;


//1. Sort all the edges in non-decreasing order of their weight.
//2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. 
//If cycle is not formed, include this edge. Else, discard it.
//3. Repeat step#2 until there are (V-1) edges in the spanning tree.
public class MSTKruskalAlgo {	
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int wt;
		
		Edge(){
			
		}
		
		Edge(int s, int d){
			this.src = s;
			this.dest = d;
		}
		
		Edge(int s, int d, int wt){
			this.src = s;
			this.dest = d;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.wt - o.wt;
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
		
		void addEdge(int s, int d, int wt) {
			edge.add(new Edge(s,d,wt));
		}
		
		
		//In worst case find takes O(logV) time
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
		
		//takes O(ElogE)=>sorting + O(ElogV)=>iterate and union and find
		void KruskaMST() {
			
			Edge[] result = new Edge[V];
			for( int i=0; i<V; i++ ) {
				result[i] = new Edge();
			}
			for( int i=0; i<V; i++ ) {
				subsets[i] = new Subset();
				subsets[i].parent = i;
				subsets[i].rank = 0;
			}
			
			Collections.sort(edge);
			
			int e = 0;
			int i = 0;
			while( e < V-1 ) {
	            Edge next_edge = new Edge(); 
	            next_edge = edge.get(i++); 
	            
				int x = find(subsets, next_edge.src);
				int y = find(subsets, next_edge.dest);
				if( x != y ) {
					result[e++] = next_edge;
					unionOfSubset(subsets,x,y);		
				}
			}
			for (i = 0; i < e; ++i) 
	            System.out.println(result[i].src+" -- " +  
	                   result[i].dest+" == " + result[i].wt); 
		}
	}
	
	public static void main (String[] args) 
    { 
  
        /* Let us create following weighted graph 
                 10 
            0--------1 
            |  \     | 
           6|   5\   |15 
            |      \ | 
            2--------3 
                4       */
        int V = 4;  // Number of vertices in graph 
        int E = 5;  // Number of edges in graph 
        Graph graph = new Graph(V); 
  
        // add edge 0-1 
        graph.addEdge(0, 1, 10);
  
        // add edge 0-2 
        graph.addEdge(0, 2, 6);
  
        // add edge 0-3 
        graph.addEdge(0, 3, 5);
  
        // add edge 1-3 
        graph.addEdge(1, 3, 15);
  
        // add edge 2-3 
        graph.addEdge(2, 3, 4);
  
        graph.KruskaMST(); 
    } 
}
