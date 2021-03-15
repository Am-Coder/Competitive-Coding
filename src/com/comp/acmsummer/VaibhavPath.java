package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class VaibhavPath {
	static int n;
	static int m;
	static int count = 0;
	static char[] vowel = {'a','e','i','o','u'};
	static StringBuilder str = new StringBuilder();
	static ArrayList<String> st = new ArrayList<>();
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		for(int i=0; i<a; i++) {
			n = s.nextInt();
			m = s.nextInt();
			int k = s.nextInt();
			char[][] grid = new char[n][m];
			for(int j=0; j<n; j++) {
				for(int l=0; l<m; l++) {
					grid[j][l] = s.next().charAt(0);
				}
				

			}
			path(grid,0,0,0,str);
			
			if(count<k) {
				System.out.println(-1);
			}else {
				Collections.sort(st);
				System.out.println(st.get(k - 1));
			}
			count = 0;
			st.clear();
			str = new StringBuilder();
		}
		
	}
	
	public static void path(char[][] ch, int a, int b, int vo,StringBuilder str ) {
		str.append(ch[a][b]);

		if( a+1 == n && b + 1 == m && vo >= 1) {
			count++;
			st.add(str.toString());
		}
		
		if( a+1<n ) {
			if(Arrays.binarySearch(vowel, ch[a][b]) >= 0)
				vo += 1;
			path(ch, a+1, b, vo,str);
			
		}
		
		if( b+1<m ) {
			if(Arrays.binarySearch(vowel, ch[a][b]) >= 0)
				vo += 1;
			path(ch, a, b+1, vo,str);
			
		}
		
		str.deleteCharAt(str.length() - 1);


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
