package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;
//Problem Description
//Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
//1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
//2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
//Your task is to find the count of good subarrays in A.
//
//
//Problem Constraints
//1 <= len(A) <= 5 x 103
//1 <= A[i] <= 103
//1 <= B <= 107
//
//
//Input Format
//The first argument given is the integer array A.
//The second argument given is an integer B.
//
//
//Output Format
//Return the count of good subarrays in A.
//
//
//Example Input
//Input 1:
//A = [1, 2, 3, 4, 5]
//B = 4
//Input 2:
//
//A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
//B = 65
//
//
//Example Output
//Output 1:
//6
//Output 2:
//
//36
//
//
//Example Explanation
//Explanation 1:
//Even length good subarrays = {1, 2}
//Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
//Explanation 1:
//There are 36 good subarrays
public class _02_AP_GoodSubarraysEasy {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9));
        System.out.println(new _02_AP_GoodSubarraysEasy().solve(in,65));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        int[] pfSum = getPfSum(A, n);

        //finding subarray
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum;
                int size = j-i+1;
                //finding sum at given index i to j
                if(i==0) sum = pfSum[j];
                else sum = pfSum[j] - pfSum[i - 1];

                if((size&1)==1 && sum>B) count++;
                if((size&1)==0 && sum<B) count++;

            }
        }
        return count;
    }

    private static int[] getPfSum(ArrayList<Integer> A, int n) {
        int[] pfSum = new int[n];
        for(int i = 0; i< n; i++){
            if (i == 0) pfSum[i] = A.get(i);
            else pfSum[i] = pfSum[i - 1] + A.get(i);
        }
        return pfSum;
    }

}
