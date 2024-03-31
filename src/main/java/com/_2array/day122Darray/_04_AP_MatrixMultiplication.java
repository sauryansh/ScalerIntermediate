package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
//Problem Description
//You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and
// return the resultant matrix. (i.e. return the matrix AB).
//
//Matrix Multiplication
//
//
//Problem Constraints
//1 <= M, N, P <= 100
//
//-100 <= A[i][j], B[i][j] <= 100
//
//
//
//Input Format
//The first argument given is the 2-D integer matrix A.
//The second argument given is the 2-D integer matrix B.
//
//
//
//Output Format
//Return a 2D integer matrix denoting AB.
//
//
//
//Example Input
//Input 1:
//
//A = [[1, 2],
//     [3, 4]]
//B = [[5, 6],
//     [7, 8]]
//Input 2:
//
//A = [[1, 1]]
//B = [[2],
//     [3]]
//
//
//Example Output
//Output 1:
//
// [[19, 22],
//  [43, 50]]
//Output 2:
//
// [[5]]
//
//
//Example Explanation
//Explanation 1:
//
// image
//Explanation 2:
//
// [[1, 1]].[[2], [3]] = [[1 * 2 + 1 * 3]] = [[5]]
public class _04_AP_MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for matrix 1: ");
        int row1 = sc.nextInt();
        System.out.print("Enter the number of columns for matrix 1: ");
        int col1 = sc.nextInt();
        ArrayList<ArrayList<Integer>> twoDMatrix1 = new ArrayList<>();
        for (int i = 0; i < row1; i++) {
            twoDMatrix1.add(new ArrayList<>(Collections.nCopies(col1, 0)));
        }
        fillMatrixWithRandomValues(twoDMatrix1);

        System.out.print("Enter the number of rows for matrix 2: ");
        int row2 = sc.nextInt();
        System.out.print("Enter the number of columns for matrix 2: ");
        int col2 = sc.nextInt();
        ArrayList<ArrayList<Integer>> twoDMatrix2 = new ArrayList<>();
        for (int i = 0; i < row2; i++) {
            twoDMatrix2.add(new ArrayList<>(Collections.nCopies(col2, 0)));
        }
        fillMatrixWithRandomValues(twoDMatrix2);
        System.out.println(twoDMatrix1);
        System.out.println(twoDMatrix2);
        System.out.println(new _04_AP_MatrixMultiplication().solve(twoDMatrix1,twoDMatrix2));
    }

    private static void fillMatrixWithRandomValues(ArrayList<ArrayList<Integer>> matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                row.set(j, random.nextInt(100)); // Set random values to the elements of the row
            }
        }
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int rowA = A.size();
        int colA = A.get(0).size();

        int rowB = B.size();
        int colB = B.get(0).size();

        if (colA != rowB) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rowA; i++) {
            ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(colB, 0));
            result.add(list);
        }

        for (int row = 0; row < result.size(); row++) {
            for (int col = 0; col < result.get(0).size(); col++) {
                int sum = multipleMatricesCell(A, B, row, col);
                result.get(row).set(col, sum); // Set the sum in the correct cell (row, col) of the result matrix
            }
        }

        return result;
    }

    private static int multipleMatricesCell(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B, int row, int col) {
        int sum = 0;
        for (int k = 0; k < B.size(); k++) {
            sum += A.get(row).get(k) * B.get(k).get(col);
        }
        return sum;
    }
}
