package com.comp.algos.graph;

//O ( log(n) )
//if n is a power of 2, then there are no dummy nodes. So the size of the segment tree is 2n-1 (n leaf nodes and n-1) internal nodes. If n is not a power of 2, 
//then the size of the tree will be 2*x � 1 where x is the smallest power of 2 greater than n. 


public class SegmentTreeSum {
	int[] st;
	
	SegmentTreeSum( int[] arr, int n ) {
		int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));
		
		
		//Total nodes in Segment Tree
		int max_size = 2*(int )Math.pow(2, x) -1 ;
		
		st = new int[max_size];
		
		constructUtil(arr,0,n-1,0);
	}
	
	public int constructUtil(int[] arr, int ss, int se, int si) {
		if( ss == se ) {
			st[si] = arr[ss];
			return arr[ss];
		}
		
		int mid = ss + (se-ss)/2;
		st[si] = constructUtil(arr, ss, mid, 2*si + 1) + constructUtil(arr, mid+1, se, 2*si + 2 );
		return st[si];
	}
	
	//Return sum of elements in range qs to qe
	int getSum(int n, int qs, int qe ) {
		if( qs<0 || qe>n-1 || qs>qe ) {
			System.out.println("Invalid range");
			return -1;
		}
		
		return getSumUtil(0, n-1, qs, qe, 0);
		
	}
	
	int getSumUtil(int ss, int se, int qs, int qe, int si ) {
		if( qs <= ss && qe >= se ) {
			return st[si];
		}
		
		if( qs > se || qe < ss ) {
			return 0;
		}
		int mid = ss + (se-ss)/2;
		return getSumUtil(ss,mid,qs,qe,2*si+1) + getSumUtil(mid+1,se,qs,qe,2*si+2);
	}
	
	
	//update element at index i
	void updateValue(int[] arr, int n, int i, int new_val ) {
		if( i<0 || i>n-1 ) {
			System.out.println("Invalid Input");
			return;
		}
		int diff = new_val - arr[i];
		arr[i] = new_val;
		
		updateValueUtil( 0, n-1, i, diff, 0 );
	}
	
	void updateValueUtil( int ss, int se, int i, int diff, int si ) {
		if( i < ss || i > se ) {
			return;
		}
		
		
		st[si] = st[si] + diff;
		if( se != ss ) {
			int mid = ss + (se -ss)/2;
			updateValueUtil( ss, mid, i, diff, 2*si + 1 ); 
			updateValueUtil( mid + 1, se, i, diff, 2*si + 2 );
		}
	}
	
	public static void main(String[] args) {
        int arr[] = {1,1,1,1,1,1}; 

        int n = arr.length; 
		SegmentTreeSum t = new SegmentTreeSum( arr, n );
        for( int i=0; i<t.st.length; i++ ) {
        	System.out.println(t.st[i]);
        }
		System.out.println(t.getSum( n, 1, 3 ));
		t.updateValue( arr, n, 1, 10 );
		System.out.println(t.getSum( n, 1, 3 ));

		
	}
}
