package com.comp.acmsummer;

import java.util.LinkedList;
import java.util.Scanner;

public class ui { 
    
  // DFS on tree 
  public static void dfs(LinkedList<Integer> list[], 
                           int node, int arrival) 
  { 
      // Printing traversed node 
      System.out.println(node); 
     
      // Traversing adjacent edges 
      for (int i = 0; i < list[node].size(); i++) { 
     
          // Not traversing the parent node 
          if (list[node].get(i) != arrival) 
              dfs(list, list[node].get(i), node); 
      } 
  } 
    
  /* Driver program to test above function */
  public static void main(String[] args)  
  { 
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
     
      // Adjacency list 
      LinkedList<Integer> list[] = new LinkedList[n+1];      
        
      for (int i = 0; i < list.length; i ++){ 
          list[i] = new LinkedList<Integer>(); 
      } 
        
      // Designing the tree 
		
		for( int i = 1; i <= n - 1; i++ ) {
			int u = s.nextInt();
			int v = s.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
//      list[1].add(2); 
//      list[2].add(1); 
//     
//      list[1].add(3); 
//      list[3].add(1); 
//     
//      list[2].add(4); 
//      list[4].add(2); 
//     
//      list[3].add(5); 
//      list[5].add(3); 
     
      // Function call 
      dfs(list, 1, 0); 
        
        
  } }
