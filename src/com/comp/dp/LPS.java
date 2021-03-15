package com.comp.dp;


// Longest Palindromic Subsequence
public class LPS {
	
	static int lps(String str) {
		int n = str.length();
		int i, j, cl;
		
		int[][] dp = new int[n][n];
		for (i = 0; i < n; i++)
			dp[i][i] = 1;
		
		// Start with strings of length 2 and then keep on increasing size.
		for (cl = 2; cl <= n; cl++) {
			
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				
				// If last chars are equal and length of string = 2
				if (str.charAt(i) == str.charAt(j) && cl == 2) {
					dp[i][j] = 2;
				}
				// If last chars are equal then it is lps(i+1,j-1) + 2
				else if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}
				// If last chars are not equal then it is either lps(i,j-1) or lps(i+1,j)
				else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		return dp[0][n - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(lps("abcdecba"));
	}
}
