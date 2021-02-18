package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class NastyaScoreboard {
	
	static String[] q;
	
	static HashMap<String, Integer> hm;
	
	static int n;
	
	static int k;
	
	static String[] num;
	
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		num = new String[] { "1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1010010",
		        "1111111", "1111011" };
		hm = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			hm.put(num[i], i);
		}
		n = s.nextInt();
		k = s.nextInt();
		q = new String[n];
		for( int i=0; i<n; i++ ) {
			q[i] = s.nextLine();
		}
		calc = new int[n][10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				calc[i][j] = poss(i, j);
			}
		}
		dq = new LinkedList<>();
		dp = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = -1;
			}
		}
		if (mcm(0, k) == 1) {
			p.println(sb.toString());
		} else {
			p.println(-1);
		}
		p.close();
	}
	
	static Deque<Integer> dq;
	
	static int[][] calc;
	
	static StringBuilder sb;
	static int[][] dp;
	public static int mcm(int i, int cou) {
		
		if (i == n && cou == 0) {
			if (sb == null) {
				sb = new StringBuilder();
				while (!dq.isEmpty()) {
					sb.append(dq.peek());
					dq.poll();
				}
			}
			return 1;
		}
		if (i >= n)
			return 0;
		if (cou < 0)
			return 0;
		if (dp[i][cou] != -1)
			return dp[i][cou];
		int ans = 0;
		for (int j = 9; j >= 0; j--) {
			if (calc[i][j] >= 0) {
				dq.addLast(j);
				ans |= mcm(i + 1, cou - calc[i][j]);
				dq.pollLast();
			}
		}
		return dp[i][cou] = ans;
	}
	
	public static int poss(int i, int j) {
		char[] qq = q[i].toCharArray();
		char[] nn = num[j].toCharArray();
		int cou = 0;
		for (int k = 0; k < nn.length; k++) {
			if (nn[k] != '1' && qq[k] == '1') {
				return -1;
			}
			if (qq[k] == '0' && nn[k] == '1') {
				cou++;
			}
		}
		return cou;
	}
	public static class Pair implements Comparable<Pair> {
		int first;
		int second;
		
		public Pair( int a, int b ) {
			this.first = a;
			this.second = b;
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
	              } catch (IOException e) {
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
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }
	}


}
