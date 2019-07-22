package com.comp.dp;

public class TwoDmatrixtraversal {
    
	// Returns count of possible paths to reach 
    // cell at row number m and column number n from 
    // the topmost leftmost cell (cell at 1, 1) 
	static int numOfPaths( int n, int m ) {
        
		// Create a 1D array to store results of subproblems 
		int[] dp = new int[m];
		
		dp[0] = 1;
		
		for( int i=0; i<n; i++ ) {
			
			for( int j=1; j<m; j++ ) {
			
				dp[j] += dp[j-1] ;
				
			}
			
		}
		
		return dp[m - 1] ;
	}
	
	
	
	
	static int numOfWays(int n, int m) {
		
        // Create a 2D table to store results 
        // of subproblems 
		int[][] arr = new int[n][m];
		
        // Count of paths to reach any cell in 
        // first column is 1 
		for( int i=0; i<n; i++ ) {
			arr[i][0] = 1;
		}
		
		
        // Count of paths to reach any cell in 
        // first row is 1 
		for( int j=0; j<m; j++ ) {
			arr[0][j] = 1;
		}
		
		
        // Calculate count of paths for other 
        // cells in bottom-up manner using 
        // the recursive solution 
		for( int i=1; i<n; i++) {
			
			for( int j=1; j<m; j++ ) {
				
                // By uncommenting the last part the 
                // code calculatest he total possible paths 
                // if the diagonal Movements are allowed 
				arr[i][j] = arr[ i - 1 ][ j ] + arr[ i ][ j - 1 ]; //+ count[i-1][j-1]; 
			}
		}
		
		return arr[ n - 1 ][ m - 1 ];
	}
	
    // Driver program to test above function 
    public static void main(String args[]) 
    { 
        System.out.println(numOfWays(3, 3)); 
    } 
}
