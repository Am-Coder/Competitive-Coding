package com.comp.algos;

public class SegmentTreeGCD {
	int[] st;
		
	int gcd( int a, int b ) {
		
		if( b == 0 ) {
			return a;
		}
		
		return gcd(b, a%b);
		
	}	
		
	int constructUtil( int[] arr, int ss, int se, int si ) {
		
		if( ss == se ) {
			st[si] = arr[ss];
			return st[si];
		}
		
		int mid = ss + (se - ss)/2;
		st[si] = gcd( constructUtil( arr, ss, mid, 2*si + 1 ), constructUtil( arr, mid+1, se, 2*si + 2 ));
		
		return st[si];
		
	}	
		
	int[] construct( int[] arr, int n ) {
		
		int si = (int)Math.ceil(Math.log(n)/Math.log(2));
		si = 2*(int)Math.pow(2, si) - 1;
		st = new int[si];
		constructUtil( arr, 0, n-1, 0);
		return st;
		
	}	
		
		
	int findGCD( int ss, int se, int qs, int qe, int si ) {
		
		if( ss>=qs && se <= qe  ) {
			return st[si];
		}
		
		if( ss>qe || se<qs ) {
			return 0;
		}
		int mid = ss +(se-ss)/2 ;
		
		return gcd(findGCD( ss,mid,qs,qe,2*si + 1 ),findGCD( mid+1,se,qs,qe,2*si+2));
		
	}	
		
	int findRangeGCD( int qs, int qe, int n ) {
		
		if( qs<0 || qe>= n || qs>qe ) {
			System.out.println("Invalid Exception");
			return -1;
		}
		
		return findGCD( 0, n-1, qs, qe, 0 );
		
	}	
	
	public static void main( String[] args ) {
		int[] arr = {2, 3, 6, 9, 5};
		SegmentTreeGCD t = new SegmentTreeGCD();
		t.construct(arr, arr.length);
		System.out.println(t.findRangeGCD( 1, 3, 5 ));
	}
}		
