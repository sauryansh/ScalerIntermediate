package com._2array.day8introtoarr._01assignment;

import java.util.*;

/**
 * Q2. Good Pair
 * Solved
 * feature icon
 * Get your doubts resolved blazing fast with Chat GPT Help
 * Check Chat GPT
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 * Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
 *
 *
 *
 * Problem Constraints
 * 1 <= A.size() <= 104
 *
 * 1 <= A[i] <= 109
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return 1 if good pair exist otherwise return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1,2,3,4]
 * B = 7
 * Input 2:
 *
 * A = [1,2,4]
 * B = 4
 * Input 3:
 *
 * A = [1,2,2]
 * B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 * Output 3:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  (i,j) = (3,4)
 * Explanation 2:
 *
 * No pair has sum equal to 4.
 * Explanation 3:
 *
 *  (i,j) = (2,3)
 */
public class _Q2GoodPair {
    public static void main(String[] args) {
        //ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1,2,4));

        _Q2GoodPair a2GoodPair = new _Q2GoodPair();
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
