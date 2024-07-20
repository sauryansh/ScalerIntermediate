package com._2array.day33array1.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _02_C_BeggarOutsideTempleII {
    public static void main(String[] args) {
        int N = 5; // Number of beggars 7
        int M = 3; // Number of devotees
        //int[][] donations = {{1, 3, 3}, {4, 6, 2}, {2, 5, 1}}; // Beggar start and end indexes and their donation amounts
        int[][] donations = {{1,2,10}, {2,3,20}, {2, 5, 25}};
        int[] beggars = beggarsOutsideTempleLevel1(N, M, donations);
        System.out.println(Arrays.toString(beggars)); // Output: [0, 5, 7, 7, 2, 10, 10]
        int[] beggars1 = beggarsOutsideTempleLevel2(N, M, donations);
        System.out.println(Arrays.toString(beggars1)); // Output: [0, 5, 7, 7, 2, 10, 10]
// Donation amounts for each beggar
        ArrayList<ArrayList<Integer>> donations1 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,2,10)),
                new ArrayList<>(Arrays.asList(2,3,20)),
                new ArrayList<>(Arrays.asList(2,5,25))
        ));
        ArrayList<Integer> result = new _02_C_BeggarOutsideTempleII().beggarsOutsideTempleLevel3(N, donations1);

        System.out.println("Beggars' collections:");
        System.out.println(result);
    }

    public static int[] beggarsOutsideTempleLevel1(int N, int M, int[][] donations) {
        int[] beggars = new int[N]; // Initialize an array to store beggars' collections
        for (int i = 0; i < M; i++) {
            int startIndex = donations[i][0]; // Start Index of the beggar
            int endIndex = donations[i][1]; // End Index of the beggar
            int donation = donations[i][2]; // Donation amount
            for(int j=startIndex;j<=endIndex;j++){
                beggars[j-1]+=donation;
            }
        }
        return beggars;
    }
    //TC: O(N^2)
    //SC: O(1)


    public static int[] beggarsOutsideTempleLevel2(int N, int M, int[][] donations) {
        int[] beggars = new int[N]; // Initialize an array to store beggars' collections
        for(int i=0;i<M;i++){
            int startIndex = donations[i][0]; // Start Index of the beggar
            int endIndex = donations[i][1]; // End Index of the beggar
            int donation = donations[i][2]; // Donation amount
            // Increment the collection of the start index beggar
            beggars[startIndex-1] += donation;
            // Decrement the collection of the end index  beggar (if within array bounds)
            if (endIndex < N) {
                beggars[endIndex] -= donation;
            }
        }
        for (int i = 1; i < N; i++) {
            beggars[i] += beggars[i - 1]; // Calculate prefix sum
        }
        return beggars;
    }
    //TC: O(N)
    //SC: O(1)

    public ArrayList<Integer> beggarsOutsideTempleLevel3(int A, ArrayList<ArrayList<Integer>> B) {
        //A is number of the number of beggars and number of devotee - M
        int M = B.size();
        ArrayList<Integer> beggars = new ArrayList<>(Collections.nCopies(A,0));

        for (ArrayList<Integer> integers : B) {
            int startIndex = integers.get(0);
            int endIndex = integers.get(1);
            int donation = integers.get(2);
            //Increasing the value of beggars at start index
            beggars.set(startIndex-1, beggars.get(startIndex-1) + donation);

            if (endIndex < A) {
                beggars.set(endIndex, beggars.get(endIndex) - donation);
            }
        }

        for(int i=1;i<A;i++){
            beggars.set(i,beggars.get(i)+beggars.get(i-1));
        }

        return beggars;
    }
}


