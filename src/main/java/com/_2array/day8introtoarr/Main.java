package com._2array.day8introtoarr;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
             ArrayList<Integer> in = new ArrayList<Integer>();
                int size = sc.nextInt();
                for(int i=0;i<size;i++){
                    in.add(sc.nextInt());
                }
                int B = sc.nextInt();

                if(in.contains(B)){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
        }

    }
}