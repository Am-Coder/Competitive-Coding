package com.comp.hearth;

import java.util.*;
import java.io.*;

public class kVowels {

	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int t = s.nextInt();
        for( int i=0; i<t; i++ ){
            int n=s.nextInt();
            int k=s.nextInt();
            String st = s.nextLine().toLowerCase();
            int[] arr = new int[256];
            int l = 0;
            int max = -1;
            int j = 0;
            boolean pause = false;
			while ( j < st.length() ){
				char ch = st.charAt(j);
				if( !pause ) {
					arr[ch]++;
					pause = false;
				}
				int aa = arr['a']>0?1:0;
				int ee = arr['e']>0?1:0;
				int ii = arr['i']>0?1:0;
				int oo = arr['o']>0?1:0;
				int uu = arr['u']>0?1:0;
				int count = aa + ee + ii + oo + uu; 
//				System.out.println(l +"-"+j +" " +count+ "aa-"+arr['a']+ " ee-"+arr['e']+ " ii-"+arr['i']+ " oo-"+arr['o']+ " uu-"+arr['u']);
				if( count > k ) {
//					System.out.println(st.charAt(l));
					arr[st.charAt(l)]--;
					l++;
					pause = true;
				}else if( count == k ) {
					max = Math.max(max, j - l + 1);
//					System.out.println(st.charAt(l)+ " - "+st.charAt(j)+ "-");
					
					j++;
					pause = false;

				}else {
					pause = false;

					j++;					
				}
				
			}

			
			p.println(max);
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
