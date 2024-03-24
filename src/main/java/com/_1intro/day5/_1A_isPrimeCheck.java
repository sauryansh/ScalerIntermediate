package com._1intro.day5;

import java.lang.*;
import java.util.*;

public class _1A_isPrimeCheck {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc= new Scanner(System.in);
        System.out.print(new _1A_isPrimeCheck().isPrime(sc.nextInt()));
    }

    public String isPrime(int n){
        int count = 0;

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(i==n/i){
                    System.out.println("The Value which are factor are :" + i);
                    count++;
                }else{
                    System.out.println("The Value which are factor are :" + i+ " and "+ (n/i));
                    count+=2;
                }
            }
        }

        if(count==2){
            System.out.println(count);
            return "YES";
        }else{
            System.out.println(count);
            return "NO";
        }
    }
}