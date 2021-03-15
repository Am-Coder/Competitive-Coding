package com.comp.algos;

// VVIP
public class KMPAlgo {
	
	// lps[i] => index of last char of longest prefix uptil index i which is also a suffix;
	public static int[] computeLPSArray(String pat) {
		int n = pat.length();
		int[] aux = new int[n];
		int i = 1;
		int len = 0;
		aux[0] = 0;
		while (i < n) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				aux[i] = len;
				i++;
				
			} else {
				if (len != 0) {
					len = aux[len - 1];
				} else {
					aux[i] = len;
					i++;
				}
			}
		}
		return aux;
	}
	
	static void KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int[] lps = computeLPSArray(pat);
		int i = 0; // For text
		int j = 0; // For pattern
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
				
			}
			if (j == M) {
				System.out.println("Found pattern " + "at index " + (i - j));
				j = lps[j - 1];
				
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		KMPSearch(pat, txt);
	}
}
