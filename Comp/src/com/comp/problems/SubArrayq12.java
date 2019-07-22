package com.comp.problems;

import java.util.Scanner;

public class SubArrayq12 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        int[] num = new int[n];
        String[] arr = s.nextLine().split(" ");
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(arr[i]);
        }

        int count=0;
        for(int i=0; i<num.length; i++){
            for(int j=0; j<num.length; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                    sum=sum+num[k];
                }
                if(sum<0){
                    count+=1;
                }
            }
        }
        System.out.println(count);
    }
}
