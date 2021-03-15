package com.comp.dp;

import java.util.Scanner;

public class LongestRepeatingSubsequence {
	
	public static void main(String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		while (t-- > 0) {
			int n = s.nextInt();
			s.nextLine();
			String str = s.nextLine();
			System.out.println(LCS(str, str));
		}
	}
	
	/* 
		 Same as LCS except that we find the LCS of s1 with itself such that common characters don't have same
		 index
	*/
	public static int LCS(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1) && i != j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}
}
