package com.comp.algos.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//For DAG edges can exist from a given vertex in Topologically Sorted list to all the edges ahead of it
public class TopologicalSortDAGMaxEdges {
	static class Graph{
	
		int V;
		LinkedList<Integer>[] adj;
		
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			
			for( int i=0; i<V; i++ ) {
				adj[i] = new LinkedList<>();
			}
			
		}
		
		void addEdge( int u, int v ) {
			adj[u].add(v);
		}
		
		
		int topoSort() {
			int[] indegree = new int[V];
			for( int i=0; i<V; i++ ) {
				for( int ch: adj[i] ) {
					indegree[ch]++;
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
					
				for( int ch: adj[head] ) {
					if(  --indegree[ch] == 0 )
						q.add(ch);
				}
				cnt++;
			}
			//If no cycle then exactly V nodes removed, therfore cnt should be V
			if( cnt != V ) {
				System.out.println("Cycle Present");
				return -1;
			}
			
			int maxcnt = 0;
			int size = topo.size();
			for( int i=0; i<size; i++ ) {
				int u = topo.get(i);
				boolean[] vis = new boolean[V];
				for( int ch: adj[u] ) {
					vis[ch] = true;
				}
				for( int j=i+1; j<size; j++ ) {
					if( !vis[topo.get(j)] )
						maxcnt++;
				}
			}
			
			return maxcnt;
		}
	
	}
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g=new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        System.out.println("Following is a Topological Sort"); 
        System.out.println(g.topoSort()); 
  
    } 
}
