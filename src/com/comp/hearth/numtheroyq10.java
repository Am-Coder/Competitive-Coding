package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numtheroyq10 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		int[] val = new int[a];
		double x1,x2,y1,y2;
		for(int i=0; i<a; i++) {
			int count=2;
			x1 = s.nextInt();
			y1 = s.nextInt();
			x2 = s.nextInt();
			y2 = s.nextInt();
			double cal ;
			if(x1==x2) {
				count += Math.abs(y2 - y1)-1;
			}else if(y1==y2){
				count+= Math.abs(x2-x1)-1;
			}else {
				cal = (y2-y1)/(x2-x1);
//				System.out.println(cal);
				if(Math.floor(cal)==Math.ceil(cal)) {
					count += Math.abs(x2 - x1)-1;
//					System.out.println("eq0");
				}else if(x1<x2){
//					System.out.println("eq1");

					for(double j=x1+1; j<x2; j++) {
						cal = ((y2-y1)*(j-x1))/(x2-x1);
						if(Math.floor(cal)==Math.ceil(cal))
							count++;
					}
				}else if(x1>x2){
//					System.out.println("eq2");

					for(double j=x2+1; j<x1; j++) {
						cal = ((y2-y1)*(j-x1))/(x2-x1);
						if(Math.floor(cal)==Math.ceil(cal))
							count++;
					}
				}
			}
			
			
			
			val[i] = count;
		}
		for(int i=0 ; i < val.length; i++) {
			System.out.println(i+1+"  =>  "+val[i]);
		}
//		int cases = s.nextInt();
//		for(int i = 0; i<cases ; i++) {
//			int pts = s.nextInt();
//			int ans = -1;
//			for(int j=0 ; j<val.length; j++) {
//				if(val[j]==-2 || val[j]>=pts) {
//					ans = j+1;
//					break;
//					}
//				}
//			System.out.println(ans);
//			}
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
