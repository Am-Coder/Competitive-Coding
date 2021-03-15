package com.comp.hearth;

import java.util.Arrays;

public class ranking {

	static int max = 256;
	static int[] fact = new int[max];

    static int fact(int n) 
    { 
        return (n <= 1) ? 1 : n * fact(n - 1); 
    }
	static void populate( int[] count, char[] ch ) {
		
		for( int i=0; i<ch.length; i++ ) {
			count[ch[i]] += 1;
		}
		
		for( int i=1; i<max; i++ ) {
			count[i] += count[i-1];
		}
	}
	
	static void update(int[] count, char ch ) {
		
		for( int i=ch; i<max; i++ ) {
			count[i]--;
		}
	}
	
	public static int rank( char[] ch) {
		
		
		int[] count = new int[max];
		populate(count, ch);
		int mul = fact(ch.length);
		
		int rank = 1;
		for( int i=0; i<ch.length; i++ ) {
			mul /= ch.length - i;
			
			rank += mul*count[ch[i]-1];
			update(count,ch[i]);
			
			
		}
		return rank;
	}
	
    public static void main(String args[]) 
    { 
        char str[] = "string".toCharArray(); 
        System.out.println(rank(str)); 
    }
}
