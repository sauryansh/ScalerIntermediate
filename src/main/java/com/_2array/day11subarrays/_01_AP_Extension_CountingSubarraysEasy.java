package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Problem Description
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum strictly greater than B.
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
 * Return an integer denoting the number of subarrays in A having sum strictly greater than B.
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
 *  The subarrays with sum greater than B are {5,6} and {2,5,6}
 * Explanation 2:
 *  1, 11, 2, 3, 15
 *  The subarrays with sum greater than B are {1,11}, {1,11,2},{1, 11, 2, 3},{1, 11, 2, 3, 15},
 *  {11},{11, 2},{11, 2, 3}, {11, 2, 3, 15}, {2, 3, 15},{3, 15} and {15}
 */
public class _01_AP_Extension_CountingSubarraysEasy {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1, 11, 2, 3, 15));
        System.out.println(new _01_AP_Extension_CountingSubarraysEasy()
                .solve(in,10)
        );
    }


    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int countForLessThanK = getCountForLessThanK(A, B, n);
        int countForEqualToK = getCountForEqualToK(A, B, n);
        int totalSubarray = n*(n+1)/2;
        return totalSubarray - countForEqualToK-countForLessThanK;
    }

    private int getCountForEqualToK(ArrayList<Integer> in, int B, int n) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //Number of time that sum has occurred
        for(int j=0;j<n;j++){
            sum += in.get(j);
            if(map.containsKey(sum -B)){
                ans += map.get(sum-B);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    private static int getCountForLessThanK(ArrayList<Integer> A, int B, int n) {
        int countForLessThanK = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += A.get(right);

            while (sum >= B && left <= right) {
                sum -= A.get(left);
                left++;
            }

            countForLessThanK += (right - left + 1);
        }
        return countForLessThanK;
    }
}
