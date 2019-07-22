package com.comp.acmsummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
class Sol {
    public List<Integer> countSmaller(int[] nums) {
 
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length==0){
            return result;
        }
 
        Node root = new Node(nums[nums.length-1]);
        root.count=1;
        result.add(0);
 
        for(int i=nums.length-2; i>=0; i--){
            result.add(insertNode(root, nums[i]));
        }
 
        Collections.reverse(result);
 
        return result;
    }
 
    public int insertNode(Node root, int value){
        Node p=root;
        int result=0;
 
        while(p!=null){
            if(value>p.value){
                result+=p.count+p.numLeft;
                if(p.right==null){
                    Node t = new Node(value);
                    t.count=1;
                    p.right=t;
                    return result;
                }else{
                    p=p.right;
                }
            }else if(value==p.value){
                p.count++;
                return result+p.numLeft;
            }else{
                p.numLeft++;
 
                if(p.left==null){
                    Node t = new Node(value);
                    t.count=1;
                    p.left=t;
                    return result;
                }else{
                    p=p.left;
                }
            }
        }
 
        return 0;
    }
}
 
class Node{
    Node left;
    Node right;
 
    int value;
    int count;
    int numLeft;
    public Node(int value){
        this.value=value;
    }
}
public class ChrissyPhysics {
    public static void main(String args[] ) throws Exception {
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int num = s.nextInt();
            arr[i] = num;
        }
        Sol so = new Sol();
        
        List<Integer> result = new ArrayList<Integer>();
        result = so.countSmaller(arr);
        long sum = 0;
        for(int i=0; i<result.size(); i++) {
        	sum += (long)result.get(i);
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
