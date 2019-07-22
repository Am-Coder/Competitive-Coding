package com.comp.problems;

import java.util.*;
abstract class Book{
	protected String title;
	abstract void setTitle(String s);
	String getTitle(){
		return title;
	}
	
}

//Write MyBook class here
class MyBook extends Book   {
    void setTitle(String s){
        this.title = s;
    }
}
public class tett{
	
	public static void main(String []args){
		//Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		Book new_novel=new MyBook();
		new_novel.setTitle(title);
		System.out.println("The title is: "+new_novel.getTitle());
      	sc.close();
      	System.out.println(new_novel instanceof Book);
		
	}
}
