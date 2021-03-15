package com.comp.dp;

import java.util.Scanner;

public class LCSWildcardPatternMatching {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t > 0) {
			String pat = sc.nextLine();
			String text = sc.nextLine();
			System.out.println(wildCard(pat, text));
			t--;
		}
	}
	
	static int wildCard(String pat, String str) {
		int n = str.length();
		int m = pat.length();
		
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;
		
		for (int j = 1; j <= m; j++) {
			if (pat.charAt(j - 1) == '*')
				dp[0][j] = dp[0][j - 1];
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pat.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else if (pat.charAt(j - 1) == '?' || str.charAt(i - 1) == pat.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		
		return dp[n][m] ? 1 : 0;
	}
}
