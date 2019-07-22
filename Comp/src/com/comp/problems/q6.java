package com.comp.problems;

import java.util.Scanner;

public class q6 {
	
    public static Scanner sc = new Scanner(System.in);
	public static int B = sc.nextInt();
	public static int H = sc.nextInt();
//	public static boolean flag = B>0&&H>0?true:false);
	public static boolean flag = B>0&&H>0?true:false;
	
	static {
		if(flag==false) {
//			 throw new Exception(" ");
		}
	}
	

	public static void main(String[] args) {
			if(flag){
				int area=B*H;
				System.out.print(area);
			}
			
		}
}
