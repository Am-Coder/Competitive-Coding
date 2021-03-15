package com.comp.dp;

import java.util.Arrays;

//Count even length binary sequences with same sum of first and second half bits
		
//Given a number n, find count of all binary sequences of length 2n 
//such that sum of first n bits is same as sum of last n bits
		
public class EvenLenghtBiinarySeq {
		
	//returns kth bit
	static int getBit(int n, int k) {
		
		return n>>(k-1) & 1;
		
	}	
		
	static int[][] lookup = new int[1000][1000];
	
	//Memoization
	static int elbs(int n, int diff) {
		if( n == 1 && diff == 0 ) {
			return 2;
		}
		else if( n == 1 && Math.abs(diff) == 1 ) {
			return 1;
		}else if( Math.abs(diff) > n) {
			return 0;
		}
		
		if(lookup[n][n + diff] != -1) {
			return lookup[n][n + diff];
		}
		
		
		int res = elbs(n - 1, diff - 1) + elbs( n - 1, diff + 1) + 2*elbs( n - 1, diff);
		
		lookup[n][n + diff] = res;
		
		return res;
		
	}	
	
	
	
	// A O(n) C++ program to count 
	// even length binary sequences 
	// such that the sum of first 
	// and second half bits is same 
	  
	// Returns the count of  
	// even length sequences 
	//Bottom up approach
	static int countSeq(int n) 
	{ 
	    int nCr = 1, res = 1; 
	  
	    // Calculate SUM ((nCr)^2) 
	    for (int r = 1; r <= n ; r++) 
	    { 
	        // Compute nCr using nC(r-1) 
	        // nCr/nC(r-1) = (n+1-r)/r; 
	        nCr = (nCr * (n + 1 - r)) / r;  
	  
	        res += nCr * nCr; 
	    } 
	  
	    return res; 
	} 
	
	
	public static void main(String[] args) {
		
		Integer a = 10;
		
		for(int i=0; i<lookup.length; i++) {
			Arrays.fill(lookup[i], -1);	
		}
		
		System.out.println(elbs(2,0));

		
	}
	
	
}		
		