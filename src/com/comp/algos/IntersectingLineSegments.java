package com.comp.algos;


public class IntersectingLineSegments {
	
	static class Point {
		
		int x;
		
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// Given three COLINEAR points p, q, r, the function checks if 
	// point q lies on line segment 'pr' 
	static boolean onSegment(Point p, Point q, Point r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
			return true;
		
		return false;
	}
	
	// To find orientation of ordered triplet (p, q, r). 
	// The function returns following values 
	// 0 --> p, q and r are colinear 
	// 1 --> Clockwise 
	// 2 --> Counterclockwise 
	static int orientation(Point p, Point q, Point r) {
		// See https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
		// for details of below formula. 
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
		
		if (val == 0)
			return 0; // colinear 
			
		return (val > 0) ? 1 : 2; // clock or counterclock wise 
	}
	
	// The main function that returns true if line segment 'p1q1' 
	// and 'p2q2' intersect. 
	static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
		// Find the four orientations needed for general and 
		// special cases 
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);
		
		// General case 
		if (o1 != o2 && o3 != o4)
			return true;
		
		// Special Cases 
		// p1, q1 and p2 are colinear and p2 lies on segment p1q1 
		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;
		
		// p1, q1 and q2 are colinear and q2 lies on segment p1q1 
		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;
		
		// p2, q2 and p1 are colinear and p1 lies on segment p2q2 
		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;
		
		// p2, q2 and q1 are colinear and q1 lies on segment p2q2 
		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;
		
		return false; // Doesn't fall in any of the above cases 
	}
	
	// Driver code 
	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point q1 = new Point(10, 1);
		Point p2 = new Point(1, 2);
		Point q2 = new Point(10, 2);
		
		if (doIntersect(p1, q1, p2, q2))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		p1 = new Point(10, 1);
		q1 = new Point(0, 10);
		p2 = new Point(0, 0);
		q2 = new Point(10, 10);
		if (doIntersect(p1, q1, p2, q2))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		p1 = new Point(-5, -5);
		q1 = new Point(0, 0);
		p2 = new Point(1, 1);
		q2 = new Point(10, 10);
		;
		if (doIntersect(p1, q1, p2, q2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
