package com.comp.hearth;

import java.util.HashSet;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        s.close();
        HashSet<Integer> hse = new HashSet<>();
        int max = 0,sum = 0;
        for( int i=0; i<n; i++ ){
            max = arr[i] ;
            int mprev = arr[i] ;
            int cur = arr[i] ;
            hse.add(cur);
//            sum += cur ;
//            hse.add(sum);
            for( int j=i+1; j<n; j++ ){
                cur += arr[j];
                if(arr[j] > max){
                    max = arr[j];
                }
                if(max>mprev){
                    mprev = max;
                }
                if(cur>mprev)
                    mprev = cur;
//                mprev = Math.max(cur, max);
//                System.out.println(mprev);
                hse.add(mprev);
//                sum += mprev;
//                hse.add(sum);
            }
        }
        long ans=0;
        
        for(int ele:hse) {
        	System.out.println(ele);
        	ans+=(long)ele;
        }
        System.out.println(ans);
    }
}
