package com.comp.problems;

import java.util.*;

public class NdArrayq11 {
	   private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int[][] arr = new int[6][6];

	        for (int i = 0; i < 6; i++) {
	            String[] arrRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 6; j++) {
	                int arrItem = Integer.parseInt(arrRowItems[j]);
	                arr[i][j] = arrItem;
	            }
	        }

	        scanner.close();
	        int[] sum = new int[16];
	        int k = 0;
	        for(int i=0; i<4; i++){
	            for(int j=0; j<4; j++){
	                sum[k] = arr[i][j] + arr[i][j+1] + arr[i][j+2]+arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2] + arr[i+1][j+1];
	                k+=1;
	            }
	        }
	        Arrays.sort(sum);
	        ArrayList<Integer> arra = new ArrayList<Integer>();
	        System.out.println(sum[sum.length-1]);
	    }
}
