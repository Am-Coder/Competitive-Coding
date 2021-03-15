package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Shino {
    static int mod = (int)1e9 + 7;
	//Simple fxn to compute nCr%p
//Similar to nCr
static int nCrmodP(int n, int r ) {
	
	int[] arr = new int[n+1];
	
	arr[0] = 1;
	
	for( int i=1; i<=n; i++) {
		
		for( int j=Math.min(i, r); j>0; j--) {
			
			arr[j] = (arr[j] +arr[j-1])%mod;
		}
	}
	return arr[r];
}


//Lucas Theorem states the nCr%p == niCri%p where ni and ri are individual same positioned digits in 
//base p representation of n and r respectively.
static int nCrmodPLucas( int n, int r) {
	if( r==0)
		return 1;
	
	int ni = n%mod;
	int ri = r%mod;
	
	return (nCrmodPLucas( n/mod, r/mod)*nCrmodP(ni, ri))%mod;
}

public static void main(String[] args) throws Exception {
	MyScanner s = new MyScanner();
	int t = s.nextInt();
	Print p = new Print();
    for (int i = 0; i < t; i++) {
        int m = s.nextInt();
        int n = s.nextInt();
        int k = s.nextInt();
        long sum = 0;
        for(int j=0; j<k; j++){
            int r = s.nextInt();
            int c = s.nextInt();
            int v = s.nextInt();
            long w = (nCrmodPLucas(r -1 + c - 1,r-1) * nCrmodPLucas(n - r + m - c,n - r)) % mod;
            long happiness = (w * v) % mod;
            sum = (sum + happiness) % mod;
        }
        p.println(sum);
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
