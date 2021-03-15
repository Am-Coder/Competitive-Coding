package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ZerosAndOnes {
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int[] arr = new int[n];
		arr[0] = 1;
		
		for( int i=1; i<n; i++ ) {
			arr[i] += arr[i-1]+1;
		}
//		Arrays.fill(arr, 1);
		int val = n;
		int q = s.nextInt();
		int a,b;
		while( q != 0 ) {
			a = s.nextInt();
			if( a == 1 ) {
				b = s.nextInt();
				if( b > n ) {
					System.out.println(1);
				}else {
					int count = 0;
					for( int i = 0; i<val ; i++ ) {
						if( arr[i] == 1)
							count++;
						if(count == b) {
							System.out.println(i+1);
							break;
						}
					}
				}
			}else {
				b = s.nextInt();
				if(arr[b-1] == 1)
					n--;
				arr[b-1] = 0;
			}
			q--;
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
