package com._2array.day9intermediatearraysprefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class _01AEquilibriumIndex {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<Integer>(Arrays.asList(-7,1,5,2,-4,3,0));
        ArrayList<Integer> B= new ArrayList<Integer>(Arrays.asList(1,2,3,7,1,2,3));
        //System.out.println(new EquilibriumIndex().solve(A));
        System.out.println(new _01AEquilibriumIndex().solve2(B));
        System.out.println(new _01AEquilibriumIndex().solve(B));
    }

    public int solve3(ArrayList<Integer> A){
        int size = A.size();
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));

        for(int i=1;i<size;i++){
            prefixSum.add(prefixSum.get(i-1)+A.get(i));
        }
        System.out.println(prefixSum);
        int c=-1;
        int left =-1;
        int right=-1;
        for (int i=0;i<size;i++){
            if(i==0){
                left=0;
            }else{
                left=prefixSum.get(i-1);
            }
            right=prefixSum.get(size-1)-prefixSum.get(i);

            if(left==right){
                c=i;
                break;
            }
        }
        return c;
    }
    public int solve2(ArrayList<Integer> A){
        int size = A.size();
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));

        for(int i=1;i<size;i++){
            prefixSum.add(prefixSum.get(i-1)+A.get(i));
        }
        System.out.println(prefixSum);
        int totalSum = prefixSum.get(size-1);
        for(int i=0;i<size;i++){
            //int leftSum = prefixSum.get(i)-A.get(i);
            int leftSum;
            if(i==0){
                leftSum=0;
            }else{
                leftSum= prefixSum.get(i-1);
            }

            int rightSum = totalSum - prefixSum.get(i);
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
    public int solve(ArrayList<Integer> A){
        int size = A.size();
        long totalSum = 0;
        for (Integer integer: A){
            totalSum+=integer;
        }
        long leftSum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            totalSum -=A.get(i);

            if(totalSum==leftSum){
                ans=i;
                break;
            }
            leftSum+=A.get(i);
        }

        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    //TC: O(n) SC: O(1)

    public int solve1(ArrayList<Integer> A) {
        int size = A.size();

        ArrayList<Integer> prefixSum = new ArrayList<>(Collections.nCopies(size,0));
        prefixSum.set(0,A.get(0));

        for(int i=1;i<size;i++){
            prefixSum.set(i,prefixSum.get(i-1)+A.get(i));
        }
        //System.out.println(prefixSum);

        ArrayList<Integer> suffixSum= new ArrayList<>(Collections.nCopies(size,0));
        suffixSum.set(size-1,A.get(size-1));

        //System.out.println(suffixSum);
        for(int i=size-2;i>=0;i--){
            suffixSum.set(i,suffixSum.get(i+1)+A.get(i));
        }
        //System.out.println(suffixSum);

        int equilibriumIndex = -1;

        for(int i=0;i<size;i++){
            if(Objects.equals(prefixSum.get(i), suffixSum.get(i))){
                return i;
            }
        }

        return equilibriumIndex;
    }
    //TC: O(n) SC: O(n)



}
