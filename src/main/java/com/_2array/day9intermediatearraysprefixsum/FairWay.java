package com._2array.day9intermediatearraysprefixsum;

public class FairWay {
    public int waysToMakeFair(int[] nums) {
        // [6,1,7,4,1]
        // cumulative sum from left = [6, 7, 14, 18, 19]
        // even sum = 6 + 7 + 1 = 14
        // odd sum = 1 + 4 = 5
        // toggle = 0
        // even = 14 - 6 = 8
        // way = 0
        // odd = 5 + 6 = 11

        // toggle = 1
        // odd = 11 - 1 = 10
        // even = 8 + 1 = 9

        // toggle = 0
        // even = 9 - 7 = 2
        // odd = 10 + 7 = 17

        // toggle = 1
        // odd = 17 - 4 = 13
        // even = 2 + 4 = 8

        // toggle = 0
        // even = 8 - 1 = 7
        // odd =

        int ways = 0;
        int totalOdd = 0;
        int totalEven = 0;

        for(int i = 0; i < nums.length; i+= 2) totalEven += nums[i];
        for(int i = 1; i < nums.length; i+= 2) totalOdd += nums[i];

        int toggle = 0;
        for(int n : nums){
            if(toggle == 1){
                totalOdd -= n;
                ways += (totalOdd == totalEven) ? 1 : 0;
                totalEven += n;
            }else{
                totalEven -= n;
                ways += (totalOdd == totalEven) ? 1 : 0;
                totalOdd += n;
            }
            toggle ^= 1;
        }

        return ways;
    }
}

/**
 * class Solution {
 *     public int waysToMakeFair(int[] nums) {
 *         int len = nums.length;
 *         int totalEvenSum = 0;
 *         int totalOddSum =0;
 *         int fairCount = 0;
 *
 *         for(int i=0;i<len;i++){
 *             if((i&1)==1){
 *                 totalOddSum +=nums[i] ;
 *             }else{
 *                 totalEvenSum+=nums[i];
 *             }
 *         }
 *
 *         int prefixEvenSum = 0;
 *         int prefixOddSum =0;
 *
 *         for(int i=0;i<len;i++){
 *             if((i&1)==1){
 *                 totalOddSum-=nums[i];
 *             }else{
 *                 totalEvenSum -= nums[i];
 *             }
 *
 *             if((prefixEvenSum+totalOddSum)==(prefixOddSum+totalEvenSum)){
 *                 fairCount++;
 *             }
 *
 *             if((i&1)==1){
 *                 prefixOddSum+=nums[i];
 *             }else{
 *                 prefixEvenSum+=nums[i];
 *             }
 *         }
 *
 *         return fairCount;
 *
 *     }
 * }
 */