package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class numtheoryq12 {
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
	int n = s.nextInt();
//	s.nextLine();
	long a,b,c;
	HashMap<Long,Long> hmap = new HashMap<>();
	for(int i=0; i<n ; i++) {
//		String[] str = s.nextLine().split(" ");
		a = s.nextLong();
		b = s.nextLong();
		c = s.nextLong();
		int ans=0;
		if(c==0) {
			ans = 1;
		}else if(c<(a>=b?b:a)) {
			ans = 0;
		}else	{
			
			long j=0;
			Double val1;
			while( a*j<c ) {
				val1 = (double)(c - a*j)/b;
//				System.out.println(val1);
				if(Math.floor(val1) == Math.ceil(val1)) {
					ans += 1;
					hmap.put(j,val1.longValue());
				}
				j++;

			}
//			System.out.println(ans);
			j=0;
			while( b*j<c ) {
				val1 = (double)(c - b*j)/a;
	
				if((hmap.containsKey(val1.longValue()) && hmap.get(val1.longValue())!=j) || hmap.containsKey(val1.longValue())==false )
					if( Math.floor(val1) == Math.ceil(val1) && hmap.containsKey(val1.longValue())==false ) {
						ans += 1;
					}
				
				j++;
			}			
		}
		
		System.out.println(ans);
		
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
