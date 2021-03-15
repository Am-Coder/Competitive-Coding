package com.comp.dp;

//P(n) = P(P(n - 1)) + P(n - P(n - 1)) 
public class NewManConwaySequence {
	
	//Recursive Approach
	static int recConway( int n ) {
		
		if(n == 1 || n==2) {
			return 1;
		}
		
		return recConway(recConway(n-1)) + recConway( n - recConway( n - 1 ));
	}
	
	
	//Bottom up approach
	static int newmanConway( int n ) {
		
		int[] nc = new int[n+1];
		nc[1] = 1;
		nc[2] = 1;
		
		for(int i = 3; i<=n; i++) {
			
			nc[i] = nc[nc[i - 1]] + nc[i - nc[i - 1]];
			
		}
		
		return nc[n];
	}
	
	public static void main( String[] args ) {
		
		long a = System.nanoTime();
		System.out.println(newmanConway(30));
		long b = System.nanoTime();
		System.out.println(b - a);
		System.out.println("----------------------------------------------------------------------");
		a = System.nanoTime();
		System.out.println(recConway(30));
		b = System.nanoTime();
		System.out.println(b - a);
	}
}
