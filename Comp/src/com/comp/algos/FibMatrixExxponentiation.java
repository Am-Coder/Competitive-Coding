package com.comp.algos;

import java.util.Scanner;

//if we n times multiply the matrix M = {{1,1},{1,0}} to itself 
//(in other words calculate power(M, n )), then we get the (n+1)th Fibonacci number as 
//the element at row and column (0, 0) in the resultant matrix.
public class FibMatrixExxponentiation {
    static int mod = 1000000007 ;
	static long fib( long n ) {
		long f[][] = new long[][] {{ 1 , 1 },{ 1 , 0 }};
		if(n == 0)
			return 0;
		power(f, n-1);
		
		return f[0][0];
	}

	static void multiply(long[][] f, long[][] m) {
		long x = f[0][0]*m[0][0]%mod + f[0][1]*m[1][0]%mod;
		long y = f[0][0]*m[0][1]%mod + f[0][1]*m[1][1]%mod;
		long z = f[1][0]*m[0][0]%mod + f[1][1]*m[1][0]%mod;
		long w = f[1][0]*m[0][1]%mod + f[1][1]*m[1][1]%mod;
		
		f[0][0] = x%mod ;
		f[0][1] = y%mod ;
		f[1][0] = z%mod ;
		f[1][1] = w%mod ;

		
	}
	static void power( long[][] f, long n) {
		if(n == 0 || n == 1) {
			return ;
		}
		long m[][] = new long[][] {{ 1 , 1 },{ 1 , 0 }};
		  power(f, n/2); 
		  multiply(f, f); 
		  
		  if (n%2 != 0) 
		     multiply(f, m);
		
	}
	
    public static void main(String args[] ) throws Exception {
    
        Scanner s = new Scanner( System.in );
        
        int t = s.nextInt();
    
        for(int i=0; i<t; i++){
    
            long n = s.nextLong();
            System.out.println(fib(n+2));
            
        }
        s.close();
    }   
        
        
    // static long ans(long n){
        
    // }   
        
}
