package com._2array.day122Darray;

import java.util.Random;

public class BoundaryElement {
    public static void main(String[] args) {
        int [][]matrix = new int[5][5];
        fillMatrixWithRandomValues(matrix);
        print2dArray(matrix);
        boundaryMatrix(matrix);
    }

    public static void boundaryMatrix(int matrix[][]) {
        int n = matrix.length;

        int i = 0;
        int j = 0;

        while (n > 1) {
            // Print top row from left to right
            for (int k = 1; k < n; k++) {
                System.out.print(matrix[i][j] + "-->");
                j++;
            }
            //System.out.println("\n"+i+" "+j);
            for (int k = 1; k < n; k++) {
                System.out.print(matrix[i][j] + "-->");
                i++;
            }
            //System.out.println("\n"+i+" "+j);
            for (int k = 1; k < n; k++) {
                System.out.print(matrix[i][j] + "-->");
                j--;
            }
            //System.out.println("\n"+i+" "+j);
            for (int k = 1; k < n; k++) {
                System.out.print(matrix[i][j] + "-->");
                i--;
            }
            //System.out.println("\n"+i+" "+j);
            i++;j++;
            n-=2;
        }
        //System.out.println("\n"+i+" "+j);

        if((n&1)==1){
            System.out.print(matrix[i][j]);
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
