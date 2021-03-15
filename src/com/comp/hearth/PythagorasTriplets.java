package com.comp.hearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PythagorasTriplets {
	
	static class py{
		int a;
		int b;
		int c;
		
		public py( int a, int b, int c ) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	public static void Pytha(int[] arr, int n) {
		HashSet<Integer> hset = new HashSet<>();
		for( int i=0; i<n; i++ ) {
			
			arr[i] = arr[i]*arr[i];
			hset.add(arr[i]);
			
		}	
//		PriorityQueue<Integer> pq = new PriorityQueue<>( 15, Collections.reverseOrder());
		
		HashSet<py> hs = new HashSet<>();
		for(int val: hset) {
			
			for( int i=0; i<n; i++ ) {
				int ind = Arrays.binarySearch(arr,val - arr[i] );
				if( ind>=0 && ind != i ) {
					hs.add(new py((int)Math.sqrt(arr[i]), (int)Math.sqrt(val-arr[i]),  (int)Math.sqrt(val) ));
					System.out.println("{" + Math.sqrt(arr[i]) + " , " + Math.sqrt(val-arr[i]) + " , " + Math.sqrt(val) + "}");
				}
			}
		}
		for(py ele: hs) {
			
			System.out.println("{" + ele.a + " , " + ele.b + " , " + ele.c + "}");

		}
	}		
	
	public static void main(String[] args) {
		int[] arr = {3,4,5,7,12,13};
		Pytha(arr,arr.length);
	}
}			
