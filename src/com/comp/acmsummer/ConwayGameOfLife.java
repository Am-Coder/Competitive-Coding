package com.comp.acmsummer;

import java.math.BigInteger;
import java.util.Scanner;

public class ConwayGameOfLife {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		for(int i=0; i<a; i++) {
			int n = s.nextInt();
			if(n == 1) {
				System.out.println(2);
				continue;
			}else {
				BigInteger b = new BigInteger("2");
				BigInteger res = (b.pow(n).add(b.pow(n-1)));
				System.out.println(res);
			}
		}
		s.close(); 
	}

}
