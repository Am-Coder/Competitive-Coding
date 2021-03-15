package com.comp.hearth;

import java.io.PrintWriter;
import java.util.Scanner;

public class Masking {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		PrintWriter p = new PrintWriter(System.out);
		int x = s.nextInt();
		int y = s.nextInt();
		int l = s.nextInt();
		int r = s.nextInt();
		
		
		for( int i=l; i<=r; i++ ) {
			
			int mask = (1 << i-1);
			int ans = mask&y;

			if( ans >= 1 ) {
				x = x|mask;
			}
			
		}
		
		p.println(x);
		p.flush();
		p.close();
	}
}
