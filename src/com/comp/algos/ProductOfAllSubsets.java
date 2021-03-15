package com.comp.algos;

import java.util.Scanner;

//sum of Product of all subsets of an array having elements a1,a2,a3,....an
// solution = (1+a1)(1+a2)(1+a3) ... (1+an) -1
public class ProductOfAllSubsets {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long ans = 1;
		for( int i=0; i<n; i++) {
			int a = s.nextInt();
			ans = ans*(1+a);
		}
		
		System.out.println(ans - 1);
		s.close();
	}
}
