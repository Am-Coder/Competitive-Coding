package com.comp.problems;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapq14 {
	public static void main(String []argh)
	{		
		Scanner in = new Scanner(System.in);
		HashMap<String,Integer> hmap = new HashMap<>();
		int n=in.nextInt();
			
		in.nextLine();
		for(int i=0;i<n;i++)
		{	
			String name=in.nextLine();
			int phone=in.nextInt();
			hmap.put(name, phone);
			in.nextLine();
		}	
		while(in.hasNext())
		{	
			String s=in.nextLine();
			Integer contact=hmap.get(s);
			if(contact!=null) {
				System.out.println(s+"="+contact);	
			}else {
				System.out.println("Not Found");
			}
		}	
	}		
}
