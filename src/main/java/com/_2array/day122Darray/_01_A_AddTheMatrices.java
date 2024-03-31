package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Random;

/**
 * Problem Description
 *
 * You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
 * Note: Matrices are of same size means the number of rows and number of columns of both matrices are equal.
 *
 * The Following will give you an idea of matrix addition:
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size(), B.size() <= 1000 1 <= A[i].size(), B[i].size() <= 1000 1 <= A[i][j], B[i][j] <= 1000
 * Input Format
 *
 * The first argument is the 2D integer array A The second argument is the 2D integer array B
 * Output Format
 *
 * You have to return a vector of vector of integers after doing required operations.
 * Example Input
 *
 * Input 1:
 * A = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 *
 * B = [[9, 8, 7],
 *      [6, 5, 4],
 *      [3, 2, 1]]
 *
 * Input 2:
 * A = [[1, 2, 3],
 *      [4, 1, 2],
 *      [7, 8, 9]]
 *
 * B = [[9, 9, 7],
 *      [1, 2, 4],
 *      [4, 6, 3]]
 *
 * Example Output
 *
 * Output 1:
 * [[10, 10, 10],
 *  [10, 10, 10],
 *  [10, 10, 10]]
 * Output 2:
 * [[10, 11, 10],
 *  [5,   3,  6],
 *  [11, 14, 12]]
 * Example Explanation
 *
 * Explanation 1:
 * A + B = [[1+9, 2+8, 3+7],
 *          [4+6, 5+5, 6+4],
 *          [7+3, 8+2, 9+1]]
 *       = [[10, 10, 10],
 *          [10, 10, 10],
 *          [10, 10, 10]].
 * Explanation 2:
 * A + B = [[1+9, 2+9, 3+7],
 *          [4+1, 1+2, 2+4],
 *          [7+4, 8+6, 9+3]]
 *       = [[10, 11, 10],
 *          [5,   3,  6],
 *          [11, 14, 12]].
 */
public class _01_A_AddTheMatrices {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<>(3);
        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<>(3);
        fillMatrixWithRandomValues(matrix1,3);
        fillMatrixWithRandomValues(matrix2,3);
        print2dArray(matrix1);
        print2dArray(matrix2);
        ArrayList<ArrayList<Integer>> result = new _01_A_AddTheMatrices().solve(matrix1,matrix2);
        print2dArray(result);
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            result.add(new ArrayList<>());
            ArrayList<Integer> row = result.get(i); // Get the newly added row
            for(int j=0;j<A.get(0).size();j++){
                row.add(A.get(i).get(j)+B.get(i).get(j));
            }
        }
        return result;
    }

    private static void print2dArray(ArrayList<ArrayList<Integer>> matrix) {
        System.out.println("=================");
        for (ArrayList<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("=================");
    }

    private static void fillMatrixWithRandomValues(ArrayList<ArrayList<Integer>> matrix, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>()); // Add a new row
            ArrayList<Integer> row = matrix.get(i); // Get the newly added row

            for (int j = 0; j < size; j++) {
                row.add(random.nextInt(100)); // Add random values to the row
            }
        }
    }
}
