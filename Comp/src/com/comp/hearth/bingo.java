package com.comp.hearth;

import java.util.*;
import java.io.*;
public class bingo {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int[][] me = new int[5][5];
		int[][] you = new int[5][5];
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<5; j++) {
				me[i][j] = s.nextInt();
			}
		}
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<5; j++) {
				you[i][j] = s.nextInt();
			}
		}
		int m = 0 ;
		int y = 0 ;
		for(int i=0; i<=25; i++) {
			
			int a = s.nextInt();
			for(int j=0; j<5; j++) {
				
				for(int k=0; k<5; k++) {
					if(you[j][k] == a)
						you[j][k] = -1;
				}
			}
			for(int j=0; j<5; j++) {
				
				for(int k=0; k<5; k++) {
					if(me[j][k] == a)
						me[j][k] = -1;
				}
			}
			
			m = check(me);
			y = check(you);
			System.out.println(m + " " + y);
			if(m == 5 || y == 5 ) {
				break;
			}
		}	
		if(m == 5 && y == 5 || m != 5  && y != 5) {
			System.out.println("It's a tie!");
		}else if(m == 5 && y != 5 ) {
			System.out.println("I Won!");
		}else if(m != 5 && y == 5) {
			System.out.println("You won -_-");
		}
		
	}
	
	static int check(int[][] arr) {
		int count1 = 0;
		for(int i=0; i<5; i++) {
			if(arr[i][i] == -1) {
				count1++;
				
			}
		}
		int c1 = 0;
		for(int i=0; i<5 ; i++) {
		
			if(arr[i][4-i]==-1) {
				c1++;
			}
		}
		if( count1 < c1 ) {
			count1 = c1;
		}
		for(int i=0; i<5; i++) {
			int c = 0;
			for(int j=0; j<5; j++) {
				if(arr[i][j] == -1 ) {
					c++;
				}
			}
			if(c > count1) {
				count1 = c;
			}
		}
		
		for(int i=0; i<5; i++) {
			int c = 0;
			for(int j=0; j<5; j++) {
				if(arr[j][i] == -1 ) {
					c++;
				}
			}
			if(c > count1) {
				count1 = c;
			}
		}
		
		return count1;
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