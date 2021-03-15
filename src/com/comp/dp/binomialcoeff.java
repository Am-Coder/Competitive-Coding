package com.comp.dp;

import java.util.Scanner;

public class binomialcoeff {
	
	//Recursive sol
	static int bincoff(int n, int r) {
		
		if(r == 0 || r == n )
			return 1;
		
		return bincoff( n-1, r-1 ) + bincoff( n-1, r );
	}
	
		
	//bottom up solution 
	static int binomial( int n, int r ) {
		
		int[][] arr = new int[n+1][r+1];
		
		for(int i=0; i<=n; i++) {
			
			for(int j=0; j<=Math.min(i, r); j++) {
				
				if( j == 0 || j == i) {	
					
					arr[i][j] = 1;	
					
				}else {
						
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j] ;
					
				}
				
			}
		}
		
		return arr[n][r];
		
	}	
		
	//Space efficient solution
	static int bin( int n, int r) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		
		for(int i=1; i<=n; i++) {
			
			for( int j=Math.min(i, r); j>0; j--) {
				arr[j] = arr[j] + arr[j-1];
			}
		}
		
		return arr[r];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int r = s.nextInt();
		System.out.println(bincoff(n, r));
		
		s.close();
	}
	
	
}
