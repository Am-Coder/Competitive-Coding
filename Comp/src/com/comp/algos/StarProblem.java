package com.comp.algos;

//import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//See how the prefix sumarr is holding the sum of all elements
//and providing when necessary
public class StarProblem {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int a = s.nextInt();
		long[] arr = new long[a];
		long[] sumarr = new long[a+1];
		
		long suma = 0;
		for(int i=0; i<a; i++) {
			arr[i] = (s.nextLong());
			suma += arr[i]; 

			sumarr[i] = suma;
            
		}
		

		a = s.nextInt();
		for(int i=0; i<a; i++) {
			int j = s.nextInt();
			int k = s.nextInt() - 1;
			int l = s.nextInt() - 1;
			if(j == 1) {
				sumarr[k] = sumarr[k] - arr[k] + arr[l];
				int ak = k;
				int al = l;
				while(k<l) {
					long temp = arr[k];
					arr[k] = arr[l];
					arr[l] = temp;
					k += 1;
					l -= 1;

				}
				for(int o=ak+1; o<al; o++)
					sumarr[o] = sumarr[o-1] + arr[o];
//				System.out.println()
			}else if(j == 2) {
				if(k == 0)
					System.out.println(sumarr[l]);
				else
					System.out.println(sumarr[l] - sumarr[k-1]);
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

