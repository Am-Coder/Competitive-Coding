package com.comp.hearth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AllVowels {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        Character[] arr = {'a','e','i','o','u'};
        HashSet<Character> hset1 = new HashSet<>(Arrays.asList(arr));
        HashSet<Character> hset = new HashSet<>();
        int n = s.nextInt(), c = 0;
        s.nextLine();
        String str = s.nextLine();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(hset1.contains(str.charAt(i))){
                hset.add(ch);
            }
            if(hset.size() == 5 ){
                c = 1;
                break;
            }
                    
        }
        
        System.out.println( c == 1?"YES":"NO");
    }
}
