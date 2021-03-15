package com.comp.hearth;

import java.util.Arrays;

public class MinimumStations {
	public static int minStat( int[] arr, int[] dep, int a ) {
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		int res = 0;
		int i=1, j=0 ;
		int sta = 1;
		while( i<a && j<a ) {
			
			if( arr[i] <= dep[j] ) {
				
				i++;
				sta++;
				if(sta>res) {
					res = sta;
				}
			}else if( arr[i] > dep[j] ) {
				
				j++;
				sta--;
				
			}
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
	    int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
	    int n = arr.length; 
	    System.out.println("Minimum Number of Platforms Required = "
	                        + minStat(arr, dep, n)); 
	}
}
