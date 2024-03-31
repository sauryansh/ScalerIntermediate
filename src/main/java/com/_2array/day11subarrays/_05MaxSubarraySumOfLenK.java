package com._2array.day11subarrays;

public class _05MaxSubarraySumOfLenK {
    public static void main(String[] args) {
        int []nums = new int[]{-3,4,-2,5,3,-2,8,2,-1,4};
        System.out.println(new _05MaxSubarraySumOfLenK().maxSubarraySumOfLengthK(nums,5));
        System.out.println(new _05MaxSubarraySumOfLenK().maxSubarraySumOfLengthKWithNoSpace(nums,5));
    }

    public int maxSubarraySumOfLengthK(int[] nums, int k) {
        int n = nums.length;
        int []pfsum= new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                pfsum[i]=nums[i];
            }else{
                pfsum[i]=pfsum[i-1]+nums[i];
            }
        }

        int start =0;int end =k-1;
        int result = Integer.MIN_VALUE;
        for(;start<=n-k;start++,end++){
            int sum = 0;
            if(start==0){
                sum = pfsum[start];
            }else{
                sum = pfsum[end]-pfsum[start-1];
            }
            result=Math.max(result,sum);
        }
        //System.out.println("start: "+(start-1)+ " end: "+(end-1));
        return result;
    }


    public int maxSubarraySumOfLengthKWithNoSpace(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        //Storing sum of first K numbers
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }

        int result = Integer.MIN_VALUE;
        result=Math.max(result, sum);
        int start =1;
        int end = k;

        for(;start<n-k;start++,end++){
            sum=sum-nums[start-1]+nums[end];
            result=Math.max(result, sum);
        }
        //System.out.println("start: "+(start+1)+ " end: "+(end+1));
        return result;
    }
}
