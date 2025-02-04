package com.comp.algos;

//How does Extended Algorithm Work?
//
//As seen above, x and y are results for inputs a and b,
//   a.x + b.y = gcd                      ----(1)  
//
//And x1 and y1 are results for inputs b%a and a
//   (b%a).x1 + a.y1 = gcd   
//                    
//When we put b%a = (b - (⌊b/a⌋).a) in above, 
//we get following. Note that ⌊b/a⌋ is floor(a/b)
//
//   (b - (⌊b/a⌋).a).x1 + a.y1  = gcd
//
//Above equation can also be written as below
//   b.x1 + a.(y1 - (⌊b/a⌋).x1) = gcd      ---(2)
//
//After comparing coefficients of 'a' and 'b' in (1) and 
//(2), we get following
//   x = y1 - ⌊b/a⌋ * x1
//   y = x1

public class ExtendedEuclidAlgorithm {
    // extended Euclidean Algorithm 
    public static int gcdExtended(int a, int b, int x, int y) 
    { 
        // Base Case 
        if (a == 0) 
        { 
            x = 0; 
            y = 1; 
            return b; 
        } 
  
        int x1=1, y1=1; // To store results of recursive call 
        int gcd = gcdExtended(b%a, a, x1, y1); 
  
        // Update x and y using results of recursive 
        // call 
        x = y1 - (b/a) * x1; 
        y = x1; 
  
        return gcd; 
    } 
  
// Driver Program 
    public static void main(String[] args) 
    { 
        int x=1, y=1; 
        int a = 35, b = 15; 
        int g = gcdExtended(a, b, x, y); 
        System.out.print("gcd(" + a +  " , " + b+ ") = " + g); 
  
    } 
}
