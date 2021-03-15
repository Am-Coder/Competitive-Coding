package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FrequencyOfStudents {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		Map<String,Integer> hmap = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
					String[] str1 = a.split(" ");
					String[] str2 = b.split(" ");
					if(str1[0].equals(str2[0])) {
//						if(a.end == b.end) {
//							return a.count - b.count;
//						}
						return Integer.parseInt(str1[1]) - Integer.parseInt(str2[1]);
					}
				return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
			}
			
		});
		for(int i=0; i<a; i++) {
//			point pt = new point(s.nextInt(), s.nextInt(),1);
			String str = s.nextLine();
			if(hmap.containsKey(str) == false) {
				hmap.put(str, 1);
			}else {
//				pt.count = hmap.get(pt) + 1;
				hmap.replace(str, hmap.get(str) + 1);
			}
		}
		Set<String> key = hmap.keySet();
		for(String k: key) {
			System.out.println(k + " " + hmap.get(k));
		}
		
		
	}
	
	static class point{
		int st;
		int end;
		int count;
		public point(int st, int end, int count) {
			super();
			this.st = st;
			this.end = end;
			this.count = count;
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
