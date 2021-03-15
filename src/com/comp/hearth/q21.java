package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class q21 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		int[] arr = new int[a];
		
		for(int i=0; i<a; i++) {
			arr[i]=(s.nextInt());
		}
		Arrays.sort(arr);

		for(int i=1; i<a; i++) {
			if(arr[i] - arr[i-1]>0) {
				arr[i-1] = 0;
			}else {
				int j=i-2;
				while(j>=0){
					if(arr[j]!=0 && arr[i]-arr[j]>0){
						arr[j]=0;
						break;
						}
					else
						j--;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<a; i++) {
			if(arr[i]!=0)
//				System.out.println(arr[i]);
				sum+=arr[i];
		}
		System.out.println(sum);
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
