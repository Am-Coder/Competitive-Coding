package com.comp.dp;

import java.util.Arrays;

public class subsetsumProblem {

	//recursive approach
	static boolean countSubset(int[] arr,int sum, int n) {
//		int[] res = new int[n+1];
		
		if(sum == 0)
			return true;
		
		if(sum != 0 && n<=0) {
			return false;
		}
		
		if(arr[n - 1] > sum)
			return countSubset( arr, sum, n - 1);
		
		return countSubset(arr, sum - arr[n-1], n-1)|| countSubset(arr, sum, n-1);
	}
	
	//TopDown approach not so efficient
	static int[] dp = new int[100];
	static int cout(int[] arr,int sum, int n) {
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		if(sum == 0)
			return 1;
		
		if(sum != 0 && n<=0) {
			return 0;
		}
		
		if(arr[n - 1] > sum)
			return dp[n] = cout( arr, sum, n - 1);
		
		return dp[n] = cout(arr, sum - arr[n-1], n-1) +  cout(arr, sum, n-1);
	}	
		
	//Bottom up approach always efficient
	static boolean cout1( int[] set, int sum, int n ) {
		
        // The value of subset[i][j] will be 
        // true if there is a subset of  
        // set[0..j-1] with sum equal to i 
		boolean[][] sub = new boolean[sum +1][n + 1];
		
		for(int i=0; i<=n; i++) {
			sub[0][i] = true; 
		}
		
		for(int i=1; i<=sum; i++) {
			sub[i][0] = false;
		}
		
		for(int i=1; i<=sum; i++) {
			
			for(int j=1; j<=n; j++) {
				
				sub[i][j] = sub[i][j-1];
				if( i >= set[j-1])
					sub[i][j] = sub[i][j] || sub[i - set[j - 1]][j-1];
				
			}
			
		}
		return sub[sum][n];
	}	
	public static void main(String[] args) {
		int[] arr = {3, 34, 4, 12, 5, 2};
		Arrays.fill(dp, -1);
		cout(arr,60,6);
		for (int i : dp) {
			System.out.print(i + " ");
		}
		System.out.println(	cout(arr,9,6)>0 );
	}	
}		
		