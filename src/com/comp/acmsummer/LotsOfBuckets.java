package com.comp.acmsummer;

import java.util.Arrays;
import java.util.Scanner;

public class LotsOfBuckets {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] arr = new int[a];
        int[] arr1 = new int[a];
 
        for(int i=0; i<a; i++){
        	int k = s.nextInt();
            arr[i] = k;
            arr1[i] = k;
        }
        
        Arrays.sort(arr);
        Arrays.sort(arr1);

        int count = 0;
        int max = arr[a - 1];
        int last = a - 1;
        for(int i=a-1; i>=0; i--){
            
        	if(last<0)
        		break;
            if(2*arr[i] <= max && arr[i] != -1){
            	last = last -1;
            	
            	while(arr[last] == arr[i]) {
            		last -= 1;
            		if(last<0) {
            			last += 1;
            			break;
        			}
            	}
                max = arr[ last ] ;
                count ++ ;
                arr[i] = -1 ;
            }
            
        }
        
        
        last = a - 1;
        int count1 = 0;
        max = arr1[last];
        for(int i=0; i<(a/2); i++) {
            
        	if(last<0)
        		break;
            if(2*arr1[i] <= max && arr1[i] != -1){
            	last = last -1;
            	
            	while(arr1[last] == arr1[i]) {
            		last -= 1;
            		if(last<0) {
            			last += 1;
            			break;
        			}
            	}
                max = arr1[ last ] ;
                count1 ++ ;
                arr1[i] = -1 ;
            }
            
        }
        int val = count>count1?count:count1;
        System.out.println(a - val);
        s.close();
    }
}