package com.comp.problems;

import java.util.Scanner;

public class q1 {
	
	public static void main(String args[]) {
    	int ik="S1".compareToIgnoreCase("s1");
    	int jk="S1".compareTo("S0");
        System.out.println(ik+"="+jk);
        double id1=2.5;
        double id2=2.53;
        if(id1<id2) {
        	System.out.println(id1);
        }
        Scanner scan = new Scanner(System.in);
//        int i = scan.nextInt();
        double d = scan.nextDouble();
//        String s = scan.next();
//        double e = scan.nextDouble();
//
//        // Write your code here.
//        scan.close();
//        System.out.println("String: " + s);
        System.out.println("Double: " + d);
//        System.out.println("Int: " + i);
	}
}
