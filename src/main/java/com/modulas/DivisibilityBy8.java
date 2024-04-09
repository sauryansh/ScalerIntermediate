package com.modulas;

public class DivisibilityBy8 {
    public static void main(String[] args) {
        System.out.println(new DivisibilityBy8().solve("123"));
    }
    public int solve(String A) {
        int k = A.length();
        long base = 1; //10^0
        long ans = 0;
        int divisor = 8;
        for (int i = k - 1; i >= 0; i--) {
            ans = (ans + (A.charAt(i) - '0') * base) % divisor;
            base = (base * 10) % 8; //Track Power
        }
        return (int)ans==0?1:0;
    }
}
