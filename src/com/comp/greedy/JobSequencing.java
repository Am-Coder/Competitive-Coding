package com.comp.greedy;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class DisjointSet {
	
	int parent[];
	
	DisjointSet(int n) {
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	int find(int s) {
		if (parent[s] == s) {
			return s;
		}
		
		return parent[s] = find(parent[s]);
	}
	
	void union(int u, int v) {
		parent[v] = u;
	}
}

public class JobSequencing {
	
	static class Job {
		
		int id;
		
		int x;
		
		int y;
		
		Job(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) {
		//code
		MyScanner s = new MyScanner();
		int tt = s.nextInt();
		while (tt-- > 0) {
			int n = s.nextInt();
			Job[] b = new Job[n];
			int t = 0;
			for (int i = 0; i < n; i++) {
				int a1 = s.nextInt();
				int a2 = s.nextInt();
				int a3 = s.nextInt();
				t = Math.max(t, a2);
				b[i] = new Job(a1, a2, a3);
			}
			Arrays.sort(b, new Comparator<Job>() {
				
				public int compare(Job p1, Job p2) {
					return p2.y - p1.y;
				}
			});
			
			DisjointSet ds = new DisjointSet(t);
			
			int time[] = new int[t];
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				
				int avlSlot = ds.find(b[i].x);
				if (avlSlot > 0) {
					ds.union(ds.find(avlSlot - 1), avlSlot);
					cnt++;
					sum += b[i].y;
					
				}
				
			}
			
			System.out.println(cnt + " " + sum);
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
