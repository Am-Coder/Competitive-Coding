package com.comp.hearth;

import java.util.Scanner;
import java.util.Stack;

public class stackq5a {
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
        int si = Integer.parseInt(s.nextLine());
        String[] str = s.nextLine().split(" ");
        Stack<Integer> st = new Stack<>();
        s.close();      
        // ArrayList<Integer> res = new ArrayList<>();
        int a,most,least,d;
        
        for(int i=0 ; i<si ;i++){
            a = Integer.parseInt(str[i]);
            most = -1;  
            least = -1; 
            st.push(a);	
            			
            			
            System.out.print(most+least+" "); 
        }				
        				
    } 
}
