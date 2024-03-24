package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04PrintSubarraySumForSubArray {
    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>(Arrays.asList(3,-1,0,2));
        //List<Integer> alist = new ArrayList<>(Arrays.asList(1,2,3));
        //new _04PrintSubarraySum().subarraySum(alist);
        //new _04PrintSubarraySum().subarraySumComputePrefix(alist);
        new _04PrintSubarraySumForSubArray().subarraySumCarryForward(alist);
        new _04PrintSubarraySumForSubArray().subarraySumOptimisation(alist);
    }

    private void subarraySum(List<Integer> A) {
        int size = A.size() ;
        long result = 0;
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                int sum =0;
                for(int k=i;k<=j;k++){
                    sum+=A.get(k);
                }
                System.out.println("Value of subarray from index start: "+i+" end: "+j +" sum is :" +sum);
            }
        }
    }
    private void subarraySumComputePrefix(List<Integer>A){
        int size = A.size() ;
        long result = 0;
        int []prefSum = new int[size];
        prefixSumCompute(A, size, prefSum); //TC: O(N) && SC: O(N)
        // Now compute the subarray sums
        for (int start = 0; start < size; start++) {
            for (int end = start; end < size; end++) {
                // Calculate the sum of subarray from start to end
                int sum;
                if (start > 0) {
                    sum = prefSum[end] - prefSum[start - 1];
                } else {
                    sum = prefSum[end];
                }
                // Add this sum to the result
                System.out.println("Value of subarray from index start: "+start+" end: "+end +" sum is :" +sum);

            }
        }
    }

    private void subarraySumCarryForward(List<Integer> A) {
        int size = A.size();
        long result = 0;
        int maxSubarraySum =A.get(0);
        // Iterate over all possible sub-arrays
        for (int start = 0; start < size; start++) {
            int currentSum = 0; // Initialize the sum for the current subarray
            for (int end = start; end < size; end++) {
                // Update the current sum by adding the current element
                currentSum += A.get(end);
                // Add the current sum to the result
                System.out.println("Value of subarray from index start: "+start+" end: "+end +" sum is :" +currentSum);
                maxSubarraySum=Math.max(maxSubarraySum,currentSum);
                result+=currentSum;
            }
        }

        System.out.println("Max Subarray sum: "+ maxSubarraySum);
        System.out.println("Total Subarray sum: "+ result);
    }

    private void subarraySumOptimisation(List<Integer> A) {
        int sum =0;
        int size = A.size();
        int left;
        int right;
        int result = 0;
        for(int i=0;i<size;i++){
            left=i+1;
            right=size-i;
            int count =left*right;
            result+= count*A.get(i);
        }

        System.out.println("Result: "+ result);
    }

    private static void prefixSumCompute(List<Integer> A, int size, int[] prefSum) {
        for(int i = 0; i< size; i++){
            if(i==0){
                prefSum[0]= A.get(0);
            }else{
                prefSum[i] = prefSum[i-1]+ A.get(i);
            }
        }
    }
}
