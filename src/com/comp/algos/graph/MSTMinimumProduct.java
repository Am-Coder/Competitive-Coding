package com.comp.algos.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//		Minimum spanning tree algorithms tries to minimize total sum of weights, here we need to minimize total product of weights. 
//		We can use property of logarithms to overcome this problem.
//		As we know,
//		
//		 log(w1* w2 * w3 * …. * wN) = 
//		    log(w1) + log(w2) + log(w3) ….. + log(wN)  

public class MSTMinimumProduct {
	static class Node{
		int src;
		int dest;
		int wt;
		double lwt;
		Node(){
			
		}
		Node(int s, int d, int wt){
			this.src = s;
			this.dest = d;
			this.wt = wt;
			this.lwt = Math.log(wt);
		}
	}
	
	static class QNode implements Comparable<QNode>{
		double key;
		int vertex;
		
		QNode( double key, int ver ){
			this.key = key;
			this.vertex = ver;
		}
		@Override
		public int compareTo(QNode o2) {
			// TODO Auto-generated method stub
			return this.key - o2.key>0?1:0;
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
		
		void PrimsMST() {
			
			//Heap to handle finding minimum key value
			QNode[] arr = new QNode[V];
			Queue<QNode> q = new PriorityQueue<QNode>();
			
			//Whether vertex is present in set of MST vertices
			boolean[] mtset = new boolean[V];
	        
			//Stores parent of vertex
			int[] parent = new int[V]; 
			
			for( int i=0; i<V; i++ ) {
				mtset[i] = false;
				arr[i] = new QNode(Double.MAX_VALUE, i);
				
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
						if( arr[n.dest].key > n.lwt ) {
							q.remove(arr[n.dest]);
							arr[n.dest].key = n.lwt;
							q.add(arr[n.dest]);
							parent[n.dest] = qn.vertex;
						}
					}
				}
			}
			
	        for (int o = 1; o < V; o++) 
	            System.out.println(parent[o] + " "
	                               + "-"
	                               + " " + o); 
		}
	}
	
	public static void main(String[] args) 
    { 
        int V = 5; 
  
        Graph g = new Graph(V); 

        g.addEdge( 0, 3, 6);
        g.addEdge( 0, 1, 2); 
        g.addEdge( 1, 2, 3); 
        g.addEdge( 1, 3, 8); 
        g.addEdge( 1, 4, 5); 
        g.addEdge( 2, 4, 7); 
        g.addEdge( 3, 4, 9);  
  
        // Method invoked 
        g.PrimsMST(); 
    } 
}
