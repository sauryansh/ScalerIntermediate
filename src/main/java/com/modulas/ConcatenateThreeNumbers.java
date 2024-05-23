package com.modulas;

public class ConcatenateThreeNumbers {
    public static void main(String[] args) {
        System.out.println(new ConcatenateThreeNumbers().solve(10,20,30));
        System.out.println(new ConcatenateThreeNumbers().solve(53,43,47));
    }
    public int solve(int A, int B, int C) {

        if(A <= B && B <= C)
            return A*10000 + B*100 + C;
        else if(A <= C && C <= B)
            return A*10000 + C*100 + B;
        else if(B <= A && A <= C)
            return B*10000 + A*100 + C;
        else if(B <= C && C <= A)
            return B*10000 + C*100 + A;
        else if(C <= A && A <= B)
            return C*10000 + A*100 + B;
        else
            return C*10000 + B*100 + A;
    }
}
