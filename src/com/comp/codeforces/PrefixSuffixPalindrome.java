package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class PrefixSuffixPalindrome {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			HashSet<String> hs = new HashSet<>();
			String sol = "";
			String t1 = longpref(str);
			if (t1.length() > sol.length()) {
				sol = t1;
			}
			t1 = longsuff(str);
			if (t1.length() > sol.length()) {
				sol = t1;
			}
			
			int st = 0;
			int en = str.length() - 1;
			char[] tmp = str.toCharArray();
			StringBuilder pre = new StringBuilder();
			StringBuilder suff = new StringBuilder();
			while (st <= en && tmp[st] == tmp[en]) {
				if (st == en) {
					pre.append(tmp[st]);
				} else {
					pre.append(tmp[st]);
					suff.append(tmp[en]);
				}
				st++;
				en--;
			}
			if (st < en) {
				String sst = str.substring(st, en + 1);
				String ss1 = longpref(sst);
				String ss2 = longsuff(sst);
				if (ss1.length() > ss2.length()) {
					pre.append(ss1);
				} else {
					pre.append(ss2);
				}
			}
			pre.append(suff.reverse().toString());
			System.out.println(pre.toString());
		}
	}
	
	public static String longpref(String str) {
		String sol = "";
		int len = 0;
		for (int i = 1; i <= str.length(); i++) {
			String s1 = str.substring(0, i);
			if (ispalin(s1) && s1.length() > len) {
				len = s1.length();
				sol = s1;
			}
		}
		return sol;
	}
	
	public static String longsuff(String str) {
		String sol = "";
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			String suff = str.substring(i);
			if (ispalin(suff) && suff.length() > len) {
				len = suff.length();
				sol = suff;
			}
		}
		return sol;
	}
	
	public static boolean ispalin(String str) {
		if (str.length() == 0)
			return false;
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
