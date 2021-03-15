package com.comp.dp;

import java.io.PrintWriter;
import java.util.HashMap;

public class choiceOfArea {
	
	static class are{
		int a;
		int b;
		
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		public are(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
		
	}
	
	//Top Down Approach
	static int areas(int A, int B,int p, are x, are y, are z, HashMap<are, Integer> mem) {
		if(A < 0 || B < 0)
			return 0;
		int temp = 0;
		are cur = new are(A,B);
		if(mem.containsKey(cur)) {
			return mem.get(cur);
		}
		if( p == 1) {
			temp = 1 + Math.max(areas(A + y.a, B + y.b, 2, x ,y, z, mem), areas(A + z.a, B + z.b, 3, x ,y, z, mem));
		}
		else if( p == 2) {
			temp = 1 + Math.max(areas(A + x.a, B + x.b, 1, x ,y, z, mem), areas(A + z.a, B + z.b, 3, x ,y, z, mem));
		}
		else if( p == 3) {
			temp = 1 + Math.max(areas(A + y.a, B + y.b, 1, x ,y, z, mem), areas(A + z.a, B + z.b, 2, x ,y, z, mem));
		}
		mem.put(cur, temp);
		return temp;
	}	
	
	static int getsol(int A, int B, are x, are y, are z) {
		
		if(A<= 0 || B <= 0) {
			return 0;
		}
		HashMap<are,Integer> mem = new HashMap<>();
		return Math.max(areas(A,B,1,x,y,z,mem),Math.max(areas(A,B,2,x,y,z,mem), areas(A,B,3,x,y,z,mem) ));
	}
	
	public static void main(String[] args) {
	    are X = new are(3, 2); 
	    are Y = new are(-5, -10); 
	    are Z = new are(-20, 5); 
	  
	    int A = 20; 
	    int B = 8; 
	    PrintWriter p = new PrintWriter(System.out);
	    p.println(getsol(A, B, X, Y, Z));
	    p.close();
	    
	}
}		
