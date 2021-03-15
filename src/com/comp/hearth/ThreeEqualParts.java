package com.comp.hearth;

import java.util.*;
import java.io.*;

public class ThreeEqualParts {
    static int mod = 1000000007;
	
    public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
	    Print p = new Print();
	    int t = s.nextInt();
	    boolean ans = false;
	    for( int i=0; i<t; i++ ){
	        int n = s.nextInt();
	        int[] arr = new int[n];
	        for( int j=0; j<n; j++ ){
	            arr[j] = s.nextInt();
	        }
	        int val1=0,val2=0,val3=0;
	        int po1=1, po2=1, po3=1;
	        ans = false;
	        for( int j=n-1; j>=0; j-- ){
	        	
	        	po1 = n-1-j!=0?(2%mod*po1%mod)%mod:po1;
	            val1 = (val1%mod + (arr[j]*po1)%mod)%mod;
//	            System.out.println("Val1 - "+val1);
	            val2 = 0;
	            po2=1;
	            for( int k=j-1; k>=0; k--){
	            	po2 = j-1-k!=0?(2%mod*po2%mod)%mod:po2;
	            	val2 = (val2%mod + (arr[k]*po2)%mod)%mod;
//	            	System.out.println("Val2 - "+val2);
	            	if( val1 == val2 ){
	                    val3 = 0;
	                    po3=1;
	                    for( int l=k-1; l>=0; l-- ){
	                    	po3 = k-1-l!=0?(2%mod*po3%mod)%mod:po3;
	                    	val3 = (val3%mod + (arr[l]*po3)%mod)%mod;
//	                    	System.out.println("Val3 - "+val3);
	                        if( val3 > val2 )
	                            break;
	                    }
                    	if(val1==val3){
                			ans = true;
//                    		break;
                		}

	                }
	                if( val2 > val1 )
	                    break;
	                if( ans )
	                	break;
	            }
	            if( ans )
	            	break;
	        }
	        if( !ans )
	        	p.println(-1);
	        else
	        	p.println(val1);
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
