package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Collections;

public class _07_A_SpiralOrderMatrixII {
    public static void main(String[] args) {
        System.out.println(new _07_A_SpiralOrderMatrixII().generateMatrix(5));
    }
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int totalElement=A;
        //Fill the matrix from 1 to A^2
        int count = 1;
        int row = A;
        int col = A;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //Define array of size n
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>(Collections.nCopies(col, 0));
            result.add(list);
        }

        //start from index 0 till centre
        int start = 0;
        int end = 0;
        while (A > 1) {
            //Print top row from Left to Right
            for (int k = 1; k < A; k++) {
                result.get(start).set(end, count);
                count++;
                end++;
            }
            //Right to Bottom
            for (int k = 1; k < A; k++) {
                result.get(start).set(end, count);
                count++;
                start++;
            }
            //Bottom to Left
            for (int k = 1; k < A; k++) {
                result.get(start).set(end, count);
                count++;
                end--;
            }

            //left to top
            for (int k = 1; k < A; k++) {
                result.get(start).set(end, count);
                count++;
                start--;
            }

            start++;end++;
            A-=2;
        }
        if((totalElement&1)==1){
            result.get(start).set(end, count);
        }
        return result;
    }


}
