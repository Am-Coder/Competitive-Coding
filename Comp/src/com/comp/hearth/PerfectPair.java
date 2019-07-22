package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class PerfectPair {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		HashSet<Integer> tset = new HashSet<Integer>();
		HashMap<Integer,Integer> hmap = new HashMap<>();
		for(int i=0; i<n; i++) {
			int a = s.nextInt();
			int[] arr = new int[a];
			int count = 0;
			for(int j=0; j<a; j++) {
				int num = s.nextInt();
				if(hmap.containsKey(num) == false)
					hmap.put(num,1);
				else
					hmap.replace(num,hmap.get(num) + 1);
				arr[j] = num;
				
			}
			tset = maxsum(arr);
			Arrays.sort(arr);

			for(int j=0; j<a; j++) {
			
				for(Integer val:tset) {
					if(Arrays.binarySearch(arr, val - arr[j])>=0) {
						if(val - arr[j] != arr[j])
							count++;
						else {
							if(hmap.get(arr[j])>1) {
								hmap.replace(arr[j],1);
								count++;
							}
						}
					}
				}

			}
			System.out.println(count/2);
		}
		
		
	}
	static HashSet<Integer> maxsum(int[] arr) {
		Arrays.sort(arr);
		int max = arr[arr.length - 1]+arr[arr.length -2];
		HashSet<Integer> hset = new HashSet<Integer>();

		for(int i=0; i<=max; i++) {
			if(Math.ceil(Math.cbrt(i)) == Math.floor(Math.cbrt(i)) || Math.ceil(Math.sqrt(i)) == Math.floor(Math.sqrt(i))) {
				hset.add(i);
			}
		}
		return hset;
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
