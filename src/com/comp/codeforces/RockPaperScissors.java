package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RockPaperScissors {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] aa = br.readLine().split(" ");
		String[] bb = br.readLine().split(" ");
		long r1 = Integer.parseInt(aa[0]);
		long s1 = Integer.parseInt(aa[1]);
		long p1 = Integer.parseInt(aa[2]);
		
		long r2 = Integer.parseInt(bb[0]);
		long s2 = Integer.parseInt(bb[1]);
		long p2 = Integer.parseInt(bb[2]);
		

		long max = Math.min(r1, s2) + Math.min(p1, r2) + Math.min(s1, p2);
		long min = Math.max(0, (r1 - r2 - p2)) + Math.max(0, s1 - (s2 + r2)) + Math.max(0, p1 - (p2 + s2));
		System.out.println(min + " " + max);
	}
	
}
