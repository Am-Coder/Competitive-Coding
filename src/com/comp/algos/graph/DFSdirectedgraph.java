package com.comp.algos.graph;

import java.util.*;
import java.io.*;

public class DFSdirectedgraph {
	public static class Graph{
		static int V;
		static LinkedList<Integer>[] adj;
	
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V+1];
			for( int i=1; i<=V; i++ ) {
				adj[i] = new LinkedList<>();
			}
		}
		
		static void addEdge(int a, int b) {
			adj[a].add(b);
		}
		
		static void DFS(int v, boolean[] visit) {
			if( visit[v] ) {
				return;
			}
			visit[v] = true;
			System.out.print(v + " ");
			for( int ch: adj[v] ) {
				if ( !visit[ch] )
					DFS(ch, visit);
			}
		}
	}
    public static void main(String args[]) 
    { 
        Graph g = new Graph(4); 
  
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(3, 1); 
        g.addEdge(3, 4); 
        g.addEdge(4, 4); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
        boolean[] visit = new boolean[4+1];
        g.DFS(3, visit); 
    } 
	
}
