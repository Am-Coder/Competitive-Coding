package com.comp.acmsummer;

import java.math.BigInteger;
import java.util.Scanner;

public class LazyBoss {
    static long max = 1000000007 ;
    
    public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
//		String n = s.nextLine();
//		String k = s.nextLine();
//		int val = Integer.parseInt(k);
		long n = s.nextLong();
		long k = s.nextLong();
		BigInteger sum = BigInteger.valueOf(0);
		BigInteger p = BigInteger.valueOf(n);
		BigInteger mod = BigInteger.valueOf(max);
		while(k !=0) {
			BigInteger b = BigInteger.valueOf(k);
			System.out.println(b + " " + p);
			sum = sum.add(b.modPow(p,mod));
//			sum += Math.pow(k, n)%max;
			k--;
		}
		sum = sum.mod(mod);
//		String str = Double.toString(sum);
		System.out.println(sum);
		s.close();


	}
}
