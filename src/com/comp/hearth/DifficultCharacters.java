package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;


public class DifficultCharacters {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		HashMap<Character,Integer> hmap = new LinkedHashMap<>();
		HashSet<val> hset = new LinkedHashSet<>();
		ArrayList<val> arr = new ArrayList<>();
		for(int i=25; i>=0; i--) {
		 	hset.add(new val((char)('a' + i),0));
		 	hmap.put((char)('a' + i),0);
		 	arr.add(new val((char)('a' + i),0));
		}
		
		for(int i=0; i<a; i++) {
//		 	char b = s.next().charAt(0);
		 	String b = s.nextLine();
//		 	System.out.print(b);
//		 	hmap.replace(b, hmap.get(b) + 1);
		 	for(int j=0; j<b.length(); j++) {
		 		char c = b.charAt(j);
		 		hmap.replace(c, hmap.get(c) + 1);
		 		
		 	}
		 	
		 	List<Map.Entry<Character, Integer>> ll = new LinkedList<>(hmap.entrySet());
		 	
		 	Collections.sort(ll, new Comparator<Map.Entry<Character, Integer>>(){

				@Override
				public int compare(Entry<Character, Integer> arg0, Entry<Character, Integer> arg1) {
					// TODO Auto-generated method stub
					if(arg0.getValue().compareTo(arg1.getValue()) == 0) {
						return -arg0.getKey().compareTo(arg1.getKey());
					}
					return arg0.getValue().compareTo(arg1.getValue());
				}
		 		
		 	}
		 	
	 		
		 	);
		 	hmap.clear();
		 	for(Map.Entry<Character, Integer> v: ll) {
		 		
		 		hmap.put(v.getKey(), v.getValue());
		 		
		 	}
		 	Set<Character> set = hmap.keySet();
		 	for (Character entry : set) {
				System.out.print(entry + " ");
				hmap.replace( entry, 0 );
			}
		 	
		 	System.out.print("\n");
		 	
		}
		
//		System.out.println("HI");
	}	 
	 static class val{
		 char v;
		 int c;
		public val(char v, int c) {
			super();
			this.v = v;
			this.c = c;
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
