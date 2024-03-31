package com._2array.day122Darray;

import java.util.ArrayList;

public class MatrixScalarProduct {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int sum=0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                sum+=A.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }
}
