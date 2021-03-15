package com.comp.algos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AlterSubseq {
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int t = s.nextInt();
		while( t --> 0 ) {
			long n = s.nextLong();
			long sum = 0;
			long tba = s.nextLong();
			boolean req = false;
			
			if( tba>0 ) {
				req = false;
			}else {
				req = true;
			}
			
			for( int i=0; i<n-1; i++ ) {
				long a = s.nextLong();
				if( req == true ) {
					if( a>0 ) {
						sum += tba;
						tba = a;
						req = false;
					}else {
						tba = Math.max(tba, a);
					}
				}else {
					if( a<0 ) {
						sum += tba;
						tba = a;
						req = true;
					}else {
						tba = Math.max(tba, a);
					}
				}
			}
			sum += tba;
			p.println(sum);
		}
		
		p.close();
	}
	
	public static class Pair implements Comparable<Pair> {
		int first;
		int second;
		
		public Pair( int a, int b ) {
			this.first = a;
			this.second = b;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.first - first;
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
