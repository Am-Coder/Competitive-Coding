package com.comp.hearth;

public class Inversions {
	static int mergeSort( int[] arr, int n ) {
		if( n<2 ) {
			return 0;
		}
		int mid = n/2; 
		int[] l = new int[mid];
		int[] r = new int[n-mid];
		
		for( int i=0; i<mid; i++ ) {
			l[i] = arr[i];
		}
		
		for( int j=mid; j<(n); j++ ) {
			r[j - mid] = arr[j];
		}
		
		int count = 0;
		count += mergeSort(l,mid);
		count += mergeSort(r, n-mid);
		count += merge(arr,l,r,mid,n-mid);
		return count;
	}
	
	static int merge(int[] arr, int[] l, int[] r, int left, int right ) {
		
		int i=0, j=0, k=0;
		int count = 0;
		while( i<left && j<right ) {
			if( l[i] < r[j] ) {
				arr[k++] = l[i++]; 
			}else {
				arr[k++] = r[j++];
				count += left - i;
			}
		}
		if( i<left) {
			arr[k++] = l[i];
		}
		if( j<right) {
			arr[j++] = r[j++];
		}
		
		return count;
	}
}
