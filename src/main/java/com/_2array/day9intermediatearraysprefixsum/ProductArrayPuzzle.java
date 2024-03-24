package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProductArrayPuzzle {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(new ProductArrayPuzzle().solve(A));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int size = A.size();
        ArrayList<Integer> prefixPrd = new ArrayList<>(Collections.nCopies(size,0));
        ArrayList<Integer> suffixPrd = new ArrayList<>(Collections.nCopies(size,0));

        prefixPrd.set(0,A.get(0));
        for (int i = 1; i < size; i++) {
            prefixPrd.set(i,prefixPrd.get(i-1)*A.get(i));
        }
        suffixPrd.set(size-1,A.get(size-1));
        for (int i = size-2; i >=0 ; i--) {
            suffixPrd.set(i, suffixPrd.get(i+1)*A.get(i));
        }
        System.out.println("Prefix Product: "+prefixPrd);
        System.out.println("Suffix Product: "+suffixPrd);

        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(size,0));

        for (int i=0;i<size;i++){
            if(i==0){
                result.set(i,suffixPrd.get(i+1));
                System.out.println("Index: "+i+" suffixPrd: "+suffixPrd.get(i+1));
            } else if (i==size-1) {
                result.set(i, prefixPrd.get(i-1));
                System.out.println("Index: "+i+" prefixPrd: "+prefixPrd.get(i-1));
            } else {
                result.set(i, prefixPrd.get(i-1)* suffixPrd.get(i+1));
                System.out.println("Index: "+i+" prefixPrd: "+prefixPrd.get(i-1)+" suffixPrd: "+suffixPrd.get(i+1));
            }
            //System.out.println("Index: "+i+" Result: "+result.get(i));
        }
        return result;
     }
}

