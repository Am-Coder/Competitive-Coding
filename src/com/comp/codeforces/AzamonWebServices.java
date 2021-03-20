package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AzamonWebServices {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] arr = br.readLine().split(" ");
			String s1 = arr[0];
			String s2 = arr[1];
			int n = s1.length();
			int m = s2.length();
			int i = 0;
			int j = 0;
			int[] cou = new int[26];
			for (int k = 0; k < n; k++) {
				cou[s1.charAt(k) - 'A']++;
			}
			i = 0;
			char[] tmp = s1.toCharArray();
			for (int k = 0; k < 26; k++) {
				if (cou[k] > 0) {
					char ch = (char) ('A' + k);
					while (cou[k] > 0 && tmp[i] == ch) {
						i++;
						cou[k]--;
					}
					if (cou[k] > 0) {
						for (j = n - 1; j >= 0; j--) {
							if (tmp[j] == ch) {
								break;
							}
						}
						tmp[j] = tmp[i];
						tmp[i] = ch;
						break;
					}
				}
			}
			boolean ans = false;
			s1 = String.valueOf(tmp);
			i = 0;
			j = 0;
			while (i < n && j < m && s1.charAt(i) <= s2.charAt(j)) {
				if (s1.charAt(i) < s2.charAt(j)) {
					ans = true;
					break;
				}
				i++;
				j++;
			}
			if ((i == n && j != m) || ans) {
				System.out.println(s1);
			} else {
				System.out.println("---");
			}
		}
	}
}
