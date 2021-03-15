package com.comp.algos;

public class AllSubsets {
	
	public static void generateAllSubsets(int[] arr, int n) {
		
		//total subsets
		long tot = (long)Math.pow(2,n);
//		System.out.println(tot);
		for( int i=0; i < tot; i++ ) {
			System.out.print( "{" );
//			String str = Integer.toBinaryString(i);;
			for( int j=0; j<n; j++ ) {
				
				if( (i & (1<<j)) > 0 ) {
					
					System.out.print(arr[j]);
					
				}
				
			}
			System.out.println("}");
		}
	}
	
	public static void main( String[] args ) {
		int[] arr = {1,2,3,4};
		generateAllSubsets(arr,4);
	}
}
