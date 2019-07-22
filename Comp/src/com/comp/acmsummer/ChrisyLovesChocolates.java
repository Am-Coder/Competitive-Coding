package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ChrisyLovesChocolates {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int k = s.nextInt();
		ArrayList<Integer> sum = new ArrayList<>();
		sum.add(0,0);
		int sub = 0;
		int[] freq = new int[n+1];
		freq[0] = 1;
		String arr = s.nextLine();
// 		System.out.println(countSub(arr,k));
		for(int i=1; i<=n; i++) {
			if(arr.charAt(i-1)=='0') {
				sum.add(i, sum.get(i-1)) ;
				freq[sum.get(i)]+=1;
//				System.out.println(sum.get(i));
			}
			else {
//				sum[i] = sum[i-1]+1;
				sum.add(i, sum.get(i - 1) + 1);
				freq[sum.get(i)]+=1;

//				System.out.println(sum.get(i));

			}
		}
//		for(int i=0;i<freq.length;i++)
//			System.out.println(freq[i]);
 		for(int i=0; i<n+1; i++) {
 			if(	sum.get(i) >= k	) {
 				sub+=freq[sum.get(i) - k];
 			}
 				
 		}
		System.out.println(sub);
	}


	 static int countSub( String s, int K ) 
    { 
        int N = s.length(); 
        int res = 0; 
        int countOfOne = 0; 
        int []freq = new int[N+1]; 
      

        freq[0] = 1; 
      

        for (int i = 0; i < N; i++) { 
      
 
            countOfOne += (s.charAt(i) - '0'); 
      
 
            if (countOfOne >= K) { 
      
 
                res += freq[countOfOne - K]; 
            } 
      
            freq[countOfOne]++; 
        } 
          
        return res; 
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
