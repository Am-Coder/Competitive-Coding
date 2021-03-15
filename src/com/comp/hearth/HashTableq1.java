package com.comp.hearth;

import java.util.*;

public class HashTableq1 {
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
        int a= Integer.parseInt(s.nextLine());
        HashMap<String,String> hmap = new HashMap<>();
        for(int i=0; i<a; i++) {
        	String[] data = s.nextLine().split(" ");
        	hmap.put(data[0], data[1]);
        }
        a = Integer.parseInt(s.nextLine());
        String[] keys = new String[a];
        for(int i = 0 ; i < a ; i++) {
        	keys[i] = s.next(); 
        }
        s.close();
//        keys[i].join(" ",arr);
        for(int i=0; i<a; i++) {
        	System.out.println(hmap.get(keys[i]));
        }
        
    }
}
