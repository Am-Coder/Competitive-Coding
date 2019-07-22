package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class OddEvenSub {
    public static void main(String args[] ) throws Exception {
        MyScanner s = new MyScanner();
        int a = s.nextInt(), b ,e = 0 , o = 0;
        int[] arr = new int[a] ;
        for( int i=0; i<a; i++ ){
            
            b = s.nextInt();  
            if( b%2 == 0) {
                e++ ;
                arr[i] = -1 ;

            }else{
                o++ ;
                arr[i] = 1;
            }
            
            
        }
        
        long sum = 0, j = 1, count = 0;
        for( int i=0; i<a; i++){
            
            sum += arr[i];
            
            if(sum == 0){
                count += j;
                j++;
            }
            
        }
        
        
        System.out.println(findSubArrays(arr, a));
        
        
    }       
    static long findSubArrays(int[] arr, int n) 
    { 
            // create an empty map  
            HashMap<Integer,ArrayList<Integer>> map = new HashMap<>(); 
  
            // create an empty vector of pairs to store  
            // subarray starting and ending index  
//            ArrayList<Pair> out = new ArrayList<>(); 
            long count = 0;
            // Maintains sum of elements so far 
            int sum = 0; 
  
            for (int i = 0; i < n; i++)  
            { 
                // add current element to sum  
                sum += arr[i]; 
  
                // if sum is 0, we found a subarray starting  
                // from index 0 and ending at index i  
                if (sum == 0)
                	count++;
//                    out.add(new Pair(0, i)); 
                ArrayList<Integer> al = new ArrayList<>(); 
                  
                // If sum already exists in the map there exists  
                // at-least one subarray ending at index i with  
                // 0 sum  
                if (map.containsKey(sum)) 
                { 
                    // map[sum] stores starting index of all subarrays 
                    al = map.get(sum); 
                    for (int it = 0; it < al.size(); it++) 
                    { 
                    	count++;
//                            out.add(new Pair(al.get(it) + 1, i));  
                    } 
                } 
                al.add(i); 
                map.put(sum, al); 
            } 
            return count; 
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
