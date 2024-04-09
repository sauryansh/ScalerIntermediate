package com._2array.day34array2;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        MaxChunksToMakeSorted maxChunksToMakeSorted = new MaxChunksToMakeSorted();
        int []arr1= new int[]{4,3,2,1,0};
        int[] arr2 = new int[]{1, 0, 2, 3, 4};
        System.out.println(maxChunksToMakeSorted.maxChunksToSorted(arr1));
        System.out.println(maxChunksToMakeSorted.maxChunksToSortedII(arr2));
    }

    public int maxChunksToSorted(int[] arr) {
        int chunk = 0;
        int[] max = new int[arr.length];
        max[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (max[i] == i) {
                chunk++;
            }
        }
        return chunk;
    }


    public int maxChunksToSortedII(int[] arr) {
        int chunk = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunk++;
            }
        }
        return chunk;
    }

}
