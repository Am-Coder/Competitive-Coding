package com.comp.dp;

public class NewmanShanksWilliamPrime {
		
	static int getNSW(int n) {
		
		int[] nsw = new int[n+1];
		nsw[0] = 1;
		nsw[1] = 1;
		
		for(int i=2; i<=n; i++) {
			nsw[i] = 2*nsw[i-1] + nsw[i-2];
		}
		
		return nsw[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(getNSW(5));
	}
}
