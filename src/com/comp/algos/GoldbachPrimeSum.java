package com.comp.algos;

//Every even no can be expressed as a sum of 2 primes ----> Goldbach Theorem
public class GoldbachPrimeSum {
    
  // Function to check if a  
  // number is prime or not. 
  public static boolean isPrime(int x) 
  { 
      if (x == 0 || x == 1) 
          return false; 
            
      for (int i = 2; i * i <= x; ++i)  
          if (x % i == 0) 
              return false;  
      return true; 
  } 

    
  // Prints at most three prime  
  // numbers whose sum is n. 
  public static void findPrimes(int n) 
  { 
      if (isPrime(n)) // CASE-I  
          System.out.print( n ); 
    
      else if (isPrime(n - 2)) // CASE-II  
          System.out.print( 2 + " " +  
                            (n - 2) ); 

      else // CASE-III 
      { 
          System.out.print( 3 + " "); 
          n = n - 3; 
            
          for (int i = 0; i < n; i++) { 
              if (isPrime(i) && isPrime(n - i)) { 
                  System.out.print( i + " " +  
                                       (n - i)); 
                  break; 
              } 
          } 
      } 
  } 

  // driver code 
  public static void main(String[] args) 
  { 
      int n = 27; 
      findPrimes(n); 
  } 
}
