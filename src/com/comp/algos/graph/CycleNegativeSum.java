package com.comp.algos.graph;

import java.util.Arrays;

//Bellman Ford Algorithm - Relax edges V - 1 times and then one more time and if there is a change then
//-ve cycle exists

public class CycleNegativeSum {
	
	static class Edge {
		int src, dest, wt;
	}
	
	static class Graph {
		int V, E;
		Edge[] edge;
		
		Graph( int V, int E ){
			this.V = V;
			this.E = E;
			this.edge = new Edge[E];
			
			for( int i=0; i<E; i++ ) {
				edge[i] = new Edge();
			}
			
		}
		
		void addEdge(int edgeno, int s, int d, int wt ) {
			edge[edgeno].src = s;
			edge[edgeno].dest = d;
			edge[edgeno].wt = wt;
		}
		
		boolean checkNegativeCycle( int src ) {
			int[] dist = new int[V];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[src] = 0;
			
			for( int i=1; i<V; i++ ) {
				for( int j=0; j<E; j++ ) {
	                int u = edge[j].src; 
	                int v = edge[j].dest; 
	                int weight = edge[j].wt; 
	                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
	                    dist[v] = dist[u] + weight; 
				}
			}
			
			for( int j=0; j<E; j++ ) {
                int u = edge[j].src; 
                int v = edge[j].dest; 
                int weight = edge[j].wt; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
                    return true; 
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
        int V = 5, E = 8; 
        Graph g = new Graph(V, E); 
  
        g.addEdge(0, 0, 1, -1);

        g.addEdge(1, 0, 2, 4);
  
        g.addEdge(2, 1, 2, 3);
  
        g.addEdge(3, 1, 3, 2);
  
        g.addEdge(4, 1, 4, 2);
  
        g.addEdge(5, 3, 2, 5);
  
        g.addEdge(6, 3, 1, 1);
  
        g.addEdge(7, 4, 3, -3);
  
        if (g.checkNegativeCycle(0)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
	}
}
