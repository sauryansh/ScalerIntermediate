package com._2array.day8introtoarr._02addprob;

public class LeftRotationGame {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int rotation = 2;
 /*       int[] solve = solve(arr, arr.length, rotation);
        for (int i:solve){
            System.out.print(i+" ");
        }*/

        rotate(arr, arr.length, rotation);
    }

    private static int[] solve(int[] arr, int size, int rotation) {
        int[] temp = new int[size];
        int k=0;
        for (int i=rotation;i<size;i++){
            temp[k++]=arr[i];
        }
        for (int i=0;i<rotation;i++){
            temp[k++]=arr[i];
        }
        for (int i=0;i<size;i++){
            arr[i] = temp[i];
        }
        return arr;
    }

    public static void rotate(int[] arr, int size, int d){
        int p=0;
        while (p<d){
            int last = arr[0];
            for (int i=0;i<size-1;i++){
                arr[i]=arr[i+1];
            }
            arr[size-1]=last;
            p++;
        }

        for (int i: arr){
            System.out.print(i+ " ");
        }
    }

}
