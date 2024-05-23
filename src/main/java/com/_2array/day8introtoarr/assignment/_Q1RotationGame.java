package com._2array.day8introtoarr.assignment;

import java.util.Scanner;

/**
 * Q1. Rotation Game
 * Solved
 * feature icon
 * Get your doubts resolved blazing fast with Chat GPT Help
 * Check Chat GPT
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 * Given an integer array A of size N and an integer B, you have to print the same array after rotating it B times towards the right.
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 * 1 <= A[i] <=108
 * 1 <= B <= 109
 *
 *
 * Input Format
 * There are 2 lines in the input
 *
 * Line 1: The first number is the size N of the array A. Then N numbers follow which indicate the elements in the array A.
 *
 * Line 2: A single integer B.
 *
 *
 * Output Format
 * Print array A after rotating it B times towards the right.
 *
 *
 * Example Input
 * Input 1 :
 * 4 1 2 3 4
 * 2
 *
 *
 * Example Output
 * Output 1 :
 * 3 4 1 2
 *
 *
 * Example Explanation
 * Example 1 :
 *
 * N = 4, A = [1, 2, 3, 4] and B = 2.
 *
 * Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
 *
 * Final array = [3, 4, 1, 2]
 */
public class _Q1RotationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfIteration = sc.nextInt();
        int arr[] = new int[numOfIteration];
        for(int i=0;i<numOfIteration;i++){
            arr[i] = sc.nextInt();
        }
        int rotation = sc.nextInt();

        int[] solve = new _Q1RotationGame().solve1(arr, numOfIteration, rotation%numOfIteration);

        for (int i:solve){
            System.out.print(i+" ");
        }
    }

    private int[] solve(int[] arr, int size, int rotation) {
        int result[] = new int[size];

        for(int i=0;i<size;i++){
            if(i<rotation){
                result[i]=arr[size+i-rotation];
            }else {
                result[i]=arr[i-rotation];
            }
        }
        return result;
    }

    private int[] solve1(int[] arr, int size, int rotation){
        int result[] = new int[size];
        for (int i=0;i<size;i++){
            int newIndex= (i+rotation)%size;
            result[newIndex] = arr[i];
        }

        return result;

    }

    private int[] solve2(int[] arr, int size, int rotation){
        int n = arr.length;
        rotation=rotation%n;

        reverse(arr,0,n-1);
        reverse(arr,0,rotation-1);
        reverse(arr,rotation,n-1);
        return arr;
    }

    private void reverse(int[] arr, int start, int end) {
        while(start<end){
            arr[start]= arr[start]+arr[end];
            arr[end]=arr[start]-arr[end];
            arr[start]=arr[start]-arr[end];
            start++;
            end--;
        }

    }
}