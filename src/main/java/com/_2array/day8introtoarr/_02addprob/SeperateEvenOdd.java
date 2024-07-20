package com._2array.day8introtoarr._02addprob;

import java.util.ArrayList;
import java.util.Scanner;

public class SeperateEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0){
            int size = sc.nextInt();
            ArrayList<Integer> alist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                alist.add(sc.nextInt());
            }

            ArrayList<Integer> eList = new ArrayList<>();
            ArrayList<Integer> oList = new ArrayList<>();

            filterEvenOddList(alist, eList, oList);

            alist=null;
            eList=null;
            oList=null;
        }

    }

    private static void filterEvenOddList(ArrayList<Integer> alist, ArrayList<Integer> eList, ArrayList<Integer> oList) {
        for (Integer integer : alist) {
            if (integer % 2 == 0) {
                eList.add(integer);
            } else {
                oList.add(integer);
            }
        }
        for (Integer a : oList) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (Integer a : eList) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
