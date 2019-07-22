package com.comp.hearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queueq4 {
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
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> buff = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        str = s.nextLine().split(" ");
//        System.out.println(str[0]);
        int ele;
        for(int i=0; i<a ; i++){
            ele = Integer.parseInt(str[i]);
            arr.add(ele);
            que.add(ele);
        }
        s.close();
        while(que.size()>=b){
            int max=0;
            buff.clear();
            for(int i=0; i<b; i++){
                ele = que.poll();
                buff.add(ele);
//                System.out.println(ele);
                if(max<ele)
                    max=ele;

            }
//            System.out.println("Max- "+max);
            buff.remove(buff.indexOf(max));
//            System.out.println("Buff- "+buff.size()+"---------");

            for(int k=0; k<buff.size() ; k++) {
            	ele = buff.get(k)-1;
//            	System.out.println(ele);
            	if(ele<0) {
            		que.add(0);
            		continue;
            	}
                que.add(ele);

            }
//            System.out.println(que.size() +"-" +que.peek());
            System.out.print(arr.indexOf(max)+1+" ");
        }
        a = que.size();
        buff.clear();
        for(int i=0; i<a ; i++) {
        	buff.add(que.poll());
        }
        Collections.sort(buff);
        for (Integer integer : buff) {
            System.out.print(arr.indexOf(integer)+1+" ");

		}
    }
}
