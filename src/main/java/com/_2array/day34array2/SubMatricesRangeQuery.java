package com._2array.day34array2;

import java.util.Arrays;

public class SubMatricesRangeQuery {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] queries = {
                {0, 0, 1, 1}, // Top-left: (0, 0), Bottom-right: (1, 1)
                {1, 1, 2, 2}  // Top-left: (1, 1), Bottom-right: (2, 2)
        };
        SubMatricesRangeQuery submatrixSum = new SubMatricesRangeQuery();
        System.out.println(submatrixSum.getSubmatrixSum(matrix, queries)); // Output: 28

    }

    public int getSubmatrixSum(int [][]matrix, int [][]queries){
        int m = matrix.length;
        int n = matrix[0].length;

        int [][]rowPrefixSum = new int[m][n];
        //Calculate prefix sum for each row
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rowPrefixSum[i][j] = matrix[i][j] + (j>0?rowPrefixSum[i][j-1]:0);
            }
        }

        System.out.println("rowPrefixSum: "+Arrays.deepToString(rowPrefixSum));

        int totalSum =0;
        for(int []query  : queries){
            int topLeftRow =query[0];
            int topLeftCol = query[1];
            int bottomRightRow = query[2];
            int bottomRightCol = query[3];
            int submatrixSum = 0;
            // Iterate over rows in the submatrix
            for (int i = topLeftRow; i <= bottomRightRow; i++) {
                // Calculate row sum using prefix sum
                int rowSum = rowPrefixSum[i][bottomRightCol];
                if (topLeftCol > 0) {
                    rowSum -= rowPrefixSum[i][topLeftCol - 1];
                }
                // Add row sum to submatrix sum
                submatrixSum += rowSum;
            }
            // Add submatrix sum to total sum
            totalSum += submatrixSum;
        }

        return totalSum;
    }
}
