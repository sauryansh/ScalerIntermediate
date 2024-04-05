package com._2array.day33array1;

import java.util.ArrayList;

public class _02_AP_MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int size = A.size();
        long maxSum= 0;// maximum sum of sub-array
        int maxLength = 0; // Maximum length of subarray
        int start = -1; // Starting index of the maximum sum subarray
        int curStart = 0; // Starting index of the current subarray
        long curSum = 0; // Current sum of subarray

        for(int i=0;i<A.size();i++){
            if(A.get(i)>=0){
                //Expand sub-array
                if(start==-1){
                    curStart=i;
                }
            }else{
                // Update maximum sum subarray if the current sum is greater or if there's a tie
                if (curSum > maxSum || (curSum == maxSum && i - curStart > maxLength)) {
                    maxSum = curSum;
                    maxLength = i - curStart;
                    start = curStart;
                }
                // Reset the current sum and current start index
                curSum = 0;
                curStart = i + 1;
            }
        }


        return result;
    }
}
