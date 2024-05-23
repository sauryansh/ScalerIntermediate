package com.modulas;

import java.util.*;

public class RepeatAndMissingNumberArray {
    public static void main(String[] args) {
        System.out.println(new RepeatAndMissingNumberArray().repeatedNumber(new ArrayList<>(Arrays.asList( 7, 3, 4, 5, 5, 6, 1 ))));
        System.out.println(new RepeatAndMissingNumberArray().repeatedNumber1(new ArrayList<>(Arrays.asList( 7, 3, 4, 5, 5, 6, 1 ))));
        System.out.println(new RepeatAndMissingNumberArray().repeatedNumber2(new ArrayList<>(Arrays.asList( 7, 3, 4, 5, 5, 6, 1 ))));
    }

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int num : A) {
            if (result.get(num - 1) > 0) {
                repeatingNumber = num;
            } else {
                result.set(num - 1, result.get(num - 1) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (result.get(i) == 0) {
                missingNumber = i + 1;
                break;
            }
        }

        ArrayList<Integer> resultArray = new ArrayList<>();
        resultArray.add(repeatingNumber);
        resultArray.add(missingNumber);
        return resultArray;
    }
    public ArrayList<Integer> repeatedNumber1(final List<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int num : A) {
            boolean addElement = seen.add(num);
            if (!addElement) {
                repeatingNumber = num;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                missingNumber = i;
                break;
            }
        }

        result.add(repeatingNumber);
        result.add(missingNumber);
        return result;
    }
    //Altering the Main ArrayList
    public ArrayList<Integer> repeatedNumber2(final List<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();

        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int i = 0; i < n; i++) {
            int num = Math.abs(A.get(i));
            if (A.get(num - 1) < 0) {
                repeatingNumber = num;
            } else {
                A.set(num - 1, -A.get(num - 1));
            }
        }

        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0) {
                missingNumber = i + 1;
                break;
            }
        }

        result.add(repeatingNumber);
        result.add(missingNumber);
        return result;
    }

}
