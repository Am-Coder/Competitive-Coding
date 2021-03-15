package com.comp.algos;

// In a circular array, every kth person is killed starting from index 1. 
// Find the last remaining safe position.
public class JosephusProblem {
	
	// 1 index based, For 0 index use jose(n,k) -> (jose(n-1,k)+k)%n
	public static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		
		return (josephus(n - 1, k) + k - 1) % n + 1;
	}
	
	static int josephusNonRec(int n, int k) {
		int res = 0;
		for (int i = 2; i <= n; ++i)
			res = (res + k) % i;
		return res + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(josephus(41, 2));
		System.out.println(josephusNonRec(41, 2));
		
	}
}
