package com.comp.algos.graph;

import java.util.LinkedList;
import java.util.*;



//Backtracking
public class Path2Vertices {
	static Stack<Integer> st = new Stack<>();

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
		
		static void DFS(int v, boolean[] visit, Stack st, int dest) {
			if( v == dest ) {
				st.push(v);
				System.out.println(st.toString());
				st.pop();
				return;
			}
			
			if( visit[v] ) {
				return;
			}
			
			st.push(v);
			visit[v] = true;

			for( int ch: adj[v] ) {
				if ( !visit[ch] )
					DFS(ch, visit, st, dest);
			}
			visit[v] = false;
			st.pop();
		}
	}
    public static void main(String args[]) 
    { 
        Graph g = new Graph(7); 
	    g.addEdge(1, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(2, 4); 
	    g.addEdge(5, 2); 
	    g.addEdge(7, 1); 
	    g.addEdge(7, 5); 
	    g.addEdge(6, 7); 
	    g.addEdge(6, 3); 
	    
        boolean[] visit = new boolean[7+1];
        g.DFS(6, visit, st , 4); 
    } 
	
}
