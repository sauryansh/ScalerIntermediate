package com.modulas;

public class A_BandModulo {
    public static void main(String[] args) {
        System.out.println(new A_BandModulo().solve(5,9));
    }
    public int solve(int A, int B) {
        return Math.abs(A-B);
    }
}
