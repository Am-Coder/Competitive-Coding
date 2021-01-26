package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

public class ReadingBooks {
	
	static final int MAXN = 1000_006;
	
	static final long MOD = (long) 1e9 + 7;
	
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int n = s.nextInt();
		int k = s.nextInt();
		int al = 0;
		int bo = 0;
		ArrayList<Integer> oneone = new ArrayList<>();
		ArrayList<Integer> zeroone = new ArrayList<>();
		ArrayList<Integer> onezero = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int ti = s.nextInt();
			int ai = s.nextInt();
			if(ai == 1)
				al++;
			int bi = s.nextInt();
			if(bi == 1)
				bo++;
			if (ai == 1 && bi == 1) {
				oneone.add(ti);
			} else if (ai == 0 && bi == 1) {
				zeroone.add(ti);
			} else if (ai == 1 && bi == 0) {
				onezero.add(ti);
			}
			
		}
		if(al < k || bo < k) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(oneone);
		Collections.sort(onezero);
		Collections.sort(zeroone);
		int[] prfa = new int[onezero.size() + 1];
		int[] prfb = new int[zeroone.size() + 1];
		for (int i = 1; i <= onezero.size(); i++) {
			prfa[i] = prfa[i - 1] + onezero.get(i - 1);
		}
		for (int i = 1; i <= zeroone.size(); i++) {
			prfb[i] = prfb[i - 1] + zeroone.get(i - 1);
		}
		long min = Long.MAX_VALUE;
		long val = 0;
		for (int i = 0; i < k && i < oneone.size(); i++) {
			val += oneone.get(i);
			if (onezero.size() >= k - i - 1 && zeroone.size() >= k - i - 1) {
				min = Math.min(min, val + (long) prfa[k - i - 1] + (long) prfb[k - i - 1]);
			}
		}
		if (onezero.size() >= k && zeroone.size() >= k)
			min = Math.min(min, prfa[k] + prfb[k]);
		System.out.println(min);
	}
	
	

	public static class Pair implements Comparable<Pair> {
		
		int first;
		
		int second;
		
		int third;
		
		public Pair(int a, int b, int c) {
			this.first = a;
			this.second = b;
			this.third = c;
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
	
	public static class Helper {
		
		long MOD = (long) 1e9 + 7;
		
		int MAXN = 1000_006;;
		
		Random rnd;
		
		public Helper(long mod, int maxn) {
			MOD = mod;
			MAXN = maxn;
			rnd = new Random();
		}
		
		public Helper() {
			
		}
		
		public static int[] sieve;
		
		public static ArrayList<Integer> primes;
		
		public void setSieve() {
			primes = new ArrayList<>();
			sieve = new int[MAXN];
			int i, j;
			for (i = 2; i < MAXN; ++i)
				if (sieve[i] == 0) {
					primes.add(i);
					for (j = i; j < MAXN; j += i) {
						sieve[j] = i;
					}
				}
		}
		
		public static long[] factorial;
		
		public void setFactorial() {
			factorial = new long[MAXN];
			factorial[0] = 1;
			for (int i = 1; i < MAXN; ++i)
				factorial[i] = factorial[i - 1] * i % MOD;
		}
		
		public long getFactorial(int n) {
			if (factorial == null)
				setFactorial();
			return factorial[n];
		}
		
		public long ncr(int n, int r) {
			if (r > n)
				return 0;
			if (factorial == null)
				setFactorial();
			long numerator = factorial[n];
			long denominator = factorial[r] * factorial[n - r] % MOD;
			return numerator * pow(denominator, MOD - 2, MOD) % MOD;
		}
		
		public long[] getLongArray(int size, MyScanner s) throws Exception {
			long[] ar = new long[size];
			for (int i = 0; i < size; ++i)
				ar[i] = s.nextLong();
			return ar;
		}
		
		public int[] getIntArray(int size, MyScanner s) throws Exception {
			int[] ar = new int[size];
			for (int i = 0; i < size; ++i)
				ar[i] = s.nextInt();
			return ar;
		}
		
		public int[] getIntArray(String s) throws Exception {
			s = s.trim().replaceAll("\\s+", " ");
			String[] strs = s.split(" ");
			int[] arr = new int[strs.length];
			for (int i = 0; i < strs.length; i++) {
				arr[i] = Integer.parseInt(strs[i]);
			}
			return arr;
		}
		
		public long gcd(long a, long b) {
			return b == 0 ? a : gcd(b, a % b);
		}
		
		public int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a % b);
		}
		
		public long max(long[] ar) {
			long ret = ar[0];
			for (long itr : ar)
				ret = Math.max(ret, itr);
			return ret;
		}
		
		public int max(int[] ar) {
			int ret = ar[0];
			for (int itr : ar)
				ret = Math.max(ret, itr);
			return ret;
		}
		
		public long min(long[] ar) {
			long ret = ar[0];
			for (long itr : ar)
				ret = Math.min(ret, itr);
			return ret;
		}
		
		public int min(int[] ar) {
			int ret = ar[0];
			for (int itr : ar)
				ret = Math.min(ret, itr);
			return ret;
		}
		
		public long sum(long[] ar) {
			long sum = 0;
			for (long itr : ar)
				sum += itr;
			return sum;
		}
		
		public long sum(int[] ar) {
			long sum = 0;
			for (int itr : ar)
				sum += itr;
			return sum;
		}
		
		public long pow(long base, long exp, long MOD) {
			base %= MOD;
			long ret = 1;
			while (exp > 0) {
				if ((exp & 1) == 1)
					ret = ret * base % MOD;
				base = base * base % MOD;
				exp >>= 1;
			}
			return ret;
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
