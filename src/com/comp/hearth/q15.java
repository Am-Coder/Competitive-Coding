package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15 {
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		int b = s.nextInt();
		int[][] arr = new int[a][b];
//		int c = -999999998;
//		long d =(long) (10*Math.abs(c) + Math.abs(c));
//		System.out.println(d);
		int sum1=0,sum2=0,sum3=0;
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		int resRow = 0;
		int resCol = 0;
		int v1 = s.nextInt();
		int v2 = s.nextInt();
		int v3 = s.nextInt();
		int v4 = s.nextInt();
		
		for(int i=0; i<a; i++) {
			sum1 = 0;
			sum2 = 0;
			sum3 = 0;
			for(int j=0; j<b; j++) {
				sum1 += Math.abs(arr[i][j]) ;
				sum2 += Math.abs(v2) ; 
				sum3 += Math.abs(arr[i][j] + v1) ;
			}
//			System.out.println(sum1+"-"+sum2+"-"+sum3);
			if(sum1>=sum2 && sum1>=sum3) {
				resRow += sum1;
			}else if(sum2>sum1 && sum2>sum3) {
				resRow += sum2;
			}
			else {
				resRow += sum3;
			}
				
		}
		System.out.println(resRow);
//		for(int i=0; i<b; i++) {
//			sum1 = 0;
//			sum2 = 0;
//			sum3 = 0;
//			for(int j=0; j<a; j++) {
//				sum1 += Math.abs(arr[j][i]) ;
//				sum2 += Math.abs(v4) ; 
//				sum3 += Math.abs(arr[j][i] + v3) ;
//			}
//			
//			if(sum1>=sum2 && sum1>=sum3) {
//				resCol += sum1;
//			}else if(sum2>sum1 && sum2>sum3) {
//				resCol += sum2;
//			}
//			else {
//				resCol += sum3;
//			}
//				
//		}
//		System.out.println(resCol);

		System.out.println(resCol>=resRow?resCol:resRow);
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
