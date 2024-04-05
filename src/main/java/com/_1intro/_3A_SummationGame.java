package com._1intro;

import java.util.Scanner;

public class _3A_SummationGame {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        System.out.println(new _3A_SummationGame().summationGame(sc.nextInt()));
    }

    public int summationGame(int n){
        return n*(n+1)/2;
    }
}