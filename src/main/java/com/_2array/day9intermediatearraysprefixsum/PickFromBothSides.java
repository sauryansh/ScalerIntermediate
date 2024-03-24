package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PickFromBothSides {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, -2, 3 , 1, 2));
        //System.out.println(new PickFromBothSides().solve(A,3));
        System.out.println(new PickFromBothSides().solve1(A,3));
    }
    public int solve(ArrayList<Integer> A, int B) {
        int size = A.size();
        ArrayList<Integer> prefixSum = new ArrayList<>(Collections.nCopies(size,0));
        prefixSum.set(0, A.get(0));
        for(int i=1;i<size;i++){
            prefixSum.set(i,prefixSum.get(i-1)+A.get(i));
        }
        //System.out.println(prefixSum);
        ArrayList<Integer> suffixSum = new ArrayList<>(Collections.nCopies(size,0));
        suffixSum.set(size-1,A.get(size-1));

        //System.out.println(suffixSum);

        int result = Math.max(prefixSum.get(B-1), suffixSum.get(size - B));

        for(int i=1;i<B;i++){
            int sum = prefixSum.get(i-1)+suffixSum.get(size-B +i);
            if(sum>result){
                result = sum;
            }
        }
        return result;
    }

    public int solve1(ArrayList<Integer> A, int B){
        int n = A.size();
        int curr = 0;

        for (int i = 0; i < B; i++) {
           curr+=A.get(i);
        }

        int back = B - 1;
        int ans = curr;
        for(int j = n - 1 ; j >= n-B; j--){
            curr += A.get(j);
            curr -= A.get(back);
            back--;
            ans = Math.max(ans, curr);
        }
        return ans;
    }

}
