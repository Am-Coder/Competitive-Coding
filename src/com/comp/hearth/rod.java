package com.comp.hearth;

public class rod {
		
	static int rodcut( int[] price, int len ) {
		
		int[] arr = new int[len+1];
		arr[0] = 0;
		int q;
		for( int i=1; i<=len; i++ ) {
			q = Integer.MIN_VALUE;
			for( int j=0; j<=i; j++ ) {
				q = Math.max( q, price[j] + arr[i-j-1] );
			}
			arr[i] = q;
		}
		return arr[len];
	}	
	
}
