package com.comp.acmsummer;

import java.util.HashMap;
import java.util.Scanner;

public class basement {
	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        long c1 = a/3;
        long c2 = b/3;
        HashMap<Long,Long> h1 = new HashMap<>();
        HashMap<Long,Long> h2 = new HashMap<>();
        h1.put((long)1,c1);
        h1.put((long)2,c1);
        h1.put((long)0,c1);
        h2.put((long)1,c2);
        h2.put((long)2,c2);
        h2.put((long)0,c2);
        for(long i=c1*3 + 1; i<=a; i++){
            long val = i%3;
            h1.replace(val, h1.get(val)+1);
        }
        for(long i=c2*3 + 1; i<=b; i++){
            long val = i%3;
            h2.replace(val, h2.get(val)+1);
        }
        long ans  = h1.get((long)1)*h2.get((long)2) + h1.get((long)0)*h2.get((long)0) + h1.get((long)2)*h2.get((long)1);
        
        System.out.println(ans);
        s.close();
    }
}
