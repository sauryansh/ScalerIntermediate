package com._2array.day122Darray;

import java.util.Random;

public class TransposeSquareMatrix {
    public static void main(String[] args) {
        int [][]matrix = new int[5][5];
        fillMatrixWithRandomValues(matrix);
        print2dArray(matrix);
        //squareMatrixTranspose(matrix);
        squareMatrixTransposeLT(matrix);
        print2dArray(matrix);

    }

    private static void squareMatrixTranspose(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                swap(matrix,i,j);
            }
        }
    }

    private static void squareMatrixTransposeLT(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<=i;j++){
                swap(matrix,i,j);
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
