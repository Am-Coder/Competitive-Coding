package com.comp.algos;

public class EuclidsTotientFunction {
	//gives the count of numbers from 1 to n that are coprime to n
	// Totient formula ==> phi(n) = n * [(1 - 1/p1)(1 - 1/p2)(1 - 1/p3)...(1 - 1/pn)] where p1.p2,...pn are prime factors of n
	static int phi( int n ) {
	    // Initialize result as n 
		int result = n;
	    
		// Consider all prime factors  
	    // of n and subtract their 
	    // multiples from result 
		for( int i=2; i*i<=n; i++) {
			
	        // Check if p is  
	        // a prime factor. 
			if(n%i == 0) {
	            // If yes, then update 
	            // n and result 
				while( n%i == 0 ) {
					n /= i;
				}
				result -= result/i;
				
				
			}
		}
	    // If n has a prime factor 
	    // greater than sqrt(n) 
	    // (There can be at-most  
	    // one such prime factor) 	
		if( n >1 )
			result -= result/n;
		
		return result;
		
	}
	
	public static void main (String[] args) 
	{ 
	    int n; 
	    for (n = 1; n <= 10; n++) 
	        System.out.println("phi(" + n +  
	                           ") = " + phi(n)); 
	} 
}
