package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Problem Description
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum less than B.
 * We may assume that there is no overflow.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 5 x 103
 *
 * 1 <= A[i] <= 1000
 *
 * 1 <= B <= 107
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of subarrays in A having sum less than B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 5, 6]
 *  B = 10
 * Input 2:
 *
 *  A = [1, 11, 2, 3, 15]
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
 * Explanation 2:
 *
 *  The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */
public class _01_AP_CountingSubarraysEasy {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1,11,2,3,15));
        System.out.println(new _01_AP_CountingSubarraysEasy()
                .solve(in,10)
        );        System.out.println(new _01_AP_CountingSubarraysEasy()
                .solve1(in,10)
        );
    }

    /**
     * In this implementation:
     *
     * We initialize count to 0 to keep track of the number of subarrays with a sum less than B.
     * We use two pointers, left and right, to represent the current subarray.
     * We initialize both pointers at the beginning of the array.
     * We iterate through the array using the right pointer.
     * At each step, we add the value of A[right] to sum.
     * If sum becomes greater than or equal to B, we enter a while loop to adjust sum by subtracting values from the subarray starting from index left until sum becomes less than B again. We also ensure that left does not exceed right.
     * We update count by adding the number of subarrays ending at right with a sum less than B. This is calculated as (right - left + 1) because each subarray ending at right contributes (right - left + 1) subarrays.
     * Finally, we return the count as the result.
     */
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += A.get(right);

            while (sum >= B && left <= right) {
                sum -= A.get(left);
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
    public int solve1(ArrayList<Integer> A, int B) {
        int n = A.size();
        int result = 0;
        ArrayList<Integer> prefixSum = new ArrayList<>(Collections.nCopies(n,0));
        prefixSumCompute(A, n, prefixSum);

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = prefixSum.get(j); //at 0 we won't do anything
                if(i>0){
                    sum -= prefixSum.get(i-1);
                }
                if(sum < B) result++;
            }
        }
        return result;
    }

    private static void prefixSumCompute(ArrayList<Integer> A, int n, ArrayList<Integer> prefixSum) {
        //Prefix Sum
        for(int i = 0; i< n; i++){
            if(i==0)
                prefixSum.set(i, A.get(i));
            else
                prefixSum.set(i, prefixSum.get(i-1)+ A.get(i));
        }
    }

}
