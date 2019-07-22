package com.comp.hearth;
		
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
		
//class Compare implements Comparator<Values>{
//
//	@Override
//	public int compare(Values o1,Values o2) {
//		// TODO Auto-generated method stub
//		if(o1.value>o2.value)
//			return 1;
//		else if(o1.value<o2.value)
//			return -1;
//		else 
//			return 0;
//	}
//	
//}
//class Values	{
//	int value;
//	int index;
//	public int getValue() {
//		return value;
//	}
//	public void setValue(int value) {
//		this.value = value;
//	}
//	public Values(int value, int index) {
//		super();
//		this.value = value;
//		this.index = index;
//	}
//	public int getIndex() {
//		return index;
//	}
//	public void setIndex(int index) {
//		this.index = index;
//	}
//	
//}
public class q18 {
	int MOD=1000000007;
    
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		
		int n = s.nextInt();
		int x = s.nextInt();
		int k = s.nextInt();
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<Integer,Integer> fin = new HashMap<>();
		for(int i=0; i<n; i++) {
			
			arr.add(s.nextInt());
			
		}
		
		for( int i=0 ; i<n ; i++ ) {
			
			for(int j=n-1; j>i; j--) {
				int min = arr.get(i);
				int max = min;
				int maxi = i;
				for( int l=i; l<=j; l++ ) {
					int val = arr.get(l);
					if(val > max) {
						max = val;
						maxi = l;
					}
					if(val < min)
						min = val;
				}
				sum += max - min;
				if(fin.containsKey(maxi)) {
					fin.replace(maxi, fin.get(maxi)+1);
				}else {
					fin.put(maxi,1);
				}
				
			}
		}	
		for( int i=0 ; i<x ; i++ ) {
			Set<Integer> se = fin.keySet();
			int max = 0,ke=-1;
			for (Integer key : se) {
				if(fin.get(key)>max) {
					max = fin.get(key);
					ke = key;
				}
			}
			sum = sum + max;
			fin.remove(ke);
		}
		System.out.println(sum);
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
