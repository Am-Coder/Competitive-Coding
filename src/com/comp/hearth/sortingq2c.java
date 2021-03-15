package com.comp.hearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sortingq2c {
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
        // Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String[] coll = new String[a];
        for(int i=0; i<a ; i++) {
        	coll[i] = br.readLine();
        }
        br.close();
        int i=1;
        int ch1,ch2;
        StringBuffer[] buff = new StringBuffer[a];
        while(true) {
        	ch1=5*i;
        	ch2=5*i - 4;
        	
        	for(int j=0; j<a; j++) {
        		buff[j].append(coll[j].substring(ch2, ch1));
        	}
//        	for() {
//        		break;
//        	}
        	i++;
        }
    }
}
