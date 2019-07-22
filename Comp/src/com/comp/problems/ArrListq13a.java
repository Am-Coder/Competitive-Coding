package com.comp.problems;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrListq13a {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        ArrayList<Integer> arr = new ArrayList<>();
        String[] inp = s.nextLine().split(" ");
        for(int i=0;i<n;i++){
            arr.add(Integer.parseInt(inp[i]));
        }
        n = Integer.parseInt(s.nextLine());
        for(int i=0;i<n;i++) {
        	String str=s.nextLine();
        	if(str.equals("Insert")) {
        		String[] ins = s.nextLine().split(" ");
        		arr.add(Integer.parseInt(ins[0]), Integer.parseInt(ins[1]));
        	}else {
        		int rem = Integer.parseInt(s.nextLine());
        		arr.remove(rem);
        	}
        }

        for(int i=0; i<arr.size();i++) {
        	System.out.print(arr.get(i)+" ");
        }
    }
}
