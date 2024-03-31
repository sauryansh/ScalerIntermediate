package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinorDiagonalSum {
    public static void main(String[] args) {
        List<ArrayList<Integer>> result = new ArrayList<>(3);
        result.add(new ArrayList<>(Arrays.asList(1, -2, -3)));
        result.add(new ArrayList<>(Arrays.asList(-4, 5, -6)));
        result.add(new ArrayList<>(Arrays.asList(-7, -8, 9)));
        System.out.println(new MinorDiagonalSum().solve(result));
    }
    public int solve(final List<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();
        int start=0;
        int end=col-1;
        int sum = 0;
        while(start<row && end>=0){
            sum+=A.get(start).get(end);
            start++;
            end--;
        }

        return sum;
    }
}
