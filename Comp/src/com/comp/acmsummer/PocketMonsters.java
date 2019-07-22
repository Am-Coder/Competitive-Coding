package com.comp.acmsummer;

import java.util.Arrays;
import java.util.Scanner;

public class PocketMonsters {
	static int max = 1000000007;
	static int len = 100000;
	static long dp[] = new long[len+1];
	static int[] arr = {1,2,2};
	static void initialize() {
		for(int i=0; i<=100000; i++) {
			dp[i] = -1;
		}
	}
	 
	static int count[] = new int[len + 1];
    public static void main(String args[] ) throws Exception {
//    	initialize();
    	Arrays.fill(dp, -1);
    	sol1(len);
        // Write your code here
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
//        countWays(len);
        for(int i=0; i<a; i++){

            System.out.println(dp[s.nextInt()]%max);
            
        }
        s.close();
    }
    
    static long sol(int n){
        if(n<0)
            return 0;
        if(n == 0 )
            return 1;
        if(dp[n]!=-1)
        	return dp[n];
        return dp[n] = sol( n -2)%max + sol( n -2)%max + sol(n - 1)%max;   
    }
    
    static long sol1(int n){
        if(n<0)
            return 0;
        if(n == 1 )
            return 1;
        
        if(dp[n] != -1) {
        	return dp[n];
        }
        
        if(n%2 == 0) {
        	return dp[n] = 2*sol1(n-1)%max +1%max;
        }else {
        	return dp[n] = 2*sol1(n-1)%max - 1%max;
        }   
    }
//    static long sol1(int n){
//        if(n<0)
//            return 0;
//        if(n == 0 )
//            return 1;
//
//        if(n%2 == 0) {
//        	return 2*sol1(n-1)%max + 1%max;
//        }else {
//        	return 2*sol1(n-1)%max - 1%max;
//        }   
//    }
//    static int countWays(int N) 
//    { 
////        int count[] = new int[N + 1]; 
//          
//        // base case 
//        count[0] = 1; 
//          
//        // count ways for all values up  
//        // to 'N' and store the result 
//        for (int i = 1; i <= N; i++) 
//            for (int j = 0; j < arr.length; j++) 
//      
//                // if i >= arr[j] then 
//                // accumulate count for value 'i' as 
//                // ways to form value 'i-arr[j]' 
//                if (i >= arr[j]) 
//                    count[i] = count[i]%max + count[i - arr[j]]%max; 
//          
//        // required number of ways  
//        return count[N];  
//          
//    } 
}
