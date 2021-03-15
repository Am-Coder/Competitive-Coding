package com.comp.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
	
	//Adjacency List used
	static HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
//    static HashMap<Integer,LinkedList<Integer>> graph=new HashMap<>(); 
	
	public static void addEdge(int u, int v ) {
		
		if( graph.containsKey(u)){
			LinkedList<Integer> ll = graph.get(u);
			ll.add(v);
			
		}else {
			LinkedList<Integer> ll = new LinkedList<>();
			ll.add(v);
			graph.put( u, ll );
		}
		
	}
	
	public static void BFSutil(int u, ArrayList<Boolean> vis) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(u);
		vis.set(u, true);
		
		
		while( !q.isEmpty() ) {
			int n = q.poll();
			System.out.print(n+" " );
			if( graph.containsKey(n) ) {
				
				Iterator<Integer> it = graph.get(n).listIterator();
				while( it.hasNext()) {
					int val = it.next();
					if( !vis.get(val)) {
						vis.set(val, true);
						q.add(val);
					}
				}
			}
		}
	}
	
	public static void DFSutil(int u, ArrayList<Boolean> vis ) {
		
		vis.set( u, true );
		System.out.print( u + " " );
		
		if(graph.get(u) != null ) {
			Iterator<Integer> it = graph.get(u).listIterator();
			while( it.hasNext() ) {
				int val = it.next();
				if(!vis.get(val)) {
					DFSutil(val,vis);
				}
			}
		}
	}
	public static void bfs( int u ) {
		ArrayList<Boolean> arr = new ArrayList<>();
		
		for( int i=0; i<u; i++ ) {
			arr.add( i, false );
		}
		
		for( int i=0; i<u; i++ ) {
			if(!arr.get(i)) {
				BFSutil(i,arr);
			}
		}
		
	}
	
	public static void dfs( int u ) {
		ArrayList<Boolean> arr = new ArrayList<>();
		
		for( int i=0; i<u; i++ ) {
			arr.add( i, false );
		}
		
		for( int i=0; i<u; i++ ) {
			if(!arr.get(i)) {
				DFSutil(i,arr);
			}
		}
		
	}
	
    public static void main(String[] args)  
    { 
        int v=5; 
        addEdge(0, 4);  
        addEdge(1, 2);  
        addEdge(1, 3);  
        addEdge(1, 4);  
        addEdge(2, 3);  
        addEdge(3, 4);  
        bfs(v);   
        System.out.println();
    	dfs(v);
//    	int v = 4;
//    	addEdge(0,1);
//        addEdge(0, 2); 
//        addEdge(1, 2); 
//        addEdge(2, 0); 
//        addEdge(2, 3); 
//        addEdge(3, 3); 
//        dfs(v);
    } 
}
