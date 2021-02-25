package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumWidth {
	
	static int n;
	
	static int m;
	
	static String str1;
	
	static String str2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		str1 = br.readLine();
		str2 = br.readLine();
		int[] left = new int[m];
		int[] right = new int[m];
		int j = 0;
		for (int i = 0; i < n && j < m; i++) {
			if (str1.charAt(i) == str2.charAt(j)) {
				left[j] = i;
				j++;
			}
		}
		j = m - 1;
		for (int i = n - 1; i >= 0 && j >= 0; i--) {
			if (str1.charAt(i) == str2.charAt(j)) {
				right[j] = i;
				j--;
			}
		}
		int ans = 0;
		for (int i = 0; i < m - 1; i++) {
			ans = Math.max(ans, right[i + 1] - left[i]);
		}
		System.out.println(ans);
	}
	
}
