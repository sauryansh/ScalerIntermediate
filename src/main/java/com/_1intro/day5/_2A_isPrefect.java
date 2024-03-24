package com._1intro.day5;

import java.util.Scanner;

public class _2A_isPrefect {
    public static void main(String[] args) {
        //Example 6 is a perfect number than 1, 2, 3 and 6 are its proper divisors, and 1 + 2 + 3 = 6.
        //Example 28 is a perfect number than 1, 2, 4, 7, 14 and 28 are its proper divisors, and 1 + 2 + 4 + 7 + 14 + 28 = 28.
        Scanner sc= new Scanner(System.in);
        int numOfIteration = sc.nextInt();
        for(int i=0;i<numOfIteration;i++){
            System.out.println(new _2A_isPrefect().isPrefectCheck(sc.nextInt()));
        }
    }

    private String isPrefectCheck(int n) {
        int sum = 0;
        for (int i=1;i<=(n/2);i++){
            if(n%i==0){
                sum+=i;
            }
        }

        if(sum==n){
            return "YES";
        }else{
            return "NO";
        }
    }


}
