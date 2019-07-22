package com.comp.dp;

public class AssemblyLineScheduling {
	
	//Bottom Up Approach
	static int carAssembly( int a[][], int t[][], int e[], int x[] ) {
		
		int len = a[0].length;
		int[] T1 = new int[len];
		int[] T2 = new int[len];
		
		T1[0] = (a[0][0] + e[0]); 
		T2[0] = (a[1][0] + e[1]);
		for(int i=1; i<len; i++) {
			T1[i] = Math.min( T1[i-1] + a[0][i], T2[i-1] + t[1][i] + a[0][i] );	
			T2[i] = Math.min( T2[i-1] + a[1][i], T1[i-1] + t[0][i] + a[1][i] );		

		}
		
		return Math.min(T1[len - 1] + x[0], T2[len - 1] + x[1]);
		
	}
}
