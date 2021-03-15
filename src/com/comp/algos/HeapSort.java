package com.comp.algos;

//	A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.
//
//	The root element will be at Arr[0].
//	Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
//	Arr[(i-1)/2] 	Returns the parent node
//	Arr[(2*i)+1] 	Returns the left child node
//	Arr[(2*i)+2] 	Returns the right child node
//
//	The traversal method use to achieve Array representation is Level Order

public class HeapSort {
	
	public void sort( int[] arr, int n ) {
		
		for( int i=n/2 - 1; i>=0; i-- ) {
			heapify(arr, n, i);
		}
		
		for( int i=n-1; i>=0; i-- ) {
			
			int tmp = arr[i];
			arr[i] = arr[0];
			arr[0] = tmp;
			heapify( arr, i, 0 );
			
		}
//		heapify(arr,0,0);
		MYheapify(arr,0,0);

	}
	
	public void MYheapify( int[] arr, int n, int pos ) {
		int l = 2*pos + 1;
		int r = 2*pos + 2;
		
		if( r >= n  || l>=n ) {
			return;
		}
		if( arr[l] > arr[pos] || arr[r] > arr[pos]) {
			if( arr[l] > arr[r] ) {
				swap( arr, pos, l);
				heapify( arr, n, l);
			}else {
				swap( arr, pos, r);
				heapify( arr, n, r);				
			}
		}
	}
	
	

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
	public void swap( int[] arr, int l, int f ) {
		int tmp = arr[l];
		arr[l] = arr[f];
		arr[f] = tmp;
	}
	
	public static void main( String[] args ) {
		int[] arr = {4,2,3,1,9,11,5};
		HeapSort h = new HeapSort();
		h.sort( arr, arr.length );
		for( int i=0; i<arr.length; i++ ) {
			System.out.println(arr[i]);
		}
	}
}
