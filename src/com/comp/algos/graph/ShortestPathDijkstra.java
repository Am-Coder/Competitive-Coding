package com.comp.algos.graph;
import java.util.*;

/*		
		1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree, 
			i.e., whose minimum distance from source is calculated and finalized. Initially, this set is empty.
		2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE.
			Assign distance value as 0 for the source vertex so that it is picked first.
		3) While sptSet doesn’t include all vertices
		….a) Pick a vertex u which is not there in sptSet and has minimum distance value.
		….b) Include u to sptSet.
		….c) Update distance value of all adjacent vertices of u. To update the distance 
			values, iterate through all adjacent vertices. For every adjacent vertex v, 
			if sum of distance value of u (from source) and weight of edge u-v, is less than 
			the distance value of v, then update the distance value of v.
*/
public class ShortestPathDijkstra {
	
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
	
	static class QNode implements Comparable<QNode>{
		int vertex;
		int val;
		
		QNode(int v, int val ){
			this.vertex = v;
			this.val = val;
		}
		
		@Override
		public int compareTo(QNode o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
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
		
		void djikstraUtil(int src) {
			boolean[] sptSet = new boolean[V];
			
			PriorityQueue<QNode> q = new PriorityQueue<>();
			QNode[] arr = new QNode[V];
			
			int[] dist = new int[V];
			StringBuilder[] path = new StringBuilder[V];
			for( int i=0; i<V; i++ ) {
				dist[i] = Integer.MAX_VALUE;
				path[i] = new StringBuilder();
			}
			dist[src] = 0;
			path[0].append("0 ");
			for( int i=0; i<V; i++ ) {
				arr[i] = new QNode(i, dist[i]);
				q.add(arr[i]);
			}
			
			while( !q.isEmpty() ) {
				QNode qn = q.poll();
				sptSet[qn.vertex] = true;
				
				for( Node ch: adj[qn.vertex] ) {
					if( sptSet[ch.dest] == false) {
						if( dist[qn.vertex] + ch.wt < dist[ch.dest] && dist[qn.vertex] != Integer.MAX_VALUE ) {
							dist[ch.dest] = dist[qn.vertex] + ch.wt;
							path[ch.dest] = new StringBuilder( path[qn.vertex] ).append(ch.dest + " ");
							q.remove(arr[ch.dest]);
							arr[ch.dest].val = dist[qn.vertex] + ch.wt;
							q.add(arr[ch.dest]);
						}
					}
				}
			}
			
			for( int i=0; i<V; i++ ) {
				System.out.println(dist[i] + " with path " + path[i].toString());
			}
		}
		
		
	}
  
    // Driver method 
    public static void main (String[] args) 
    { 
    	Graph g = new Graph(4);
    	
    	g.addEdge(0, 1, 1);
    	g.addEdge(0, 2, 2);
    	g.addEdge(2, 3, 2);
    	g.addEdge(1, 3, 1);
//    	g.addEdge(0, 1, 2);
//    	g.addEdge(0, 2, 4);
//    	g.addEdge(1, 2, 1);
//    	g.addEdge(2, 3, 1);
//    	g.addEdge(1, 3, 3);
    	g.djikstraUtil(0);
    } 
    
}
