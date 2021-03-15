package com.comp.algos;

import java.util.ArrayList;
import java.util.Scanner;

public class NQUEEN {
	
	public static void main(String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			mat = new int[n + 1];
			sol = new ArrayList<>();
			nqueen(1, n);
			if (sol.size() == 0)
				System.out.print(-1);
			else
				for (int i = 0; i < sol.size(); i++) {
					System.out.print(sol.get(i));
				}
			System.out.println("");
		}
	}
	
	static int[] mat;
	
	static ArrayList<String> sol;
	
	public static boolean chkqueen(int k, int i) {
		
		for (int j = 1; j < k; j++) {
			if (mat[j] == i || Math.abs(j - k) == Math.abs(i - mat[j]))
				return false;
		}
		return true;
	}
	
	public static void nqueen(int k, int n) {
		for (int i = 1; i <= n; i++) {
			if (chkqueen(k, i)) {
				mat[k] = i;
				if (k == n) {
					String ans = "[";
					for (int l = 1; l <= n; l++) {
						ans += String.valueOf(mat[l]) + " ";
					}
					ans += "] ";
					sol.add(ans);
				} else {
					nqueen(k + 1, n);
				}
			}
		}
	}
	
}
