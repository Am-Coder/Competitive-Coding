package com.comp.hearth;

import java.util.HashMap;

public class LongestSubstring {
				
	public static int maxi( char[] arr ) {
		int n = arr.length ;
		int maxsum = 0;
		int maxlen = 0;
		HashMap<Integer,Integer> hmap = new HashMap<>();
		for( int i=0; i<n; i++ ) {
				
			if( arr[i] == '1' ) {
				
				maxsum += 1 ;
				
			}else {
				
				maxsum -= 1 ;
				
			}	
			
			if( maxsum>0 ) {
				maxlen = i+1;
			}else {
				if(hmap.containsKey(maxsum-1)) {
					maxlen = Math.max(maxlen, i-hmap.get(maxsum-1) );
				}
			}	
			
			if(!hmap.containsKey(maxsum)) {
				hmap.put( maxsum, i);
			}
		}
		return maxlen;
		
	}			
	
	public static void main(String[] args) {
		System.out.println(maxi("1010".toCharArray()));
	}
				
}				
