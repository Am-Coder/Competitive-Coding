package com.comp.algos;
import java.util.*;

public class SubArraysWithGivenSum {
    static int findSubarraySum(int arr[], int n, int sum)  
    {  
        // HashMap to store number of subarrays  
        // starting from index zero having   
        // particular value of sum.  
        HashMap <Integer, Integer> prevSum = new HashMap<>();  
        
        int res = 0;  
        
        // Sum of elements so far.  
        int currsum = 0;  
        
        for( int i=0; i<n; i++ ) {
        	currsum += arr[i];
        	
        	if( currsum == sum )
        		res++;
        	
        	if( prevSum.containsKey(currsum - sum))
        		res += prevSum.get(currsum - sum);
        	
        	Integer count = prevSum.getOrDefault(currsum, 0);
        	prevSum.put(currsum, count+1);
        	
        }
        return res;  
    }  
}
