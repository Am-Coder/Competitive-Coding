package com.comp.dp;


//Given a 3 x n board, find the number of ways to fill it with 2 x 1 dominoes. ==> Bottom Up Approach
public class TilingWithDominoes {
	static int countWays(int n) {
		int[] A = new int[n+1];
		int[] B = new int[n+1];
		A[0] = 1;
		A[1] = 0;
		B[0] = 0;
		B[1] = 1;
		
		for(int i=2; i<=n; i++) {
			
			A[i] = A[i-2] + 2*B[i-1];
			B[i] = A[ i - 1 ] + B[ i - 2 ];
			
		}
		
		return A[n];
	}
	
	public static void main(String[] args) {
		System.out.println(countWays(8));
	}
}
