package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO:Problem Description
Find the maximum sum of contiguous non-empty subarray within an array A of length N.
Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000

Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.

Example Input
Input 1:

 A = [1, 2, 3, 4, -10]
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]


Example Output
Output 1:

 10
Output 2:

 6


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6.

 */

public class _01_A_MaxSumContiguousSubarray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(4,-1,2,1));
        System.out.println(new _01_A_MaxSumContiguousSubarray().maxSubArray(A));
        System.out.println(new _01_A_MaxSumContiguousSubarray().maxSubArrayOptimise(A));
    }
    //TLE: Constraint 1<=n<=10^6 , O(N^2) will compute to 10^12 iteration
    public int maxSubArray(final List<Integer> A) {
        int result = Integer.MIN_VALUE;
        int size = A.size();
        for(int i=0;i<size;i++){
            int sum =0;
            for(int j=i;j<size;j++){
                sum+=A.get(j);
                result=Math.max(sum,result);
            }
        }

        return result;
    }

    public int maxSubArrayOptimise(final List<Integer> A) {
        int curr_sum =0;
        int max_sum = Integer.MIN_VALUE;
        for (Integer integer : A) {
            curr_sum += integer;
            max_sum = Math.max(curr_sum, max_sum);
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        return max_sum;
    }
}
