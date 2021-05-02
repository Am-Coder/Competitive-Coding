package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ProductOneModN {
	
	static final int MAXN = 1000_006;
	
	static final long MOD = (long) 1e9 + 7;
	
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		Print p = new Print();
		Helper hp = new Helper();
		int n = s.nextInt();
		int[] arr = new int[100005];
		long prod = 1;
		int cou = 0;
		for (int i = 1; i < n; i++) {
			if (hp.gcd(n, i) == 1) {
				arr[i] = 1;
				prod = (prod * (long) i) % (long) n;
			}
		}
		
		if (prod != 1) {
			arr[(int) prod] = 0;
		}
		
		for (int i = 1; i < n; i++) {
			if (arr[i] == 1)
				cou++;
		}
		
		System.out.println(cou);
		for(int i=1; i<n; i++) {
			if(arr[i] == 1) {
				System.out.print(i + " ");
			}
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
		
		static void swap(int ar[], int i, int j) {
			int temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
		}
		
		static void findNext(int ar[], int n) {
			int i;
			
			for (i = n - 1; i > 0; i--) {
				if (ar[i] > ar[i - 1]) {
					break;
				}
			}
			
			if (i == 0) {
				Arrays.sort(ar);
			} else {
				int x = ar[i - 1], min = i;
				
				for (int j = i + 1; j < n; j++) {
					if (ar[j] > x && ar[j] < ar[min]) {
						min = j;
					}
				}
				
				swap(ar, i - 1, min);
				
				Arrays.sort(ar, i, n);
				
			}
			
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
