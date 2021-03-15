package com.comp.dp;

import java.util.Arrays;
import java.util.Scanner;

// Variation of Longest Increasing Subsequence
// For decision making we use area of base and dimensions of base
public class BoxStacking {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//sc.next();
		while (t-- > 0) {
			int n = sc.nextInt();
			
			int A[] = new int[1000];
			int B[] = new int[1000];
			int C[] = new int[1000];
			
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				A[i] = a;
				B[i] = b;
				C[i] = c;
			}
			
			Geeks ob = new Geeks();
			System.out.println(ob.maxHeight(A, B, C, n));
		}
	}
}

class Geeks {
	
	static class Box implements Comparable<Box> {
		
		int h, w, d, area;
		
		Box(int h, int w, int d) {
			this.h = h;
			this.w = w;
			this.d = d;
		}
		
		public int compareTo(Box b2) {
			return b2.area - this.area;
		}
	}
	
	public static int maxHeight(int h[], int w[], int l[], int n) {
		Box[] rot = new Box[3 * n];
		Box[] arr = new Box[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Box(h[i], w[i], l[i]);
		}
		
		for (int i = 0; i < n; i++) {
			Box box = arr[i];
			
			rot[3 * i] = new Box(box.h, Math.max(box.w, box.d), Math.min(box.w, box.d));
			
			rot[3 * i + 1] = new Box(box.w, Math.max(box.d, box.h), Math.min(box.d, box.h));
			
			rot[3 * i + 2] = new Box(box.d, Math.max(box.w, box.h), Math.min(box.w, box.h));
		}
		
		for (int i = 0; i < rot.length; i++) {
			rot[i].area = rot[i].w * rot[i].d;
		}
		
		Arrays.sort(rot);
		
		int count = 3 * n;
		
		int[] msh = new int[count];
		for (int i = 0; i < count; i++) {
			msh[i] = rot[i].h;
		}
		for (int i = 0; i < count; i++) {
			msh[i] = 0;
			Box box = rot[i];
			int val = 0;
			
			for (int j = 0; j < i; j++) {
				Box prevBox = rot[j];
				
				// Area Comparator alone is not sufficient 
				// We also need to check the dimensionwise 
				// fit
				if (box.w < prevBox.w && box.d < prevBox.d) {
					val = Math.max(val, msh[j]);
				}
			}
			msh[i] = val + box.h;
		}
		
		int max = -1;
		for (int i = 0; i < count; i++) {
			max = Math.max(max, msh[i]);
		}
		return max;
	}
	
}
