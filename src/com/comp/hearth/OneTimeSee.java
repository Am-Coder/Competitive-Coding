package com.comp.hearth;

public class OneTimeSee {
	
	
	public static void OneTimeSort( int[] arr, int st, int end) {
		
		
		if( st>end ) {
			
			return;
			
		}
		
		if ( st == end ) {
			
			System.out.println(arr[end]);
			return;
		}

		int mid = (st+end)/2 ;
		
		if( mid%2 == 0) {
			
			if( arr[mid+1] == arr[mid] ) {
				
				OneTimeSort( arr, mid+2, end );
				
			}else {
				
				OneTimeSort( arr, st, mid );
				
			}
			
		}else {
			
			if( arr[mid + 1] == arr[mid] ) {

				OneTimeSort( arr, st, mid-1 );
//				OneTimeSort( arr, mid+1, end );
				
			}else {
				
				OneTimeSort(arr, mid+1, end );
				
			}
			
		}
	}	
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,5,5,9,9,10,10};
		OneTimeSort(arr, 0, arr.length - 1 );
		
		
	}

}
