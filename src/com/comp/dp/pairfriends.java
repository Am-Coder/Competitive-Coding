package com.comp.dp;
public class pairfriends {

	//bottom up approach	
	static int pair(int n) {
		int[] arr = new int[n+1];
		
		arr[0] = 0;
		
		
		for(int i=1; i<=n; i++) {
				
			if(i<=2)
				arr[i] = i;
			else
				arr[i] = arr[i - 1] + (i - 1)*arr[i - 2];
			
		}
		
		return arr[n];
		
	}
	
	//Memoize top down approach
	static int[] dp = new int[1000];
	static int pair1(int n) {
		if(dp[n] != -1) {
			return dp[n];
		}
		if(n>2) {
			return dp[n] = pair1(n-1) + (n-1)*pair1(n - 2);
		}else {
			return dp[n] = n;
		}
	}
	public static void main(String[] args) {
		System.out.println(pair(3));
	}
}
