package com._1intro;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MultiplicationTable multiplicationTable= new MultiplicationTable();
        multiplicationTable.printMultiplicationTable(scanner.nextInt());
    }

    private void printMultiplicationTable(int nextInt) {
        for (int i=1;i<=10;i++){
            System.out.println(nextInt +" * " +i +" = "+ nextInt*i);
        }
    }
}
