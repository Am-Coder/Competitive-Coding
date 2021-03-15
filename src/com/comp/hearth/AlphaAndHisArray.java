package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class AlphaAndHisArray {
	
	static long[] st ;
	static long[] arr ;
	static long ans ;
	static long constructUtil( long[] arr, int ss, int se, int si ) {
		if( ss == se ) {
			st[si] = arr[ss];
			return st[si];
		}
		int mid = ss + (se-ss)/2;
		st[si] = constructUtil(arr, ss, mid, 2*si + 1 ) + constructUtil( arr, mid + 1, se, 2*si + 2 );
		return st[si];
	}	
		
	static void construct(long[] arr, int n) {
		int si = (int)Math.ceil(Math.log(n)/Math.log(2));
		si = 2*(int)Math.pow(2, si) - 1;
		st = new long[si];
		constructUtil(arr, 0, n - 1, 0);
	}	
		
	static void update( int si, int ss, int se, int us, int ue, long diff ) {
		
		if( ss>se || ss>ue || se<us ) {
			return;
		}
		
		if( ss == se ) {
			
			if( arr[ss] >= diff ) {
				arr[ss] -= diff;
				ans += diff;
			}else {
				ans += arr[ss];
				arr[ss] = 0;
			}
			return;
		}
		
		int mid = (se+ss)/2;
		
		update( 2*si + 1, ss, mid, us, ue, diff);
		update( 2*si + 2, mid + 1, se, us, ue, diff);
	}	
		
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int n = s.nextInt();
	    arr = new long[n];
        long d;
	    for( int i=0; i<n; i++ ){
	        arr[i] = s.nextLong();
	    }
//	    s.nextLine();
	    construct( arr, n );
//	    for( int i = 0; i<st.length; i++ ) {
//	    	System.out.println(st[i]);
//	    }
	   // for( int j=0; j<n; j++ ){
	   //     d[j] = s.nextInt();
	   // }
	    for( int i=0; i<n; i++ ){
	        
	    	ans = 0;
	        d = s.nextLong();
	        
	        update( 0, 0, n-1, 0, i, d);
	        
	        p.print(ans + " ");
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
