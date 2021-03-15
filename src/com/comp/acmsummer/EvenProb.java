package com.comp.acmsummer;

import java.util.Scanner;

public class EvenProb {
	
	static int q,n,k,val,ec,co;
	static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		k = s.nextInt();
		q = s.nextInt();
		for(int i=0; i<q; i++) {
			val = s.nextInt();
			ec = 0;
			co = 0;
			cou(n, 0 );
			int g = gcd(ec,co);
			if(ec == 0)
				System.out.println("All odd");
			else
				System.out.println(ec + " "+ co);
		}

		s.close();
	}	
		
	static void cou(int num, int ch) {
		
		if(ch == val) {
			if(num%2 == 0) {
				ec++;
			}
			co++;
			return;
		}
		
		int p1, p2, p3;
		p1 = num&k;
		p2 = num^k;
		p3 = num|k;
		
		cou( p1, ch + 1 );
		cou( p2, ch + 1 );
		cou( p3, ch + 1 );
	}	
		
}		
