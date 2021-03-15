package com.comp.algos;
	
	
//Inversions : a[i] > a[j] but i < j i.e. no of smaller elements to the right of an element
public class ArrayInversion {
	
	public static int mergeSort(int[] a, int n) {
		if( n < 2) {
			return 0;
		}
		int mid = n/2;
		int count = 0;
		int[] l = new int[mid];
		int[] r = new int[n - mid];
		
		for( int i=0; i<mid; i++) {
			l[i] = a[i];
		}
		for( int i=mid; i<n; i++) {
			r[i - mid] = a[i];
		}
		
		count = mergeSort(l, mid);
		count += mergeSort(r, n - mid);
		
		count += merge(a,l,r,mid,n - mid);
		return count;
	}
	
	public static int merge(int[] a,int[] l,int[] r, int left, int right) {
		
		int i=0,j=0,count = 0, k = 0;
		
		while( i < left && j < right ) {
			if(l[i] <= r[j]) {
				a[k++] = l[i++];
			}else {
				a[k++] = r[j++];
				count += left - i;  //*****************
			}
		}
		
		while(i<left) {
			a[k++] = l[i++];
		}
		
		while(j<right) {
			a[k++] = r[j++];
		}
		return count;
	}
	public static void main(String[] args) {
        int arr[] = new int[] { 5,4,3,2,1 }; 
        System.out.println("Number of inversions are " + mergeSort(arr, 5)); 
	}
}	
