package com.comp.hearth;

import java.util.Scanner;

public class XsquareAndTwoArrays {

    public static void main(String args[] ) throws Exception {
    	
    	int ad = 1000000000;
//    	long ab = (long)(ad)*(long)(ad);
//    	System.out.println(ab);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[][] arr = new int[2][n];
        for(int j=0; j<2; j++){    
            for(int i=0; i<n; i++){
                
                arr[j][i] = s.nextInt();
                
            }
        }
        long[][] a = new long[2][n+1];
        	
        ans(arr,n,a);
        	
        	
//        for(int i=0; i < 2; i++) {
//        	
//        	for(int j=0; j<n; j++) {
//        		
//        		System.out.println(a[i][j]);
//        		
//        	}
//        	
//        }	
        for(int i=0; i<q; i++){
        	
            int row = s.nextInt() - 1;
            int l = s.nextInt() ;
            int r = s.nextInt() ;
            // int sum = 0;
            if( l == 1) {
            	System.out.println(a[row][r-1]);
            }else if( l%2 == 0 ) {
            	System.out.println(a[row^1][r-1] -a[row^1][l-2]);
            }else {
            	System.out.println(a[row][r-1] -a[row][l-2]);
            }
            
        }	
    }		
    		
    static void ans(int[][] arr, int n, long[][] a){
        a[0][0] = arr[0][0];
        a[1][0] = arr[1][0];
        	
        for(int j=0; j<2; j++){
            for(int i=1; i<n; i++){
                
                if( i%2 == 0){
                    a[j][i] += (long)a[j][i-1] + (long)arr[j][i];
                }else{
                    a[j][i] += (long)a[j][i-1] + (long)arr[j^1][i];
                }
                
            }
        }
        
    }
}
