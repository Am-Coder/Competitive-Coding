package com.comp.hearth;

import java.util.Scanner;

public class firatMeet {
    static int max = 1000001;
    static int[] arr = new int[max];
    
    public static void sieve(){
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i=2; i*i<max; i++){
            if(arr[i] == 0){
                for( int j=i*2; j<max; j+=i ){
                    arr[j] = 1;
                }
            }
        }
        
    }
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        sieve();
        for(int i=0; i<n; i++){
            int a =s.nextInt();
            if(arr[a] == 0){
                max = Math.max(max,a);
                min = Math.min(min,a);
            }
        }
        System.out.println(Math.abs(max - min));
    }
}
