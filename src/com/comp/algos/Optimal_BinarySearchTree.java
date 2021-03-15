package com.comp.algos;

public class Optimal_BinarySearchTree {
	
	// w[i][j] holds freq sum from i to j
	static int[][] w;
	
	//Holds root[i][j] holds root node for i to j
	static int[][] root;
	//Utility sum function to reduce time complexity on O(n^3) 
	static void sum( int[] freq, int n) {
		
		for( int i=0; i<n; i++ ) {
			
			for( int j=0; j<n; j++ ) {
				
				for( int l=i; l<=j; l++ ) {
					w[i][j] += freq[l];
				}
				
			}
			
		}
	}
	
//    static int sum(int freq[], int i, int j) { 
//        int s = 0; 
//        for (int k = i; k <= j; k++) { 
//            if (k >= freq.length) 
//                continue; 
//            s += freq[k]; 
//        } 
//        return s; 
//    }
    
	static int OBST(int[] key, int[] freq, int n) {
		
		int[][] dp = new int[n+1][n+1];
		w = new int[n+1][n+1];
		root = new int[n+1][n+1];

		sum(freq,n);
		
		
		//Length 1 chain
		for( int i=0; i<n; i++ ) {
			dp[i][i] = freq[i];
		}
		
		//Considering chains of length 2,3,....
		for( int L=2; L<=n; L++ ) {
			
			// i is row no dp
			for( int i=0; i<=n-L+1; i++ ) {
				
				//j is column no for dp
				int j = i + L - 1;
				dp[i][j] = Integer.MAX_VALUE;
				
				//Make all values from i to j as a key and then find the optimal key
				for( int r =i ; r<=j; r++ ) {
					int t = ((r>i)?dp[i][r-1]:0) + ((r<j)?dp[r+1][j]:0) +w[i][j];
					if( t<dp[i][j] ) {
						dp[i][j] = t;
						root[i][j] = r;
					}
				}
			}
			
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		int keys[] = { 10, 12, 20 }; 
        int freq[] = { 34, 8, 50 }; 
        int n = keys.length; 
        System.out.println("Cost of Optimal BST is "
                + OBST(keys, freq, n)); 
	}
}
