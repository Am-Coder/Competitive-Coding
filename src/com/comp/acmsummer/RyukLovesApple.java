package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class RyukLovesApple {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();

		int a = s.nextInt();
		ArrayList<Integer> even = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();

		for(int i=1; i<=a; i++) {
			if(i%2 == 0) {
				even.add(s.nextInt());
			}
			else {
				odd.add(s.nextInt());
			}
		}
		ArrayList<Integer> even1 =(ArrayList<Integer>) even.clone();

		ArrayList<Integer> odd1 = (ArrayList<Integer>) odd.clone();
		Collections.sort(even1);
		Collections.sort(odd1);

		long q=0,w=0;
		for(int i=0; i<even.size(); i++) {
			if(even.get(i) == even1.get(0)) {
				q = i;
				int flag = 0;
				for(int j=0; j<even.size(); j++) {
					if(even1.get(j) != even.get((j+i)%even.size())){
						flag = 1;
						break;
					}
				}
				if(flag==1) {
					System.out.println("NO");
					return;
				}
				break;
			}
		}
		
		for(int i=0; i<odd.size(); i++) {
			if(odd.get(i) == odd1.get(0)) {
				w = i;

				int flag = 0;
				for(int j=0; j<odd.size(); j++) {
					if(odd1.get(j) != odd.get((j+i)%odd.size())){
						flag = 1;
						break;
					}
				}
				if(flag==1) {
					System.out.println("NO");
					return;
				}
				break;
			}
		}
		
		if(even.size()-q<q)
		{
			q = even.size()-q;
		}
		if(odd.size()-w<w)
		{
			w = odd.size()-w;
		}
		System.out.println("YES");
		System.out.println(w+q);
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
