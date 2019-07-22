package com.comp.acmsummer;

import java.util.HashMap;
import java.util.Scanner;

public class dedust2 {
    

    public static void main(String args[] ) throws Exception {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        HashMap<Integer,Integer> hmap1 = new HashMap<>();

//        int g = 1000;
//        int d1 = 0;
//        int d2 = 0;
        for(int i=0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
//            if(a == b){
//                hmap.put(0, hmap.getOrDefault(0, 0) + 1);
//            }
                hmap.put(a+b, hmap.getOrDefault(a+b, 0) + 1);
                hmap1.put(a-b, hmap1.getOrDefault(a-b, 0) + 1);
            
        }
        long sum = 0;
        for(Integer key: hmap.keySet()) {
        	int val = hmap.get(key);
        	sum += (val*(val - 1))/2;
        }
        
        for(Integer key: hmap1.keySet()) {
        	int val = hmap1.get(key);
        	sum += (val*(val - 1))/2;
        }
        s.close();
        System.out.println(sum);
    }
}
