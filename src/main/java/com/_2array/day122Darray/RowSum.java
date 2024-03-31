package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(3);
        //[1,2,3,4]
        //[5,6,7,8]
        //[9,2,3,4]
        result.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        result.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        result.add(new ArrayList<>(Arrays.asList(9,2,3,4)));

        System.out.println(new RowSum().solve(result));
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            int sum=0;
            for(int j=0;j<A.get(0).size();j++){
                sum+=A.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }
}
