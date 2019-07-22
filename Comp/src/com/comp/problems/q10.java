package com.comp.problems;

import java.util.Scanner;

public class q10 {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        s.nextLine();
        for(int i=0;i<n;i++){
            String str = s.nextLine();
            int len = str.length();
            int sum=0;
            for(int j=0;j<=len;j++){
                for(int k=len;k>=j;k--){
                    String sub = str.substring(j,k);
                    sum = sum + countVowels(sub.toLowerCase());
                }
            }
            System.out.println(sum);
            
        }
        s.close();

    }
    
    public static int countVowels(String string){
        int count=0;
//        char[] str = string.toCharArray();
        for(int j=0;j<string.length();j++){
        
            if(string.charAt(j)=='a'||string.charAt(j)=='e'||string.charAt(j)=='i'||string.charAt(j)=='o'||string.charAt(j)=='u')
                count++;
            
        }
        return count;
    }
}
