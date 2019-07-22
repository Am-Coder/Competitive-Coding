package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17divisor {
	public static void main(String[] args) {
	    int MOD=1000000007;

		MyScanner s = new MyScanner();
		int a = s.nextInt();
		for(int i=0; i<a; i++) {
			int b = s.nextInt();
			long sum=0;
			long num = 1;
			for(int j=0; j<b; j++) {
				
				num = num%MOD*s.nextInt()%MOD;
			}
//			System.out.println(num);
			for(int k=1; k<=Math.sqrt(num); k++) {
				if (num % k == 0) {
//					System.out.println(k);
//					sum = sum%MOD+sumdiv(k)%MOD;
					if( num/k == k) {
						
						sum = sum%MOD + sumdiv(k)%MOD;
						
					}else {
						
						sum = sum%MOD + sumdiv(k)%MOD;
						sum = sum%MOD + sumdiv(num/k)%MOD;

					}
				}
			}
			System.out.println(sum%MOD);
		}
	}
	
	
	static long sumdiv(long n) 
	{ 
		long sum = 0;
	    // Note that this loop runs till square root 
	    for (int i=1; i<=Math.sqrt(n); i++) 
	    { 
	        if (n%i == 0) 
	        { 
	            // If divisors are equal, print only one 
	            if (n/i == i) {
//	                System.out.printf("%d ", i); 
	                sum += i;
	            }
	            else // Otherwise print both 
	            {
//	                System.out.printf("%d %d ", i, n/i);
	                sum += i;
	                sum += n/i;
	            }
	        } 
	    }
	    return sum;
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
