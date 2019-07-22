package com.comp.hearth;

import java.util.Scanner;

class node{
	int info;
	node left;
	node right;
	public node(int info) {
		super();
		this.info = info;
	}
	
}

class bintree{
	node root = new node(1);
		
	public bintree() {
		super();
		this.root = null;
	}	
		
	public node getParent(node r, int d) {
		
		node tmp = r;
		if(tmp == null) {
			return null;
		}
		else if( tmp.info == d ) {
			return tmp;
		}
		
		node a = getParent(tmp.left, d);
		node b = getParent(tmp.right, d);
		if(a == null && b == null)
			return null;
		
		return a == null? b : a;
	}	
	
	public void insert(int p, int d, char c) {
		
		node n = getParent(root, p);
		if(c == 'L') {
			n.left = new node(d);
		}else {
			n.right = new node(d);
		}
	}
	
    node mirror(node node) 
    { 
        if (node == null) 
            return node; 
        
        /* do the subtrees */
        node left = mirror(node.left); 
        node right = mirror(node.right); 
  
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left; 
  
        return node; 
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
