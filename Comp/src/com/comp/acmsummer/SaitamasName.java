package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SaitamasName {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int k = s.nextInt();
		int[] clist = new int[26];
		StringBuilder str = new StringBuilder();
		for(int i=0; i<n; i++) {
			int ch = s.next().charAt(0) - 'a';
			clist[ch] += 1;
		}
//		for(int i=0; i<clist.length; i++) {
//			System.out.println(clist[i]);
//		}
//		System.out.println(str.length());
		for(int i=0; i<26; i++) {
			if(str.length() == k)
				break;
			if(clist[i] >= k) {
					int a = clist[i];
					if((a&1) == 1)
						a-=1;
					while(a !=0 || (a&1) != 1) {
						if(str.length()+2 > k)
							break;
						str.insert((str.length()/2), (char)(i+'a'));
						str.insert((str.length()/2), (char)(i+'a'));
						clist[i] -= 2;
						a -= 2;
					}
				break;

			}else if(clist[i] < k && clist[i]>0) {
				int a = clist[i];
				if((a&1) == 1)
					a -= 1;
				while(a != 0 ) {
					if(str.length()+2 > k)
						break;
					str.insert((str.length()/2), (char)(i+'a'));
					str.insert((str.length()/2), (char)(i+'a'));
			
					clist[i] -= 2;
					a -=2;
				}

//				System.out.println(str);
			}
		}
		
		if((k&1) == 1) {
			for(int i=0; i<26; i++) {
				int ch = clist[i];
				if(ch!=0) {
					str.insert((str.length()/2), (char)(i+'a'));
					break;
				}
			}
		}
		
		if(str.length() != k) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
			System.out.println(str);
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
