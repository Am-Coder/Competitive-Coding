package com.comp.algos.graph;
import java.util.*; 

//Algo:
//    1. Initialize all vertices as unvisited.
//    2. Now choose vertex which is unvisited and has zero indegree and decrease 
//    indegree of all those vertices by 1 (corresponding to removing edges) now add this 
//    vertex to result and call the recursive function again and backtrack.
//    3. After returning from function reset values of visited, result and indegree for enumeration 
//    of other possibilities.

public class TopologicalSortDAGAllPossiblilities {
	//Java program to print all topolgical sorts of a graph 

	static class Graph { 
		int V;  

		List<Integer> adjListArray[]; 

		public Graph(int V) { 

			this.V = V; 

			List<Integer> adjListArray[] = new LinkedList[V]; 

			this.adjListArray = adjListArray; 

			for (int i = 0; i < V; i++) { 
				adjListArray[i] = new LinkedList<>(); 
			} 
		} 
		public void addEdge(int src, int dest) { 

			this.adjListArray[src].add(dest); 

		} 
		
		private void allTopologicalSortsUtil(boolean[] visited, 
							int[] indegree, Stack<Integer> stack) { 
			// To indicate whether all topological are found 
			// or not 
			boolean flag = false; 

			for (int i = 0; i < this.V; i++) { 
				// If indegree is 0 and not yet visited then 
				// only choose that vertex 
				if (!visited[i] && indegree[i] == 0) { 
					
					// including in result 
					visited[i] = true; 
					stack.push(i); 
					for (int adjacent : this.adjListArray[i]) { 
						indegree[adjacent]--; 
					} 
					allTopologicalSortsUtil(visited, indegree, stack); 
					
					// resetting visited, res and indegree for 
					// backtracking 
					visited[i] = false; 
					stack.pop();
					for (int adjacent : this.adjListArray[i]) { 
						indegree[adjacent]++; 
					} 

					flag = true; 
				} 
			} 
			// We reach here if all vertices are visited. 
			// So we print the solution here 
			if (!flag) { 
				stack.forEach(i -> System.out.print(i + " ")); 
				System.out.println(); 
			} 

		} 
		
		public void allTopologicalSorts() { 
			// Mark all the vertices as not visited 
			boolean[] visited = new boolean[this.V]; 

			int[] indegree = new int[this.V]; 

			for (int i = 0; i < this.V; i++) { 

				for (int var : this.adjListArray[i]) { 
					indegree[var]++; 
				} 
			} 

			Stack<Integer> stack = new Stack<>(); 

			allTopologicalSortsUtil(visited, indegree, stack); 
		} 
	}

	 
	public static void main(String[] args) { 

		Graph graph = new Graph(6); 
		graph.addEdge(5, 2); 
		graph.addEdge(5, 0); 
		graph.addEdge(4, 0); 
		graph.addEdge(4, 1); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 1); 

		System.out.println("All Topological sorts"); 
		graph.allTopologicalSorts(); 
	} 
}
