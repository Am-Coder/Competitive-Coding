package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;



public class HelpMidoriya {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		HashMap<Integer,Integer> hmap = new HashMap<>();
		HashMap<Integer,Integer> cmap = new HashMap<>();
		HashMap<Integer,Integer> bmap = new HashMap<>();
		int[] arr = new int[n];
		int[] xor = new int[n];
		xor[0] = 0;
		int sum = 0;
		for(int i=0; i<n; i++) {
			int d = s.nextInt();
			arr[i] = d ;
			sum = sum^d;
			xor[i] = sum ;
			
			
		}	
		int max = 0;		
		for(int i=0; i<n; i++) {
			if (hmap.containsKey(xor[i])){
				hmap.replace(xor[i], i );
				cmap.replace(xor[i], cmap.get(xor[i])+1);
			}else {
				hmap.put(xor[i],i);
				cmap.put(xor[i], 1);
				bmap.put(xor[i], i);
			}
		}
		Set<Integer> set = hmap.keySet();
		for(Integer i: set ) {
			if(hmap.get(i) > max && i==0)
				max = hmap.get(i)+1;
			else if(hmap.get(i)-bmap.get(i) > max && cmap.get(i) > 1 ) {
				max = hmap.get(i) - bmap.get(i);
			}
		}

		System.out.println(max);
	}		
//	static long subarrayXor(int arr[], int n, int m) 
//	{ 
//	    long ans = 0; // Initialize answer to be returned 
//	  
//	    // Create a prefix xor-sum array such that 
//	    // xorArr[i] has value equal to XOR 
//	    // of all elements in arr[0 ..... i] 
//	    int[] xorArr = new int[n]; 
//	  
//	    // Create map that stores number of prefix array 
//	    // elements corresponding to a XOR value 
//	    HashMap<Integer, Integer> mp = new HashMap<>(); 
//	  
//	    // Initialize first element of prefix array 
//	    xorArr[0] = arr[0]; 
//	  
//	    // Computing the prefix array. 
//	    for (int i = 1; i < n; i++) 
//	        xorArr[i] = xorArr[i - 1] ^ arr[i]; 
//	  
//	    // Calculate the answer 
//	    for (int i = 0; i < n; i++) { 
//	        // Find XOR of current prefix with m. 
//	        int tmp = m ^ xorArr[i]; 
//	  
//	        // If above XOR exists in map, then there 
//	        // is another previous prefix with same 
//	        // XOR, i.e., there is a subarray ending 
//	        // at i with XOR equal to m. 
//	        ans = ans + ((long )mp.getOrDefault(tmp,0)); 
//	  
//	        // If this subarray has XOR equal to m itself. 
//	        if (xorArr[i] == m) 
//	            ans++; 
//	  
//	        // Add the XOR of this subarray to the map
//	        mp.replace(xorArr[i], mp.getOrDefault(xorArr[i],0)+1);
////	        mp[xorArr[i]]++; 
//	    } 
//	  
//	    // Return total count of subarrays having XOR of 
//	    // elements as given value m 
//	    return ans; 
//	}  

	static int mynum(int a) {
		int c = a%4;
		if(c == 0)
			return a;
		else if( c == 1)
			return 1;
		else if(c == 3)
			return 0;
		else 
			return a+1;
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
