package com._2array.day122Darray;

import java.util.*;

public class _02_A_AntiDiagonals {
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

        System.out.println(new _02_A_AntiDiagonals().diagonal(twoDMatrix1));

    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int row = A.size();
        int col = A.get(0).size();
        //Upper half of diagonal
        for(int j=0;j<col;j++){
            int fx_row=0;
            int vr_col=j;
            ArrayList<Integer> diagonal = new ArrayList<>();
            while(fx_row<row && vr_col>=0){
                diagonal.add(A.get(fx_row).get(vr_col));
                fx_row++;
                vr_col--;
            }
            result.add(diagonal);
        }
        //Bottom half
        for(int i=1;i<row;i++){
            int vr_row =i;
            int fx_col = col-1;
            ArrayList<Integer> diagonal = new ArrayList<>();
            while(vr_row<row && fx_col>=0){
                diagonal.add(A.get(vr_row).get(fx_col));
                vr_row++;
                fx_col--;
            }
            result.add(diagonal);
        }
        // Fill missing elements with 0s
        int maxDiagonalSize = Math.min(row, col);
        for (ArrayList<Integer> diagonal : result) {
            while (diagonal.size() < maxDiagonalSize) {
                diagonal.add(0);
            }
        }
        return result;
    }

    private static void fillMatrixWithRandomValues(ArrayList<ArrayList<Integer>> matrix) {Random random = new Random();

        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);

            for (int j = 0; j < row.size(); j++) {
                row.set(j, random.nextInt(100)); // Set random values to the elements of the row
            }
        }
    }
}
