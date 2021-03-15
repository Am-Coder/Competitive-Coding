package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class DistinctIntegerCount {
    
	BitSet[] st;
	
	DistinctIntegerCount( int[] arr, int n ) {
		int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));
		
		
		//Total nodes in Segment Tree
		int max_size = 2*(int )Math.pow(2, x) -1 ;
		
		st = new BitSet[max_size];
		
		constructUtil(arr,0,n-1,0);
	}
	
	public void constructUtil(int[] arr, int ss, int se, int si ) {
		if( ss == se ) {
			st[si] = new BitSet(5001);
			st[si].set(arr[ss]);
			return;
//			return st[si];
		}
		
		int mid = ss + (se-ss)/2;
		constructUtil(arr, ss, mid, 2*si + 1);
		constructUtil(arr, mid+1, se, 2*si + 2 );
		st[si] = new BitSet(5001);

		st[si].or(st[2*si+1]);
		st[si].or(st[2*si+2]);

	}
	
	//Return sum of elements in range qs to qe
	BitSet getSum(int n, int qs, int qe ) {
		

		
		return getSumUtil( 0, n-1, qs, qe, 0 );
		
	}
	
	BitSet getSumUtil(int ss, int se, int qs, int qe, int si ) {
		if( qs <= ss && qe >= se ) {
			return (BitSet)st[si].clone();
		}
		
		if( qs > se || qe < ss ) {
			return new BitSet();
		}
		int mid = ss + (se-ss)/2;
		BitSet b = getSumUtil(ss,mid,qs,qe,2*si+1);
		b.or(getSumUtil(mid+1,se,qs,qe,2*si+2));
		return b;

	}
	
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int n = s.nextInt();
		int[] arr1 = new int[2*n];
		for( int i=0; i<2*n; i++ ){
		    arr1[i] = s.nextInt();
		}


		DistinctIntegerCount t1 = new DistinctIntegerCount( arr1, 2*n );
//		for( int i=0; i<t1.st.length; i++ ) {
//			System.out.println(t1.st[i]);
//		}
	    int q = s.nextInt();
	    int l1,r1,l2,r2;
	    for( int i=0; i<q; i++ ){
	        
	        l1 = s.nextInt();
	        r1 = s.nextInt();
	        l2 = s.nextInt();
	        r2 = s.nextInt();
//	        p.println(Integer.bitCount(t1.getSum( 2*n, l1 -1, r1 - 1 )|t1.getSum( 2*n, n+l2-1, n+r2-1 )));
	        BitSet b = t1.getSum( 2*n, l1 -1, r1 - 1 );
	        b.or(t1.getSum( 2*n, n+l2-1, n+r2-1 ));
	        p.println(b.cardinality());
	       
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
