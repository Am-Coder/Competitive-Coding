package com.comp.hearth;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class IntersectionOfLinkedList {
	public static void getNew(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> l3 = new LinkedList<>();
		Iterator<Integer> i1 = l1.iterator();
		Iterator<Integer> i2 = l2.iterator();
		int val1 = i1.next();
		int val2 = i2.next();
		while( i1.hasNext() && i2.hasNext()) {
			System.out.println(val1 + " " + val2);

			if( val1 == val2 ) {
				l3.add(val1);
				val1 = i1.next();
				val2 = i2.next();
			}else if( val1 < val2 ){
				val1 = i1.next();
			}else {
				val2 = i2.next();
			}
			
		}
		
		if( val1 == val2 ) {
			l3.add(val1);
		}
		PrintWriter p = new PrintWriter(System.out);
		for( int i=0; i<l3.size(); i++ ) {
			p.print(l3.get(i) + " ");
		}
		p.close();
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(1,2,3,4,6));
		LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(2,4,6,8));
		getNew(l1,l2);
	}
}
