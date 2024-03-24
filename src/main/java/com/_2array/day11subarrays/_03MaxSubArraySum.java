package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _03MaxSubArraySum {
    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>(Arrays.asList(-3,4,-2,5,3,-2,8,2,-1,4));
        System.out.println(new _03MaxSubArraySum().maxSubArray(alist, 5));
        System.out.println(new _03MaxSubArraySum().maxSubArray1(alist, 5));
        System.out.println(new _03MaxSubArraySum().maxSubArray2(alist, 5));
    }

    //Brute Force
    private Integer maxSubArray(List<Integer> A, int K) {
        int size = A.size();
        int start = 0;
        int end = K-1;
        int maxSum = Integer.MIN_VALUE;
        while(start<=size-K){
            int sum = 0;
            for(int i=start;i<=end;i++){
                sum+=A.get(i);
            }
            maxSum=Math.max(maxSum,sum);
            start++;
            end++;
        }
        return maxSum;
    }

    //Solution 2
    private Integer maxSubArray1(List<Integer> A, int k) {
        int size = A.size() ;
        int []prefSum = new int[size];

        prefixSumCompute(A, size, prefSum);

        int start =0;int end = k-1;
        int result = Integer.MIN_VALUE;

        while(start<=size-k){
            int sum  = getPrefixSum(start, prefSum, end);
            result=Math.max(result,sum);
            start++;
            end++;
        }
        return result;
    }

    private static int getPrefixSum(int start, int[] prefSum, int end) {
        int sum;
        if(start ==0){
            sum = prefSum[end];
        }else{
            sum = prefSum[end]- prefSum[start -1];
        }
        return sum;
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

    private Integer maxSubArray2(List<Integer> A, int k) {
        int sum =0;
        int size = A.size();
        for(int i=0;i<k;i++){
            sum+=A.get(i);
        }
        int result = sum;

        int start =1;
        int end = k;
        for(;start<size-k;start++,end++){
            sum=sum-A.get(start-1)+A.get(end);
            result=Math.max(sum,result);
        }
        System.out.println("start: "+(start+1)+ " end: "+(end+1));
        return result;
    }
}