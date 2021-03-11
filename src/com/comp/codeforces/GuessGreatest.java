package com.comp.codeforces;

import java.util.Scanner;

public class GuessGreatest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = 1;
		int r = n;
		int ans = 0;
		
		while (l < r) {
			if (r - l == 1) {
				System.out.println("? " + l + " " + r);
				System.out.flush();
				int sm = sc.nextInt();
				if (l == sm)
					ans = r;
				else
					ans = l;
				break;
			}
			
			int mid = (r + l) / 2;
			System.out.println("? " + l + " " + r);
			System.out.flush();
			int sm = sc.nextInt();
			
			if (sm >= mid) {
				System.out.println("? " + mid + " " + r);
				System.out.flush();
				int rr = sc.nextInt();
				if (sm == rr) {
					l = mid;
				} else {
					r = mid;
				}
			} else {
				System.out.println("? " + l + " " + mid);
				System.out.flush();
				int ll = sc.nextInt();
				if (sm == ll) {
					r = mid;
				} else {
					l = mid;
				}
			}
		}
		System.out.println("! " + ans);
		sc.close();
	}
	
}
