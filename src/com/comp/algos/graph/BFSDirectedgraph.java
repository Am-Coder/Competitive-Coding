package com.comp.algos.graph;

import java.io.*; 
import java.util.*; 
  
//If we use Priority Queue then this becomes Best First Search

public class BFSDirectedgraph {

	static class Graph 
	{ 
	    private int V;    
	    private LinkedList<Integer> adj[];  
	  
	    
	    Graph(int v) 
	    { 
	        V = v; 
	        adj = new LinkedList[v+1]; 
	        for (int i=1; i<=v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    void addEdge(int v,int w) 
	    { 
	        adj[v].add(w); 
	    } 
	  
	    void BFS(int s) 
	    { 
	        boolean visited[] = new boolean[V+1]; 
	  
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	  
	        visited[s]=true; 
	        queue.add(s); 
	  
	        while (queue.size() != 0) 
	        { 
	            s = queue.poll(); 
	            System.out.print(s+" "); 
	  
	            for (int chi: adj[s]) 
	            { 
	                if (!visited[chi]) 
	                { 
	                    visited[chi] = true; 
	                    queue.add(chi); 
	                } 
	            } 
	        } 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        Graph g = new Graph(4); 
	  
	        g.addEdge(1, 2); 
	        g.addEdge(1, 3); 
	        g.addEdge(1, 3); 
	        g.addEdge(3, 1); 
	        g.addEdge(3, 4); 
	        g.addEdge(4, 4); 
	  
	        System.out.println("Following is Breadth First Traversal "+ 
	                           "(starting from vertex 2)"); 
	  
	        g.BFS(3); 
	    } 
	} 
}
