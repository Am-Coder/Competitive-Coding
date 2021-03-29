package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoArras {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		n = n + 2 * m - 1;
		m = 2 * m;
		long max = (int) 1e9 + 7;
		long[][] ncr = new long[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, m); j++) {
				if (i == j || j == 0) {
					ncr[i][j] = 1;
				} else {
					ncr[i][j] = (ncr[i - 1][j] + ncr[i - 1][j - 1]) % max;
				}
			}
		}
		
		System.out.println(ncr[n][m]);
	}
	
}
