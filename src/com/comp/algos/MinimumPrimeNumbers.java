package com.comp.algos;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumPrimeNumbers {

    static int max = 1000001;
    static int[] arr = new int[max];

    public static void sieve(){
        
        arr[1] = 1;
        
		for (int i = 2; i * i < max; i++) {
            
        	//0 means prime
            if( arr[i] == 0 ){
                arr[i] = i;
                
                for(int j=2*i; j<max; j+=i){
                    
                    if(arr[j] == 0)
                        arr[j] = i;
                }
            }
        }
        
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        sieve();
        for( int i=0; i<n; i++ ){
            int a = s.nextInt();
            System.out.println(arr[a]);
        }
    }
}
