package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RemoveFriends {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i=0 ; i < n; i++ ){
		    int a = s.nextInt();
		    int k = s.nextInt();
		    for(int j=0; j<a; j++){
		        ll.addLast(s.nextInt());
		    }
		    for(int j=0; j<k; j++) {
		    	Iterator<Integer> it = ll.iterator();
		    	boolean DeleteFriend=false;
		    	int cur = it.next();
    		    while(it.hasNext()) {
    		    	int next = it.next() ;
    		    	if (cur < next) {
    		        	ll.remove(ll.indexOf(cur)) ; 	//delete i th friend
    		            DeleteFriend=true ;
    		            break ;
    		    	}
    		    	cur = next ;
	            }
    		    if(DeleteFriend == false)
    		        ll.removeLast();
		    	
		    }
		    
		    for(int j=0; j<ll.size(); j++) {
		    	System.out.print(ll.get(j) + " ");
		    }
		    System.out.print("\n");
		    ll.clear();
		}
	}
	
	static void delete(){
	    
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
