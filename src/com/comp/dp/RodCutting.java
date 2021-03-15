package com.comp.dp;

import java.util.ArrayList;
import java.util.Arrays;

// An example of unbounded knapsack (See Aditya Verma playlist)
public class RodCutting {
	
	static int[] arr ;
	
	//recursive approach
	static int rodcut(int[] price, int p) {
		
		if( p == 0 ) {
			return 0;
		}
		
		int q = Integer.MIN_VALUE;
		for( int i=0; i<p; i++) {
			
			q = Math.max(q, price[i] + rodcut(price, p - i - 1));
			
		}
		
		return q;
	}
	
	// Unbounded Knap Sack 
	static int knapsack_rodcut(int[] arr, int n) {
		
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = 0;
			dp[i][0] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j];
				if (i <= j) {
					dp[i][j] = Math.max(dp[i][j], arr[i - 1] + dp[i][j - i]);
				}
			}
		}
		return dp[n][n];
	}
	
	//Top Down Approach
	static int rodcut1(int[] price, int p) {
		
		if( p == 0 ) {
			return 0;
		}
		
		if( arr[p - 1] >= 0 ) {
			return arr[p - 1];
		}
		
		int q = Integer.MIN_VALUE;
		for( int i=0; i<p; i++) {
			
			q = Math.max(q, price[i] + rodcut(price, p - i - 1));
			
		}
		arr[p - 1] = q ;
		return q;
	}	
		
	//bottom up approach
	static int rodcut2(int[] price, int p) {
		
		int[] arr = new int[ p + 1 ];
		arr[0] = 0;
		int q ;
		for(int i=1; i<=p; i++) {
			
			q = Integer.MIN_VALUE;
			for(int j=0; j<i; j++) {
				q = Math.max( q, price[j] + arr[i - j -1] );
			}
			arr[i] = q;
			
		}
		
		return arr[p];
		
	}
	
	
	public static void main(String[] args) {
		int[] price = {3,5,8,9,10,17,17,20};
		int len = price.length;
		arr = new int[len];
		Arrays.fill(arr, -1);
		long st,end,dur;
		
		st = System.nanoTime();
		System.out.println(rodcut(price, len));
		end = System.nanoTime();
		dur = end - st;
		System.out.println(dur);
		
		st = System.nanoTime();
		System.out.println(rodcut1(price, len));
		end = System.nanoTime();
		dur = end - st;
		System.out.println(dur);

		st = System.nanoTime();
		System.out.println(rodcut2(price, len));
		end = System.nanoTime();
		dur = end - st;
		System.out.println(dur);
	}
}
