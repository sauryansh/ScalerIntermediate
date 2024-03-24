package com._2array.day122Darray;

public class MatrixRotation180Direct {
    public static void rotate180(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = temp;
            }
        }
        if (n % 2 != 0) {
            int mid = n / 2;
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[mid][j];
                matrix[mid][j] = matrix[mid][n - 1 - j];
                matrix[mid][n - 1 - j] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\nAfter 180-degree rotation:");
        rotate180(matrix);
        printMatrix(matrix);
    }
}
