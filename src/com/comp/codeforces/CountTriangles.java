package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountTriangles {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int C = Integer.parseInt(str[2]);
		int D = Integer.parseInt(str[3]);
		int N = (int) 1e6 + 77;
		long[] pref = new long[N];
		
		for (int i = A; i <= B; i++) {
			pref[i + B] += 1;
			pref[i + C + 1] -= 1;
		}
		for (int i = 1; i < N; i++) {
			pref[i] += pref[i - 1];
		}
		for (int i = 1; i < N; i++) {
			pref[i] += pref[i - 1];
		}
		long ans = 0;
		for (int i = C; i <= D; i++) {
			ans += pref[N - 1] - pref[i];
		}
		System.out.println(ans);
	}
	
}
