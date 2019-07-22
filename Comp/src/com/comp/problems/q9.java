package com.comp.problems;

import java.util.Arrays;

public class q9 {
	
	public static void main(String args[]) {
//		isAnagram("anagram","margana");
//		String str="      YES      leading spaces        are valid,    problemsetters are         evillllll";
		String str="a0.1.233.4b";
//		str=str.replaceFirst(regex, "");
		str=str.trim();
		System.out.println(str);
		String[] arrOfStr =str.split("[0-255]{3}\\.");
		System.out.println(arrOfStr.length);
//		String[] arrOfStr =str.split("[A-Za-z !,?._'@]+");
		for (String a : arrOfStr) 
            System.out.println(a); 
	}
	
	
    static boolean isAnagram(String a, String b) {
        // Complete the function
                boolean res=true;
        char[] c=a.toLowerCase().toCharArray();
        char[] d=b.toLowerCase().toCharArray();
        // Arrays.sort(c);
        // Arrays.sort(d);
                if(c.length!=d.length) {
            return false;
        }
        for(int i=0;i<c.length;i++){
            for(int j=i+1;j<c.length;j++){
                if(c[i]>c[j]){
                    char temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                }
                if(d[i]>d[j]) {
                    char temp1=d[i];
                    d[i]=d[j];
                    d[j]=temp1;
                }
            }
        }

        System.out.println(c);
        System.out.println(d);

        
        for(int i=0; i<c.length; i++) {
            if(c[i]!=d[i]) {
                res = false;
            }
        }
        return res;
    }
    
    public static void sorting(char[] c){
        for(int i=0;i<c.length;i++){
            for(int j=i+1;j<c.length;j++){
                if(c[i]>c[j]){
                    char temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                }
            }
        }
        System.out.println(c);
    }
}
