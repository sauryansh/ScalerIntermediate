package com._2array.day33array1.assignment;

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

public class _01_C_MaxSumContiguousSubarray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(5,6,7,-3,2,-10,-12,8,12,21));
        //List<Integer> A = new ArrayList<>(Arrays.asList(-10,-9,-8,-7,-1));
        System.out.println(new _01_C_MaxSumContiguousSubarray().maxSubArray(A));
        System.out.println(new _01_C_MaxSumContiguousSubarray().maxSubArrayOptimise(A));
    }
    //TLE: Constraint 1<=n<=10^6 , O(N^2) will compute to 10^12 iteration
    public int maxSubArray(final List<Integer> A) {
        int max_sum = Integer.MIN_VALUE;
        int size = A.size();
        int startIdx = 0;
        int endIdx = 0;
        for(int start=0;start<size;start++){
            int sum =0;
            for(int end=start;end<size;end++){
                sum+=A.get(end);
                if (sum > max_sum) {
                    max_sum = sum;
                    startIdx = start;
                    endIdx = end;
                }
            }
        }
        System.out.println("Start index: " + startIdx);
        System.out.println("End index: " + endIdx);
        return max_sum;
    }

    public int maxSubArrayOptimise(final List<Integer> A) {
        int curr_sum =0;
        int max_sum = Integer.MIN_VALUE;
        int startIdx = 0;
        int endIdx = 0;
        int tempStartIdx = 0;
        for (int i=0;i<A.size();i++) {
            curr_sum += A.get(i);
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                startIdx = tempStartIdx;
                endIdx = i;
            }
            if (curr_sum < 0) {
                curr_sum = 0;
                tempStartIdx = i + 1;
            }
        }
        System.out.println("Start index: " + startIdx);
        System.out.println("End index: " + endIdx);
        return max_sum;
    }
}
