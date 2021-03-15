package com.comp.algos.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;


//Logic-First remove 0 indegree => 1 indegree becomes 0, 2 becomes 1 ..=> again remove 0 indegree and so on
// O(V+E)
public class TopologicalSortKahnAlgo {
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
		
		void topoSortUtil(int[] indegree) {
			
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
				return;
			}
		
			topo.forEach(i -> System.out.print(i+" "));
		}
		
		void topoSort() {
			int[] indegree = new int[V];
			for( int i=0; i<V; i++ ) {
				for( int ch: adj[i] ) {
					indegree[ch]++;
				}
			}
			topoSortUtil(indegree);
			
		}
	
	}
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g=new Graph(6); 
        g.addEdge(0, 1);  
        g.addEdge(0, 2);  
        g.addEdge(1, 3);  
        g.addEdge(1, 2);  
        g.addEdge(2, 4);  
        g.addEdge(2, 5);  
        g.addEdge(2, 3);  
        g.addEdge(3, 5);  
        g.addEdge(3, 4);  
        g.addEdge(4, 5);  
        System.out.println("Following is a Topological Sort"); 
        g.topoSort(); 
  
    } 
}
