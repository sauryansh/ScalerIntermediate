package com.day20string;

import java.util.ArrayList;
import java.util.Arrays;

public class Isalnum {
    public static void main(String[] args) {
        System.out.println(new Isalnum().solve(new ArrayList<>(Arrays.asList('a', 'A'))));
    }

    public int solve(ArrayList<Character> A) {
        int size = A.size();
        int i = 0;
        while (i < size) {
            if (!isAlnum(A.get(i))) {
                return 0;
            }
            i++;
        }
        return 1;
    }

    public boolean isAlnum(Character c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
    }
}
