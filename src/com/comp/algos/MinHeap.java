package com.comp.algos;
//	A min heap is a complete binary tree with maximum node being as left as possible
// 	It can be represented in the form of an array
//	Arr[(i -1) / 2] returns its parent node.
//	Arr[(2 * i) + 1] returns its left child node.
//	Arr[(2 * i) + 2] returns its right child node.
//  This was for indexing 0

public class MinHeap {
	
	private int[] heap;
	private int size;
	private int maxsize;
	
	
	private static final int FRONT = 1 ; 
	
	public MinHeap( int maxsize ) {
				
		this.size = 0;
		this.maxsize = maxsize;

		//First element at index 1
		heap = new int[this.maxsize + 1];
		heap[0] = Integer.MIN_VALUE;

	}
	
	private int parentNode( int pos ) {
		return pos/2;
	}
	
	private int leftChild( int pos ) {
		return 2*pos;
	}
	
	private int rightChild( int pos ) {
		return 2*pos + 1;
	}
	
	private boolean isLeafNode( int pos ) {
			
		if( pos>=size/2 && pos <= size ) {
			return true;
		}
		
		return false;
	}
	
	private void swap( int fpos, int lpos ) {
		int tmp;
		tmp = heap[fpos] ;
		heap[fpos] = heap[lpos];
		heap[lpos] = tmp;
	}
	
	
	public void minHeapify( int pos ) {
		
		if( !isLeafNode(pos)) {
			if( heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
				if( heap[leftChild(pos)] < heap[rightChild(pos)] ) {
					swap(pos,leftChild(pos));
					minHeapify( leftChild(pos) );
				}	else {
					swap( pos, rightChild(pos) );
					minHeapify(rightChild(pos));
				}
			}
		}
	}
	
	public void insert( int element ) {
		
		if( size >= maxsize ) {
			return;
		}
		
		heap[++size] = element ;
		int current  = size;
		
		while( heap[current] < heap[parentNode(current)]) {
			swap(current, parentNode(current));
			current = parentNode(current);
		}
	}
	
	public void minHeap() {
		for( int pos = size/2; pos>=1; pos-- ) {
			minHeapify(pos);
		}
	}
	
	public int remove() {
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minHeapify(FRONT);
		return popped;
	}
	
    // Function to print the contents of the heap 
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + heap[i] 
                             + " LEFT CHILD : " + heap[2 * i] 
                             + " RIGHT CHILD :" + heap[2 * i + 1]); 
            System.out.println(); 
        } 
    }
    
    // Driver code 
    public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.minHeap(); 
  
        minHeap.print(); 
        System.out.println("The Min val is " + minHeap.remove()); 
    } 
}
