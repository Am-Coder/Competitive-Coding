package com.comp.hearth;

import java.util.Scanner;

public class PandaAndChainReaction {
    static long mod = 1000003;
    static long[] arr = new long[100001];
    static void fact(){
        
        arr[0] = 1;
        for( int i=1; i<=100000; i++){
            arr[i] = (arr[i-1]%mod)*(i%mod);
        }
        
    }
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        fact();
        
        for( int i=0; i<t; i++ ){
                
//            int n = s.nextInt();
            long n = s.nextLong()%(mod);

            long x = s.nextLong();
            // long prod = 1;
                
            // for(int j=1; j<=n; j++){
                
            //     prod = (prod%mod)*(j%mod);
                
            // }   
            System.out.println((long)(arr[(int)n]%mod)*(long)(x%mod));
        }       
    }           
}
