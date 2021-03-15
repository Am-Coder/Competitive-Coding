package com.comp.algos;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
	
	public int x, y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

class Quad implements Comparable<Quad> {
	
	public int x, y, z, w;
	
	Quad(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	@Override
	public int compareTo(Quad o) {
		// TODO Auto-generated method stub
		if (o.x == x) {
			if (o.y == y) {
				if (o.z == z) {
					return w - o.w;
				}
				return z - o.z;
			}
			return y - o.y;
		}
		return x - o.x;
	}
	
}

// LOGIC - Store all possible pair sum in hash map then look for sum - arr[i] -arr[j] in n^2 complexity
public class AllQuadrupleSum {
	
	public static void quadTuple(int[] A, int n, int sum) {
		Map<Integer, List<Pair>> map = new HashMap<>();
		HashSet<String> hs = new HashSet<>();
		ArrayList<Quad> sol = new ArrayList<>();
		boolean found = false;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int val = sum - (A[i] + A[j]);
				
				if (map.containsKey(val)) {
					for (Pair pair : map.get(val)) {
						int x = pair.x;
						int y = pair.y;
						
						if ((x != i && x != j) && (y != i && y != j)) {
							found = true;
							int[] aa = new int[4];
							aa[0] = A[i];
							aa[1] = A[j];
							aa[2] = A[x];
							aa[3] = A[y];
							Arrays.sort(aa);
							String ans = aa[0] + " " + aa[1] + " " + aa[2] + " " + aa[3] + " $";
							if (!hs.contains(ans)) {
								sol.add(new Quad(aa[0], aa[1], aa[2], aa[3]));
								hs.add(ans);
							}
							
						}
					}
				}
				
				map.putIfAbsent(A[i] + A[j], new ArrayList<>());
				map.get(A[i] + A[j]).add(new Pair(i, j));
			}
		}
		
		if (!found) {
			System.out.print(-1);
		} else {
			Collections.sort(sol);
			for (Quad an : sol)
				System.out.print(an.x + " " + an.y + " " + an.z + " " + an.w + " $");
		}
	}
	
	// Driver Code 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			quadTuple(arr, n, k);
			System.out.println("");
		}
		
	}
	
}
