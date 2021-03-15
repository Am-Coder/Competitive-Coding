package com.comp.dp;


/*package whatever //do not write package name here */

/*1. Find the smallest string in the group
2. Do a binary search for the common prefix in other strings using this smallest string.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestCommonPrefix {
	
	static final int MAXN = 1000_006;
	
	static final long MOD = (long) 1e9 + 7;
	
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			String[] arr = new String[n];
			int mini = 0;
			int minl = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = s.next();
				if (arr[i].length() < minl) {
					minl = arr[i].length();
					mini = i;
				}
			}
			sol = "";
			binsearch(arr, 0, minl - 1, arr[mini]);
			if (sol.length() == 0)
				System.out.println(-1);
			else
				System.out.println(sol);
		}
	}
	
	static String sol = "";
	
	static void binsearch(String[] arr, int st, int end, String min) {
		if (st <= end) {
			int mid = st + (end - st) / 2;
			if (allhave(arr, st, mid, arr.length, min)) {
				sol += arr[0].substring(st, mid + 1);
				binsearch(arr, mid + 1, end, min);
			} else {
				binsearch(arr, st, mid - 1, min);
			}
		}
	}
	
	static boolean allhave(String[] arr, int st, int end, int n, String min) {
		for (int i = 0; i < n; i++) {
			for (int j = st; j <= end; j++) {
				if (arr[i].charAt(j) != min.charAt(j)) {
					return false;
				}
			}
		}
		return true;
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