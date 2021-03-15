package com.comp.dp;

import java.util.Scanner;

public class Fibonaci {
	
	int max = 100;
	 int[] lookup = new int[max];
	
	 void initialize() {
		for(int i=0; i<max; i++) {
			lookup[i] = -1;
		}
	}
	
	
	  /* function for nth Fibonacci number  TOP DOWN*/
	 int fib(int n) {
		if(lookup[n] == -1) {
			if(n<=1)
				lookup[n] = n;
			else
				lookup[n] = fib(n - 1) + fib( n - 2 );
		}
		
		return lookup[n];
	}
	
	 //Tabulation Bottom Up approach
	 int fib1(int n) 
	 { 
	    int f[] = new int[n+1]; 
	    f[0] = 0; 
	    f[1] = 1; 
	    for (int i = 2; i <= n; i++) 
	          f[i] = f[i-1] + f[i-2]; 
	    return f[n]; 
	 }  
	  
	  
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Fibonaci f = new Fibonaci();
		f.initialize();
		System.out.println(f.fib(n));
		s.close();
	}
}
