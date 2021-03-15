package com.comp.algos;

// 5
// 100 99 2 98 101

//{ Driver Code Starts
import java.util.*;

class PeakElement {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			
			int A = new Peak().peakElement(a, n);
			int f = 0;
			if (n == 1)
				f = 1;
			else if (A == 0 && a[0] >= a[1])
				f = 1;
			else if (A == n - 1 && a[n - 1] >= a[n - 2])
				f = 1;
			else if (a[A] >= a[A + 1] && a[A] >= a[A - 1])
				f = 1;
			else
				f = 0;
			System.out.println(f);
			
		}
	}
}// } Driver Code Ends

/*Complete the function below*/

class Peak {
	
	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr, int n) {
		//add code here.
		int st = 0;
		int end = n - 1;
		int ind = -1;
		
		while (st <= end) {
			int mid = st + (end - st) / 2;
			
			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
				ind = mid;
				break;
			} else if (mid + 1 < n && arr[mid] <= arr[mid + 1]) {
				st = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return ind;
	}
}