package com._2array.day122Darray;

import java.util.Random;

public class Rotate270SquareMatrix {
    public static void main(String[] args) {
        int [][]matrix = new int[5][5];
        fillMatrixWithRandomValues(matrix);
        print2dArray(matrix);
        rotateBy270(matrix);
        print2dArray(matrix);

    }

    private static void rotateBy270(int[][] matrix) {
        int col = matrix[0].length;
        for (int i = 0; i < col; i++) {
            int start = 0;
            int end = col - 1;
            while(start<end){
                matrix[start][i] ^=matrix[end][i];
                matrix[end][i]^=matrix[start][i];
                matrix[start][i] ^=matrix[end][i];
                start++;
                end--;
            }
        }
    }


    private static void swap(int[][] matrix, int i, int j){
        if(i!=j){
            matrix[i][j]=matrix[i][j]^matrix[j][i];
            matrix[j][i]=matrix[i][j]^matrix[j][i];
            matrix[i][j]=matrix[i][j]^matrix[j][i];
        }
    }

    private static void fillMatrixWithRandomValues(int[][] twoDMatrix) {
        Random random = new Random();
        int row = twoDMatrix.length;
        int col = twoDMatrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                twoDMatrix[i][j] = random.nextInt(100); // Filling with random values between 0 and 99
            }
        }
    }
    private static void print2dArray(int[][] twoDMatrix) {
        System.out.println("=================");
        for (int i = 0; i < twoDMatrix.length; i++) {
            for (int j = 0; j < twoDMatrix[0].length; j++) {
                System.out.print(twoDMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=================");
    }
}
