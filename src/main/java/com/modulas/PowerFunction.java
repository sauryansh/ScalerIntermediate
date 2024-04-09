package com.modulas;

public class PowerFunction {
    public static void main(String[] args) {
        System.out.println(new PowerFunction().result(2, 5, 7));
        System.out.println(new PowerFunction().result1(2, 5, 7));
        System.out.println(new PowerFunction().power(2, 7 ));
    }

    private int result(int base, int power, int divisor) {
        if (power == 0) {
            return 1 % divisor;
        }
        long result = 1;
        long x = base % divisor;

        for (int i = 0; i < power; i++) {
            result = (result % divisor * x % divisor) % divisor;
        }

        return (int) result;
    }
    private long power(int base, int exponent) {
        long result = 1;
        long x = base;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= x;
            }
            x *= x;
            exponent /= 2;
        }
        return result;
    }

    private int result1(int base, int power, int divisor) {
        if (power == 0) {
            return 1 % divisor;
        }
        long result = 1;
        long x = base % divisor;
        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * x) % divisor;
            }
            x = (x * x) % divisor;
            power /= 2;
        }
        return (int) result;
    }

}