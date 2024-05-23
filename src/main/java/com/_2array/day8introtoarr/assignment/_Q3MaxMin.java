package com._2array.day8introtoarr.assignment;

import java.lang.*;
import java.util.*;

/**
 * Q3. Max and Min of an Array
 * Solved
 * feature icon
 * Get your doubts resolved blazing fast with Chat GPT Help
 * Check Chat GPT
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Take input an array A of size N and write a program to print maximum and minimum elements of the input. The only line of the input would contain a single integer N that represents the length of the array followed by the N elements of the input array A.
 *
 * Problem constraints
 *
 * 1 <= N <= 1000
 *
 * 1 <= A <= 1000
 *
 *
 * Input Format
 *
 * The first line contains a single integer N representing the length of the array A followed by N elements of the array A.
 *
 *
 * Output Format
 *
 * A single line output containing two space-separated integers.
 * The first integer is the maximum value of the array.
 * The second integer is the minimum value of the array.
 *
 * There is **no space** after the minimum value in the output format.
 * There is only a **single space** between the maximum and minimum value.
 *
 *
 * Example Input
 *
 * Input 1:
 * 5 1 2 3 4 5
 * Input 2:
 * 4 10 50 40 80
 *
 * Example Output
 *
 * Output 1:
 * 5 1
 * Output 2:
 * 80 10
 * Note: There is no space after the minimum value in the output format.
 * There is only a single space between the maximum and minimum value.
 */
public class _Q3MaxMin {
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