package com.comp.hearth;

import java.util.HashMap;
import java.util.Scanner;

public class AshuAndPrimeNum {

    static int max = 1000001;
    static HashMap<Integer,Integer> hmap = new HashMap<>();

    public static void sieve(){
        int[] arr = new int[max];
        
        arr[1] = 1;
        
        for(int i=2; i<max; i++){
            
            if( arr[i] == 0 ){
                arr[i] = i;
                
                for(int j=2*i; j<max; j+=i){
                    
                    if(arr[j] == 0)
                        arr[j] = i;
                }
            }
        }
        
        for(int i=2; i<max; i++){
            
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
            
        }
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        sieve();
        for( int i=0; i<n; i++ ){
            int a = s.nextInt();
            System.out.println(hmap.get(a));
        }
    }
}
