package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class PerfectKeyboard {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			char[] sol = new char[100];
			int i = 50;
			Arrays.fill(sol, '-');
			sol[i] = arr[0];
			int n = arr.length;
			boolean ans = true;
			HashSet<Character> hs = new HashSet<>();
			HashSet<Character> added = new HashSet<>();
			
			for (char ch = 'a'; ch <= 'z'; ch++)
				hs.add(ch);
			hs.remove(arr[0]);
			added.add(arr[0]);
			for (int k = 1; k < n; k++) {
				hs.remove(arr[k]);
				if (sol[i + 1] == arr[k]) {
					i++;
				} else if (sol[i - 1] == arr[k]) {
					i--;
				} else if (added.contains(arr[k])) {
					ans = false;
					break;
				} else if (sol[i + 1] == '-') {
					i++;
					sol[i] = arr[k];
					added.add(sol[i]);
				} else if (sol[i - 1] == '-') {
					i--;
					sol[i] = arr[k];
					added.add(sol[i]);
				} else {
					ans = false;
					break;
				}
			}
			if (!ans) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				i = 0;
				
				while (sol[i] == '-') {
					i++;
				}
				StringBuilder sb = new StringBuilder();
				while (i < 100 && sol[i] != '-') {
					sb.append(sol[i]);
					i++;
				}
				for (char ch : hs)
					sb.append(ch);
				System.out.println(sb.toString());
			}
		}
	}
	
}
