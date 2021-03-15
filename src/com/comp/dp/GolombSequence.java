package com.comp.dp;

public class GolombSequence {
	//Bottom up Approach ==> nth term is no of times n appears in the sequence
	static int golombNum(int n) {
		int[] gol = new int[n+1];
		gol[1] = 1;
		System.out.print(1 + " ");
		for(int i=2; i<=n; i++) {
			
			gol[i] = 1 + gol[i - gol[gol[i-1]]];
			System.out.print(gol[i] + " ");
		}
		
		return gol[n];
		
	}
	
	public static void main(String[] args) {
		golombNum(10);
		
	}
	
}
