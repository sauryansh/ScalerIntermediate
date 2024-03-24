package com._2array.day8introtoarr;

import java.util.ArrayList;
import java.util.Arrays;

public class _3AP_MinimumPicks {
    public static void main(String[] args) {
        System.out.println(new _3AP_MinimumPicks().solve(new ArrayList<>(Arrays.asList(5, 17, 100, 1))));
    }
    public int solve(ArrayList<Integer> A) {
      int n = A.size();
      int maxEven = Integer.MIN_VALUE;
      int minOdd = Integer.MAX_VALUE;
      for (int i=0;i<n;i++){
          if(A.get(i)%2==0){
            maxEven=Math.max(maxEven,A.get(i));
          }else {
            minOdd=Math.min(minOdd,A.get(i));
          }
      }
      return maxEven-minOdd;
    }
}
