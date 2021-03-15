package com.comp.algos.graph;

import java.util.Arrays;

public class BacktrackKnightTour {
	static class KnightGame{
		int N;
		KnightGame( int N ){
			this.N = N;
		}
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        boolean isSafe(int x, int y, int[][] sol) {
			if( x< 1 || x>N || y<1 || y>N || sol[x][y] != -1 )
				return false;
			return true;
        }
        
        boolean chkUtil(int x, int y, int move, int[][] sol) {
			
			if( move == N*N-1 ) {
				for( int i=1; i<=N; i++ ) {
					for( int j=1; j<=N; j++ ) {
						System.out.print(sol[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
				return true;
			}
			
			for( int i=0; i<8; i++ ) {
				int nx = x + xMove[i];
				int ny = y + yMove[i];
				
				if( isSafe(nx, ny, sol) ) {
					sol[nx][ny] = move;
					if(chkUtil(nx, ny, move + 1, sol))
						return true;
					else
						sol[nx][ny] = -1;
				}
			}
			return false;
		}
		
		void chk(int x, int y) {
			int[][] sol = new int[N+1][N+1];
			for( int i=1; i<=N; i++) {
				Arrays.fill(sol[i], -1);
			}
			sol[x][y] = 0;
			chkUtil(x, y, 1, sol);
		}
	}
	
	public static void main(String[] args) {
		KnightGame kg = new KnightGame(8);
		kg.chk(1, 1);
	}
}
