package com._2array.day34array2;

import java.util.Arrays;

public class SumMatrixSumQueries {
    public static void main(String[] args) {
        // Sample input
        int[][] A1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] B1 = {1, 2};
        int[] C1 = {1, 2};
        int[] D1 = {2, 3};
        int[] E1 = {2, 3};

        SumMatrixSumQueries solution = new SumMatrixSumQueries();
        int[] result1 = solution.solve(A1, B1, C1, D1, E1);
        System.out.println(Arrays.toString(result1)); // Output: [12, 28]

        int[][] A2 = {
                {5, 17, 100, 11},
                {0, 0, 2, 8}
        };
        int[] B2 = {1, 1};
        int[] C2 = {1, 4};
        int[] D2 = {2, 2};
        int[] E2 = {2, 4};
        int[] result2 = solution.solve(A2, B2, C2, D2, E2);
        System.out.println(Arrays.toString(result2)); // Output: [22, 19]
    }

    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int row = A.length,
                col = A[0].length,
                mod = 1000*1000*1000+7;

        long[][] preSum = new long[row+1][col+1];
        //preSum[i][j] denotes the sum of elements of matrix (0, 0) to (i, j)
        for(int i = 1; i <= row ; i++){
            for(int j = 1; j <= col; j++){
                preSum[i][j] = (
                                    A[i-1][j-1]
                                        + preSum[i-1][j]
                                            + preSum[i][j-1]
                                                - preSum[i-1][j-1]
                                                    + mod
                                ) % mod;
            }
        }
        int[] res = new int[B.length];
        for(int i = 0; i < B.length; i++){
            int top = B[i], left = C[i], bottom = D[i], right = E[i];
            long ans = preSum[bottom][right] //x2,y2
                        - preSum[bottom][left-1] //x2,y1-1
                            - preSum[top-1][right]//x1-1,y2
                                + preSum[top-1][left-1]; //x1-1,y1-1
            while(ans < 0)
                ans += mod;
            ans = ans % mod;
            res[i] = (int)ans;
        }
        return res;
    }
}


