package com.comp.codeforces;

import java.util.Scanner;

public class CyclicPermutations {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long MOD = (long) 1e9 + 7;
		long fact = 1; // Number of Permutations
		long pow = 1; // Number of Unimodal Permutations
		for (long i = 1; i < n; i++) {
			fact = (fact % MOD * i % MOD) % MOD;
			pow = (pow % MOD * 2 % MOD) % MOD;
		}
		fact = (fact % MOD * n % MOD) % MOD;
		fact = (fact - pow + MOD) % MOD;
		
		System.out.println(fact);
	}
}
