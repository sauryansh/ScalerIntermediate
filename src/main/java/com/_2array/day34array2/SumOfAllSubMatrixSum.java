package com._2array.day34array2;

import java.util.Arrays;

public class SumOfAllSubMatrixSum {

    public static void main(String[] args) {
        SumOfAllSubMatrixSum solution = new SumOfAllSubMatrixSum();

        // Test case matrix
//        int[][] matrix = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//        };
      int[][] matrix = {
            {1,5,2,3},
            {7,2,3,4},
            {3,4,3,5},
            {8,4,2,3}
        };



        // Calculate and print the sum of all submatrices
        int totalSum = solution.submatrixSum(matrix);
        System.out.println("Sum of all submatrices: " + totalSum);

        System.out.println(new SumOfAllSubMatrixSum().submatrixSumOP(matrix));
        System.out.println(new SumOfAllSubMatrixSum().submatrixSumBF(matrix));
    }

    public int[][] prefixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize prefix sum matrix
        int[][] prefixSum = new int[m + 1][n + 1];

        // Calculate prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        return prefixSum;
    }

    public int submatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Calculate prefix sum matrix
        int[][] prefixSum = prefixSum(matrix);
        System.out.println(Arrays.deepToString(prefixSum));

        // Compute sum of all submatrices
        int totalSum = 0;
        for (int top = 1; top <= m; top++) {
            for (int left = 1; left <= n; left++) {
                for (int bottom = top; bottom <= m; bottom++) {
                    for (int right = left; right <= n; right++) {
                        totalSum += prefixSum[bottom][right]
                                - prefixSum[top - 1][right]
                                - prefixSum[bottom][left - 1]
                                + prefixSum[top - 1][left - 1];
                    }
                }
            }
        }

        return totalSum;
    }

    public int submatrixSumBF(int[][] matrix){
        int rowLen = matrix.length;
        int colLen=matrix[0].length;
        int sum=0;
        for(int i=0;i<rowLen;i++){
            for (int j = 0; j < colLen; j++) {
                for (int k = 0; k < rowLen; k++) {
                    for (int l = 0; l<colLen; l++) {
                        for (int m = i; m <=k; m++) {
                            for (int n = j; n <= l; n++) {
                                sum+=matrix[m][n];
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    public int submatrixSumOP(int[][] matrix){
        int rowLen = matrix.length;
        int colLen=matrix[0].length;
        int sum=0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                sum+= matrix[i][j]*
                        (   (i+1)*(j+1)    *   (rowLen-i)*(colLen-j)
                        );
            }
        }
        return sum;
    }


}
