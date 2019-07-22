package com.comp.hearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Check implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.compareTo(arg1);
	}
	
}

public class Sortingq2a {
	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        ArrayList<String> arr = new ArrayList<>();
        String st = str[0];
        int len = st.length();
        for(int i=0 ; i < len ; i++){
        	System.out.println(st.substring(i));
            arr.add(st.substring(i));
        }
        Collections.sort(arr);
        s.close();
        System.out.println(arr.get(Integer.parseInt(str[1])-1));
	}
}
