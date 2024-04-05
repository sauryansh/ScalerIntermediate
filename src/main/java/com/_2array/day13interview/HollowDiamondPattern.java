package com._2array.day13interview;

import java.util.Scanner;

public class HollowDiamondPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inp = scanner.nextInt();
        int n = 2 * inp;

        // Upper half of the diamond
        for (int i = 0; i < n / 2; i++) {
            // Print asterisks before the hollow part
            for (int j = 0; j < n / 2 - i; j++) {
                System.out.print("*");
            }
            // Print spaces for the hollow part
            for (int j = 0; j < i * 2; j++) {
                System.out.print(" ");
            }
            // Print asterisks after the hollow part
            for (int j = n / 2 + i; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = 0; i < n / 2; i++) {
            // Print asterisks before the hollow part
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces for the hollow part
            for (int j = 0; j < (n / 2 - i - 1) * 2; j++) {
                System.out.print(" ");
            }
            // Print asterisks after the hollow part
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}




