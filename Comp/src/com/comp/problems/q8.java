package com.comp.problems;

import java.util.Scanner;

public class q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int len = A.length();
        int flag=1;
        /* Enter your code here. Print output to STDOUT. */
        for(int i=0; i<len/2; i++){
            if(A.charAt(i)!=A.charAt(len - i -1)){
                flag=0;
            }

        }
        if(flag==0){
            System.out.println("No");
        }else{
            System.out.println("Yes");

        }
	}

}
