package com.comp.hearth;

import java.util.Scanner;

public class stackq5 {
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
        s.close();
        // ArrayList<Integer> res = new ArrayList<>();
        int a,most,least,d;
        for(int i=0 ; i<si ;i++){
            a = Integer.parseInt(str[i]);
            most = -1;
            least = -1;
            for(int j=0; j<i ;j++){
                d = Integer.parseInt(str[j]);
                if(d>a) {
                    most = j+1;
//                    System.out.print("Enter\n");
                }

            }
            for(int j=si-1; j>i ; j--) {
                d = Integer.parseInt(str[j]);
            	if(a<d) {
            		least = j+1;
            	}
            }
//            System.out.println(most + leas" =----= "+ least);
            System.out.print(most+least+" "); 
        }
        
    }
}
