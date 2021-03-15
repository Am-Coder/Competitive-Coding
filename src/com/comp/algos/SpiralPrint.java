package com.comp.algos;

import java.io.PrintWriter;

public class SpiralPrint {

	public static void spiral(int[][] arr, int m, int n) {
		PrintWriter p = new PrintWriter(System.out);
		
		//m is ending row
		//n is ending column
		//k is starting row
		//l is starting column
		int i = 0, l = 0, k = 0;
		
		while( k<m && l<n ) {
			
			//print top row
			for( i=l; i<n; i++ ) {
				p.print(arr[k][i] + " ");
			}
			k++;
			
			
			//print last column
			for( i=k; i < m; i++ ) {
				p.print(arr[i][n-1] + " ");
			}
			n--;
			
			//print last row
			if(k<m) {
				
				for( i=n-1; i>=l; i--) {
					p.print(arr[m-1][i] + " ");
				}
				m--;
			}
			
			//print first column
			if(l<n) {
				
				for( i=m-1; i>=k; i--) {
					p.print(arr[i][l] + " ");
				}
				l++;
				
			}
		}
		p.close();
	}
	
    public static void main(String[] args) 
    { 
        int R = 3; 
        int C = 6; 
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 } }; 
        spiral(a,R, C); 
    } 
}
