package com.comp.algos;

import java.util.Arrays;
import java.util.Scanner;

public class MaxXORSubset {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[10004];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			MaxXOR g = new MaxXOR();
			System.out.println(g.maxSubarrayXOR(a, n));
		}
	}
}

/*Complete the function below*/
class MaxXOR {
	
	static int[][] dp = new int[101][101];
	
	public static int maxSubarrayXOR(int set[], int n) {
		//add code here.
		for (int i = 0; i <= 100; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		return maxi(set, 0, n, 0);
	}
	
	public static int maxi(int[] set, int i, int n, int val) {
		if (i == n) {
			return val;
		}
		if (dp[val][i] != -1)
			return dp[val][i];
		
		return dp[val][i] = Math.max(maxi(set, i + 1, n, val ^ set[i]), maxi(set, i + 1, n, val));
	}
}
