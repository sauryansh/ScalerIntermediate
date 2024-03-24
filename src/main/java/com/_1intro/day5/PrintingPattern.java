package com._1intro.day5;

import java.util.ArrayList;

public class PrintingPattern {
    public static void main(String[] args) {
        PrintingPattern printingPattern = new PrintingPattern();
        System.out.println(printingPattern.solve(3));
    }

    //Fill the rest with 0 example 1 0 0 0 0 for n =5
    //1 2 0 0 0
    //1 2 3 0 0
    //1 2 3 4 0
    //1 2 3 4 5
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i=1;i<=A;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j=1;j<=i;j++){
                temp.add(j);
            }
            for (int j=i+1;j<=A;j++){
                temp.add(0);
            }
            result.add(temp);
        }
        return result;
    }

    public int[][] solve1(int A) {
        int[][]newArr=new int[A][];
        for (int i = 1; i <=A; i++) {
            newArr[i-1]=new int[A];
            for (int j = 1; j <=i; j++) {
                newArr[i-1][j-1]=j;
            }
        }
        return newArr;
    }
}
