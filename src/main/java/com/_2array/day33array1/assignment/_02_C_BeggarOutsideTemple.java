package com._2array.day33array1.assignment;

import java.util.Arrays;

public class _02_C_BeggarOutsideTemple {
    public static void main(String[] args) {
        int N = 7; // Number of beggars
        int M = 3; // Number of devotees
        int[][] donations = {{1, 3}, {4, 2}, {2, 1}}; // Beggar indexes and their donation amounts

        int[] beggars = beggarsOutsideTempleLevel1(N, M, donations);
        System.out.println(Arrays.toString(beggars)); // Output: [0, 3, 4, 4, 6, 6, 6]
        int[] beggars1 = beggarsOutsideTempleLevel2(N, M, donations);
        System.out.println(Arrays.toString(beggars1)); // Output: [0, 3, 4, 4, 6, 6, 6]
    }

    public static int[] beggarsOutsideTempleLevel1(int N, int M, int[][] donations) {
        int[] beggars = new int[N]; // Initialize an array to store beggars' collections
        for (int i = 0; i < M; i++) {
            int index = donations[i][0]; // Index of the beggar
            int donation = donations[i][1]; // Donation amount
            for(int j=index;j<N;j++){
                beggars[j]+=donation;
            }
        }
        return beggars;
    }
    //TC: O(N^2)
    //SC: O(N)


    public static int[] beggarsOutsideTempleLevel2(int N, int M, int[][] donations) {
        int[] beggars = new int[N]; // Initialize an array to store beggars' collections
        for(int i=0;i<M;i++){
            int index = donations[i][0]; // Index of the beggar
            int donation = donations[i][1]; // Donation amount
            beggars[index] = donation;
        }
        for (int i = 1; i < N; i++) {
            beggars[i] += beggars[i - 1]; // Calculate prefix sum
        }
        return beggars;
    }
    //TC: O(N)
    //SC: O(1)
}


