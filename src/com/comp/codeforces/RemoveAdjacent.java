package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveAdjacent {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cou = 0;
		for (char ch = 'z'; ch > 'a'; ch--) {
			for (int j = 0; j < 100; j++) {
				StringBuilder sb = new StringBuilder("");
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == ch && str.length() > 1) {
						if (i == 0) {
							if (Math.abs(str.charAt(i + 1) - ch) == 1) {
								cou++;
							} else {
								sb.append(str.charAt(i));
							}
						} else if (i == str.length() - 1) {
							if (Math.abs(str.charAt(i - 1) - ch) == 1) {
								cou++;
							} else {
								sb.append(str.charAt(i));
							}
						} else {
							int diff1 = Math.abs(str.charAt(i - 1) - ch);
							int diff2 = Math.abs(str.charAt(i + 1) - ch);
							if (diff1 == 1 || diff2 == 1) {
								cou++;
							} else {
								sb.append(str.charAt(i));
							}
						}
					} else {
						sb.append(str.charAt(i));
					}
				}
				str = sb.toString();
			}
		}
		System.out.println(cou);
	}
	
}
