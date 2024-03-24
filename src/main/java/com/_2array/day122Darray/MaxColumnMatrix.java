package com._2array.day122Darray;

import java.util.Scanner;

public class MaxColumnMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col=sc.nextInt();
        System.out.println("Enter the value for row: "+row+" and column: "+col);
        int [][]_2dMatrics = new int[row][col];



        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                _2dMatrics[i][j]=sc.nextInt();
            }
        }
        int maxSum =Integer.MIN_VALUE       ;
           for(int i=0;i<col;i++){
               int sum=0;
                for (int j=0;j<row;j++){
                    int element = _2dMatrics[j][i];
                    sum+= element;
                }
            maxSum= Math.max(maxSum,sum);
             }

        System.out.println("Max Sum :"+ maxSum);
    }
}
//