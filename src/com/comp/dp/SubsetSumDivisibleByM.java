package com.comp.dp;

import java.util.Arrays;

public class SubsetSumDivisibleByM {
		
	static boolean check(int[] arr, int n, int m) {
		if(n>m)
			return true;
		
		boolean[] dp = new boolean[m];
		
		Arrays.fill(dp, false);
		
		for(int i=0; i<n; i++) {
			
			if(dp[0])
				return true;
			
			boolean[] temp = new boolean[m];
			Arrays.fill(temp, false);
			
			for(int j=0; j<m; j++) {
				
				if(dp[j] == true) {
					if(dp[(j+arr[i])%m] == false) {
						temp[(j + arr[i])%m] = true;
					}
				}
			}
			
			for(int j=0; j<m; j++) {
				if(temp[j])
					dp[j] = true;
			}
			
			dp[arr[i]%m] = true;
			
			
		}
		return dp[0];
	}
	
//	static boolean divCheck(int[] set,int m, int n) {
//		
//		
//		
//		boolean[][] div = new boolean[ m + 1 ][ n + 1 ];
//		
//		for(int i=0; i<=n; i++) {
//			div[0][i] = false;
//			div[1][i] = true;
//		}
//		
//		for(int i=1; i<=m; i++) {
//			div[i][0] = true;
//		}
//		
//		for(int i=2; i<=m; i++) {
//			
//			for(int j=1; j<=n; j++) {
//				if(j>i)
//					div[i][j] = true;
//				
//				
//				
//			}
//		}
//		
//	}
	public static void main(String[] args) {
		
	}
}
