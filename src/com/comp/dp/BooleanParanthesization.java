package com.comp.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BooleanParanthesization {
	
	static int MOD = 1003;
	
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		//code
		MyScanner s = new MyScanner();
		Print p = new Print();
		
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			String str = s.nextLine();
			dp = new int[2][n + 1][n + 1];
			for (int l = 0; l < 2; l++)
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						dp[l][i][j] = -1;
					}
				}
			int ans = parenthesize(str, 0, n - 1, 1);
			System.out.println(ans);
		}
	}
	
	static int parenthesize(String str, int i, int j, int sol) {
		if (i > j) {
			return dp[sol][i][j] = 0;
		}
		
		if (dp[sol][i][j] != -1)
			return dp[sol][i][j];
		
		if (i == j) {
			if (sol == 1)
				return dp[sol][i][i] = (str.charAt(i) == 'T' ? 1 : 0);
			else
				return dp[sol][i][i] = (str.charAt(i) == 'F' ? 1 : 0);
		}
	    

	    	
		int ans = 0;
		
		// SEE HERE K IS INCREMENTED BY 2, IF INCREMENTED BY 1 THEN THERE IS TLE
		for (int k = i + 1; k < j; k += 2) {
			if (dp[1][i][k - 1] == -1) {
				dp[1][i][k - 1] = parenthesize(str, i, k - 1, 1);
			}
			int lt = parenthesize(str, i, k - 1, 1);
			
			if (dp[0][i][k - 1] == -1) {
				dp[0][i][k - 1] = parenthesize(str, i, k - 1, 0);
			}
			int lf = parenthesize(str, i, k - 1, 0);
			
			if (dp[1][k + 1][j] == -1) {
				dp[1][k + 1][j] = parenthesize(str, k + 1, j, 1);
			}
			int rt = parenthesize(str, k + 1, j, 1);
			
			if (dp[0][k + 1][j] == -1) {
				dp[0][k + 1][j] = parenthesize(str, k + 1, j, 0);
			}
			int rf = parenthesize(str, k + 1, j, 0);
			
			if (str.charAt(k) == '|') {
				if (sol == 1) {
					ans = (ans + lt * rt + lt * rf + rt * lf) % MOD;
				} else {
					ans = (ans + lf * rf) % MOD;
				}
			} else if (str.charAt(k) == '&') {
				if (sol == 1) {
					ans = (ans + lt * rt) % MOD;
				} else {
					ans = (ans + lt * rf + rt * lf + lf * rf) % MOD;
				}
			} else if (str.charAt(k) == '^') {
				if (sol == 1) {
					ans = (ans + rf * lt + lf * rt) % MOD;
				} else {
					ans = (ans + lf * rf + lt * rt) % MOD;
				}
			}
		}
		
		return dp[sol][i][j] = ans % MOD;
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
}
