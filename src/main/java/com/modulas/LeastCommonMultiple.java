package com.modulas;

import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        for(int j=0 ; j<t ; j++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int G = 1;
            // Loop from 1 to minimum of A and B and largest number which divides A and B is HCF
            for(int i = 1; i <= Math.min(A, B); i++){
                if(A % i == 0 && B % i == 0){
                    G = i;
                }
            }
            // LCM will be A*B/HCF
            int L = (A * B) / G;
            System.out.println(L);
        }
    }
}
