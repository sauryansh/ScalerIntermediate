package com._2array.day9intermediatearraysprefixsum;

public class PrefixOddCount {

    public static int[] constructPrefixOddArray(int[] nums) {
        int n = nums.length;
        int[] prefixOdd = new int[n];
        prefixOdd[0] = 0;

        for (int i = 1; i < n; i++) {
            if((i&1)==1){
                prefixOdd[i] = prefixOdd[i-1]+nums[i];
            }else{
                prefixOdd[i] = prefixOdd[i-1];
            }
        }

        return prefixOdd;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,1,5};
        int[] prefixOdd = constructPrefixOddArray(nums);

        System.out.println("Constructed Prefix Odd Array:");
        for (int i = 0; i < prefixOdd.length; i++) {
            System.out.println("Index " + i + ": " + prefixOdd[i]);
        }
    }
}
