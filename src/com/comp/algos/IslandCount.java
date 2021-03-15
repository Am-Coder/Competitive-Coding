package com.comp.algos;

//Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
//
//Example:
//
//Input : mat[][] = {{1, 1, 0, 0, 0},
//                   {0, 1, 0, 0, 1},
//                   {1, 0, 0, 1, 1},
//                   {0, 0, 0, 0, 0},
//                   {1, 0, 1, 0, 1} 
//Output : 5
public class IslandCount {
	
	static int ROW, COL;
	
	public static void dfs( int[][] M, int row, int col, boolean[][] vis ) {
		
		int[] rown = {0,0,1,1,1,-1,-1,-1};
		int[] coln = {-1,1,-1,0,1,-1,0,1};
		
		vis[row][col] = true;
		for( int i=0; i<8; i++ ) {
			
			if( row + rown[i] >=0 && row + rown[i]<ROW && col + coln[i]>=0 && col + coln[i]<COL && (!vis[row + rown[i]][col + coln[i]] && M[row + rown[i]][col + coln[i]] == 1) ) {
				dfs(M, row + rown[i], col + coln[i], vis);
			}
			
		}
		
	}
	
	public static int dd( int[][] M ) {
		boolean[][] vis = new boolean[ROW][COL];

		int count = 0;
		for( int i=0; i<ROW; i++ ) {
			
			for( int j=0; j<COL; j++) {
				
				if(!vis[i][j] && M[i][j] == 1) {
					dfs( M, i, j, vis);
					count++;
				}
				
			}
		}
		
		return count;
	}
    public static void main(String[] args) throws java.lang.Exception 
    { 
		int M[][] = new int[][] { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 0, 1, 0, 0 } };
		ROW = 4;
		COL = 4;
        System.out.println("Number of islands is: " + dd(M)); 
    } 
}
