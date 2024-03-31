package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Arrays;

public class RowToColumnZero {
    public static void main(String[] args) {
        //[1,2,3,4]
        //[5,6,7,0]
        //[9,2,0,4]

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(3);
        result.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        result.add(new ArrayList<>(Arrays.asList(5, 6, 7, 0)));
        result.add(new ArrayList<>(Arrays.asList(9, 2, 0, 4)));
        System.out.println(result);
        System.out.println(new RowToColumnZero().solve1(result));
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        boolean[] zeroRow = new boolean[n];
        boolean[] zeroCol = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (zeroRow[i]) {
                for (int j = 0; j < m; j++) {
                    A.get(i).set(j, 0);
                }
            }
        }

        for (int j = 0; j < m; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < n; i++) {
                    A.get(i).set(j, 0);
                }
            }
        }

        return A;
    }

    public ArrayList<ArrayList<Integer>> solve1(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();

        boolean[] zeroRow = new boolean[row];
        boolean[] zeroCol = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A.get(i).get(j) == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if (zeroRow[i]) {
                for (int j = 0; j < col; j++) {
                    A.get(i).set(j, 0);
                }
            }
        }

        for (int j = 0; j < col; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < row; i++) {
                    A.get(i).set(j, 0);
                }
            }
        }

        return A;
    }
}
