package com.comp.acmsummer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Graph{
	public int V;
	public LinkedList<Integer> adj[];
	public int count ;
	public Graph(int a) {
		this.V = a;
		adj = new LinkedList[V];
//		count = new int[V];
		for(int i=0; i<a; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		
		adj[u].add(v);
		
	}
	
	public void dfsutil(int v,boolean[] visited, int[] arr1) {
		visited[v] = true;
		if(arr1[v]<0) {
			count += 1;
		}
		Iterator<Integer> it = adj[v].listIterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n]) {
				dfsutil(n,visited,arr1);
			}
		}
		
	}
	
	public void dfs(int v,int[] arr1) {
		
		boolean[] check = new boolean[V];
		dfsutil(v,check,arr1);
	}
}
public class UltraInstinct {
	static HashMap<Integer, HashSet<Integer>> hmap = new HashMap<>();
	static int[] arr1;
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr1 = new int[n+1];
        for(int i=0; i<n; i++){
            arr1[i] = s.nextInt();
        }
        
        
        for(int i=0; i<n - 1; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            HashSet<Integer> set1 = hmap.getOrDefault(x,new HashSet<Integer>());
            set1.add(y);
            HashSet<Integer> set2 = hmap.getOrDefault(y,new HashSet<Integer>());
            set2.add(x);           
            hmap.put(x, set1);
            hmap.put(y, set2);

        }
        
        Graph g = new Graph(n);
    	HashSet<Integer> hset ;
    	HashSet<Integer> cset = new HashSet<>();

    	Queue<Integer> q = new LinkedList<>();
    	q.add(1);
    	

//    	for(int k: hmap.keySet()) {
//    		hset = hmap.get(k);
//    		System.out.print(k+"-");
//    		for(int val:hset) {
//    			System.out.print(val + " ");
//    		}
//    		System.out.print("\n");
//    	}

    	while(!q.isEmpty()) {
    		int val = q.poll() ;
    		if(cset.contains(val))
    			continue;
    		hset = hmap.get(val) ;
    		if(hset != null) {
	    		for(int key:hset) {   
	        		if(cset.contains(key))
	        			continue;
	
	    			g.addEdge(val-1, key-1);
	    			
	    			q.add(key);
	    			
	    		}
    		}

    		cset.add(val);

    	}
//    	g.dfs(0, arr1);
    	for(int i=0; i<n; i++) {
    		g.dfs(i,arr1);
    		System.out.print(g.count + " ");
    		g.count = 0;
    	}

    }
    

}
