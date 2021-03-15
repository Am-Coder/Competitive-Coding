package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class VaibhavsPath {
	static String vowel = "aeiou";
	static StringBuilder str = new StringBuilder();
	static ArrayList<String> st = new ArrayList<>();
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int t = s.nextInt();
		
		for(int i=0; i<t; i++) {
			
			int n = s.nextInt();
			int m = s.nextInt();
			int k = s.nextInt();
			char[][] grid = new char[n][m];
			for(int j=0; j<n; j++) {
				
				for(int l=0; l<m; l++) {
					grid[j][l] = s.next().charAt(0);
				}
				
			}
			List<Character> path = new ArrayList<>();
			findPaths(grid,path,0,0);
			Collections.sort(st);
			if(st.size() >= k) {
				System.out.println(st.get(k-1));
			}else {
				System.out.println(-1);
			}
			st.clear();
		}
		

	}	
		
	public static void printPath(List<Character> path, char last)
	{	StringBuilder str = new StringBuilder();
		int vo = 0;
		if(vowel.indexOf(last) != -1){
			vo = 1;
		}
		for (char i : path) {
			if(vowel.indexOf(i) != -1)
				vo = 1;
			str.append(i);
		}
		if(vo == 1) {
			str.append(last);
			st.add(str.toString());
		}
	}

	public static void findPaths(char[][] mat, List<Character> path,
													int i, int j)
	{
		int M = mat.length;
		int N = mat[0].length;

		// if we have reached the last cell, print the route
		if (i == M - 1 && j == N - 1)
		{
			printPath(path, mat[i][j]);
			return;
		}

		// include current cell in path
		path.add(mat[i][j]);

		// move right
		if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) {
			findPaths(mat, path, i, j + 1);
		}

		// move down
		if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) {
			findPaths(mat, path, i + 1, j);
		}

		// remove current cell from path
		path.remove(path.size() - 1);
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
