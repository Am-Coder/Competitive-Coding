package com.comp.acmsummer;

import java.util.Scanner;

public class alphaweb {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		char c = (char)('A' + a - 1);
		for(int i=1; i<a; i++) {
			
			for(int j=1; j<i; j++ )
				System.out.print(" ");
			
			for(int k=1; k<=3; k++) {
				System.out.print(c);
				for(int l=1; l<a-i; l++) {
					System.out.print(" ");
				}
			}
				
				
			System.out.print("\n");
			c--;
		}
		c = (char) ('A' + a -1);
		for(int i=1; i<=a;i++ ) {
			System.out.print(c);
			c--;
		}
		c++;
		for(int i=1; i<a ; i++) {
			c++;
			System.out.print(c);
		}
		System.out.print("\n");
		c = 'B';
		for(int i=1; i<a; i++) {
			
			for(int j=a; j>i+1; j-- )
				System.out.print(" ");
			
			for(int k=1; k<=3; k++) {
				System.out.print(c);
				for(int l=1; l<i; l++) {
					System.out.print(" ");
				}
			}
				
				
			System.out.print("\n");
			c++;
		}
		
		
	}
}
