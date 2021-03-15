package com.comp.hearth;

import java.io.PrintWriter;
import java.util.Scanner;

public class nonrepeatingchar {
	
	public static void main(String[] args) {
		PrintWriter p = new PrintWriter(System.out);
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int[] carr = new int[256];
		
		for( int i=0; i<str.length(); i++ ) {
			carr[str.charAt(i)]++;
		}
		
		for( int i=0; i<str.length(); i++ ) {
			if( carr[str.charAt(i)] == 1) {
				p.println(str.charAt(i));
				break;
			}
		}
		p.close();
		
	}
}
