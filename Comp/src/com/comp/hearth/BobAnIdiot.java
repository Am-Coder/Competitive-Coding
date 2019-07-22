package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BobAnIdiot {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		HashMap<Character, Integer> hmap = new HashMap<>();

		for(Integer i=0; i<26; i++){
		    hmap.put((char)('A' + i), i);

		}
		
		for(int i=0; i<a; i++){
		    char c = s.next().charAt(0);
		    char b = s.next().charAt(0);
		    int val1 = hmap.get(c);
		    int val2 = hmap.get(b);
		    hmap.replace(c, val2);
		    hmap.replace(b, val1);
		    
		    }
		String str = s.nextLine();
		char[] ch = str.toCharArray();
		StringBuilder ans = new StringBuilder();
	    for(int i=0; i<ch.length; i++){
	        if( ch[i]>='a' && ch[i]<= 'z'){
	        	
    	        if(hmap.containsKey(Character.toUpperCase(ch[i]))){
    	        	int c = hmap.get(Character.toUpperCase(ch[i]));
    	            ans.append((char)(c+'a'));
    	        }
	        }
	        else if(ch[i]>='A' && ch[i]<='Z'){
    	        if(hmap.containsKey(ch[i])){
    	        	
    	            ans.append((char)(hmap.get(ch[i])+'A'));
    	        }
	        }

	    }
	    
	    System.out.println(ans);
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
