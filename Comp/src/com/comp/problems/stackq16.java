package com.comp.problems;

import java.util.Scanner;
import java.util.Stack;

public class stackq16 {
	
	
	public static void main(String []argh)
	{			
		Scanner sc = new Scanner(System.in);
				
        while (sc.hasNext()) {
            String input=sc.next();
                
            Stack<Character> st=new Stack<>();
            st.push('-');
            for(int i=0; i<input.length(); i++) {
                char seen = input.charAt(i);
                if(seen=='(' || seen=='[' || seen=='{') {
                    st.push(seen);
                }
                
                if(seen==')' && st.peek()=='(')
                    st.pop();
                else if(seen=='}' && st.peek()=='{') 
                    st.pop();
                else if(seen==']' && st.peek()=='[')
                    st.pop();
                else if(st.peek()=='-' &&(seen==']'||seen=='}'||seen==')'))
                    st.push(seen);
            }
            if(st.peek()=='-')
                System.out.println("true");
            else
                System.out.println("false");
        }
		
	}
	
	
}	
		
	
	
	