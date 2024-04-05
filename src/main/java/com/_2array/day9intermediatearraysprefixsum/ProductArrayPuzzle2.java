package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProductArrayPuzzle2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new ProductArrayPuzzle2().solve(nums)));
        System.out.println(Arrays.toString(new ProductArrayPuzzle2().solve2(nums)));
    }

    public int[] solve(int[] nums) {
        int[]left = new int[nums.length];
        int[]right = new int[nums.length];
        int[]ans = new int[nums.length];

        left[0] = nums[0] ;
        for(int i = 1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i];
        }

        right[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i];
        }

        for(int i = 0;i<nums.length;i++){
            if(i==0)
                ans[i]=right[i+1];
            else if(i==nums.length-1)
                ans[i]=left[i-1];
            else
                ans[i] = left[i-1]*right[i+1];
        }

        return ans;
    }

    public int[] solve2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Calculate left product
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Calculate right product while computing final result
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return ans;
    }
}




