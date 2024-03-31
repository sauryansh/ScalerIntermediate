package com._2array.day122Darray;

import java.util.ArrayList;

public class RotateMatrix {
    public void solve(ArrayList<ArrayList<Integer>> A) {
        squareTranspose(A);
        reverseRow(A);
    }

    private void reverseRow(ArrayList<ArrayList<Integer>> A) {
        int row_size= A.size();
        for(int row=0;row<row_size;row++){
            int start =0;
            int end = row_size-1;
            while(start<end){
                A.get(row).set(start,A.get(row).get(start)^A.get(row).get(end));
                A.get(row).set(end,A.get(row).get(end)^A.get(row).get(start));
                A.get(row).set(start,A.get(row).get(start)^A.get(row).get(end));
                start++;
                end--;
            }
        }
    }

    private void squareTranspose(ArrayList<ArrayList<Integer>> A) {
        for(int row=0;row<A.size();row++){
            for(int col=row+1;col<A.get(0).size();col++){
                swap(A,row,col);
            }
        }
    }

    private void swap(ArrayList<ArrayList<Integer>> A, int row, int col) {
        if(row!=col){
            A.get(row).set(col, A.get(row).get(col)^A.get(col).get(row));
            A.get(col).set(row, A.get(row).get(col)^A.get(col).get(row));
            A.get(row).set(col, A.get(row).get(col)^A.get(col).get(row));
        }
    }

}
