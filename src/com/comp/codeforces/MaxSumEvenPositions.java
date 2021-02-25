package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MaxSumEvenPositions {
	
	static final int MAXN = 1000_006;
	
	static final long MOD = (long) 1e9 + 7;
	
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = s.nextInt();
			long[][] dp = new long[n + 1][3];
			for (int i = 0; i < n; i++) {
				dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0] + ((i & 1) == 1 ? 0 : arr[i]));
				if (i + 2 <= n)
					dp[i + 2][1] = Math.max(dp[i + 2][1],
					    Math.max(dp[i][0], dp[i][1]) + ((i & 1) == 1 ? arr[i] : arr[i + 1]));
				dp[i + 1][2] = Math.max(dp[i + 1][2],
				    Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])) + ((i & 1) == 1 ? 0 : arr[i]));
			}
			System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));
		}
		
	}
	
	public static class Pair implements Comparable<Pair> {
		
		int first;
		
		int second;
		
		public Pair(int a, int b) {
			this.first = a;
			this.second = b;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + first;
			result = prime * result + second;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (first != other.first)
				return false;
			if (second != other.second)
				return false;
			return true;
		}
		
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.first - first;
		}
		
	}
		
	static class Print {
		
		private BufferedWriter bw;
		
		public Print() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}
		
		public void print(Object object) throws IOException {
			bw.append("" + object);
		}
		
		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}
		
		public void close() throws IOException {
			bw.close();
		}
	}
	
	public static class MyScanner {
		
		BufferedReader br;
		
		StringTokenizer st;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
}
