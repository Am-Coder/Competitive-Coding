package com.comp.hearth;

import java.util.*;
import java.io.*;


public class Help {
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

	public static void main(String[] args) throws Exception {
		MyScanner s = new MyScanner();
        Print p = new Print();
        int n = s.nextInt();
        Pair[] arr = new Pair[n];
        for( int j=0; j<n; j++ ){        	
        	arr[j] = new Pair(s.nextInt(),s.nextInt());
        }
        Arrays.sort(arr);

        int td = s.nextInt();
        int cp = s.nextInt();
        int minst = 0;
        int curst = 0;
        while( cp >= 0 ) {
        	if( curst == -1 ) {
            	p.println(-1);
        		break;
        	}
        	if( cp >= td ) {
        		p.println(minst);
        		break;
        	}
        	int maxp = -1;
        	int st = -1;
        	for( int i=curst; i<arr.length; i++ ) {
        		
        		if( td - arr[i].first > cp )
        			break;
        		
        		if( maxp < cp - (td - arr[i].first) + arr[i].second ) {
        			st = i;
        			maxp = cp - (td - arr[i].first) + arr[i].second;
        		}
            	
        	}
        	if( st != -1 ) {
        		td = arr[st].first;
        		curst = st+1;
        	}else {
        		curst = -1;
        	}
        	System.out.println(maxp+"-"+st);
        	cp = maxp != -1? maxp:cp;
        	minst++;

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
