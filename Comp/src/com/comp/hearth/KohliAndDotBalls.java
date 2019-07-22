package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class KohliAndDotBalls {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,  0);
        int a = s.nextInt();
        int[] arr = new int[a];
        for(int i=1; i<=a; i++) {
            int num = s.nextInt() ;
    
            arr[i-1] = num;

        }
//        count = 0;
//        for(int i=1; i<=a; i++){
//        	int num = arr[i-1];
//            if(num == 0){
//                count++ ;
//              
//            }
//            
//            if(count>=1){
//                int ball = count*3;
////                System.out.println(ball +"-" + i);
//                if( hmap.getOrDefault(i+1, 0) == 0) {
//                	if(i >= ball && max < ball) {
//                		max = ball;
//                	}
//                }
//                else if( hmap.getOrDefault(i+1, 0) >= ball ){
//                    if(max < ball)
//                		max = ball;
//                    }
//                else {
//                	while()
//                }
//
//            }
//            
//        }
        System.out.println(maxLen(arr, arr.length));
    }
	
    static int maxLen(int arr[], int n)  
    { 
        // Creates an empty hashMap hM 
   
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 
  
        int sum = 0;     // Initialize sum of elements 
        int max_len = 0; // Initialize result 
        int ending_index = -1; 
        int start_index = 0; 
  
        for (int i = 0; i < n; i++)  
        { 
            arr[i] = (arr[i] == 0) ? -2 : 1; 
        } 
  
        // Traverse through the given array 
   
        for (int i = 0; i < n; i++)  
        { 
            // Add current element to sum 
   
            sum += arr[i]; 
  
            // To handle sum=0 at last index 
   
            if (sum == 0)
            { 
                max_len = i + 1; 
                ending_index = i; 
            } 
  
            // If this sum is seen before, then update max_len 
            // if required 
   
            if (hM.containsKey(sum + n))  
            { 
                if (max_len < i - hM.get(sum + n))  
                { 
                    max_len = i - hM.get(sum + n); 
                    ending_index = i; 
                } 
            }  
            else // Else put this sum in hash table 
                hM.put(sum + n, i); 
        } 
  
        for (int i = 0; i < n; i++)  
        { 
            arr[i] = (arr[i] == -1) ? 0 : 1; 
        } 
  
  
        return max_len; 
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
