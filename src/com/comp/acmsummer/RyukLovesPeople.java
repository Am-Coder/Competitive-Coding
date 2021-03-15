package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RyukLovesPeople {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		int leve ;
		int lodd ;
		int a = s.nextInt();
		ArrayList<Integer> even = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();
		for(int i=1; i<=a; i++) {
			if(i%2 == 0) {
				even.add(s.nextInt());
			}
			else {
				odd.add(s.nextInt());
			}
		}
		
		
		int size = even.size(),check=1;
		int temp;
		if(size !=0)
			temp = even.get(size - 1);
		int j=0;
		for( j=0; j<size; j++) {
			check=1;
			for(int i=1; i<size; i++) {
				if(even.get(i)-even.get(i-1) < 0) {
					check = -1;
					break;
				}
			}
			if(check == 1) {
				break;
			}
			temp = even.get(size - 1);
			for(int i=size-1 ; i>0; i--) {
				
				even.set(i, even.get(i-1));
				
			}
			even.set(0, temp);


		}
		if(check==-1)
			leve = -1;
		else 
			leve = j<size-j?j:size-j;
		
		
		size = odd.size();
		if(size !=0)
			temp = odd.get(size - 1);
		j=0;
		for( j=0; j<size; j++) {
			check=1;
			for(int i=1; i<size; i++) {
				if(odd.get(i)-odd.get(i-1) < 0) {
					check = -1;
					break;
				}
			}
			if(check == 1) {
				break;
			}
			temp = odd.get(size - 1);
			for(int i=size-1 ; i>0; i--) {
				
				odd.set(i, odd.get(i-1));
				
			}
			odd.set(0, temp);


		}
		if(check==-1)
			lodd = -1;
		else 
			lodd = j<size-j?j:size-j;
		
		

		if(leve >= 0 && lodd >= 0) {
			System.out.println("YES");
			System.out.println(leve +lodd);
		}else
			System.out.println("NO");
		

	}
	public static int check(ArrayList<Integer> arr) {
		int size = arr.size(),check=1;
		int temp = arr.get(size - 1);
		int j=0;
		for( j=0; j<size; j++) {
			check=1;
			for(int i=1; i<size; i++) {
				if(arr.get(i)-arr.get(i-1) < 0) {
					check = -1;
					break;
				}
			}
			if(check == 1) {
				break;
			}
			temp = arr.get(size - 1);
			for(int i=size-1 ; i>0; i--) {
				
				arr.set(i, arr.get(i-1));
				
			}
			arr.set(0, temp);


		}
		if(check==-1)
			return -1;
		else 
			return j<size-j?j:size-j;
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
