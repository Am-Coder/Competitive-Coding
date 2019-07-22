package com.comp.algos;

import java.util.ArrayList;
import java.util.Scanner;

//Kadane's Algorithm
// Time complexity O(n*log(n))
public class MaxSubArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();

		int[] arr = new int[a];
		for(int i = 0; i < a; i++ ) {
			arr[i] = s.nextInt();
		}
		s.close();
		ArrayList<Integer> Ar=MaxSubArr(arr,0,arr.length-1);
		System.out.println(Ar.get(0)+"="+Ar.get(1));
		
	}
	
	public static ArrayList<Integer> MaxCrossingSubArr(int[] arr, int low, int mid, int high) {
		int lsum=-9990,rsum=-9990;
		int sum=0,nlow=mid,nhigh=mid;
		for(int i=mid; i>=low; i--) {
			sum += arr[i];
			if(lsum<sum) {
				lsum = sum;
				nlow = i;
			}
		}
		sum=0;
		for(int i=mid+1; i<=high; i++) {
			sum += arr[i];
			if(rsum<sum) {
				rsum = sum;
				nhigh = i;
			}
		}
		ArrayList<Integer> ret = new ArrayList<>();
		ret.add(nlow);
		ret.add(nhigh);
		ret.add(lsum+rsum);
		return ret;
	}	
		
	public static ArrayList<Integer> MaxSubArr(int[] arr, int low, int high) {
		int mid;
		ArrayList<Integer> res = new ArrayList<>();
		if(low==high) {
			res.add(low);
			res.add(high);
			res.add(arr[low]);
			return res;
		}else {
			mid = (low + high)/2;
		}
		ArrayList<Integer> ar1 = MaxSubArr(arr, low, mid);
		ArrayList<Integer> ar2 = MaxSubArr(arr, mid+1, high);
		ArrayList<Integer> ar3 = MaxCrossingSubArr(arr, low, mid, high);
		
		if(ar1.get(2) > ar2.get(2) && ar1.get(2) > ar3.get(2))
			return ar1;
		else if(ar2.get(2) > ar1.get(2) && ar2.get(2) > ar3.get(2))
			return ar2;
		else 
			return ar3;
	}
}
