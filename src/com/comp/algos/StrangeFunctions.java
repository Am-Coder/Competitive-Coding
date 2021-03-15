package com.comp.algos;

import java.util.*;
import java.io.*;
public class StrangeFunctions {
	public static void main(String[] args) throws IOException {
		MyScanner s = new MyScanner();
		Print p = new Print();
		int n = s.nextInt();
		int[] arr = new int[n];
		int[] pri = new int[n];
		HashMap<Integer, Pair> hmap = new HashMap<>();
//		HashMap<Integer, Integer> imap = new HashMap<>();
		for( int i=0; i<n; i++ ) {
			arr[i] = s.nextInt();
		}
		
		long pis = 0;
		for( int i=0; i<n; i++ ) {
			pri[i] = s.nextInt();
			pis += (long)pri[i];
		}
		n = s.nextInt();
		boolean noans = false;
		int[] fin = new int[n];
		for( int i=0; i<n; i++ ) {
			fin[i] = s.nextInt();
		}
		for( int i=0; i<n; i++ ) {
			if( hmap.containsKey(arr[i])) {
				Pair pa = hmap.get(arr[i]);
				if( pa.first < arr[i] ) {
					pa.first = arr[i];
					pa.second = i;
				}
				hmap.put(arr[i], pa);
			}else {
				hmap.put(arr[i], new Pair(pri[i],i));
			}
		}

		HashSet<Integer> hset = new HashSet<>();
		int prevind = 0;
		for( int i=0; i<n; i++ ) {
			int a = s.nextInt();
			
			if( hmap.containsKey(a)  ) {
				hset.add(a);
			} else {
				noans = true;
				break;		
			}
		}
		if( noans )
			p.println("NO");
		else {
			
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
