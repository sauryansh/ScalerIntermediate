package com._2array.day33array1;

import java.util.ArrayList;
import java.util.Arrays;

public class _02_AP_MaxNonNegativeSubArray {
    public static void main(String[] args) {
        //ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,5,-7,2,3));
        //ArrayList<Integer> input = new ArrayList<>(Arrays.asList(10, -1, 2, 3, -4, 100));//[100]
        //ArrayList<Integer> input = new ArrayList<>(Arrays.asList(-1,-1,-1,-1,-1)); //[]
        //ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0,0,-1,0));//[0, 0]
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1967513926,1540383426,-1303455736,-521595368));//[0, 0]
        System.out.println(new _02_AP_MaxNonNegativeSubArray().maxset(input));
    }
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int startIdx=-1;
        int endIdx=-1;
        int startIdxMax=-1;
        int endIdxMax=-1;
        long currSum = 0;
        long maxSum = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)>=0){
                if (startIdx == -1) {
                    startIdx = endIdx = i;
                } else {
                    endIdx = i;
                }
                currSum+=A.get(i);
                if((currSum>maxSum)||(currSum==maxSum && count<(endIdx-startIdx+1))){
                    startIdxMax=startIdx;
                    endIdxMax=endIdx;
                    maxSum=currSum;
                    count=endIdx-startIdx+1;
                }
            }else{
                startIdx=endIdx=i+1;
                currSum=0;
            }
        }
        if(startIdxMax!=-1 && endIdxMax!=-1){
            for(int i=startIdxMax;i<=endIdxMax;i++){
                result.add(A.get(i));
            }
        }

        return result;
    }
}
