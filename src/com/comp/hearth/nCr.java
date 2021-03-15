package com.comp.hearth;

public class nCr {
	
	
	// 2D dp
	public static int NCR( int n, int r ) {
		
		int[][] arr = new int[n+1][r+1];	
		
		arr[0][0] = 1;
	
		for( int i=1; i<=n; i++ ) {
			arr[i][0] = 1;
		}
	
		for( int i=1; i<=n; i++ ) {
			
			for( int j=1; j<=Math.min(r,i); j++ ) {
				
				if( j == i ) {
					arr[i][j] = 1;
				}else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
		
		return arr[n][r];
	}
	
	//Space efficient approach using pascal triangle
    static int binomialCoeff(int n, int k) 
    { 
        int C[] = new int[k + 1]; 
         
        // nC0 is 1 
        C[0] = 1;   
       
        for (int i = 1; i <= n; i++) 
        { 
            // Compute next row of pascal  
            // triangle using the previous row 
            for (int j = Math.min(i, k); j > 0; j--) 
                C[j] = C[j] + C[j-1]; 
        } 
        return C[k]; 
    } 
}
