package com.comp.problems;

import java.util.Scanner;
import java.math.BigDecimal;

public class BigDecq11 {
	   public static void main(String []args){
	        //Input
	        Scanner sc= new Scanner(System.in);
	        int n=sc.nextInt();
	        String []s=new String[n+2];
	        for(int i=0;i<n;i++){
	            s[i]=sc.next();
	        }
	      	sc.close();
	      	System.out.println(s);
	        //Write your code here
	      	for(int i=0; i < n; i++) {

	      		for(int j=0; j<n-1-i;j++) {
			      	System.out.println(s[j]);
			      	System.out.println(s[j+1]);
	      			BigDecimal a = new BigDecimal(s[j]);
	      			BigDecimal b = new BigDecimal(s[j+1]);
      				if(b.compareTo(a)>0) {
      					String temp=s[j+1];
      					s[j+1]=s[j];
      					s[j]=temp;
      				}
	      		}
	      	}
	        //Output
	        for(int i=0;i<n;i++)
	        {
	            System.out.println(s[i]);
	        }
	    }
}
