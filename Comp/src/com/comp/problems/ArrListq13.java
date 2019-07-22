package com.comp.problems;
							
import java.util.ArrayList;	
import java.util.Scanner;	
							
public class ArrListq13 {	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        ArrayList<ArrayList<Integer>> container = new ArrayList<ArrayList<Integer>>();
        					
        for(int i=0; i<n; i++) {
        	String[] arr = s.nextLine().split(" ");
        	
//        	System.out.println(arr.length);
        	int q = Integer.parseInt(arr[0]);
        	ArrayList<Integer> var = new ArrayList<Integer>();
        	for(int j=1; j<q+1; j++) {
        		var.add(Integer.parseInt(arr[j]));
        	}				
        	container.add(var);
        }				
//        System.out.println(container.get(0));
        n = Integer.parseInt(s.nextLine());
        int[] pos = new int[2];
        for(int i=0; i<n; i++) {
        	String[] arr = s.nextLine().split(" ");
        	pos[0] = Integer.parseInt(arr[0]);
        	pos[1] = Integer.parseInt(arr[1]);
        	
        	try {		
        		System.out.println(container.get(pos[0]-1).get(pos[1]-1));
        	}catch(Exception e) {
        		System.out.println("ERROR!");
        	}

        }
        s.close();
    }
}
