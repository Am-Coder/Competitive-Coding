package com.comp.dp;
//Time Complexity: O(n^3)
//Auxiliary Space: O(n^2)
public class MatrixChainMultiplication {
	
	static int[][] s;
	static char a = 'A';
	static void printOptimal(int[][] s, int i, int j) {

		if( i==j ) {
			System.out.print(a++ + " ");
		}else {
		System.out.print(" ( ");
		printOptimal(s,i,s[i][j]);
		printOptimal(s,s[i][j] + 1, j);
		System.out.print(" ) ");
		}
	}
	
	/* m[i,j] = Minimum number of scalar  
    multiplications needed to compute the 
    matrix A[i]A[i+1]...A[j] = A[i..j] where 
    dimension of A[i] is p[i-1] x p[i] */
	static int MM( int[] p, int n ) {
		int[][] m = new int[n+1][n+1];
		s = new int[n][n];
		
		
		//for a single matrix
		for( int i=1; i<=n; i++ ) {
			m[i][i] = 0;
		}
		
		
		//Considering l matrix at a time
		for( int l=2; l<n; l++ ) {
			
			for( int i=1; i<n-l+1; i++ ) {
				int j = i+l-1;
				if( j==n )
					continue;
				m[i][j] = Integer.MAX_VALUE;
				
				
				for( int k=i; k<=j-1; k++ ) {
					int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if( q<m[i][j] ) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
				
			}	
			
		}
		return m[1][n-1];
	}
	
    public static void main(String args[]) 
    { 
        int arr[] = new int[] {1, 2, 3, 4}; 
        int size = arr.length; 
  
        System.out.println("Minimum number of multiplications is "+ 
                           MM(arr, size)); 

        printOptimal(s,1,size-1);
    } 
}
