package com.comp.hearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class stackq1 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int a = Integer.parseInt(s.nextLine());
		String[] coins = s.nextLine().split(" ");
		List<Integer> harry = new ArrayList<>();
		Stack<Integer> monk = new Stack<>();
		for(int i=0; i<a ; i++) {
			harry.add(Integer.parseInt(coins[i]));
		}
		String[] str = s.nextLine().split(" ");
		int c,d,val,add;
		c = Integer.parseInt(str[0]);
		d = Integer.parseInt(str[1]);
		val = 0;
		String task;
		for(int i=0; i<c ;i++) {
			task = s.nextLine();
			if(task.equals("Harry")) {
				add = harry.remove(0);
				monk.push(add);
				val+=add;
			}else {
				add = monk.pop();
				val-=add;
			}
			if(val==d) {
				break;
			}
		}
		s.close();
		System.out.println(monk.size());
	}
}
