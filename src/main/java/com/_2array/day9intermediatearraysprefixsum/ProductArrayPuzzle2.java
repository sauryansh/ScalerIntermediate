package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProductArrayPuzzle2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new ProductArrayPuzzle2().solve(nums)));
    }

    public int[] solve(int[] nums) {
        int[]left = new int[nums.length];
        int[]right = new int[nums.length];
        int[]ans = new int[nums.length];

        left[0] = 1 ;
        for(int i = 1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }

        right[nums.length-1] = 1;
        for(int i = nums.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }

        for(int i = 0;i<nums.length;i++){
            ans[i] = left[i]*right[i];
        }

        return ans;




    }
}




