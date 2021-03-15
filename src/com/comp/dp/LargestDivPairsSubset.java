package com.comp.dp;

import java.util.Arrays;

public class LargestDivPairsSubset {
	
	//Bottom up approach ==> largest divisible pair subset
	//dp holds the length of largest subsets starting from arr[i] such that the condition is followed
	static int ldps(int[] arr, int m ) {
		int[] dp = new int[ m ];
		dp[ m - 1 ] = 0; 
		Arrays.sort(arr);
		for(int i = m - 2; i >=0; i--) {
			int mxm = 0;
			for(int j = i+1; j < m; j++) {
				if( arr[j]%arr[i] == 0 )
					mxm = Math.max(mxm, dp[j]);
			}
			
			dp[i] = 1 + mxm;
		}
		
		return Arrays.stream(dp).max().getAsInt();
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,8,9,16,20};
		System.out.println(ldps(arr, arr.length));
		
	}
}
