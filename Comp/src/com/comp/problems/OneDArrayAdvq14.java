package com.comp.problems;
		
import java.util.Scanner;
		
public class OneDArrayAdvq14 {
//    public static boolean canWin(int leap, int[] game) {
//        // Return true if you can win the game; otherwise, return false.
//    	
//        int n = game.length,s=0,check=-1;
//        while(s+leap<n && s!=n-1) {
//            if(game[s+1]==0) {
//                s=s+1;
//                check=1;
//            }
//            else if( game[s+leap]==0) {
//                s=s+leap;
//                check=0;
//            } else if(check==0 && game[s-1]==0){
//                s=s-1;
//            }
//            else{
//                return false;
//            }
//        }
//        return true;
//    }	

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
         
        int n = game.length,s=0,check=-1;
        while(s+leap<n && (s+leap)!=n-1 && s!=n-1) {
            check=-1;
            if(s+1<n && game[s+1]==0) {
                s=s+1;
                check=1;
//                System.out.println("a");
            }
            else if(s+leap<n && game[s+leap]==0) {
                s=s+leap;
                check=0;
//                System.out.println("b");

            } else if(check==0  && game[s-1]==0){
                s=s-1;
//                System.out.println("c");
            }
            else if(check==-1){
//                System.out.println("d");
                return false;
            }
        }
        return true;
    }
	
	
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
        
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }	
}		
		