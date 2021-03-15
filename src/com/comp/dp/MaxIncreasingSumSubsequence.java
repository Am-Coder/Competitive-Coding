package com.comp.dp;

import java.io.*;
import java.util.*;

/*
1
3
13 14 14

*/
/*
Parent question is Longest Increasing Subsequence
*/
public class MaxIncreasingSumSubsequence {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int Arr[] = new int[n];
			for (int i = 0; i < n; i++)
				Arr[i] = sc.nextInt();
			Solver ob = new Solver();
			System.out.println(ob.maxSumIS(Arr, n));
		}
	}
} // } Driver Code Ends

//User function Template for Java

class Solver {
	
	public int maxSumIS(int arr[], int n) {
		//code here.
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = arr[i - 1];
		}
		int max = dp[1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[j - 1] < arr[i - 1] && dp[j] + arr[i - 1] > dp[i]) {
					dp[i] = dp[j] + arr[i - 1];
					max = Math.max(max, dp[i]);
				}
			}
		}
		return max;
	}
}
