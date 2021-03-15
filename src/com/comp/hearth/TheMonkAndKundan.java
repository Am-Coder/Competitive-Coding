package com.comp.hearth;

import java.util.HashMap;
import java.util.Scanner;

public class TheMonkAndKundan {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        HashMap<Character,Integer> hmap = new HashMap<>();
        char ch1 = 'a';
        
        for(int i=0; i<26; i++){
            hmap.put((char)(ch1+i),i);    
        }
        hmap.put('1',26);
        hmap.put('2',27);
        hmap.put('3',28);
        hmap.put('4',29);
        hmap.put('5',30);
        hmap.put('6',31);
        hmap.put('7',32);
        hmap.put('8',33);
        hmap.put('9',34);
        hmap.put('0',35);
        int l=36;
        ch1 = 'A';
        for(int j=0; j<26; j++){
            hmap.put((char)(ch1 + j),l);
            l++;
        }

        int n = s.nextInt();
        s.nextLine();
        // ArrayList<String> arr = new ArrayList<>();
        
        for( int i = 0; i < n; i++ ){
            String str = s.nextLine();
            String[] arr = str.split(" ");
            int h = 0;
            for(String st: arr){
//            	System.out.println(st);
                for( int j=0; j<st.length(); j++ ){
                	int val = hmap.get(st.charAt(j));
//                	System.out.println(j+ "-" +val);
                    h += j + val;
                }
            }
            System.out.println(h*arr.length);
            h = 0;
            
            
        }
    }
}
