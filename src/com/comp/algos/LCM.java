package com.comp.algos;

import java.math.BigInteger;

public class LCM {
    // function to calculate LCM of two large numbers 
    public static BigInteger lcm(String a, String b) 
    { 
        // convert string 'a' and 'b' into BigInteger 
        BigInteger s = new BigInteger(a); 
        BigInteger s1 = new BigInteger(b); 
  
        // calculate multiplication of two bigintegers 
        BigInteger mul = s.multiply(s1); 
  
        // calculate gcd of two bigintegers 
        BigInteger gcd = s.gcd(s1); 
  
        // calculate lcm using formula: lcm * gcd = x * y 
        BigInteger lcm = mul.divide(gcd); 
        return lcm; 
    } 
  
    // Driver Code 
    public static void main(String[] args) 
    { 
  
        // Input 'a' and 'b' are in the form of strings because 
        // they can not be handled by integer data type 
        String a = "36594652830916364940473625749407"; 
        String b = "448507083624364748494746353648484939"; 
  
        System.out.print(lcm(a, b)); 
    } 
}
