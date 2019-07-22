package com.comp.problems;

public class q7 {
	
	public static void main(String args[]) {
		System.out.println(getSmallestAndLargest("Heroku",4));
		System.out.println("erok".compareTo("Hero"));
	}
	
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
     
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i=0; i<=s.length()-k; i++) {
        	String comp = s.substring(i,i+k);
        	System.out.println(comp);
        	if(comp.compareTo(largest)>0) {
        		largest = comp;
        	}
        	else if(comp.compareTo(smallest)<0) {
        		smallest = comp;
        	}
        }
        
        return smallest + "\n" + largest;
    }
}
