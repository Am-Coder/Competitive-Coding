package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class stacksq7 {
	
		public static void main(String[] args) {
			MyScanner s = new MyScanner();
//			PrintWriter out = new PrintWriter();
			int a = s.nextInt();
//			s.nextLine();
			Stack<Long>[] st =new Stack[a]; //I love java
			for(int i=0 ; i < a ; i++) {
				String[] str = s.nextLine().split(" ");
				st[i] = new Stack<Long>();
				for(int j=0; j<Integer.parseInt(str[0]); j++){
					st[i].add(Long.parseLong(str[j+1]));
				}
				if (i!=0)
					Collections.sort(st[i]);
			}
			int b = s.nextInt();
			int k;
			Long h;
			for(int i=0; i<b ; i++) {
				String[] str = s.nextLine().split(" ");
				if(str[0].equals("0")) {
					k = Integer.parseInt(str[1])-1;
					if(st[k].size()!=0)
						st[k].pop();
				}else if(str[0].equals("1")) {
					k = Integer.parseInt(str[1])-1;
					h = Long.parseLong(str[2]);
					st[k].add(h);
					if(k!=0)
						Collections.sort(st[k]);
					
				}else {
					int check=0;
					for(int l=0 ; l<a-1 ;l++) {
						h=st[l+1].peek();
						k=st[l].size();
						if(k==0) {
							check=0;
							break;
						}
						for(int m = 0; m < k ; m++) {
							long c = st[l].get(m);
							if (c<h) {
								check=1;
								break;
							}
						
						}
					}
					if(check==1)
						System.out.println("YES");
					else 
						System.out.println("NO");
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
