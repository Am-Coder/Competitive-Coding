package com.comp.acmsummer;

import java.util.Scanner;

public class Lottery {
	//Using goldbach theorem
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0; i<t; i++){
            
            long n = s.nextLong();
            if(isPrime(n))
                System.out.println(1);
            else if (n%2 == 0)
                System.out.println(2);
            else if(isPrime(n-2)){
                System.out.println(2);
            }else{
                System.out.println(3);
            }

        }
        s.close();

    }
	static boolean isPrime(long a) {
		for(long i=2; i<=Math.sqrt(a);i++) {
			if(a%i == 0) {
				return false;
			}
		}
		return true;
	}
  
}
