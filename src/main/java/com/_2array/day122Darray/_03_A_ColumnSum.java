package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class _03_A_ColumnSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int col = sc.nextInt();

        ArrayList<ArrayList<Integer>> twoDMatrix1 = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            twoDMatrix1.add(new ArrayList<>(Collections.nCopies(col, 0)));
        }
        fillMatrixWithRandomValues(twoDMatrix1);
        System.out.println(twoDMatrix1);

        System.out.println(new _03_A_ColumnSum().solve(twoDMatrix1));
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();

        for(int j=0;j<col; j++){
            int sum =0;
            for(int i=0;i<row;i++){
                sum+=A.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
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
}
