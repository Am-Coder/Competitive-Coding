package com.comp.hearth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import static java.lang.System.out;
public class NearestPrime {

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
  static int max = 1000001;
  static int[] arr = new int[max];
  public static void seive(){
      arr[0] = 1;
      arr[1] = 1;
      for(int i=2; i*i<max; i++){
          
          if(arr[i] == 0){
              for(int j=i*i; j<max; j+=i){
                  arr[j] = 1;
              }
              
          }
      }
      
          
  }
  
  public static void main(String args[] ) throws Exception {
      MyScanner s = new MyScanner();
      int n = s.nextInt();
      seive();
      Print print = new Print();
      
      for( int i=0; i<n; i++ ){
          int a = s.nextInt();
          for(int j=a,k=a; ;j--,k++){
              if (j>=1 && arr[j]== 0){
                  print.println(j);
                  break;
              } else if (arr[k] == 0){
                  print.println(k);
                  break;
              }
          }
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
