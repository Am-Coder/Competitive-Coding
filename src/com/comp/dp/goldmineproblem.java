package com.comp.dp;

import java.util.Arrays;

public class goldmineproblem {
		
	static int gmine(int[][] gold,int m ,int n) {
		
		int[][] mine = new int[m][n];
		
		for(int[] row : mine) {
			Arrays.fill(row, 0);
		}
		
		for	(int col = n - 1; col >= 0; col--) {
			
			for	(int row = 0; row < m; row++) {
				
				int right = (col == n - 1)	? 0 : mine[row][col + 1];
				
				int right_up = ( row == 0 || col == n - 1) ? 0 : mine[row - 1][col + 1];
				
				int right_down = (row == m - 1 || col == n - 1) ? 0 : mine[row + 1][col +1];
				
				mine[row][col] = gold[row][col] + Math.max( right, Math.max(right_up, right_down ));
			}
			
		}
		
		int res = mine[0][0];
		
		for	( int i = 1; i < m; i++ ) {
			res = Math.max( res, mine[i][0] );
		}
		
		return res;
	}	
		
	public static void main(String[] args) {
		
	}	
}		
