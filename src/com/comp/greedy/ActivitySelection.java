package com.comp.greedy;

public class ActivitySelection {
	
	// Prints a maximum set of activities that can be done by a single 
    // person, one at a time. 
    //  n   -->  Total number of activities 
    //  s[] -->  An array that contains start time of all activities 
    //  f[] -->  An array that contains finish time of all activities 
	
	//Activities are assumed sorted based on their finish time
	public static void actSelect(int[] s, int[] f, int n ) {
		
		System.out.println("The activity sequence is -");
		int j=0;
		
		//First activity always gets selected
		System.out.print(0+" ");
		
		
		for( int i=1; i<n; i++ ) {
	         // If this activity has start time greater than or 
	         // equal to the finish time of previously selected 
	         // activity, then select it 
			if( f[j] < s[i] ) {
				System.out.print(i+" ");
				j=i;
			}
		}
		
	}
	
	public static void main(String[] args) { 
	    int s[] =  {1, 3, 0, 5, 8, 5}; 
	    int f[] =  {2, 4, 6, 7, 9, 9}; 
	    int n = s.length; 
	         
	    actSelect(s, f, n); 
	    } 
}
