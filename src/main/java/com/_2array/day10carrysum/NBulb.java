package com._2array.day10carrysum;

import java.util.ArrayList;
import java.util.Arrays;

public class NBulb {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(1,1,0,1,0,0,1));
        System.out.println(new NBulb().solve(list));
    }

    public int solve(ArrayList<Integer> A){
        int n = A.size();
        int count=0;
        for(int i=0;i<n;i++){
            if(A.get(i)==0){
                count++;
                for(int j=i;j<n;j++){
                    A.set(j,1-A.get(j));
                }
            }
        }

        System.out.println(A);
        return count;
    }

    public int solve1(ArrayList<Integer> A){
        int n = A.size();
        int count =0;
        for (int i = 0; i < n; i++) {
            int state = A.get(i);
            if(count%2==0){
                state=A.get(i);
            }else {
                state=1-A.get(i);
            }

            if(state==0){
                count++;
            }
        }
        return count;
    }
}
