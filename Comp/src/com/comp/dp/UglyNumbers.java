package com.comp.dp;

import java.util.Scanner;
//Ugly numbers have only 2,3,5 as prime factors
public class UglyNumbers {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println(getUgly(a));
		s.close();
	}
	
	//bottom up approach
	static int getUgly(int n) {
		int[] ugly = new int[n];
		int mulof3 = 3;
		int mulof2 = 2;
		int mulof5 = 5;
		int next_ug_no = 1;
		int i2=0,i3=0,i5=0;
		
		for(int i=1; i<n; i++) {
			next_ug_no = Math.min( mulof2, Math.min(mulof3, mulof5));
			
			ugly[i] = next_ug_no;
			if(next_ug_no == mulof2) {
				i2 += 1;
				mulof2 = ugly[i2]*2;
			}
			if(next_ug_no == mulof3) {
				i3 += 1;
				mulof3 = ugly[i3]*3;
			}			
			if(next_ug_no == mulof5) {
				i5 += 1;
				mulof5 = ugly[i5]*5;
			}
			
		}
				
		return next_ug_no;
	}
}
