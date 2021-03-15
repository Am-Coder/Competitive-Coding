package com.comp.hearth;

public class WaterFilling {
	static int max = 1000;
	public static float glassWater( float X, int i, int j ) {
				
		int si = (i*(i+1))/2;
		float[] arr = new float[si+5];
		arr[0] = X;
		int ind = 0;
		for( int r=1; r<=i && X > 0; r++ ) {
			for( int c=1; c<=r; c++,ind++ ) {
					
				X = arr[ind];
				arr[ind] = X >= 1.0f? 1:X ;
				X = X >= 1.0f ?X - 1.0f:0.0f ; 
				
				arr[ind+r] += X/2;
				arr[ind+r+1] += X/2;
			}
		}			
		
		return arr[(int)((i*(i-1))/2) + j - 1];
		
	}
	
	public static void main(String[] args) 
	{ 
	    int i = 2, j = 2; 
	    float X = 2.0f; // Total amount of water 
	    System.out.println("Amount of water in jth " + 
	                         "glass of ith row is: " +  
	                         glassWater(X, i, j)); 
	} 
}
