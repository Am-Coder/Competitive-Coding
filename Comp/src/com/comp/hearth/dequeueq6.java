package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class dequeueq6 {
	
	
    public static void main(String args[] ) throws Exception {
    	MyScanner s = new MyScanner();
    	int a = Integer.parseInt(s.nextLine());
    	ArrayDeque<Myschool> sup = new ArrayDeque<>();
    	Deque<Myschool> que = new ArrayDeque<>();
    	for(int i=0 ; i < a ; i++) {
    		String[] str = s.nextLine().split(" ");
//    		System.out.println(str.length);
    		if(str[0].equals("E")) {
    			int si = que.size();
//    			System.out.println(si);
    			

    			Myschool sch = new Myschool(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
    			if(si==0)
    				que.add(sch);
    			else {
	    			for(int j=0 ; j<si+1 ; j++) {
		    			Myschool ele = que.pollLast();
		    			if(ele==null && que.size()==0) {
		    				sup.add(sch);
		    			}else if(ele.school == sch.school) {
		    				que.add(ele);
		    				que.add(sch);
		    				break;
		    			}else if(ele.school != sch.school) {
		    				sup.addFirst(ele);
		    			}
		    			
		    		}
    			}
    			que.addAll(sup);
//    			System.out.println("-"+que.size());
    			sup.clear();
    		}else if(str[0].equals("D")) {
    			Myschool sch=que.pollFirst();
    			System.out.println(sch.school+" "+sch.rno);
    		}
    	}
    	
    }
    
//	   public static PrintWriter out;

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

class Myschool	{
	int school;
	int rno;
	public Myschool(int school, int rno) {
		super();
		this.school = school;
		this.rno = rno;
	}
	
	
}

