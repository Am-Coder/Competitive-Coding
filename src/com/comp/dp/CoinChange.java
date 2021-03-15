package com.comp.dp;

// It is an example of unbounded knapsack
public class CoinChange {
	static int[] arr = {1,2,2};

	// My Solution as seen from Aadity Vermas video
	public long knapsack_count(int S[], int m, int n) {
		//code here.
		
		long[][] dp = new long[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = 1l;
		}
		
		for (int i = 1; i <= n; i++) {
			dp[0][i] = 0l;
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j];
				if (S[i - 1] <= j) {
					dp[i][j] += dp[i][j - S[i - 1]];
				}
			}
		}
		return dp[m][n];
		
	}
	
	public static int count( int S[], int m, int n ) 
	{ 
	    // table[i] will be storing the number of solutions for 
	    // value i. We need n+1 rows as the table is constructed 
	    // in bottom up manner using the base case (n = 0) 
	    int table[]=new int[n+1]; 
	  
	    // Base case (If given value is 0) 
	    table[0] = 1; 
	  
	    // Pick all coins one by one and update the table[] values 
	    // after the index greater than or equal to the value of the 
	    // picked coin 
	    for(int i=0; i<m; i++) 
	        for(int j=S[i]; j<=n; j++) 
	            table[j] += table[j-S[i]]; 
	  
	    return table[n]; 
	} 
	
	
	int count1( int S[], int m, int n ) 
	{ 
	    int i, j, x, y; 
	  
	    // We need n+1 rows as the table  
	    // is constructed in bottom up 
	    // manner using the base case 0 
	    // value case (n = 0) 
	    int[][] table = new int[n + 1][m]; 
	      
	    // Fill the enteries for 0 
	    // value case (n = 0) 
	    for (i = 0; i < m; i++) 
	        table[0][i] = 1; 
	  
	    // Fill rest of the table entries  
	    // in bottom up manner  
	    for (i = 1; i < n + 1; i++) 
	    { 
	        for (j = 0; j < m; j++) 
	        { 
	            // Count of solutions including S[j] 
	            x = (i-S[j] >= 0) ? table[i - S[j]][j] : 0; 
	  
	            // Count of solutions excluding S[j] 
	            y = (j >= 1) ? table[i][j - 1] : 0; 
	  
	            // total count 
	            table[i][j] = x + y; 
	        } 
	    } 
	    return table[n][m - 1]; 
	} 
	public static void main(String[] args) {
		System.out.println();
	}
}
