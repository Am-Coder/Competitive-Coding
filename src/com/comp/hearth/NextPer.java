package com.comp.hearth;

public class NextPer {
		
	public static boolean nextPer(char[] arr) {
		
		for( int i=arr.length - 2; i>=0; i-- ) {
			if( arr[i] < arr[i+1] ) {

				
				for( int b = arr.length - 1;; b--) {
					if( arr[b] > arr[i] ) {
						char t = arr[b];
						arr[b] = arr[i];
						arr[i] = t;
						i++;
						for( b = arr.length - 1; i<b; i++,b-- ) {
							t = arr[b];
							arr[b] = arr[i];
							arr[i] = t;							
						}
						return true;
					}
				}
			}
		}
		return false;
	}	
	
	public static void main(String[] args) {
		char[] arr = "1234".toCharArray();
		
		if(nextPer(arr)) {
			System.out.println(String.valueOf(arr));
		}
	}
}		
