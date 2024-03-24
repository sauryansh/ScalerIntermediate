package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeToEquality {
    public static void main(String[] args) {
        TimeToEquality timeToEquality = new TimeToEquality();
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(2, 4, 1, 3, 2));
        System.out.println(timeToEquality.solve(A));;
    }
    public int solve(ArrayList<Integer> A) {
        int size = A.size();
        int maxElement = Integer.MIN_VALUE;
        int sumOfElement = 0;
        for(int i=0;i<size;i++){
            sumOfElement+=A.get(i);
            if(A.get(i)>maxElement){
                maxElement=A.get(i);
            }
        }

        return maxElement*size - sumOfElement;
    }
}
