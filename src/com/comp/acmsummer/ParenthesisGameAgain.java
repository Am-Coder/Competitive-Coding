package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParenthesisGameAgain {
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
	public static void main(String[] args) {
	    
	    MyScanner s = new MyScanner();
	    int n = s.nextInt();
	    String[] st = new String[n];
	    LinkedHashMap<Integer,Pair> v = new LinkedHashMap<>();
	    LinkedHashMap<Integer,Pair> v2 = new LinkedHashMap<>();
	    int cnt3 = 0;
	    int l = 0, m = 0;
	    for( int i=0; i<n; i++){
	        Stack<Character> r = new Stack<>();
	        st[i] = s.nextLine();
	        
	        for( int j=0; j<st[i].length(); j++){
	            if( r.isEmpty())
	                r.push(st[i].charAt(j));
                else if(st[i].charAt(j) == ')' && r.peek() == '(' )
                    r.pop();
                else
                    r.push(st[i].charAt(j));
	        }
	        
	        int cnt = 0, cnt2 = 0;
	        
	        while( !r.isEmpty()){
	            if(r.peek() == '(')
	                cnt++;
                else
	                cnt2++;
                r.pop();
	        }
//	        System.out.println(cnt + "-" + cnt2);
	        if( cnt == 0 && cnt2 == 0)
	            cnt3++;
            else if(cnt != 0 && cnt2 == 0) {
	            v.put( l, new Pair(cnt,cnt2) );
	        	l++;
        	}
            else if( cnt == 0 &&  cnt2 != 0) {
                v2.put( m, new Pair(cnt,cnt2) );
                m++;
            }
	    }
	    int count = 0;
	    for( int i=0; i<v.size(); i++){
	        for(int j=0; j<v2.size(); j++){
	        	Pair p1 = v.get(i);
	        	Pair p2 = v2.get(j);
	            if(p1 != null && p2 != null && p1.x == p2.y ) {
//		        	System.out.println(p1.x + " - " + p2.y);

	            	count++;
	            	v.replace(i, null);
	            	v2.replace(j, null);
	            }
	        }
	    }
	    count = count + cnt3/2;
	    System.out.println(count);
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
