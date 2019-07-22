package com.comp.algos;

public class EuclidAlgoForGCD {
	
	//Euclid's algorithm for GCD
    static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    }
    public static void main(String[] args) {
    	System.out.println(gcd(10,5));
    }
}
