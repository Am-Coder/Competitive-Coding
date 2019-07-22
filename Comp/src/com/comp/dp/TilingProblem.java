package com.comp.dp;

import java.util.Scanner;

//Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 tiles.
//A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile


public class TilingProblem {
	
	//recursive approach but this is just fibonaaci sequence
	static int tiles(int n) {
			if(n<=1) {
				return 1;
			}
		return tiles(n - 1) + tiles(n - 2);
	}	
	
	
	//Fibonaci
	static int fibo(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<=n; i++) {
			arr[i] =arr[i - 1] + arr[ i -2]; 
		}
		return arr[n];
	}
		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println(fibo(a+1));
		System.out.println(tiles(a));
		s.close();
		
	}	
}		
