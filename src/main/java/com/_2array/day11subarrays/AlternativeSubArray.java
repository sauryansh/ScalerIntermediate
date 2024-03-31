package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternativeSubArray {
    public static void main(String[] args) {
        System.out.println(new AlternativeSubArray().solve(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1)), 1));
        System.out.println(new AlternativeSubArray().solve(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 0, 1)), 0));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        int len = 2 * B + 1;
        for (int i = 0; i < n - len + 1; i++) {
            //logic for checking alternative subarray
            int curr = -1;
            int flag = 1;
            for (int j = i; j < i + len; j++) {
                if (A.get(j) == curr) {
                    flag = 0;
                    break;
                }
                curr = A.get(j);
            }
            if (flag == 1) {
                result.add(i + B);
            }
        }

        return result;
    }
}

