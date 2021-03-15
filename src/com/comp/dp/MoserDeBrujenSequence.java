package com.comp.dp;

public class MoserDeBrujenSequence {
	
	// Function to generate nth term  
	// of Moser-de Bruijn Sequence 
	public static int gen(int n) 
	{  
	      
	    // S(0) = 0 
	    if (n == 0) 
	        return 0; 
	      
	    // S(1) = 1 
	    else if (n == 1) 
	        return 1; 
	      
	    // S(2 * n) = 4 * S(n) 
	    else if (n % 2 == 0) 
	        return 4 * gen(n / 2); 
	      
	    // S(2 * n + 1) = 4 * S(n) + 1 
	    else if (n % 2 == 1) 
	        return 4 * gen(n / 2) + 1; 
	    return 0; 
	} 
	
	
	//Bottom Up Approach  ==> Obtained by adding distinct powers of number 4 ==> 0,1,4,5,6,16,17 _ _ _ _
	static int Moser(int n) {
		int[] st = new int[n+1];
		st[0] = 0;
		st[1] = 1;
		for(int i=2; i<=n; i++) {
			
			if((i&1) == 1) {
				st[i] = 4*st[i/2] + 1;
			}else {
				st[i] = 4*st[i/2];
			}
		}
		
		return st[n];
	}
	
	public static void main(String[] args) {
		
		System.out.println(Moser(5));
		
	}
}
