package com._2array.day8introtoarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RotationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfIteration = sc.nextInt();
        int arr[] = new int[numOfIteration];
        for(int i=0;i<numOfIteration;i++){
            arr[i] = sc.nextInt();
        }
        int rotation = sc.nextInt();

        int[] solve = new RotationGame().solve1(arr, numOfIteration, rotation%numOfIteration);

        for (int i:solve){
            System.out.print(i+" ");
        }
    }

    private int[] solve(int[] arr, int size, int rotation) {
        int result[] = new int[size];

        for(int i=0;i<size;i++){
            if(i<rotation){
                result[i]=arr[size+i-rotation];
            }else {
                result[i]=arr[i-rotation];
            }
        }
        return result;
    }

    private int[] solve1(int[] arr, int size, int rotation){
        int result[] = new int[size];
        for (int i=0;i<size;i++){
            int newIndex= (i+rotation)%size;
            result[newIndex] = arr[i];
        }

        return result;

    }

    private int[] solve2(int[] arr, int size, int rotation){
        int n = arr.length;
        rotation=rotation%n;

        reverse(arr,0,n-1);
        reverse(arr,0,rotation-1);
        reverse(arr,rotation,n-1);
        return arr;
    }

    private void reverse(int[] arr, int start, int end) {
        while(start<end){
            arr[start]= arr[start]+arr[end];
            arr[end]=arr[start]-arr[end];
            arr[start]=arr[start]-arr[end];
            start++;
            end--;
        }

    }
}