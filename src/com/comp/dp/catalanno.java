package com.comp.dp;

import java.util.Scanner;

//Count the number of expressions containing n pairs of parentheses which are 
//correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).

//Count the number of possible Binary Search Trees with n keys

//Count the number of full binary trees (A rooted binary tree is full if every 
//vertex has either two children or no children) with n+1 leaves.

//Given a number n, return the number of ways you can draw n chords in a circle 
//with 2 x n points such that no 2 chords intersect.

//For more see here : https://www.geeksforgeeks.org/applications-of-catalan-numbers/

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
