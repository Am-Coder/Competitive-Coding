package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class xorAndInsert {
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		int q = s.nextInt();
		HashSet<Integer> hset = new HashSet<>();
		HashSet<Integer> hset1;
		HashSet<Integer> exset = new HashSet<>();
		Print p = new Print();
		int min = 0;
		int ex = 0;
		hset.add(0);
		int val;
		while(q!=0) {
			int t = s.nextInt();
			if( t == 1) {
				val = s.nextInt();
				min = Integer.MAX_VALUE;
				if( ex != 0) {
					hset1 = (HashSet)hset.clone();
					for( int c: hset1 ) {
						hset.remove(c);
						int ans = c^ex;
						if(ans<min)
							min = ans;
						hset.add(ans);
					}
					ex = 0;
				}
				if(val<min)
					min = val;
				hset.add(val);
			}else if( t == 2 ) {
				val = s.nextInt();
				ex = ex^val;
				
			}else {
				min = Integer.MAX_VALUE;
				hset1 = (HashSet)hset.clone();
				for( int c: hset1 ) {
					hset.remove(c);
					int ans = c^ex;
					if(ans<min)
						min = ans;
					hset.add(ans);
				}
					
				p.println(min);
			}
			p.bw.flush();
			q--;
		}
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
