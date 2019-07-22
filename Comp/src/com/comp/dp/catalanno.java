package com.comp.dp;

import java.util.Scanner;

public class catalanno {

	//Bottom up approach
	static int catalan(int n) {
		int[] c = new int[n+1];
		c[0] = 1;
		c[1] = 1;
		
		for(int i=2; i<=n; i++) {
			c[i] = 0;
			for( int j=0; j<i; j++ ) {
				c[i] += c[j]*c[i - 1 - j];
			}
			
		}
		
		
		return c[n ];
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println(catalan(a));
		s.close();
	}
	
}
