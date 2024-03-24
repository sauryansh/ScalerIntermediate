package com.day20string;

import java.util.ArrayList;

public class ToLower {
    public static void main(String[] args) {
        ToLower toLower = new ToLower();
        ArrayList<Character> in = new ArrayList<>();
        in.add('A');
        in.add('B');
        in.add('C');
        System.out.println(toLower.to_lower(in));

    }

    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        int size = A.size();
        int i=size-1;
        while(i>=0){
            A.set(i, (char) toLower(A.get(i)));
            i--;
        }
        return A;
    }

    public int toLower(Character c){
        int result = c;
        //if uppercase then convert to lowercase else return as it is
        if (c >= 65 && c <= 90) {
            result = (char) (c + 32);
        }
        return result;
    }
}
