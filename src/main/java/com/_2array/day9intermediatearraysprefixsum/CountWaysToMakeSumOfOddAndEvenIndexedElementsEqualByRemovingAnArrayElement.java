package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement{
    public static void main(String[] args) {
        CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement
                countWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement=
                new CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement();
        //ArrayList<Integer> integers= new ArrayList<>(Arrays.asList(2, 1, 6, 4));
        ArrayList<Integer> integers= new ArrayList<>(Arrays.asList(1,2,3,7,1,2,3));
        //ArrayList<Integer> integers= new ArrayList<>(Arrays.asList(4,3,2,7,6,-2));
        //ArrayList<Integer> integers= new ArrayList<>(Arrays.asList(1,2,3,7,1,2,3));
        System.out.println(countWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement.solve(integers));
    }

    public int solve(ArrayList<Integer> A) {
        int size = A.size();
        ArrayList<Integer> prefixOddSum = new ArrayList<>(Collections.nCopies(size, 0));
        ArrayList<Integer> prefixEvenSum = new ArrayList<>(Collections.nCopies(size, 0));
        prefixEvenSum.set(0, A.get(0));

        for (int i = 1; i < size; i++) {
            if ((i&1)== 0) {
                prefixEvenSum.set(i, prefixEvenSum.get(i - 1) + A.get(i));
                prefixOddSum.set(i, prefixOddSum.get(i - 1));
            } else {
                prefixOddSum.set(i, prefixOddSum.get(i - 1) + A.get(i));
                prefixEvenSum.set(i, prefixEvenSum.get(i - 1));
            }
        }

        int count = 0;

        for (int i = 0; i < size; i++) {
            int oddSum = 0;
            int evenSum = 0;
            if (i == 0) {
                evenSum = prefixOddSum.get(size - 1);
                oddSum = prefixEvenSum.get(size - 1) - A.get(i);
                count = getCount(count, oddSum, evenSum);
            } else if (i == size - 1) {
                if (size % 2 == 0) { // Last element in an even-length array
                    evenSum = prefixEvenSum.get(size - 2);
                    oddSum = prefixOddSum.get(size - 1) - A.get(size - 1);
                } else { // Last element in an odd-length array
                    evenSum = prefixEvenSum.get(size - 1) - A.get(size - 1);
                    oddSum = prefixOddSum.get(size - 2);
                }
                count = getCount(count, oddSum, evenSum);
            } else {
                evenSum = prefixEvenSum.get(i - 1) + prefixOddSum.get(size - 1) - prefixOddSum.get(i);
                oddSum = prefixOddSum.get(i - 1) + prefixEvenSum.get(size - 1) - prefixEvenSum.get(i);
                count = getCount(count, oddSum, evenSum);
            }
        }
        return count;
    }

    private static int getCount(int count, int oddSum, int evenSum) {
        if (evenSum == oddSum) {
            count++;
        }
        return count;
    }



}
