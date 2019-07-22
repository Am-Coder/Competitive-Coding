package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;



public class ChrissyLovesPhysics {
	
    static long mergeSort(int arr[], int array_size) 
    { 
        int temp[] = new int[array_size]; 
        return _mergeSort(arr, temp, 0, array_size - 1); 
    } 
  

    static long _mergeSort(int arr[], int temp[], int left, int right) 
    { 
        int mid; 
        long inv_count = 0;
        if (right > left) { 

            mid = (right + left) / 2; 
  

            inv_count = _mergeSort(arr, temp, left, mid); 
            inv_count += _mergeSort(arr, temp, mid + 1, right); 
  
            inv_count += merge(arr, temp, left, mid + 1, right); 
        } 
        return inv_count; 
    } 
  

    static long merge(int arr[], int temp[], int left, int mid, int right) 
    { 
        int i, j, k; 
        long inv_count = 0; 
  
        i = left; 
        j = mid;
        k = left; 
        while ((i <= mid - 1) && (j <= right)) { 
            if (arr[i] <= arr[j]) { 
                temp[k++] = arr[i++]; 
            } 
            else { 
                temp[k++] = arr[j++]; 
  
                inv_count = inv_count + (long)(mid - i); 
            } 
        } 
  

        while (i <= mid - 1) 
            temp[k++] = arr[i++]; 
  

        while (j <= right) 
            temp[k++] = arr[j++]; 
  
        for (i = left; i <= right; i++) 
            arr[i] = temp[i]; 
  
        return inv_count; 
    } 
	public static void main(String[] args) {
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int num = s.nextInt();
            arr[i] = num;
        }
        
        System.out.println(mergeSort(arr, arr.length));

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
