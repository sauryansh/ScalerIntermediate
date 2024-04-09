package com.modulas;

public class ProductOfNAndP {
    public static void main(String[] args) {
        String N = "3481"; // example value of N
        long P = 4L;  // example value of P
        long remainder = calculateModulo(N, P);
        System.out.println("Remainder of " + N + " divided by " + P + " is: " + remainder);
        long remainder1 = calculateModulo1(N, P);
        System.out.println("Remainder of " + N + " divided by " + P + " is: " + remainder1);
    }

    private static long calculateModulo(String N, long P) {
        long result = 0;
        int k = N.length();
        int base = 10;
        for (int i = k-1; i >= 0; i--) {
            result=result+
                    (
                            ((N.charAt(i) - '0') % P) * (power(base, k - i - 1, P) % P)
                    )% P;
        }
        return result%P;
    }

    private static int power(int base, int power, long divisor) {
        if (power == 0) {
            return (int) (1 % divisor);
        }
        long result = 1L;
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
    private static long calculateModulo1(String N, long P) {
        int k = N.length();
        long r = 1; //10^0
        long ans = 0;
        for (int i = k - 1; i >= 0; i--) {
            ans = (ans + (N.charAt(i) - '0') * r) % P;
            r = (r * 10) % P; //Track Power
        }
        return ans;
    }


}
