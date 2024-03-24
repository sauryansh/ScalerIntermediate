package com._2array.day8introtoarr;

import java.util.ArrayList;
import java.util.Arrays;

public class _1AP_LittlePonnyAndMaximumElement {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(23,47,8,49,47,32,48,4,36,11,8,13,2,10,18,39,31,45,9,30));
        System.out.println(new _1AP_LittlePonnyAndMaximumElement().solve(in,5));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int count =0;
        if(!A.contains(B)){
            return -1;
        }
        for(int i=0;i<A.size();i++){
            if(A.get(i)>B){
                count++;
            }
        }
        return count;
    }
}
