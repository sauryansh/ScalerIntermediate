package com._2array.day33array1;

import java.util.ArrayList;
import java.util.Collections;

public class Flip {
    public static void main(String[] args) {
        System.out.println(new Flip().flip("110000111001"));
        System.out.println(new Flip().flip("111"));
    }

    public ArrayList<Integer> flip(String A) {
        int current_sum = 0;
        int max_sum = 0;
        int left = 0;
        int right = 0;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(2,-1));
        //basic kadane's algorithm implementation
        for(int i = 0 ; i < A.length() ; i++){
            if(A.charAt(i) == '1')
                current_sum--;
            else
                current_sum++;
            if(current_sum > max_sum){
                result.set(0, left+1);
                result.set(1, right+1);
                max_sum = current_sum;
            }
            if(current_sum < 0) {
                current_sum = 0;
                left = i+1;
                right = i+1;
            }
            else
                right++;
        }
        if(max_sum == 0){
            return new ArrayList<>();
        }
        else return result;
    }
}
