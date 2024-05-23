package com._2array.day8introtoarr.addprob;

import java.util.ArrayList;
import java.util.Arrays;

public class _2AP_SecondLargest {
    public static void main(String[] args) {
        System.out.println(new _2AP_SecondLargest().solve(new
                ArrayList<>(Arrays.asList(13,7,16,18,14,17,18,8,10))));
    }
    public int solve(ArrayList<Integer> A){
        int max = Integer.MIN_VALUE;
        int nextMax= Integer.MIN_VALUE;

        for (Integer integer : A) {
            if (integer > max) {
                nextMax = max;
                max = integer;
            } else if (integer > nextMax && integer<max) {
                nextMax = integer;
            }
        }
        return nextMax==Integer.MIN_VALUE?-1:nextMax;
    }
}
