package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeSumQuery {
    public static void main(String[] args) {
        RangeSumQuery rangeSumQuery= new RangeSumQuery();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(0, 3)));
        B.add(new ArrayList<>(Arrays.asList(1,2)));
        System.out.println(rangeSumQuery.rangeSum(A,B));
    }
    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int size = A.size();
        ArrayList<Long> prefixSum = new ArrayList<>();
        prefixSum.add(Long.valueOf(A.get(0)));

        for (int i=1;i<size;i++){
            prefixSum.add(prefixSum.get(i-1)+A.get(i));
        }

        //System.out.println(prefixSum);

        ArrayList<Long> result = new ArrayList<>();

        for (ArrayList<Integer> query: B){
            int l = query.get(0);
            int r = query.get(1);

            if (l==0){
                result.add(prefixSum.get(r));
            }else {
                result.add(prefixSum.get(r)-prefixSum.get(l-1));
            }
        }
        return result;
    }
}
