package com.comp.problems;

import java.util.Scanner;
/////////////////////////////////////////////SCANNER AND FORMATTING
public class q2 {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            if(x<10){
                System.out.printf("%-15s00%1d\n",s1,x);
                continue;
            }
            else if(x<100){
                System.out.printf("%-15s0%2d\n",s1,x);
                continue;
            }
                System.out.printf("%-15s%3d\n",s1,x);


        }
        System.out.println("================================");
	}

}
