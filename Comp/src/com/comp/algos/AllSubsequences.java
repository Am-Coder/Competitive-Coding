package com.comp.algos;

public class AllSubsequences {
	
	static StringBuilder s = new StringBuilder();
	
	//O(2^n) as there are 2^n (including empty string) subsequences
	public static void subseq(String str,StringBuilder sb, int st, int end) {
		
		if(st == end+1)
			return;
		
		System.out.println( sb.toString() );
		for( int i=st; i<end; i++) {
			sb.append(str.charAt(i));
			
			subseq(str,sb,i+1,end);
			sb.deleteCharAt( sb.length() -1 );
		}
		
		return;
		
	}
	
	public static void main(String[] args) {
		String str = "cab";
		
		subseq(str,s,0,str.length());
	}

}
