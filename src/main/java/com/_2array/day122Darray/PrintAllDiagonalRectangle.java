package com._2array.day122Darray;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PrintAllDiagonalRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col=sc.nextInt();
        System.out.println("Enter the value for row: "+row+" and column: "+col);
        int [][]twoDMatrix = new int[row][col];

        fillMatrixWithRandomValues(twoDMatrix);
        // Print the matrix
        print2dArray(twoDMatrix);
        printAllDiagonal(twoDMatrix,twoDMatrix.length,twoDMatrix[0].length);
        System.out.println(getAllDiagonals(twoDMatrix,twoDMatrix.length,twoDMatrix[0].length));

    }

    private static void print2dArray(int[][] twoDMatrix) {
        System.out.println("=================");
        for (int i = 0; i < twoDMatrix.length; i++) {
            for (int j = 0; j < twoDMatrix[0].length; j++) {
                System.out.print(twoDMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========== =======");
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
    private static void printAllDiagonal(int[][] twoDMatrix, int row, int col) {
        // Print diagonals starting from the top row
        for (int j = 0; j < col; j++) {
            int x = 0; //row fixed
            int y = j; //column changingb
            while (x < row && y >= 0) {
                System.out.print(twoDMatrix[x][y]+ " ");
                x++;
                y--;
            }
            System.out.println();
        }

        // Print diagonals starting from the right column, skipping the first diagonal (top-right to bottom-left)
        for (int i = 1; i < row; i++) {
            int x = i;
            int y = col - 1;
            while (x < row && y >= 0) {
                System.out.print(twoDMatrix[x][y]+ " ");
                x++;
                y--;
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> getAllDiagonals(int[][] twoDMatrix, int row, int col) {
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();

        // Process diagonals starting from the top row
        for (int j = 0; j < col; j++) {
            int x = 0; // Starting row
            int y = j; // Starting column
            ArrayList<Integer> diagonal = new ArrayList<>();
            while (x < row && y >= 0) {
                diagonal.add(twoDMatrix[x][y]);
                x++;
                y--;
            }
            diagonals.add(diagonal);
        }

        // Process diagonals starting from the right column, skipping the first diagonal (top-right to bottom-left)
        for (int i = 1; i < row; i++) {
            int x = i; // Starting row
            int y = col - 1; // Starting column
            ArrayList<Integer> diagonal = new ArrayList<>();
            while (x < row && y >= 0) {
                diagonal.add(twoDMatrix[x][y]);
                x++;
                y--;
            }
            diagonals.add(diagonal);
        }

        // Fill missing elements with 0s
        int maxDiagonalSize = Math.min(row, col);
        for (ArrayList<Integer> diagonal : diagonals) {
            while (diagonal.size() < maxDiagonalSize) {
                diagonal.add(0);
            }
        }

        return diagonals;
    }

}
