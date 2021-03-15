package com.comp.algos;


import java.util.Scanner;

class nodey{
	int info;
	nodey left;
	nodey right;
	public nodey(int info) {
		super();
		this.info = info;
	}
	
}

class bintree{
	nodey root = new nodey(1);
		
	public bintree() {
		super();
		this.root = null;
	}	
		
	public nodey getParent(nodey r, int d) {
		
		nodey tmp = r;
		if(tmp == null) {
			return null;
		}
		else if( tmp.info == d ) {
			return tmp;
		}
		
		nodey a = getParent(tmp.left, d);
		nodey b = getParent(tmp.right, d);
		if(a == null && b == null)
			return null;
		
		return a == null? b : a;
	}	
	
	public void insert(int p, int d, char c) {
		
		nodey n = getParent(root, p);
		if(c == 'L') {
			n.left = new nodey(d);
		}else {
			n.right = new nodey(d);
		}
	}
	
    nodey mirror(nodey nodey) 
    { 
        if (nodey == null) 
            return nodey; 
        
        /* do the subtrees */
        nodey left = mirror(nodey.left); 
        nodey right = mirror(nodey.right); 
  
        /* swap the left and right pointers */
        nodey.left = right; 
        nodey.right = left; 
  
        return nodey; 
    } 
}		

public class MirrorImage {
		
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int q = s.nextInt();
		bintree bt = new bintree();
		for(int i=0; i<n; i++) {
			int p = s.nextInt();
			int c = s.nextInt();
			char ch = s.next().charAt(0);
			bt.insert(p, c, ch);
		}
		
	}
	
}
