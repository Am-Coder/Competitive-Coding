package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class EeriePlanet {
	static class MyComparator implements Comparator<worker>{

		@Override
		public int compare(worker arg0, worker arg1) {
			// TODO Auto-generated method stub
			if(arg0.st == arg1.st)
				return arg0.end - arg1.end;
			return arg0.st - arg1.st;
		}
		
	}
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int h = s.nextInt();
		int c = s.nextInt();
		int q = s.nextInt();
		int mend = -1;
		int min = Integer.MAX_VALUE;
		PriorityQueue<worker> pq = new PriorityQueue<>(c, new MyComparator());
		Queue<worker> sup = new LinkedList<>();
		for(int i=0; i<c; i++) {
			int ht = s.nextInt();
			int st = s.nextInt();
			int end = s.nextInt();
			if(end > mend)
				mend = end;
			if(st<min)
				min = st;
			worker w1 = new worker(ht, st, end); 
			
			pq.add(w1);
		}

		for(int i=0; i<q; i++) {
			
			int hi = s.nextInt();
			int ti = s.nextInt();
			int check = 0;
			if(ti> h) {
				check =0;
			}
			else if(ti > mend || ti < min) {
//				System.out.println("YES");
				check = 1;
			}
			else{
				worker prev = pq.poll();
				sup.add(prev);
				while(prev != null) {
					worker next = pq.poll();
					if(next != null)
						sup.add(next);

					if(next != null && ti>=prev.st && ti<=prev.end && ti>=next.st && ti<=next.end) {
						if(hi>next.ht && hi>prev.ht ) {
							check = 1;
						}else {
							
							check = 0;
						}
						if(check == 0)
							break;
					}else if(hi>prev.ht && ti>=prev.st && ti<=prev.end) {
						check = 1;
						break;
					}else if(next != null && ti>prev.end && ti<next.st) {
						check = 1;
						break;	
					}
					
					prev = next;
				}
				
				pq.addAll(sup);
				sup.clear();


			}
			
			if(check == 0) {
				System.out.println("NO");
			}else if (check==1) {
				System.out.println("YES");
			}
			
		}
	}
	static class worker{
		int ht;
		int st;
		int end;
		public worker(int ht, int st, int end) {
			super();
			this.ht = ht;
			this.st = st;
			this.end = end;
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
