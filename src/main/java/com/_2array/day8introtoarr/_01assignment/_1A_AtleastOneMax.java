package com._2array.day8introtoarr._01assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class _1A_AtleastOneMax {
    public static void main(String[] args) {
        _1A_AtleastOneMax a1AtleastOneMax = new _1A_AtleastOneMax();
        ArrayList<Integer> in= new ArrayList<>(Arrays.asList(-3,-2,6,8,4,8,5));
        System.out.println(a1AtleastOneMax.solve1(in));
    }

    public int solve(ArrayList<Integer> source){
        int max = Integer.MIN_VALUE;

        for (Integer value : source) {
            if (value >= max) {
                max = value;
            }
        }

        int countOfMax= 0;

        for (Integer integer : source) {
            if (integer == max) {
                countOfMax++;
            }
        }

        return source.size()-countOfMax;
    }
    //One Iteration Solution ANS: 5
    public int solve1(ArrayList<Integer> source){
        int max = Integer.MIN_VALUE;
        int countOfMax= 0;

        for (Integer integer : source) {
            if (integer >= max) {
                if (integer == max) {
                    countOfMax++;
                } else {
                    max = integer;
                    countOfMax = 1;
                }
            }
        }

        return source.size()-countOfMax;
    }
}
