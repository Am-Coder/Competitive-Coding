package com.comp.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer; 
public class PrateekAndTheories {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        
        int len = str.length();
        int count = 0;
        int[] arr = new int[len];
        for(int i=len - 1; i>=0; i--){
        	Character ch = str.charAt(i);
            int val = Integer.parseInt(ch.toString());
                        
            if(val%2 == 0)
                count ++;
            arr[i] = count;
        }
        s.close();
        for(int i=0; i<len; i++){
            System.out.print(arr[i] + " ");
        }
    }           
                
//    static int ans( HashMap< Integer, Integer > hmap, int min, int max ){
//            
//            Set<Integer> set = hmap.keySet();
//            int ans = 0;
//            for(int i=min; i<= max; i++){
//                
//            	int count = 0;
//                for(int key: set) {
//                	
//                	if( i>=key && i<=hmap.get(key)) {
//                		count++;
//                	}
//                	
//                }
//                
//                ans = count>ans?count:ans;
//            }
//            return ans;
//                
//    }           
    static int findMaxGuests(int arrl[], int exit[], int n)     
	{    
		// Sort arrival and exit arrays 
		Arrays.sort(arrl); 
		Arrays.sort(exit); 
		
		// guests_in indicates number of guests at a time 
		int guests_in = 1, max_guests = 1; 
		int i = 1, j = 0; 
		
		// Similar to merge in merge sort to process 
		// all events in sorted order 
		while (i < n && j < n) 
		{ 
			// If next event in sorted order is arrival, 
			// increment count of guests 
			if (arrl[i] <= exit[j]) 
			{ 
				guests_in++; 
				
				// Update max_guests if needed 
				if (guests_in > max_guests) 
				{ 
					max_guests = guests_in; 
				} 
				i++; //increment index of arrival array 
			} 
			else // If event is exit, decrement count 
			{ // of guests. 
				guests_in--; 
				j++; 
			} 
		} 
		

		return max_guests;
		
	} 
    static int ans1(int[] arr1, int[] arr2, int n){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 1, j = 0;
        int count = 1; 
        int max = 1;
        while( i <n || j < n ){
            
            if( i<n && arr1[i] < arr2[j] ){
                count ++;
//                arr1[i] = Integer.MAX_VALUE;
//                if(i < n-1)
                max = count>max?count:max;

                	i++;
            }else  {
                count --;
//                if( j < n - 1 )
            	j++;
            }
//            System.out.println(count);
        }   
        return max;
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
