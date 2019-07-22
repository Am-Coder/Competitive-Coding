package com.comp.acmsummer;

import java.util.Scanner;

public class banklocker {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int k ;
		for(int i=1; i<=a; i++) {
			int val =i;
			k = a-1;
			System.out.print(val+" ");
			for(int j=1; j<i; j++) {
				System.out.print(val+k+" ");
				val = val + k;
				k--;
			}
			System.out.print("\n");
		}
		s.close();
	}
}
