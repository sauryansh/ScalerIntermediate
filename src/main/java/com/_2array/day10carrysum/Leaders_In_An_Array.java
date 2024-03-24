package com._2array.day10carrysum;

import java.util.ArrayList;
import java.util.Arrays;

public class Leaders_In_An_Array {
    public static void main(String[] args) {
        System.out.println(new Leaders_In_An_Array().solve(new ArrayList<>(Arrays.asList(16, 17, 4, 3, 5, 2))));
    }
    public ArrayList<Integer> solve1(ArrayList<Integer> A) {
        int size = A.size();
        ArrayList<Integer> result = new ArrayList<>();

        int maxElement = A.get(size-1);
        result.add(A.get(size-1));

        for(int i=size-2;i>=0;i--){
            if(A.get(i)>maxElement){
                result.add(A.get(i));
                maxElement=A.get(i);
            }
        }
        //Reverse the result
        int len = result.size();
        for(int i=0;i<len/2;i++){
            int temp = result.get(i);
            result.set(i,result.get(len-i-1));
            result.set(len-i-1,temp);
        }
        return result;
    }

        public ArrayList<Integer> solve(ArrayList<Integer> A) {
            ArrayList<Integer> leaders = new ArrayList<>();
            int n = A.size();

            for (int i = 0; i < n; i++) {
                int current = A.get(i);
                boolean isLeader = true;

                // Check if the current element is greater than all elements to its right
                for (int j = i + 1; j < n; j++) {
                    if (current <= A.get(j)) {
                        isLeader = false;
                        break;
                    }
                }

                // If the current element is greater than all elements to its right, add it as a leader
                if (isLeader) {
                    leaders.add(current);
                }
            }

            return leaders;
        }



}




