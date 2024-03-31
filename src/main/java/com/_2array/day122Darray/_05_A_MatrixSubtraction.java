package com._2array.day122Darray;

import java.util.*;

public class _05_A_MatrixSubtraction {
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
        System.out.println(new _05_A_MatrixSubtraction().solve(twoDMatrix1,twoDMatrix2));
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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(A.get(0).size(),0));
            result.add(list);
        }
        for(int row=0;row<A.size();row++){
            for(int col=0;col<A.get(0).size();col++){
                int value = A.get(row).get(col)-B.get(row).get(col) ;
                result.get(row).set(col,value);
            }
        }

        return result;
    }
}
