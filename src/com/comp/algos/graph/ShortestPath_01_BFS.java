package com.comp.algos.graph;

import java.util.*;

/*		Similar to djikstra, but no need to use priority queue since there are only two weights 0 and 1.
 * 
		While performing BFS if a edge having weight = 0 
		is found node is pushed at front of double ended queue and 
		if a edge having weight = 1 is found, it is pushed at back of double ended queue.
*/
public class ShortestPath_01_BFS {
	
	static class Node{
		int src;
		int dest;
		int wt;
		Node(){
			
		}
		Node(int s, int d, int wt){
			this.src = s;
			this.dest = d;
			this.wt = wt;
		}
	}
	
	
	static class Graph{
		int V;
		LinkedList<Node>[] adj;
		
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<Node>();
			}
		}
		
		void addEdge(int u, int v, int wt) {
			adj[u].add(new Node(u,v,wt));
			adj[v].add(new Node(v,u,wt));
		}
		
		void ZeroOneBFS(int src){
			int[] dist = new int[V];
			for( int i=0; i<V; i++ ) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[src] = 0;
			Deque<Integer> dq = new ArrayDeque<Integer>();
			dq.addLast(src);
			
			while( !dq.isEmpty() ) {
				int v = dq.poll();
				for( Node ch: adj[v] ) {
					if( dist[ch.dest] > dist[v] + ch.wt ) {
						dist[ch.dest] = dist[v] + ch.wt;
						if( ch.wt == 0 ) {
							dq.addFirst(ch.dest);
						}else {
							dq.addLast(ch.dest);
						}
					}
				}
			}
			
			for( int i=0; i<V; i++ ) {
				System.out.print(dist[i] + " ");
			}
		}
		
	}
  
    // Driver method 
    public static void main (String[] args) 
    { 
    	Graph graph = new Graph(9);
        graph.addEdge(0, 1, 0); 
        graph.addEdge(0, 7, 1); 
        graph.addEdge(1, 7, 1); 
        graph.addEdge(1, 2, 1); 
        graph.addEdge(2, 3, 0); 
        graph.addEdge(2, 5, 0); 
        graph.addEdge(2, 8, 1); 
        graph.addEdge(3, 4, 1); 
        graph.addEdge(3, 5, 1); 
        graph.addEdge(4, 5, 1); 
        graph.addEdge(5, 6, 1); 
        graph.addEdge(6, 7, 1); 
        graph.addEdge(7, 8, 1);
        graph.ZeroOneBFS(0);
    } 
    
}
