package com.comp.hearth;
import java.io.*;
import java.util.*;

public class jokerandthieves {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            char[][] A = new char[N][N];
            for(int i_A=0; i_A<N; i_A++)
            {
            	String[] arr_A = br.readLine().split(" ");
            	for(int j_A=0; j_A<arr_A.length; j_A++)
            	{
            		A[i_A][j_A] = arr_A[j_A].charAt(0);
            	}
            }

            int out_ = solution(A, K);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static int solution(char[][] A, int K){
        int n = A[0].length;
        char[] arr = new char[n];
        int tc = 0;
        for( int i=0; i<n; i++ ){
            int pc =0;
            for( int j=0; j<n; j++ ){
                if( A[i][j] == 'P' ){
                    pc++;
                    for( int k=j; k<=j+K && k<n; k++ ){
                        arr[k] = 'P';
                    }
                    for( int k=j-1; k>=j-K && k>=0; k-- ){
                        arr[k] = 'P';
                    }
                }
            }

            for( int j=0; j<n; j++ ){
                if( A[i][j] == 'T' && arr[j] == 'P' && pc > 0){
                    tc++;
                    pc--;
                }
            }
            
        }

        return tc;
    }
}
