package com.comp.dp;

import java.util.Scanner;


public class bellno {
	
	
    // Function to find n'th Bell Number that counts possible partitions of set having n elements
	static int bellNo(int n) {
		int[][] arr = new int[n+1][n+1];
		arr[0][0] = 1;
		int i,j;		
		for(i=1; i<n; i++) {
		
			arr[i][0] = arr[i-1][i-1];
			for(j=1; j<=i; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j-1];
				
			}	
			
		}
		
		return arr[n-1][0];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt();
		
		System.out.println(bellNo(a));
		s.close();
	}
}
