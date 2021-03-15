package com.comp.dp;

import java.util.Scanner;

/*
	Longest Even Length Substring such that Sum of First and Second Half is same
*/
public class LongestEvenLenSubstring {
	
	public static void main(String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		while (t-- > 0) {
			String str = s.nextLine();
			int num = finlen(str);
			System.out.println(num);
		}
	}
	
	static int finlen(String str) {
		int n = str.length();
		int maxlen = 0;
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			dp[i][i] = str.charAt(i) - '0';
		}
		
		for (int len = 2; len <= n; len++) {
			
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				int k = len / 2;
				
				dp[i][j] = dp[i][j - k] + dp[j - k + 1][j];
				if (len % 2 == 0 && dp[i][j - k] == dp[(j - k + 1)][j] && len > maxlen)
					maxlen = len;
			}
			
		}
		
		return maxlen;
	}
}
