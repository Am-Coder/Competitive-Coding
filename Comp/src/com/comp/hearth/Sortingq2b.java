package com.comp.hearth;

import java.util.Scanner;

public class Sortingq2b {
    public static void main(String args[] ) throws Exception {
    	  
    	
        // Write your code here
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.next());
        String[] arr = new String[a];
        for(int i=0; i < a; i++ ){
        	arr[i] = s.next();
        }
        s.close();
        int count;
        String con;
        for(int i=0; i<arr.length; i++) {
        		con = arr[i];
        		count = 0;
        		for(int j=0; j<i; j++) {
        			if(con.compareTo(arr[j])>0) {
        			 	count++;
        			}	
        		}
        		System.out.println(count);
        }

        
    }	
}
