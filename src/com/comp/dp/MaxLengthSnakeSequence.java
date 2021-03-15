package com.comp.dp;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthSnakeSequence {
	
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static void mlsnake(int[][] arr,int n, int m) {
		
		
		
		if( Math.abs(arr[n][m] - arr[n+1][m]) == 1) {
			
			
			
		}else if( Math.abs(arr[n][m] - arr[n][m+1]) == 1 ) {
			
			
			
		}
		
	}
	
	static List<Point> findPath( int[][] grid, int i, int j ){
			
		List<Point> path = new ArrayList<Point>() ;
		
		Point pt =  new Point( i, j );
		path.add(pt);
	    while (grid[i][j] != 0) 
	    { 
	       if (i > 0 && 
	           grid[i][j] - 1 == grid[i - 1][j]) 
	       { 
	           pt = new Point( i - 1, j ); 
	           path.add(0, pt); 
	           i--; 
	       } 
	       else if (j > 0 && 
	                grid[i][j] - 1 == grid[i][j - 1]) 
       { 		
	           pt = new Point(i, j - 1); 
	           path.add(0,pt); 
	           j--; 
	       } 
	    } 
	  
	    return path; 
	}
	
	static void findMinSequence( int mat[][] , int m, int n) {
		
		int dp[][] = new int[m][n];
		int max_len = 0;
		int max_row = 0;
		int max_col = 0;
		
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) {
			
				if(i !=0 || j != 0) {
					
					//above
					if( i > 0 && Math.abs(mat[i-1][j] - mat[i][j]) == 1) {
						dp[i][j] = Math.max( dp[i][j], dp[i - 1][j] + 1 );
						if(max_len < dp[i][j]) {
							
							max_len = dp[i][j];
							max_row = i; 
							max_col = j;
						}
					}
					
					//left
					if( j>0 && Math.abs(mat[i][j] - mat[i][j-1])==1 ) {
						dp[i][j] = Math.max( dp[i][j], dp[i][j-1] + 1 );
						if(max_len < dp[i][j]) {
							max_len = dp[i][j];
							max_row = i; 
							max_col = j;
						}					
					}
					
				}
				
			}
			
			List<Point> path = findPath(dp, max_row, max_col);
			
			System.out.println( "MaxLen = " + max_len );
			for( Point p: path) {
				System.out.println("("+p.x + ","+ p.y + ")");
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		int[][] mat = {
		        {9, 6, 5, 2}, 
		        {8, 7, 6, 5}, 
		        {7, 3, 1, 6}, 
		        {1, 1, 1, 7},
		};
		
		findMinSequence(mat, 4, 4);
	}
}
