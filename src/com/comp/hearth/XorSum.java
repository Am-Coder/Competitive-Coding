package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class XorSum {
    
    static long MOD = (long)1e9 + 7 ;
    static int n, q ;
    
    static long[] a = new long[100005];
    static long[][] seg = new long[100005][44];
    static long[] po = new long[100005];
    
    static void create() {
    	for( int i=0; i<=42; i++ ) {
    		
    		for( int j=1; j<=n; j++ ) {
    			seg[j][i] = seg[j-1][i];
    			long t = a[j]&1l<<i;
//    			System.out.println(t);
    			if( t > 0) {
    				seg[j][i]++;
    			}
    		}
    	}
    }
    
	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
		n = s.nextInt();
		
		for( int i=1; i<=n; i++ ) {
			a[i] = s.nextLong();
		}
	    po[0]=1;
	    for(int i=1;i<=100002;i++)
	    {
	        po[i]=2*po[i-1];
	        po[i]%=MOD;
	    }
		create();
		q = s.nextInt();
		s.nextInt();
		int l,r;
		while( q>0) {
			l = s.nextInt();
			r = s.nextInt();
	        long cnt1,cnt0,ans=0,ans1=0;
	        for( int i=0;i<=42;i++)
	        {
	            cnt1=seg[r][i]-seg[l-1][i];
	            cnt0=r-l+1-cnt1;
	            ans=cnt1*(cnt0*(cnt0-1))/2;
	            ans+=(cnt1*(cnt1-1)*(cnt1-2))/6;
	            ans%=MOD;
	            ans=ans*po[i];
	            ans%=MOD;
	            ans1+=ans;
	            ans1%=MOD;
	        }
	        
	        System.out.println(ans1);
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
