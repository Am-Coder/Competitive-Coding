package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ZerosAndOnesSegTree {
	
	static int[] st;
	static Print p = new Print();
	static int createUtil(int[] arr, int ss, int se, int si ) {
		
		if( ss == se ) {
			
			if( arr[ss] == 1 )
				st[si] = 1;
			else st[si] = 0;
//			st[si] = arr[ss];
			return st[si] ;
			
		}
		
		int mid = ss + (se - ss)/2 ;
		st[si] = createUtil( arr, ss, mid, 2*si + 1 ) + createUtil( arr, mid+1, se, 2*si + 2 );
		
		return st[si];
		
	}
	
	static void create( int[] arr, int n ) {
		
		int s = (int)Math.ceil((Math.log(n)/Math.log(2)));
		s = 2*(int)Math.pow( 2, s ) - 1 ;
		st = new int[s];
		createUtil(arr, 0, n-1, 0);
		
	}
	
	static void updateUtil(  int ss, int se, int k, int nval,  int si ) {
		if( k < ss || k > se ) {
		return;
		}
	
	
		st[si] = st[si] + nval;
		if( se != ss ) {
			int mid = ss + (se -ss)/2;
			updateUtil( ss, mid, k, nval, 2*si + 1 ); 
			updateUtil( mid + 1, se, k, nval, 2*si + 2 );
		}
	}
	
	static void update( int[] arr, int k, int n ) {
		
		if( arr[k] == 0)
			return;
		arr[k] = 0;
		int diff = -1;
		updateUtil( 0, n-1, k, diff, 0 );
				
	}	
	
	static void search( int fi, int ss, int se, int si ) throws IOException {
		
		if( st[si] < fi ) {
			p.println(-1);
			p.bw.flush();
			return;
		}
		
		if( ss == se ) {
			p.println(ss+1);
			p.bw.flush();
			return;
		}
		
		
		int mid = ss + ( se - ss )/2;
		
		if( st[ 2*si + 1 ] >= fi ) {
			
			search( fi, ss, mid, 2*si + 1 );
			
		}else if( st[ 2*si + 2 ] >= fi - st[ 2*si + 1 ] ) {
			
			search( fi - st[ 2*si + 1 ], mid + 1, se, 2*si + 2 );
			
		}

		
	}
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		int q = s.nextInt();
		int a , b ;
		create(arr,n) ;
//		for( int i=0; i<st.length; i++ ) {
//			System.out.println(st[i]);
//		}
		while( q != 0 ) {
			a = s.nextInt() ;
			if( a == 1 ) {
				b = s.nextInt();
				search( b, 0, n-1, 0 );
			}else {
				b = s.nextInt();
				update( arr, b-1, n );
			}	
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
