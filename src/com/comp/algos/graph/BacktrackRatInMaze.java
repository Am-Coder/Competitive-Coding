package com.comp.algos.graph;

import java.util.Arrays;


public class BacktrackRatInMaze {
	
	static class MazeSolver{
		int N;
		MazeSolver( int N ){
			this.N = N;
		}
		
		boolean isSafe(int x, int y, int[][] maze) {
			if( x< 0 || x>N-1 || y<0 || y>N-1 || maze[x][y] == 0 )
				return false;
			return true;
        }
        
        boolean chkUtil(int x, int y, int[][] maze, int[][] sol) {        
        	// if (x, y is goal) return true 
            if (x == N - 1 && y == N - 1 && maze[x][y] == 1) { 
                sol[x][y] = 1; 
                return true; 
            } 
      
            // Check if maze[x][y] is valid 
            if (isSafe( x, y, maze) == true) { 
                // mark x, y as part of solution path 
                sol[x][y] = 1; 
      
                /* Move forward in x direction */
                if (chkUtil( x + 1, y, maze, sol)) 
                    return true; 
      
                /* If moving in x direction doesn't give  
                solution then Move down in y direction */
                if (chkUtil( x, y + 1, maze, sol)) 
                    return true; 
      
                /* If none of the above movements works then  
                BACKTRACK: unmark x, y as part of solution  
                path */
                sol[x][y] = 0; 
                }
            return false;
        }
		
		void chk(int[][] maze) {
			int[][] sol = new int[N][N];
			for( int i=0; i<N; i++) {
				Arrays.fill(sol[i], -1);
			}
			sol[0][0] = 1;
			chkUtil(0, 0, maze, sol);
			for( int i=0; i<N; i++ ) {
				for( int j=0; j<N; j++ ) {
					System.out.print(sol[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		MazeSolver kg = new MazeSolver(4);
        int maze[][] = { { 1, 0, 0, 0 }, 
                { 1, 1, 0, 1 }, 
                { 0, 1, 0, 0 }, 
                { 1, 1, 1, 1 } }; 
		kg.chk(maze);
	}
}
