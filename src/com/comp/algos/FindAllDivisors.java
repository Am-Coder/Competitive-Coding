package com.comp.algos;

public class FindAllDivisors {
	
	public static void main(String[] args) {
		System.out.println(printDivisors(909655296));
	}
	
	// Function to print the divisors 
	static long printDivisors(int n) 
	{ 	long sum = 0;
	    // Note that this loop runs till square root 
	    for (int i=1; i<=Math.sqrt(n); i++) 
	    { 	
	        if (n%i == 0) 
	        { 
	            // If divisors are equal, print only one 
	            if (n/i == i) {
//	                System.out.printf("%d ", i);
	                sum += i ;
	            }
	            else { // Otherwise print both 
//	                System.out.printf("%d %d ", i, n/i);
	                sum += i;
	                sum += n/i;
	            }
	        } 
	    }
	    return sum;
	} 
}
