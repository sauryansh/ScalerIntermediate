package com._2array.day8introtoarr;

import java.util.*;

public class _2A_GoodPair {
    public static void main(String[] args) {
        //ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1,2,4));

        _2A_GoodPair a2GoodPair = new _2A_GoodPair();
        System.out.println(a2GoodPair.solve2(in,4));
    }
    public int solve(ArrayList<Integer> A, int B) {
        int size = A.size();
        boolean result = false;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(A.get(i)+A.get(j)==B){
                    result = true;
                    break;
                }
            }
        }

        return  result ?1:0;
    }

    public int solve1(ArrayList<Integer> A, int B){
        int size = A.size();
        boolean result = false;
        int i = 1, j=0;
        for( i=1;i<size;++i){
            for( j=0;j<i;++j){
                if(A.get(i)+A.get(j)==B){
                    result = true;
                    break;
                }
            }
        }
        System.out.println("Pair i:" + (i-1) + " " + "Pair j:" + j);
        return result?1:0;
    }

    public int solve2(ArrayList<Integer> A, int B){
        HashMap<Integer,Integer> hm= new HashMap<>();
        int sizeOfArray = A.size();
        int flag =0;
        for(int i = 0; i< sizeOfArray; i++){
            int complement = B-A.get(i);
            if(hm.containsKey(complement)){
                //System.out.println("Pair i:" + i + " Pair j:" + hm.get(complement));
                flag =1;
                break;
            }
            hm.put(A.get(i),i);
        }
        return flag;
    }

    public int solve3(ArrayList<Integer> A, int B){
        HashSet<Integer> hs = new HashSet<>();
        int sizeOfArray = A.size();
        int flag =0;
        for (Integer integer : A) {
            int complement = B - integer;
            if (hs.contains(complement)) {
                flag = 1;
                break;
            }
            hs.add(integer);
        }
        return flag;
    }
}
/**
 * TODO: Notes to remember
 * For Each Loop to be used, where index is not a concerned.
 * When we have used for that index we need to use for-loop or indexed for loop.
 */
