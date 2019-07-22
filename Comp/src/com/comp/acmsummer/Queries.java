package com.comp.acmsummer;

//import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Queries {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<a; i++) {
			arr.add(s.nextInt());
		}

		a = s.nextInt();
		for(int i=0; i<a; i++) {
			int j = s.nextInt();
			int k = s.nextInt() - 1;
			int l = s.nextInt() - 1;
			if(j == 1) {
				while(k<l) {
					int temp = arr.get(k);
					arr.set(k,arr.get(l));
					arr.set(l, temp);
					k += 1;
					l -= 1;
				}
				for(int o=0; o<arr.size(); o++)
					System.out.print(arr.get(o)+" ");
			}else if(j == 2) {
				int sum=0;
				for(int m=k; m<=l; m++)
					sum += arr.get(m);
				System.out.println(sum);
			}
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

