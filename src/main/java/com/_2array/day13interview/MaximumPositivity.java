package com._2array.day13interview;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPositivity {
    public static void main(String[] args) {
        System.out.println(new MaximumPositivity().solve(new ArrayList<>(Arrays.asList(5,6,8,-1,1,2))));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int start = -1;
        int end = -1;
        int maxlen = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A.get(i) >= 0) {
                if (start == -1) {
                    start = end = i;
                } else {
                    end = i;
                }
            } else {
                start = end = -1;
            }

            if (start != -1 && end - start + 1 > maxlen) {
                maxlen = end - start + 1;
                result = new ArrayList<>(A.subList(start, end + 1));
            }
        }

        return result;
    }
}
