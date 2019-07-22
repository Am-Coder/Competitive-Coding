package com.comp.problems;

//import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexq10a {
		
		
	public static void main(String args[]) {
		String regex="(([01][0-9]{0,2})|(2[0-5]{0,2})|([0-9][0-9]{0,1})|(2[0-4][0-9]))";
		String reg=regex+"\\."+regex+"\\."+regex+"\\."+regex;
		System.out.println(reg);
		String check="249.249.249.249";
		Pattern pat = Pattern.compile(regex);
//		Matcher mat=pat.matcher(check);
		if(pat.matches(reg, check)) {
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
	}	
		
		
}		
		