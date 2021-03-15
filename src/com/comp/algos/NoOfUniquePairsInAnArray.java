package com.comp.algos;

import java.util.HashSet;

public class NoOfUniquePairsInAnArray {
	  // Function to return the number 
    // of unique pairs in the array 
    static int countUnique(int arr[], int n)  
    { 
  
        HashSet<Integer> s = new HashSet<>(); 
        for (int i = 0; i < n; i++) 
        { 
            s.add(arr[i]); 
        } 
        int count = (int) Math.pow(s.size(), 2); 
  
        return count; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int arr[] = {1, 2}; 
        int n = arr.length; 
        System.out.println(countUnique(arr, n)); 
    } 
}
