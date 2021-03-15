package com.comp.dp;

import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/scramble-string/
*/
public class ScrambledStrings {
	
	static class Solution {
		
		HashMap<String, Boolean> map = new HashMap<>();
		
		public boolean isScramble(String s1, String s2) {
			if (s1.length() != s2.length())
				return false;
			
			if (s1.equals(s2))
				return true;
			
			if (s1.length() == 0)
				return true;
			
			String key = s1 + " " + s2;
			if (map.containsKey(key)) {
				return map.get(key);
			}
			
			int n = s1.length();
			boolean flag = false;
			for (int i = 1; i < n; i++) {
				
				if (isScramble(s1.substring(0, i), s2.substring(0, i))
				        && isScramble(s1.substring(i, n), s2.substring(i, n))) {
					flag = true;
					break;
				} else if (isScramble(s1.substring(n - i, n), s2.substring(0, i))
				        && isScramble(s1.substring(0, n - i), s2.substring(i, n))) {
					flag = true;
					break;
				}
				
			}
			
			map.put(key, flag);
			return flag;
		}
	}
	
}
