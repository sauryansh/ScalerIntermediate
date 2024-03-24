package com._2array.day11subarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _02PrintSubArrayInRange {
    public static void main(String[] args) {
        ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(3,4,2,-1,6,7,8,9,3,2,-1,4));
        ArrayList<ArrayList<Integer>> results = new _02PrintSubArrayInRange().printSubarray(alist, 5);
        System.out.println(results);

        for(ArrayList<Integer> list : results){
            System.out.println(alist.subList(list.get(0),list.get(1)+1));
        }
    }

    private ArrayList<ArrayList<Integer>> printSubarray(ArrayList<Integer> alist, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int size = alist.size();
        int start = 0;
        int end = k-1;

/*        while(start<=size-k){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);
            start++;
            end++;
            result.add(temp);
        }*/
        for(start=0,end=k-1;start<size-k;start++,end++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);
            result.add(temp);
        }
        return result;
    }
}

/**
 * TC: O(N)
 * SC: O(N*2)
 */