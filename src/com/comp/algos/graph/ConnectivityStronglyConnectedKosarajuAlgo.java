package com.comp.algos.graph;
import java.util.*;


/*	1) Initialize all vertices as not visited.
	
	2) Do a DFS traversal of graph starting from any arbitrary vertex v. If DFS traversal doesn’t visit all vertices, then return false.
	
	3) Reverse all arcs (or find transpose or reverse of graph)
	
	4) Mark all vertices as not-visited in reversed graph.
	
	5) Do a DFS traversal of reversed graph starting from same vertex v (Same as step 2). 
		If DFS traversal doesn’t visit all vertices, then return false. Otherwise return true.

	The idea is, if every node can be reached from a vertex v, and every node can reach v, then the graph is strongly connected. 
	In step 2, we check if all vertices are reachable from v. 
	In step 4, we check if all vertices can reach v (In reversed graph, if all vertices are reachable from v, 
	then all vertices can reach v in original graph). 		
*/
public class ConnectivityStronglyConnectedKosarajuAlgo {
	static class Graph{
		 private int V;   // No. of vertices 
		    private LinkedList<Integer> adj[]; //Adjacency List 
		  
		    //Constructor 
		    Graph(int v) 
		    { 
		        V = v; 
		        adj = new LinkedList[v]; 
		        for (int i=0; i<v; ++i) 
		            adj[i] = new LinkedList(); 
		    } 
		  
		    //Function to add an edge into the graph 
		    void addEdge(int v,int w) {  adj[v].add(w); } 
		  
		    // A recursive function to print DFS starting from v 
		    void DFSUtil(int v,Boolean visited[]) 
		    { 
		        // Mark the current node as visited and print it 
		        visited[v] = true; 
		  
		        int n; 
		  
		        // Recur for all the vertices adjacent to this vertex 
		        Iterator<Integer> i = adj[v].iterator(); 
		        while (i.hasNext()) 
		        { 
		            n = i.next(); 
		            if (!visited[n]) 
		                DFSUtil(n,visited); 
		        } 
		    } 
		  
		    // Function that returns transpose of this graph 
		    Graph getTranspose() 
		    { 
		        Graph g = new Graph(V); 
		        for (int v = 0; v < V; v++) 
		        { 
		            // Recur for all the vertices adjacent to this vertex 
		            Iterator<Integer> i = adj[v].listIterator(); 
		            while (i.hasNext()) 
		                g.adj[i.next()].add(v); 
		        } 
		        return g; 
		    } 
		  
		    // The main function that returns true if graph is strongly 
		    // connected 
		    Boolean isSC() 
		    { 
		        // Step 1: Mark all the vertices as not visited 
		        // (For first DFS) 
		        Boolean visited[] = new Boolean[V]; 
		        for (int i = 0; i < V; i++) 
		            visited[i] = false; 
		  
		        // Step 2: Do DFS traversal starting from first vertex. 
		        DFSUtil(0, visited); 
		  
		        // If DFS traversal doesn't visit all vertices, then 
		        // return false. 
		        for (int i = 0; i < V; i++) 
		            if (visited[i] == false) 
		                return false; 
		  
		        // Step 3: Create a reversed graph 
		        Graph gr = getTranspose(); 
		  
		        // Step 4: Mark all the vertices as not visited (For 
		        // second DFS) 
		        for (int i = 0; i < V; i++) 
		            visited[i] = false; 
		  
		        // Step 5: Do DFS for reversed graph starting from 
		        // first vertex. Staring Vertex must be same starting 
		        // point of first DFS 
		        gr.DFSUtil(0, visited); 
		  
		        // If all vertices are not visited in second DFS, then 
		        // return false 
		        for (int i = 0; i < V; i++) 
		            if (visited[i] == false) 
		                return false; 
		  
		        return true; 
		    } 
		  
		    
	}
	public static void main(String args[]) 
    { 
        // Create graphs given in the above diagrams 
        Graph g1 = new Graph(5); 
        g1.addEdge(0, 1); 
        g1.addEdge(1, 2); 
        g1.addEdge(2, 3); 
        g1.addEdge(3, 0); 
        g1.addEdge(2, 4); 
        g1.addEdge(4, 2); 
        if (g1.isSC()) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
  
        Graph g2 = new Graph(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3); 
        if (g2.isSC()) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
}
