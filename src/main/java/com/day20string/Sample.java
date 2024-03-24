package com.day20string;

import java.util.Scanner;
//Longest increasing subarray
public class Sample {
    public static void main(String[] args) {
        int count = 1;
        int firstpos = 0;
        int lastpos = 0;

        int arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2};

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]) {
                  count++;

                if(i+1==arr.length-1) {
                    lastpos = i+1;
                }
            }else {
                firstpos = i;
            }
        }
        System.out.println("count: "+count);

        System.out.println("firstpos: "+firstpos +" lastpos: "+lastpos);
    }

    int fun(int n){
        int s=0;
        for (int i =1; i <=n; i+=2) {
            s+=i;
        }
        return s;
    }

    //
}
