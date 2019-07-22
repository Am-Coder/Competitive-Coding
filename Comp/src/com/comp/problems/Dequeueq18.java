package com.comp.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Dequeueq18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new LinkedHashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max=0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);       
            if(i<m) {
            	deque.add(num);
            	continue;
            }
//            if(deque.size()>max) {
//            	max = set.size();
//            }
//            if(i<m) {
//            	set.add(num);
//            	deque.addAll(set);
//            	continue;
//            }
//            int a=deque.removeFirst();
//            set.add(num);
//            deque.addAll(set);
        }
    }
}
