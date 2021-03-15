package com.comp.algos.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

//O(V+E)
//Following is complete algorithm for finding longest distances.
//1) Initialize dist[] = {NINF, NINF, ….} and dist[s] = 0 where s is the source vertex.
//	 Here NINF means negative infinite.
//2) Create a toplogical order of all vertices.
//3) Do following for every vertex u in topological order.
//………..Do following for every adjacent vertex v of u
//………………if (dist[v] < dist[u] + weight(u, v))
//………………………dist[v] = dist[u] + weight(u, v)
public class TopologicalSortLongestPathFromSrcToDest {
	
	static class Node{
		int u;
		int v;
		int wt;
		Node( int u, int v, int wt ){
			this.u = u;
			this.v = v;
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
		
		void addEdge( int u, int v, int wt ) {
			adj[u].add(new Node(u,v,wt));
		}
		
		
		void topoSortLongestDist(int src) {
			int[] indegree = new int[V];
			for( int i=0; i<V; i++ ) {
				for( Node ch: adj[i] ) {
					indegree[ch.v]++;
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for( int i=0; i<V; i++ ) {
				if( indegree[i] == 0 ) {
					q.add(i);
				}
			}
			LinkedList<Integer> topo = new LinkedList<>();
			
			//Extra check for cycle in DAG
			int cnt = 0;
			
			while(!q.isEmpty()) {
				int head = q.poll();
				topo.add(head);
					
				for( Node ch: adj[head] ) {
					if(  --indegree[ch.v] == 0 )
						q.add(ch.v);
				}
				cnt++;
			}
			//If no cycle then exactly V nodes removed, therfore cnt should be V
			if( cnt != V ) {
				System.out.println("Cycle Present");
				return;
			}
		
			topo.forEach(i -> System.out.print(i+" "));
			System.out.println();
			
			int[] dist = new int[V];
			Arrays.fill(dist, Integer.MIN_VALUE);
			dist[src] = 0;
			
			for( int i=0; i<topo.size(); i++ ) {
				int u = topo.get(i);
				if( dist[u] != Integer.MIN_VALUE)
					for( Node ch: adj[u] ) {
						//Remember i = ch.u
						if( dist[u] + ch.wt > dist[ch.v] )
							dist[ch.v] = dist[u] + ch.wt;
					}
			}
			
			for( int i=0; i<V; i++ ) {
				System.out.println(i+" - "+dist[i]);
			}
			
		}
	
	}
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g=new Graph(6); 
        g.addEdge(0, 1, 5);  
        g.addEdge(0, 2, 3);  
        g.addEdge(1, 3, 6);  
        g.addEdge(1, 2, 2);  
        g.addEdge(2, 4, 4);  
        g.addEdge(2, 5, 2);  
        g.addEdge(2, 3, 7);  
        g.addEdge(3, 5, 1);  
        g.addEdge(3, 4, -1);  
        g.addEdge(4, 5, -2);  
        System.out.println("Following is a Topological Sort"); 
        g.topoSortLongestDist(1); 
  
    } 
}
