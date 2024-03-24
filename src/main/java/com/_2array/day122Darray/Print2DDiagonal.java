package com._2array.day122Darray;

import java.util.Scanner;

public class Print2DDiagonal {
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
        printDiagonalTLBR(_2dMatrics,row);
        System.out.println("=================");
        printDiagonalTRBL(_2dMatrics,row,col);
    }
//1 2 3 4 5 6 7 8 9
    private static void printDiagonalTRBL(int[][] dMatrics,int row,int col) {
        int start = 0; int end = col-1;
        while(start<row && end>=0){
            System.out.println("Element are: " +dMatrics[start][end]);
            start++;
            end--;
        }
    }

    private static void printDiagonalTLBR(int[][] dMatrics,int row) {
        for(int i=0;i<row;i++){
            System.out.println("Element are: "+ dMatrics[i][i]);
        }
    }
}
//