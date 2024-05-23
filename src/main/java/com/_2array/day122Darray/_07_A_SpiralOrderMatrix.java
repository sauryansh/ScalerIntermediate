package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.List;

public class _07_A_SpiralOrderMatrix {
    public static void main(String[] args) {
        System.out.println(new _07_A_SpiralOrderMatrix().generateMatrix(5,4));
    }

    private List<Integer> generateMatrix(int row, int col) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> matrix = new ArrayList<>();

        // Initialize the matrix with empty ArrayLists
        for (int i = 0; i < row; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < col; j++) {
                matrix.get(i).add(0); // Populate with initial value 0
            }
        }

        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        int value = 1;

        while (left <= right && top <= bottom) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                matrix.get(top).set(i, value);
                value++;
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                matrix.get(i).set(right, value);
                value++;
            }
            right--;

            // Traverse bottom row (if applicable)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix.get(bottom).set(i, value);
                    value++;
                }
                bottom--;
            }

            // Traverse left column (if applicable)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix.get(i).set(left, value);
                    value++;
                }
                left++;
            }
        }
        System.out.println(matrix);
        // Convert the 2D ArrayList into a 1D list (spiral order)
        for (List<Integer> list : matrix) {
            result.addAll(list);
        }
        return result;
    }

}
