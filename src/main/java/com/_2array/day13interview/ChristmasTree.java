package com._2array.day13interview;

import java.util.ArrayList;
import java.util.Arrays;

public class ChristmasTree {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5,9,10,4,7,8));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5,6,4,7,2,5));
        System.out.println(new ChristmasTree().solve(A,B));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int minCost = Integer.MAX_VALUE;
        int n = A.size();

        for(int i=0;i<n;i++){
            int leftCost  =  Integer.MAX_VALUE;
            int rightCost =  Integer.MAX_VALUE;

            for(int left=0;left<i;left++){
                if(A.get(left)<A.get(i)){
                    leftCost=Math.min(leftCost,B.get(left));
                }
            }

            for(int right =i+1;right<n;right++){
                if(A.get(right)>A.get(i)){
                    rightCost =Math.min(rightCost,B.get(right));
                }
            }

            // Update minCost
            if (leftCost != Integer.MAX_VALUE && rightCost != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, leftCost + B.get(i) + rightCost);
            }
        }
        if (minCost == Integer.MAX_VALUE) {
            return -1;
        }

        return minCost;
    }
}
