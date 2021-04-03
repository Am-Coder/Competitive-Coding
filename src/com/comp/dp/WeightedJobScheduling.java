package com.comp.dp;

import java.util.Arrays;

public class WeightedJobScheduling {
	
	static class Job {
		
		int st;
		
		int end;
		
		int profit;
		
		Job(int st, int end, int profit) {
			this.st = st;
			this.end = end;
			this.profit = profit;
		}
		
		static int binsearch(Job[] jobs, int i) {
			int st = 0;
			int en = i - 1;
			int sol = -1;
			while (st <= en) {
				int mid = st + ((en - st) / 2);
				if (jobs[mid].end <= jobs[i].st) {
					sol = mid;
					st = mid + 1;
				} else {
					en = mid - 1;
				}
			}
			return sol;
		}

		//		Top Down DP -> n(logn)
		static int findMaxProfit(Job[] arr, int n) {
			Arrays.sort(arr, (a,b) -> {
				return a.end - b.end;
			});
			
			// dp[i] max profit of non intersecting intervals uptil job i
			int[] dp = new int[n];
			dp[0] = arr[0].profit;
			
			for (int i = 1; i < n; i++) {
				// Including profit of Job i
				int inclProf = arr[i].profit;
				int tmp = binsearch(arr, i);
				if (tmp != -1)
					inclProf += dp[tmp];
				
				// Max of result including ith job and excluding it
				dp[i] = Math.max(inclProf, dp[i - 1]);
			}
			return dp[n - 1];
		}

		public static void main(String[] args) {
			Job arr[] = { new Job(3, 5, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200) };
			int n = arr.length;
			System.out.println(findMaxProfit(arr, n));
		}
	}
}
