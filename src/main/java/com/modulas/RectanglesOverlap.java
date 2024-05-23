package com.modulas;

public class RectanglesOverlap {
    public static void main(String[] args) {
        System.out.println(new RectanglesOverlap().solve(0,0,4,4,2,2,6,6));
        System.out.println(new RectanglesOverlap().solve(0,0,1,1,2,2,3,3));
    }
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if((E>=C)||(F>=D)||(G<=A)||(H<=B))
            return 0;
        else
            return 1;
    }
}
