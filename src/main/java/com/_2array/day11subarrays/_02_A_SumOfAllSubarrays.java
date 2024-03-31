package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * You are given an integer array A of length N.
 * You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
 * A subarray sum denotes the sum of all the elements of that subarray.
 *
 * Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Ai <= 10 4
 *
 *
 * Input Format
 * The first argument is the integer array A.
 *
 *
 * Output Format
 * Return a single integer denoting the sum of all subarray sums of the given array.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 *
 * A = [2, 1, 3]
 *
 *
 * Example Output
 * Output 1:
 * 20
 * Output 2:
 *
 * 19
 *
 *
 * Example Explanation
 * Explanation 1:
 * The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
 * Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20
 * Explanation 2:
 *
 * The different subarrays for the given array are: [2], [1], [3], [2, 1], [1, 3], [2, 1, 3].
 * Their sums are: 2 + 1 + 3 + 3 + 4 + 6 = 19
 */
public class _02_A_SumOfAllSubarrays {
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3};

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(new _02_A_SumOfAllSubarrays().subarraySum(list));
        System.out.println(new _02_A_SumOfAllSubarrays().subarraySumBF(list));
        System.out.println(new _02_A_SumOfAllSubarrays().subarraySum(arr));
    }
    public Long subarraySum(ArrayList<Integer> A) {
        long sum = 0L;
        int size = A.size();
        for (int i = 0; i < size; i++) {
            int left = i + 1;
            int right = size - i;
            long count = (long) left * right; // Calculate the count as a long
            sum += count * A.get(i).longValue(); // Multiply count with the value at A[i] and add to sum
        }
        return sum;
    }

    public long subarraySum(int[] A) {
        long ans = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - i;
            ans += (long)A[i] * left * right;
        }
        return ans ;
    }

    public Long subarraySumBF(ArrayList<Integer> A) {
        long sum =0L;
        int n = A.size();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for (int k = i; k <= j; k++) {
                    sum += A.get(k);
                }
            }
        }
        return sum;
    }
}
