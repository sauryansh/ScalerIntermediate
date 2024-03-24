package com._2array.day9intermediatearraysprefixsum;

import java.util.Scanner;

public class PrefixSumBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int N = sc.nextInt();
        int[] arr = new int[N];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number of queries:");
        int Q = sc.nextInt();
        int[][] queries =new int [Q][2];

        // Input the queries
        for (int i = 0; i < Q; i++) {
            System.out.println("Enter the left and right indices of query " + (i + 1) + ":");
            queries[i][0] = sc.nextInt(); // left index
            queries[i][1] = sc.nextInt(); // right index
        }


        // Compute prefix sum for each query
        for (int i = 0; i < Q; i++) {
            int L = queries[i][0]; // left index of current query
            int R = queries[i][1]; // right index of current query

            int sum = 0;
            for (int j = L; j <= R; j++) {
                sum += arr[j];
            }
            System.out.println("Prefix sum for query " + (i + 1) + " Range ["+L+","+R+"]: " + sum);
        }


        sc.close();
    }
}
