package com.comp.algos.graph;
	
import java.util.*;
	
//1) Create a set mstSet that keeps track of vertices already included in MST.
//2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. 
//Assign key value as 0 for the first vertex so that it is picked first.
//3) While mstSet doesn’t include all vertices
//….a) Pick a vertex u which is not there in mstSet and has minimum key value.
//….b) Include u to mstSet.
//….c) Update key value of all adjacent vertices of u. To update the key values, 
//iterate through all adjacent vertices. For every adjacent vertex v, if weight 
//of edge u-v is less than the previous key value of v, update the key value as weight of u-v
public class MSTPrimsAlgo {
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
		int key;
		int vertex;
		
		QNode( int key, int ver ){
			this.key = key;
			this.vertex = ver;
		}
		@Override
		public int compareTo(QNode o2) {
			// TODO Auto-generated method stub
			return this.key - o2.key;
		}
		
	}
	
	static class Graph{
		int V;
		LinkedList<Node>[] adj;
		
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int s, int d, int w ) {
			adj[s].add(new Node(s,d,w));
			adj[d].add(new Node(d,s,w));
		}
		
		int PrimsMST() {
			
			//Heap to handle finding minimum key value
			QNode[] arr = new QNode[V];
			Queue<QNode> q = new PriorityQueue<QNode>();
			
			//Whether vertex is present in set of MST vertices
			boolean[] mtset = new boolean[V];
	        
			//Stores parent of vertex
			int[] parent = new int[V]; 
			
			for( int i=0; i<V; i++ ) {
				mtset[i] = false;
				arr[i] = new QNode(Integer.MAX_VALUE, i);
				
			}
			arr[0].key = 0;
			mtset[0] = true;
			
			for( int i=0; i<V; i++ ) {
				q.add(arr[i]);
			}
			
			while( !q.isEmpty() ) {
				QNode qn = q.poll();
				mtset[qn.vertex] = true;
				for( Node n: adj[qn.vertex] ) {
					if( mtset[n.dest] == false ) {
						if( arr[n.dest].key > n.wt ) {
							q.remove(arr[n.dest]);
							arr[n.dest].key = n.wt;
							q.add(arr[n.dest]);
							parent[n.dest] = qn.vertex;
						}
					}
				}
			}
			int sum = 0;
			for (int o = 1; o < V; o++) {
				System.out.println(parent[o] + " " + "-" + " " + o);
				for (Node ch : adj[parent[o]]) {
					if (ch.dest == o) {
						sum += ch.wt;
					}
				}
			}
			return sum;
		}
	}
	
	public static void main(String[] args) 
    { 
        int V = 9; 
  
        Graph g = new Graph(V); 
  
  
        g.addEdge( 0, 1, 4); 
        g.addEdge( 0, 7, 8); 
        g.addEdge( 1, 2, 8); 
        g.addEdge( 1, 7, 11); 
        g.addEdge( 2, 3, 7); 
        g.addEdge( 2, 8, 2); 
        g.addEdge( 2, 5, 4); 
        g.addEdge( 3, 4, 9); 
        g.addEdge( 3, 5, 14); 
        g.addEdge( 4, 5, 10); 
        g.addEdge( 5, 6, 2); 
        g.addEdge( 6, 7, 1); 
        g.addEdge( 6, 8, 6); 
        g.addEdge( 7, 8, 7); 
  
        // Method invoked 
        g.PrimsMST(); 
    } 
}	
