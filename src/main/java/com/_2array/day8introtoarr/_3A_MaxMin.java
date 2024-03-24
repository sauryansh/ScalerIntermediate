package com._2array.day8introtoarr;

import java.lang.*;
import java.util.*;

public class _3A_MaxMin {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> in = new ArrayList<>();
        for (int i=0;i<n;i++){
            in.add(sc.nextInt());
        }

        int findMax = Integer.MIN_VALUE;
        int findMin = Integer.MAX_VALUE;

        for(int i=0;i<in.size();i++){
            if (in.get(i)>findMax){
                findMax = in.get(i);
            }

            if(in.get(i)<findMin){
                findMin=in.get(i);
            }
        }

        System.out.println(findMax+"  "+findMin);
    }
}