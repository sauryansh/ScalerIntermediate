package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * You are given an integer array C of size A.
 * Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 *
 *
 * Problem Constraints
 * 1 <= A <= 10^3
 * 1 <= B <= 10^9
 * 1 <= C[i] <= 10^6
 *
 *
 * Input Format
 * The first argument is the integer A.
 * The second argument is the integer B.
 * The third argument is the integer array C.
 *
 * Output Format
 * Return a single integer which denotes the maximum sum.
 *
 *
 * Example Input
 * Input 1:
 * A = 5
 * B = 12
 * C = [2, 1, 3, 4, 5]
 * Input 2:
 *
 * A = 3
 * B = 1
 * C = [2, 2, 2]
 *
 *
 * Example Output
 * Output 1:
 * 12
 * Output 2:
 * <p>
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 * We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
 * Explanation 2:
 *
 * All elements are greater than B, which means we cannot select any subarray.
 * Hence, the answer is 0.
 */
public class _04_A_MaximumSubarrayEasy {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(2, 3, 4, 5,1));
        System.out.println(new _04_A_MaximumSubarrayEasy()
                .maxSubarray(5,8,in)
        );
        System.out.println(new _04_A_MaximumSubarrayEasy()
                .maxSubarray1(5,8,in)
        );
        System.out.println(new _04_A_MaximumSubarrayEasy()
                .maxSubarraySum2(5,8,in)
        );
    }
    public int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int maxSum = 0;
        int localSum = maxSum;
        int idx = 0;

        for (int i = 0; i < A; i++) {
            localSum = localSum + C.get(i);
            while (localSum > B) {
                localSum = localSum - C.get(idx);
                idx++;
            }
            if (maxSum < localSum) {
                maxSum = localSum;
            }
        }
        return maxSum;
    }
    /**
     * TC: O(n^2) and SC:O(1)
     * Iteration: O(n^2) --> Finding maxSum
     */
    public int maxSubarray1(int A, int B, ArrayList<Integer> C) {
        int maxSum = 0;
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += C.get(j);
                if (sum <= B)
                    maxSum = Math.max(maxSum, sum);
                else
                    break;
            }
        }
        return maxSum;
    }

    /**
     * TC: O(n^2) and SC:O(n)
     * Iteration:   O(n) --> For Prefix Iteration
     *              O(n^2) --> Finding maxSum
     */
    public int maxSubarraySum2(int A,int B,ArrayList<Integer> C){
        //Prefix Sum calculation
        int []pfSum = new int[A];
        for(int i=0;i<A;i++){
            if(i==0){
                pfSum[i] = C.get(i);
            }else{
                pfSum[i] = pfSum[i-1]+C.get(i);
            }
        }
        //- If the first element of the array C is less than or equal to B,
        // the maximum sum maxsum is initialized with the value of the first element of C.
        //- Otherwise, maxsum is initialized with 0.
        int maxSum;
        if(C.get(0)<=B){
            maxSum=C.get(0);
        }else{
            maxSum=0;
        }
        //  The function iterates through all possible starting indices i of the subarray.
        //  For each starting index i, it iterates through all possible ending indices j of the subarray.
        //  It calculates the sum of the subarray from index i to j using the prefix sum array pfsum.
        //  If the sum of the current subarray is greater than maxsum and less than or equal to B,
        //  maxsum is updated with the sum of the current subarray.

        for(int i=0;i<A;i++){
            for(int j=i;j<A;j++){
                int subarrSum;
                if(i==0){
                    subarrSum=pfSum[j];
                }else{
                    subarrSum=pfSum[j]-pfSum[i-1];
                }
                if (subarrSum > maxSum && subarrSum <= B) {
                    maxSum = subarrSum;
                }
            }
        }
        return maxSum;
    }
}
/**
 * ans = 0
 * for(start = 0, start < size; start += 1)
 *     sum = 0
 *     for(end = start; end < size; end += 1)
 *         sum += array[end]
 *         if(sum <= MaximumValue)
 *             ans = max(sum, ans)
 *         else
 *             break
 */