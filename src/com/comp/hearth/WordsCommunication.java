package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class WordsCommunication {
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		HashSet<String> hset= new HashSet<>();
		
		while(true) {
			String str = s.nextLine();
			if(str.equals("END")) {
				break;
			}
			hset.add(str);
		}
		
		String s1 = s.next();
		String s2 = s.next();
		
		int l1 = s1.length();
		int l2 = s2.length();
		int tr = 0;
		
		StringBuilder hit = new StringBuilder();
		StringBuilder m1 = new StringBuilder();
		StringBuilder m2 = new StringBuilder();
		int i=0, j=0;
		
		while( i<l1 && j<l2 ) {
			
			if( s1.charAt(i) == s2.charAt(j)) {
				hit.append(s1.charAt(i));
				i++;
				j++;
			}else {
				
			}
			
		}
		
		
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
