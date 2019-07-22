package com.comp.dp;


//Sequences of given length where every element is more than or equal to twice of previous

//Given two integers m & n, find the number of possible sequences 
//of length n such that each of the next element is greater than or 
//equal to twice of the previous element but less than or equal to m.


public class TwiceOfPrevious {
	
	static int max;
	
	
	//Memoization
	static int twiceOfPrev(int m, int n) {
			
		if( m < n )
			return 0;
		
		if( n == 0 )
			return 1;
		
		return  twiceOfPrev( m - 1, n ) + twiceOfPrev(m/2 , n);
		
	}	
		
	static int support(int m, int n) {
		int total = 0;
		
		for(int i=1; i<n; i++) {
			
			total += twiceOfPrev( 2*i, n - 1 );
			
		}	
		
		return total;
	}		
		
	public static void main( String[] args ) {
		
		
	}	
		
		
}
