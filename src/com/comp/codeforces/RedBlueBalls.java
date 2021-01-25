package com.comp.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class RedBlueBalls {
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int n = s.nextInt();
		char[] att = s.nextLine().toCharArray();
		Stack<Character> st = new Stack<>();
		boolean ins = false;
		for( int i=0; i<att.length; i++ ) {
			char ch = att[att.length - 1 - i];
			if( ch == 'B' )
				ins = true;
			if( ins ) {
				st.push(ch);
			}
		}
		n = st.size();
		long count = 0;
		for( int i=0; i<att.length; i++ ) {
			if( att[i] == 'B' ) {
				count+=(long)Math.pow(2, i);
			}
		}
//		while( true ) {
//			if( st.peek() == 'B' ) {
//				st.pop();
//				st.push('R');
//				count++;
//				continue;
//			}
//			while( !st.isEmpty() && st.peek() == 'R' ) {
//				st.pop();
//			}
//			if( st.isEmpty() ) {
//				break;
//			}
//			st.pop();
//			st.push('R');
//			while( st.size() < n )
//				st.push('B');
//			count++;
//		}
		p.println(count);
		p.close();
	}
	
	
	
    static class Print {
        private BufferedWriter bw;
 
        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(Object object) throws IOException {
            bw.append("" + object);
        }
        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }
        public void close() throws IOException {
            bw.close();
        }
    }
	
	
	
	
	
	
    public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }
	}
	
}
