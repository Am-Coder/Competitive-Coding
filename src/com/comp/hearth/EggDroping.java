package com.comp.hearth;

import java.util.Collections;
import java.util.TreeSet;

import javax.sound.sampled.ReverbType;

public class EggDroping {
	
	public static int eggdrop( int n, int k ) {
		
		if( k==1 || k==0 ) {
			return k;
		}
		
		if( n == 1) {
			return k;
		}
		
		int min = Integer.MAX_VALUE;
		for( int i=1; i<k; i++ ) {
			
			int res = Math.max( eggdrop( n-1, i - 1 ), eggdrop( n, k - i  ) );
			if( res < min )
				min = res;
		}
		
		return 1 + min;
	}
	
	//DP Solution
	public static int eggdrop1( int n, int k) {
		int[][] egg = new int[n+1][k+1];
		int res;
		for( int i=1; i<=n; i++ ) {
			egg[i][0] = 0;
			egg[i][1] = 1;
			
		}
		
		for( int i=1; i<=k; i++ ) {
			egg[1][i] = i;
		}
		
		for( int i=2; i<=n; i++ ) {
			
			for( int j=2; j<= k; j++ ) {
				egg[i][j] = Integer.MAX_VALUE;
				for( int x=1; x<=j; x++ ) {
					res = 1 + Math.max(egg[i-1][x-1], egg[i][j-x]);
					if( res < egg[i][j] ) {
						egg[i][j] = res;
					}
				}
			}
		}
		
		return egg[n][k];
	}
}
