package com.comp.algos;

public class KadanesAlgo {
	
	public static void maxSubArr(int[] arr, int size ) {
		
		int maxsum = arr[0];
		int cursum = arr[0];
		for( int i=1; i<size; i++ ) {
			
			cursum = Math.max(cursum + arr[i], arr[i]);
			maxsum = Math.max(cursum, maxsum);
			
		}
		
		System.out.println(maxsum);
	}	
	
	public static void KadaneWithIndex(int[] arr, int n) {
		int sum = Integer.MIN_VALUE;
		int cursum = 0;
		int st = 0;
		int end = 0;
		int s = 0;
		for (int i = 0; i < n; i++) {
			cursum += arr[i];
			if (cursum > sum) {
				sum = cursum;
				st = s;
				end = i;
			}
			if (cursum < 0) {
				cursum = 0;
				s = i + 1;
			}
		}
		System.out.println(sum + " From - " + st + " " + end);
	}
	public static void main(String[] args) {
		
		int[] arr = {1,2,-5,-1,-6};
		maxSubArr(arr,arr.length);
	}
}
