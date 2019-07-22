package com.comp.hearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Sortingq2 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
    	String[] str = s.nextLine().split(" ");
    	int a = Integer.parseInt(str[0]);
    	int b = Integer.parseInt(str[1]);
    	List<Integer> arr = new ArrayList<>();
    	String[] str1 = s.nextLine().split(" ");
    	for(int i=0; i<a; i++) {
    		int c = Integer.parseInt(str1[i]);
    		arr.add(c);
    	}
    	s.close();
    	for(int i=0; i<arr.size(); i++) {
    		for(int j=0; j<arr.size()-i-1; j++) {
    			int c = arr.get(j);
    			int d = arr.get(j+1);
    			if(c%b>d%b) {
    				
    				arr.set(j+1, c);
    				arr.set(j,d);
    			}
    		}
    	}
    	for(int i=0; i<arr.size(); i++) {
    		System.out.print(arr.get(i)+" ");
    	}
    }
}
