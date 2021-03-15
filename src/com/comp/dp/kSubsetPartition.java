package com.comp.dp;
//Stirling numbers of the second kind
//S(n, k) = k*S(n-1, k) + S(n-1, k-1) 

public class kSubsetPartition {
	
	
	
	// Returns count of different partitions of n 
	// elements in k subsets 
	int countP_recursive(int n, int k) 
	{ 
	  // Base cases 
	  if (n == 0 || k == 0 || k > n) 
	     return 0; 
	  if (k == 1 || k == n) 
	      return 1; 
	  
	  // S(n+1, k) = k*S(n, k) + S(n, k-1) 
	  return  k*countP(n-1, k) + countP(n-1, k-1); 
	  
	} 
	
	
	
	// Returns count of different partitions of n  
	// elements in k subsets  
	static int countP(int n, int k)  
	{  
	    // Table to store results of subproblems  
	    int[][] dp = new int[n+1][k+1];  
	      
	    // Base cases  
	    for (int i = 0; i <= n; i++)  
	    dp[i][0] = 0;  
	    for (int i = 0; i <= k; i++)  
	    dp[0][k] = 0;  
	      
	    // Fill rest of the entries in dp[][] 
	    // in bottom up manner  
	    for (int i = 1; i <= n; i++)  
	    for (int j = 1; j <= k; j++)  
	    if (j == 1 || i == j)  
	        dp[i][j] = 1;  
	    else
	        dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];  
	          
	        return dp[n][k];  
	      
	}  
	  
	// Driver program  
	public static void main(String[] args )  
	{  
	    System.out.println(countP(7, 3));  
	}  
} 

