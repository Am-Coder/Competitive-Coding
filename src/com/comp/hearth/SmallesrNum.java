package com.comp.hearth;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class SmallesrNum {
    
    
    static int max = 1000001;
    static int[] si1 = new int[max];
    
    public static void sieve1(){
        si1[0] = 1;
        si1[1] = 1;
        
        for( int i=2; i*i<max; i++ ){
            
            if( si1[i] == 0 ){
               for( int j=i*i; j<max; j+=i ){
                   si1[j] = 1;
               } 
            }
            
        }   
    }
    
    
    
    static final int MAXN = 1000001; 
       
    // stores smallest prime factor for every number 
    static int spf[] = new int[MAXN]; 
       
    // Calculating SPF (Smallest Prime Factor) for every 
    // number till MAXN. 
    // Time Complexity : O(nloglogn) 
    static void sieve() 
    { 
        spf[1] = 1; 
        for (int i=2; i<MAXN; i++) 
       
            // marking smallest prime factor for every 
            // number to be itself. 
            spf[i] = i; 
       
        // separately marking spf for every even 
        // number as 2 
        for (int i=4; i<MAXN; i+=2) 
            spf[i] = 2; 
       
        for (int i=3; i*i<MAXN; i++) 
        { 
            // checking if i is prime 
            if (spf[i] == i) 
            { 
                // marking SPF for all numbers divisible by i 
                for (int j=i*i; j<MAXN; j+=i) 
       
                    // marking spf[j] if it is not  
                    // previously marked 
                    if (spf[j]==j) 
                        spf[j] = i; 
            } 
        } 
    } 
       
    // A O(log n) function returning primefactorization 
    // by dividing by smallest prime factor at every step 
    static int getFactorization(int x) 
    { 
        int m = 1 ;
        while (x != 1) 
        {   m = Math.max(m,spf[x]);
            // ret.add(spf[x]); 
            x = x / spf[x]; 
        } 
        return m; 
    } 
public static void main(String[] args) throws Exception {
	MyScanner s = new MyScanner();
	sieve();
	sieve1();
	int t = s.nextInt();
	for( int i=0; i<t; i++ ){
	    int n = s.nextInt();
	    int m = 1 , c = -1 ;
	    for( int j=0; j<n; j++ ){
	        int a = s.nextInt() ;
	        m = Math.max(m,getFactorization(a)) ;
	    }
	    for( int j=m+1; ; j++ ){
	        if( j>= MAXN )
	            break;
	        if(si1[j] == 0){
	            c = j;
	            break;
	        }
	            
	        
	    }   
	    System.out.println(c);
	}
}



static class Print {
    private BufferedWriter bw;

    public Print() {
        this.bw = new BufferedWriter(new OutputStreamWriter(out));
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
