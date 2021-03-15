package com.comp.greedy;



//Every positive fraction can be represented as sum of unique unit fractions.
//A fraction is unit fraction if numerator is 1 and denominator is a positive integer, 
//for example 1/3 is a unit fraction. Such a representation is called Egyptian Fraction as it was used by ancient Egyptians. 
public class EgyptianFraction {
	
	static void printEgyptian(int nr, int dr) { 
        // If either numerator or  
        // denominator is 0  
        if (dr == 0 || nr == 0) { 
            return; 
        } 
  
        // If numerator divides denominator,  
        // then simple division makes  
        // the fraction in 1/n form  
        if (dr % nr == 0) { 
            System.out.print("1/" + dr / nr); 
            return; 
        } 
  
        // If denominator divides numerator,  
        // then the given number is not fraction  
        if (nr % dr == 0) { 
            System.out.print(nr / dr); 
            return; 
        } 
  
        // If numerator is more than denominator  
        if (nr > dr) { 
            System.out.print(nr / dr + " + "); 
            printEgyptian(nr % dr, dr); 
            return; 
        } 
  
        // We reach here dr > nr and dr%nr  
        // is non-zero. Find ceiling of  
        // dr/nr and print it as first  
        // fraction  
        int n = dr / nr + 1; 
        System.out.print("1/" + n + " + "); 
  
        // Recur for remaining part  
        printEgyptian(nr * n - dr, dr * n); 
    } 
	
	//My Approach
	public static void EgyptianFrac( double num, double den ) {
		if( num==0 || den==0 )
			return;
        if (num > den) { 
            System.out.print((int)(num / den) + " "); 
            EgyptianFrac(num % den, den); 
            return; 
        } 
        
		double val = Math.ceil(den/num);
		System.out.print("1/"+(int)val+" ");
		EgyptianFrac( num*val - den , val*den  );
	}
	
	public static void main( String[] args ) {
		EgyptianFrac( 12,6 );
		System.out.println();
		printEgyptian(12,6);
	}
}
