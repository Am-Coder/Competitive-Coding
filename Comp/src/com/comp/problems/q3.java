package com.comp.problems;

import java.util.Scanner;

public class q3 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for(int j=0; j<n; j++){
            	int k = (a+(int)(Math.pow(2,j))*b);
//            	System.out.println(a+Math.pow(2,j)*b);
                System.out.printf("%d ",k);
            }
            System.out.printf("\n");
        }
        in.close();
	}
}
