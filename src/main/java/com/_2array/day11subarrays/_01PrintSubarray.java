package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _01PrintSubarray {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1,2,3,4));
        //System.out.println(new PrintSubarray().printSubarray(in));
        System.out.println(Arrays.deepToString(new _01PrintSubarray().printSubarray1(new int[]{1,2,3,4})));
    }

    public ArrayList<ArrayList<Integer>> printSubarray(ArrayList<Integer> A){
        int size = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int k=i;k<=j;k++){
                    temp.add(A.get(k));
                }
                result.add(temp);
            }
        }
        return result;
    }

    public int[][][] printSubarray1(int[] A) {
        int size = A.length;
        int[][][] result = new int[size][size][];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int[] temp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    temp[k - i] = A[k];
                }
                result[i][j] = temp;
            }
        }
        return result;
    }

}
