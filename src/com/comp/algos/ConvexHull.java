package com.comp.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Given a set of points in the plane. the convex hull of the set is the smallest 
//convex polygon that contains all the points of it.
class Point implements Comparable<Point> {
	
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if (x == o.x)
			return y - o.y;
		return x - o.x;
	}
}

public class ConvexHull {
	
	static int orientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
		if (val == 0)
			return 0;
		return val > 0 ? 1 : 2;
	}
	
	static void convexhull1(Point[] arr, int n) {
		if (n < 3) {
			System.out.println(-1);
			return;
		}
		
		int l = 0;
		for (int i = 1; i < n; i++)
			if (arr[i].x < arr[l].x)
				l = i;
			
		ArrayList<Point> hull = new ArrayList<>();
		int p = l;
		int q;
		
		do {
			hull.add(arr[p]);
			q = (p + 1) % n;
			for (int i = 0; i < n; i++) {
				if (orientation(arr[p], arr[i], arr[q]) == 2)
					q = i;
			}
			p = q;
		} while (p != l);
		Collections.sort(hull);
		for (int i = 0; i < hull.size() - 1; i++) {
			System.out.print(hull.get(i).x + " " + hull.get(i).y + ", ");
		}
		System.out.println(hull.get(hull.size() - 1).x + " " + hull.get(hull.size() - 1).y);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while (t-- > 0) {
			int n = s.nextInt();
			Point[] arr = new Point[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Point(s.nextInt(), s.nextInt());
			}
			convexhull1(arr, n);
		}
	}
}
