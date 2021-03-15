package com.comp.algos;

public class QuickSort {

	static int getPivot( int[] arr, int low, int high ) {
		int pivot = arr[high];
		int i=low - 1;
		for( int j=low; j<high; j++ ) {
			if( arr[j] <= pivot ) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1] ;
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}
	
	
	
	static void qsort( int[] arr, int low, int high ) {
		if(low<high) {
			
			int piv = getPivot( arr, low, high );
			qsort(arr,low,piv-1);
			qsort(arr,piv+1,high);
			
		}
	}
	
	
}
