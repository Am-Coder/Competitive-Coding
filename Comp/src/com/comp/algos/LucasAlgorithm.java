package com.comp.algos;

public class LucasAlgorithm {
	
	//Simple fxn to compute nCr%p
	//Similar to nCr
	static int nCrmodP(int n, int r, int p ) {
		
		int[] arr = new int[n+1];
		
		arr[0] = 1;
		
		for( int i=1; i<=n; i++) {
			
			for( int j=Math.min(i, r); j>0; j--) {
				
				arr[j] = (arr[j] +arr[j-1])%p;
			}
		}
		return arr[r];
	}
	
	
	//Lucas Theorem states the nCr%p == niCri%p where ni and ri are individual same positioned digits in 
	//base p representation of n and r respectively.
	static int nCrmodPLucas( int n, int r, int p) {
		if( r==0)
			return 1;
		
		int ni = n%p;
		int ri = r%p;
		
		return (nCrmodPLucas( n/p, r/p,p)*nCrmodP(ni, ri, p))%p;
	}
	
	public static void main(String[] args) {
		
		System.out.println(nCrmodPLucas(1000, 900, 13));
	}
}
