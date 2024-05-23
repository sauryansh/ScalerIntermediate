package com._2array.day8introtoarr.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Q4A_ReverseArray {
    // DO NOT MODIFY THE LIST. IT IS READ-ONLY
    public static void main(String[] args) {
        _Q4A_ReverseArray a4AReverseArray = new _Q4A_ReverseArray();
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1,2,3,2,2,4));
        System.out.println(a4AReverseArray.solve(in));
    }
    public ArrayList<Integer> solve(final List<Integer> A) {
        int n = A.size();

        ArrayList<Integer> listOfInteger = new ArrayList<>(A.size());
        listOfInteger.addAll(A);


        for(int i=0;i<n/2;i++){
            int temp = listOfInteger.get(i);
            listOfInteger.set(i, listOfInteger.get(n-i-1));
            listOfInteger.set(n-i-1,temp);
        }
        return listOfInteger;
    }
}
