package com.comp.dp;

public class PaintingFenceAlgo {
	static int mo = 1000000007;
	//Bottom Up Approach
	static int pfalgo(int n, int k) {
		
		int[] total = new int[n+1];
		total[1] = k;
		int same = 0;
		int diff = k;
		
		for(int i=2; i<=n; i++) {
			same = diff;	
			diff = total[i-1]*(k - 1);
			diff = diff%mo;
			total[i] = (same + diff)%mo;
			
		}
		
		return total[n];
	}
	
	public static void main(String[] args) {
		System.out.println(pfalgo(2, 4));
	}
}
