package com.comp.dp;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

/*
1
4
1 6 5 11
*/
public class MinSumPartition {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int A[] = new int[n];
			for (int i = 0; i < n; i++)
				A[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.minDiffernce(A, n));
		}
	}
} // } Driver Code Ends

//User function Template for Java

class Solution {
	
	public int minDiffernce(int arr[], int n) {
		// Your code goes here
		int sum = 0;
		for (int x : arr) {
			sum += x;
		}
		boolean[][] dp = new boolean[n + 1][sum + 1];
		
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= sum; i++) {
			dp[0][i] = false;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (arr[i - 1] <= j)
					dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int j = 0; j <= sum / 2; j++) {
			if (dp[n][j]) {
				ans = Math.min(ans, sum - 2 * j);
			}
		}
		
		return ans;
		
	}
}