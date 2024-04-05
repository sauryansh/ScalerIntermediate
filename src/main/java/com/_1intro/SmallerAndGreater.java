package com._1intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SmallerAndGreater {
    public static void main(String[] args) {
        SmallerAndGreater smallerAndGreater= new SmallerAndGreater();
        System.out.println(smallerAndGreater.solve1(new ArrayList<>(Arrays.asList(5,4,3,1))));
    }

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int count =0;
        Collections.sort(A);
        for(int i=1;i<=n-2;i++){
            if(
                    (A.get(0)<A.get(i))
                            &&
                            (A.get(i)<A.get(n-1))
            ){
                System.out.println(A.get(i));
                count++;
            }
        }
        return count;
    }

    public int solve1(ArrayList<Integer> A){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i:A){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        int result = 0;

        for (int i:A ){
            if(i>min && i<max){
                result++;
            }
        }

        return result;
    }
}
