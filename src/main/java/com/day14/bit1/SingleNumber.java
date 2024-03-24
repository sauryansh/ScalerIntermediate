package com.day14.bit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber= new SingleNumber();
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,2,3,1));
        System.out.println(singleNumber.singleNumber(arrayList));
    }

    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for(int i=0;i<A.size();i++) {
            result = result ^ A.get(i);
        }
        return result;
    }
}
